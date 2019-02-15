package MyProjects.Mutex;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class MutexTest {


        private static Mutex  queue = new Mutex();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task1(queue));
        exec.execute(new Task2(queue));
        exec.execute(new Task3(queue));
//        TimeUnit.MILLISECONDS.sleep(100);
//        queue.notifier();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                synchronized (queue) {
                    queue.notify();
                }
            }
        } , 0 , 100);

        TimeUnit.SECONDS.sleep(3);


//        Timer timer2 = new Timer();
//        timer2.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        });





        timer.cancel();
        exec.shutdownNow();

    }
}
