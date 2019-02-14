package MyProjects.Mutex;

import BlockerTest.Task;

public class Task2 extends Task implements Runnable  {
      static Mutex mutex ;

    public Task2(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public synchronized void run() {
        synchronized (this.mutex){
            while (true) {
                System.out.println(Thread.currentThread() + " " +getChar());
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public char getChar(){
        return 'B';
    }
}
