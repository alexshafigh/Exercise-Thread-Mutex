package Exercise24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    List<Integer> buffer = new ArrayList(10);
    Middle middle;

    public Consumer(Middle middle) {
        this.middle = middle;
    }


    @Override
    public synchronized void run() {
//        System.out.println("size is " +buffer.size());
//                System.out.println("size is " +buffer.isEmpty());
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while ( buffer.size() > 10 || buffer.isEmpty() )
                        wait();
                }
                System.out.println(" consumer out ");
                synchronized (middle._producer) {
                    int number = buffer.get(buffer.size()-1);
                    System.out.printf(" get %d by %s \n" , number , Thread.currentThread());
                    middle._producer.notify();
                }
//                TimeUnit.MILLISECONDS.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
