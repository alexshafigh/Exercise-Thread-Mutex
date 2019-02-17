package MyProjects.Mutex;

import BlockerTest.Task;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;


public class Task1 extends Task implements Runnable {
//      Mutex mutex;
    LinkedBlockingQueue queue;

//    public Task1(Mutex mutex) {
//        this.mutex = mutex;
//    }

    public Task1(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        synchronized (this.queue){
            while (true) {
                try{
                    System.out.println(Thread.currentThread() + " Set A ");
                    queue.add(new Insider('A'));
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
                    System.out.println(Thread.currentThread() + " Set A ");
                    mutex.setCharacter('A');
                    mutex.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " Interrupted ");
                }
            }
        }
    }
*/
//    @Override
//    public synchronized void run() {
//        synchronized (this.mutex){
//            while (true) {
//                try{
//                System.out.println(Thread.currentThread() + " " +getChar());
//                    mutex.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }

    public char getChar(){
        return 'A';
    }


}
