package thread.executor.future;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import thread.executor.CallableTask;

public class InvokeAllMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        final var task1 = new CallableTask("task1", 1000);
        final var task2 = new CallableTask("task2", 2000);
        final var task3 = new CallableTask("task3", 3000);

        final var tasks = List.of(task1, task2, task3);
        final List<Future<Integer>> futures = es.invokeAll(tasks);

        for (Future<Integer> future : futures) {
            final var value = future.get();
            log("value = " + value);
        }

        es.close();
    }
}
