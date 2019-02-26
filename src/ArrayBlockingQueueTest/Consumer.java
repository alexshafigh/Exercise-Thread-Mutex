package ArrayBlockingQueueTest;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    MyQueue queue;
    int number;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

//    @Override
//    public synchronized void run() {
//        try {
//            while (!Thread.interrupted())
//            {
//                while (!queue.writable) {
//                    int number = queue.take();
//                    System.out.println("Take" + number + " By " + Thread.currentThread());
//                    queue.writable = true;
//                    TimeUnit.SECONDS.sleep(1);
//                }
//                yield();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public synchronized void run() {
//        try {
//            while (!Thread.interrupted() ) {
//                synchronized (queue) {
//                    if (!queue.writable) {
//                        number = queue.take();
//                        System.out.println("  Take" + number + " By " + Thread.currentThread());
//                        queue.writable = true;
//                        queue.notifyAll();
//                        break;
//                    }
//                }
//                TimeUnit.SECONDS.sleep(1);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
