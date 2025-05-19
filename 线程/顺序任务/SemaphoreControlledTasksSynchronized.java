package 线程.顺序任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreControlledTasksSynchronized {
    private static final Object lock = new Object();
    private static int nextToPrint = 0;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                try {
                    semaphore.acquire();

                    // 模拟任务处理
                    Thread.sleep(1000);

                    // 等待轮到自己打印
                    synchronized (lock) {
                        while (taskId != nextToPrint) {
                            lock.wait();
                        }
                        System.out.println("Hello from Task " + taskId + " - " + Thread.currentThread().getName());
                        nextToPrint++;
                        lock.notifyAll();
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            });
        }

        threadPool.shutdown();
    }
}