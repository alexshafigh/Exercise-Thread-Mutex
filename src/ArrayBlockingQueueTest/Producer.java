package ArrayBlockingQueueTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.yield;

public class Producer implements Runnable {
    MyQueue queue;
    volatile int counter = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Producer(MyQueue queue) {
        this.queue = queue;
    }
//
//    @Override
//    public synchronized void run() {
//        try {
//            while (!Thread.interrupted()) {
//                while (queue.writable) {
//                    queue.put(counter);
//                    System.out.println(" Put " + counter + " By " + Thread.currentThread());
//                    counter++;
//                    queue.writable = false;
//                    TimeUnit.SECONDS.sleep(1);
//                }
//                yield();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public synchronized void run() {
//        System.out.println(Thread.currentThread() + " Producer Inside ");
//        try {
//            while (!Thread.interrupted()) {
//                while (!queue.writable) {
//                    System.out.println(Thread.currentThread() + " Producer wait ");
//                    this.wait();
//                }
//                synchronized (Consumer.class){
//                    System.out.println(Thread.currentThread() + " Producer out of wait  ");
//                    queue.put(counter);
//                    System.out.println(" Put " + counter + " By " + Thread.currentThread());
//                    counter++;
//                    queue.writable = false;
//    //                    TimeUnit.SECONDS.sleep(1);
//                    Consumer.class.notifyAll();
//                     }
////                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted() ) {
                synchronized (queue) {
                    if (queue.writable) {
                        System.out.println(" Put " + counter + " By " + Thread.currentThread());
                        queue.put(counter++);
                        queue.writable = false;
                        queue.wait();
                        break;
                    }
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
