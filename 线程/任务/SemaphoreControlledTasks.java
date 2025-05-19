package 线程.任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreControlledTasks {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(20);


        Semaphore semaphore = new Semaphore(5);


        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                try {

                    semaphore.acquire();


                    Thread.sleep(2000);
                    System.out.println("Hello - " + Thread.currentThread().getName());

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