package MyProjects.Mutex;

import BlockerTest.Task;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Task3 extends Task implements Runnable {
    static Mutex mutex;


    public Task3(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public synchronized void run() {
        synchronized (this.mutex){
            while (true) {
                try{
                    System.out.println(Thread.currentThread() + " " +getChar());
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public char getChar(){
        return 'C';
    }

}
