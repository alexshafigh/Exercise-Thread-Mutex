package Exercise24;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    obj obj;
    Middle middle;

    public Producer(Middle middle) {
        this.middle = middle;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                while ( middle.obj != null ) {
                    System.out.println(" Going 2 wait "+ Thread.currentThread());
                    wait();
                }

                synchronized (middle) {
                    middle.obj = new obj();
                    System.out.println(" obj created by "+ Thread.currentThread());
//                    middle.notifyAll();
//                    middle.flag = true;
                }
//                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

