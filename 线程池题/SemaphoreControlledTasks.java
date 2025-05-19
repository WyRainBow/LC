package 线程池题;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreControlledTasks {
    public static void main(String[] args) {
        // 创建一个拥有 20 个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        // 创建一个许可数为 5 的信号量
        Semaphore semaphore = new Semaphore(5);

        // 提交 20 个任务
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                try {
                    // 尝试获取一个许可
                    semaphore.acquire();

                    // 模拟任务处理
                    Thread.sleep(2000);
                    System.out.println("Hello - " + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // 释放许可
                    semaphore.release();
                }
            });
        }

        // 关闭线程池（不再接收新任务）
        threadPool.shutdown();
    }
}