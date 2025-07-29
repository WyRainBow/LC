package 面经.小红书一面;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 问题：实现一个HTTP请求拦截器，用于统计每分钟来自每个城市的请求数量，并打印日志。
 *
 * 核心设计：
 * 1.  数据结构: 使用 `volatile ConcurrentHashMap<Integer, AtomicInteger>`
 *     - `ConcurrentHashMap`: 提供高并发、线程安全的Map操作。
 *     - `AtomicInteger`: 提供原子的计数操作，避免 "get-increment-put" 的竞态条件
 *     - `volatile`: 确保当后台线程替换Map实例时，所有请求线程都能立即看到最新的Map引用
 *
 * 2.  定时任务: 使用 `ScheduledExecutorService` 创建一个单线程的定时任务池
 *     - 该后台线程每分钟执行一次日志打印和数据重置
 *
 * 3.  数据重置: 采用指针交换策略。
 *     - 定时任务触发时、用一个新的空Map替换旧Map、然后处理旧Map的数据
 *     - 这样做可以避免在打印日志时长时间锁定数据、不影响新请求的计数
 */
class Interceptor {

    // 使用 volatile 保证多线程间的可见性
    private volatile ConcurrentHashMap<Integer, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    // 使用单线程的 ScheduledExecutorService 执行定时任务
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    // 日志时间格式化
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Interceptor() {
        // 启动定时任务
        // initialDelay: 1分钟后第一次执行
        // period: 每隔1分钟执行一次
        scheduler.scheduleAtFixedRate(this::logAndReset, 1, 1, TimeUnit.MINUTES);
    }

    /**
     * 每个HTTP请求都会调用此方法。
     * 此方法必须是高性能和线程安全的。
     * @param cityId 代表城市的ID
     */
    public void logRequest(int cityId) {
        // computeIfAbsent 是一个原子操作、如果key不存在、则创建并放入一个新的AtomicInteger
        // 然后对获取到的AtomicInteger执行原子自增操作
        requestCounts.computeIfAbsent(cityId, k -> new AtomicInteger(0)).incrementAndGet();
    }

    /**
     * 由后台线程定时调用的方法、用于打印日志并重置计数器。
     */
    private void logAndReset() {
        // 指针交换：原子地用一个新map替换旧map
        Map<Integer, AtomicInteger> countsToLog = this.requestCounts;
        this.requestCounts = new ConcurrentHashMap<>();

        // 如果上一个周期内没有任何请求、则不打印日志
        if (countsToLog.isEmpty()) {
            System.out.println(LocalDateTime.now().format(formatter) + " - No requests in the last minute.");
            return;
        }

        // 现在可以安全地处理旧的map、不会影响新请求的计数
        System.out.println("---------------- " + LocalDateTime.now().format(formatter) + " - Minute Stats ----------------");
        long totalRequests = 0;
        for (Map.Entry<Integer, AtomicInteger> entry : countsToLog.entrySet()) {
            int cityId = entry.getKey();
            int count = entry.getValue().get();
            totalRequests += count;
            System.out.printf("City ID: %d, Requests: %d\n", cityId, count);
        }
        System.out.println("Total requests in the last minute: " + totalRequests);
        System.out.println("----------------------------------------------------------------------\n");
    }

    /**
     * 优雅地关闭调度器、在应用关闭时调用。
     */
    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}

/**
 * 主类
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting request simulation...");
        final Interceptor interceptor = new Interceptor();
        
        // 使用一个线程池模拟高并发的HTTP请求
        final int numberOfThreads = 10;
        final int requestsPerThread = 100000;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < requestsPerThread; j++) {
                    // 模拟来自不同城市的请求 (1-10)
                    int cityId = (int) (Math.random() * 10) + 1;
                    interceptor.logRequest(cityId);
                    try {
                        // 随机休眠一小段时间、让请求分布更真实
                        TimeUnit.MICROSECONDS.sleep((long)(Math.random() * 100));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }

        // 模拟运行一段时间、观察日志输出
        // 这里我们等待所有模拟请求发完、但在真实服务器中、程序会一直运行
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All simulation threads have finished sending requests.");
        System.out.println("Waiting for the final log cycle to complete...");
        
        // 等待几分钟、让调度器有机会打印最后一批日志
        Thread.sleep(TimeUnit.MINUTES.toMillis(2));

        // 在程序退出前、优雅地关闭资源
        interceptor.shutdown();
        System.out.println("Interceptor has been shut down. Simulation finished.");
    }
}
