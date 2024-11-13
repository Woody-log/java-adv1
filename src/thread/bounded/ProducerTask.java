package thread.bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request;

    public ProducerTask(final BoundedQueue queue, final String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생성 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생성 완료] " + request + " -> " + queue);
    }
}
