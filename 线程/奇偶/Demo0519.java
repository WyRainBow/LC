package 线程.奇偶;

public class Demo0519 {

    private static final int MAX = 10;
    private static int currentNumber = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {


        //奇：odd number（odd）
        //偶：even number（even）

        Demo0519 ap = new Demo0519();

        Thread oddPrinter = new Thread(() -> ap.printNumbers(true));
        oddPrinter.setName("OddThread");
        oddPrinter.start();


        Thread evenPrinter = new Thread(() -> ap.printNumbers(false));
        evenPrinter.setName("EvenThread");
        evenPrinter.start();
    }



    private void printNumbers(boolean isOdd) {

        while (currentNumber <= MAX) {
            synchronized (lock) {
                while ((isOdd && currentNumber % 2 == 0) || (!isOdd && currentNumber % 2 != 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }


                if (currentNumber <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " printed: " + currentNumber);
                    currentNumber++;
                    lock.notifyAll();
                }
            }
        }
    }
}