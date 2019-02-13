package BusyWaitingTask;

import java.util.concurrent.TimeUnit;

public class Task1 implements Runnable {
    private volatile boolean flag ;
    private Task2 task2;


    public Task1(Task2 task2) {
        this.task2 = task2;
    }

    @Override
    public void run() {
        synchronized (this.task2) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(" flag set");
            flag = true ;
            this.task2.notify();
        }
    }
}
