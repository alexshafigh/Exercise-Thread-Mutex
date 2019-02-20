package Exercise24;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Single_Producer implements Runnable {

    private  int buffer = 0;
    LinkedBlockingQueue queue;
    Single_Consumer single_consumer;

    public Single_Producer(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public void setSingle_consumer(Single_Consumer single_consumer) {
        this.single_consumer = single_consumer;
    }

    @Override
    public synchronized void run() {
        System.out.println(" Remaining capacity " + queue.remainingCapacity());

        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while ( !queue.isEmpty() )
                        wait();
                }
                synchronized (this.single_consumer) {
                        Middle middle = new Middle(buffer++);
                        queue.offer(middle);
                        System.out.println(" Put "+ middle +" By Producer " + Thread.currentThread());
                        System.out.println(queue.remainingCapacity());
                        this.single_consumer.notify();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    }
