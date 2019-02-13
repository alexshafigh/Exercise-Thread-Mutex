import java.util.concurrent.TimeUnit;

public class Runnable2 implements Runnable {
    Runnable1 runnable1 ;

    public Runnable2(Runnable1 runnable1) {
        this.runnable1 = runnable1;
//        this.object = object;
    }

    @Override
    public void run() {
        System.out.println(" Runnable2 Starting ... ");
        synchronized (this.runnable1){
            try {
                System.out.println("Before Sleep" + Thread.currentThread());
                TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
                System.out.println(" Runnable2 Interrupted By " + Thread.currentThread());
        }
            System.out.println(" Notify All " +Thread.currentThread());
            runnable1.notifyAll();
        }

    }
}
