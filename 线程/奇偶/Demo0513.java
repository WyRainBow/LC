package 线程.奇偶;

public class Demo0513 {

    private static final int MAX = 10;
    private int number = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {
        Demo0513 printer = new Demo0513();

        Thread oddThread = new Thread(printer::printOdd, "OddThread");
        Thread evenThread = new Thread(printer::printEven, "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    public void printOdd() {
        while (true) {
            synchronized (lock) {
                if (number > MAX) break;
                if (number % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void printEven() {
        while (true) {
            synchronized (lock) {
                if (number > MAX) break;
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}