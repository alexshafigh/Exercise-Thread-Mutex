package ArrayBlockingQueueTest;

import java.util.concurrent.TimeUnit;

public class AProducer extends Producer {
    public AProducer(MyQueue queue) {
        super(queue);
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (queue) {
                    if (queue.writable) {
                        System.out.println(" Put A By " + Thread.currentThread());
                        queue.put("A" );
                        queue.writable = false;
                        queue.wait();
                        break;
                    }
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
