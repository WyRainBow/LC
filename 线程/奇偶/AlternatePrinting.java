package 线程.奇偶;

public class AlternatePrinting {

    private int currentNumber = 1; // 当前要打印的数字
    private final Object lock = new Object(); // 用于同步的锁对象

    public static void main(String[] args) {
        AlternatePrinting ap = new AlternatePrinting();

        // 创建并启动打印奇数的线程
        Thread oddPrinter = new Thread(() -> ap.printNumbers(true));
        oddPrinter.setName("OddThread");
        oddPrinter.start();

        // 创建并启动打印偶数的线程
        Thread evenPrinter = new Thread(() -> ap.printNumbers(false));
        evenPrinter.setName("EvenThread");
        evenPrinter.start();
    }

    /**
     * 根据 isOdd 标志打印奇数或偶数
     * @param isOdd 如果为 true 则打印奇数 否则打印偶数
     */
    private void printNumbers(boolean isOdd) {
        while (currentNumber <= 10) {
            synchronized (lock) {
                while ((isOdd && currentNumber % 2 == 0) || (!isOdd && currentNumber % 2 != 0)) {
                    try {
                        lock.wait(); // 当前线程不该执行时等待
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // 再次检查 确保未超过最大值
                if (currentNumber <= 10) {
                    System.out.println(Thread.currentThread().getName() + " printed: " + currentNumber);
                    currentNumber++;
                    lock.notifyAll(); // 通知其他线程
                }
            }
        }
    }
}