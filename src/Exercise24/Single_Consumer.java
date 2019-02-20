package Exercise24;

import java.util.concurrent.LinkedBlockingQueue;

public class Single_Consumer implements Runnable {

    private  int buffer;
    LinkedBlockingQueue queue;
    Single_Producer single_producer;

    public Single_Consumer(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public void setSingle_producer(Single_Producer single_producer) {
        this.single_producer = single_producer;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while ( queue.isEmpty() )
                        wait();
                }
                synchronized (this.single_producer){
                    Middle middle = (Middle) queue.poll();
                    System.out.println(" Get "+ middle.toString() + " By Consumer");
                    System.out.println(queue.remainingCapacity());
                    this.single_producer.notify();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
