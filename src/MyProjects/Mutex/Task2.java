package MyProjects.Mutex;

import BlockerTest.Task;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Task2 extends Task implements Runnable  {
//     Mutex mutex;
LinkedBlockingQueue queue;


//    public Task2(Mutex mutex) {
//            this.mutex = mutex;
//        }


    public Task2(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        synchronized (this.queue){
            while (true) {
                try{
                    System.out.println(Thread.currentThread() + " Set B ");
                    queue.add(new Insider('B'));
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " Interrupted ");
                }
            }
        }
    }

/* -------------------ver 1
//    @Override
//    public synchronized void run() {
//        synchronized (this.mutex){
//            while (true) {
//                try{
//                    System.out.println(Thread.currentThread() + " Set B ");
//                    mutex.setCharacter('B');
//                    mutex.wait();
//                } catch (InterruptedException e) {
//                    System.out.println(Thread.currentThread() + " Interrupted ");
//                }
//            }
//        }
//    }*/
//
//        @Override
//        public synchronized void run() {
//            synchronized (this.mutex){
//                while (true) {
//                    try{
//                        System.out.println(Thread.currentThread() + " " +getChar());
//                        mutex.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }


    public char getChar(){
        return 'B';
    }
}
