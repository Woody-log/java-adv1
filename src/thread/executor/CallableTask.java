package thread.executor;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private String name;
    private int sleepMs = 100;

    public CallableTask(final String name) {
        this.name = name;
    }

    public CallableTask(final String name, final int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public Integer call() throws Exception {
        log(name + " 실행");
        sleep(sleepMs);
        log(name + " 완료");
        return 0;
    }
}
