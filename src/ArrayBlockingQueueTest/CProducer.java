package ArrayBlockingQueueTest;

import java.util.concurrent.TimeUnit;

public class CProducer extends Producer {
    public CProducer(MyQueue queue) {
        super(queue);
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (queue) {
                    if (queue.writable) {
                        System.out.println(" Put C By " + Thread.currentThread());
                        queue.put("C" );
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
