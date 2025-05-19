package 线程.奇偶.新;

import 线程.奇偶.Demo0519;

public class Demo0518 {


    private static final int MAX = 10;
    private static int currentNumber = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {


        //odd是奇
        //even是偶

        Thread oddPrinter = new Thread(() -> DemoNumbers(true), "OddThread");
        Thread evenPrinter = new Thread(() -> DemoNumbers(false), "EvenThread");

        oddPrinter.start();
        evenPrinter.start();


    }


    private static void DemoNumbers(boolean isOdd) {


        while (currentNumber <= MAX) {

            synchronized (lock) {
                while ((isOdd && currentNumber % 2 == 0) || (!isOdd && currentNumber % 2 == 1)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                //代码要在synchronized 里
                if (currentNumber <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " printed: " + currentNumber);
                    currentNumber++;
                    lock.notifyAll();

                }
            }

// 放在 synchronized 外部：释放锁更早 线程切换更流畅 不容易死锁
            try {
                Thread.sleep(200); // 睡200毫秒
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }

    }
}
