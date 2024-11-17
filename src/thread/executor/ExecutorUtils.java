package thread.executor;

import static util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            final var pool = poolExecutor.getPoolSize();
            final var active = poolExecutor.getActiveCount();
            final var queued = poolExecutor.getQueue().size();
            final var completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool = " + pool + ", active=" + active + ", queuedTasks=" + queued + ", completedTask="
                + completedTask + "]");
        } else {
            log(executorService);
        }
    }

    public static void printState(ExecutorService executorService, String taskName) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            final var pool = poolExecutor.getPoolSize();
            final var active = poolExecutor.getActiveCount();
            final var queued = poolExecutor.getQueue().size();
            final var completedTask = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [pool = " + pool + ", active=" + active + ", queuedTasks=" + queued + ", completedTask="
                + completedTask + "]");
        } else {
            log(executorService);
        }
    }
}
