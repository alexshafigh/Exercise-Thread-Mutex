package MyProjects.Mutex;

import BlockerTest.Task;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Task3 extends Task implements Runnable {
//     Mutex mutex;
    LinkedBlockingQueue queue;


//    public Task3(Mutex mutex) {
//        this.mutex = mutex;
//    }

    public Task3(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        synchronized (this.queue){
            while (true) {
                try{
                    System.out.println(Thread.currentThread() + " Set c ");
                    queue.add(new Insider('C'));
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " Interrupted ");
                }
            }
        }
    }


    /* -------------------ver 1

    @Override
    public synchronized void run() {
        synchronized (this.mutex){
            while (true) {
                try{
                    System.out.println(Thread.currentThread() + " Set C ");
                    mutex.setCharacter('C');
                    mutex.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " Interrupted ");
                }
            }
        }
    }
    */
//
//    @Override
//    public synchronized void run() {
//        synchronized (this.mutex){
//            while (true) {
//                try{
//                    System.out.println(Thread.currentThread() + " " +getChar());
//                    mutex.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }


    public char getChar(){
        return 'C';
    }

}
