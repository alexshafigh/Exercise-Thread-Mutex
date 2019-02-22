package Exercise24;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    Middle middle;

    public Producer(Middle middle) {
        this.middle = middle;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this) {
                    while (middle._consumer.buffer.size() >= 10)
                        wait();
                }
                synchronized (middle._consumer){
                    int number = new Random(1).nextInt() ;
                    System.out.printf(" put %d by %s \n " , number , Thread.currentThread() );
                    middle._consumer.buffer.add(number);
                    middle._consumer.notify();
                }
//                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    }
