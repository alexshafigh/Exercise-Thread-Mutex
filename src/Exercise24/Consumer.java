package Exercise24;


import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    Middle middle;

    public Consumer(Middle middle) {
        this.middle = middle;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                while (middle.obj == null) wait();

                synchronized (middle){
                    middle.obj = null;
                    System.out.println("obj consumed by " + Thread.currentThread() );
                    middle.notifyAll();
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

