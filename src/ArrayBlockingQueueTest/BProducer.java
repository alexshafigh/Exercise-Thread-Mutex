package ArrayBlockingQueueTest;

import java.util.concurrent.TimeUnit;

public class BProducer extends Producer {
    public BProducer(MyQueue queue) {
        super(queue);
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (queue) {
                    if (queue.writable) {
                        System.out.println(" Put B By " + Thread.currentThread());
                        queue.put("B" );
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