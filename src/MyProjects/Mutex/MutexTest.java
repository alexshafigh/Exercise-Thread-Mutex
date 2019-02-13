package MyProjects.Mutex;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MutexTest {

    public static void main(String[] args) throws InterruptedException {
        Mutex  mutex = new Mutex();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task1(mutex));
        exec.execute(new Task2(mutex));
        exec.execute(new Task3(mutex));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            Random random = new Random(3);
            @Override
            public void run() {
                switch (random.nextInt()){
                    case 0:{
                        Task1.mutex.notifier();
                    }
                    case 1:{
                        Task2.mutex.notifier();
                    }
                    case 2:{
                        Task3.mutex.notifier();

                    }
                }
            }
        } , 400 , 400);




//        TimeUnit.SECONDS.sleep(2);
//        exec.shutdownNow();

    }
}
