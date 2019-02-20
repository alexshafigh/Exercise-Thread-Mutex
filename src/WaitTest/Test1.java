package WaitTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 implements Runnable {
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(true)
                        wait(); // ... while The meal not produced every Thread must wait for the chef to produce a meal
                }
//                System.out.println( " Aftert wait ");

            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
       exec.execute(new Test1());
    }
}
