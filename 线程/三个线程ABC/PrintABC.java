package 线程.三个线程ABC;

public class PrintABC {
    private static final Object lock = new Object();
    private static int state = 0;

    static class Printer implements Runnable {
        private final char ch;
        private final int targetState;

        public Printer(char ch, int targetState) {
            this.ch = ch;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (state % 3 != targetState) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(ch);
                    System.out.print(" ");
                    state++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer('a', 0)).start();
        new Thread(new Printer('b', 1)).start();
        new Thread(new Printer('c', 2)).start();
    }
}