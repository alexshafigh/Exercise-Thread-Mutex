import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runnable1 implements Runnable {
    Lock lock = new ReentrantLock();
    public Runnable1() {
    }

    @Override
    public synchronized void run() {
//        synchronized (this) {
        try {
            lock.lock();
            System.out.println(" Runnable1 Starting ....");
            try {
                System.out.println("I'm Here Before Wait" + Thread.currentThread());
                this.wait();
//                System.out.println(lock.tryLock());
                System.out.println("I'm Here After Wait" + Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(" runnable1 Interrupted ...." + Thread.currentThread());
            }

            System.out.println(" Display Some Message By" + Thread.currentThread());
//            System.out.println(lock.tryLock());

//        }}
        }finally {
            lock.unlock();
        }

    }
}
