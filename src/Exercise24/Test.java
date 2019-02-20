package Exercise24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Test {

    private static volatile int buffer = 0;
    private static LinkedBlockingQueue synchronousQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {

        Single_Producer single_producer1 = new Single_Producer(synchronousQueue);
        Single_Producer single_producer2 = new Single_Producer(synchronousQueue);

        Single_Consumer single_consumer= new Single_Consumer(synchronousQueue);




        single_consumer.setSingle_producer(single_producer1);
        single_producer1.setSingle_consumer(single_consumer);
        single_producer2.setSingle_consumer(single_consumer);




        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(single_producer1);
        exec.execute(single_producer2);

        exec.execute(single_consumer);
//        exec.shutdownNow();
    }
}
