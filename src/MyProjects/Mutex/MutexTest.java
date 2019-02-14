package MyProjects.Mutex;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MutexTest {

    private static Mutex  mutex = new Mutex();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task1(mutex));
        exec.execute(new Task2(mutex));
        exec.execute(new Task3(mutex));
//        TimeUnit.MILLISECONDS.sleep(100);
//        mutex.notifier();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                synchronized (mutex) {
                    mutex.notify();
                }
            }
        } , 0 , 1000);

//        TimeUnit.SECONDS.sleep(2);
//        exec.shutdownNow();

    }
}
