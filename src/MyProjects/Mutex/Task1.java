package MyProjects.Mutex;

import BlockerTest.Task;


public class Task1 extends Task implements Runnable {
     static Mutex mutex;

    public Task1(Mutex mutex) {
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
        return 'A';
    }


}
