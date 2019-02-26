package ArrayBlockingQueueTest;

import java.util.concurrent.TimeUnit;

public class StrConsumer extends Consumer {
    public StrConsumer(MyQueue queue) {
        super(queue);
    }


    @Override
    public synchronized void run() {
//        System.out.println(Thread.currentThread() + "Consumer Inside ");
//        int random = ThreadLocalRandom.current().nextInt(0,2);
        try {
            while (!Thread.interrupted() ) {
                synchronized (queue) {
                    if (!queue.writable) {
                        String s = queue.take().toString();
                        System.out.println("  Take" + s + " By " + Thread.currentThread());
                        queue.writable = true;
                        queue.notifyAll();
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
