package thread.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWorker("A", 1000), "Thread-A");
        Thread threadB = new Thread(new PrintWorker("B", 500), "Thread-B");

        threadA.start();
        threadB.start();
    }

    static class PrintWorker implements Runnable {
        private String content;
        private int sleepMs;

        public PrintWorker(final String content, final int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
