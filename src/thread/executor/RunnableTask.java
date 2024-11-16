package thread.executor;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(final String name) {
        this.name = name;
    }

    public RunnableTask(final String name, final int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs);
        log(name + " 종료");
    }
}
