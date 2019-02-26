package Exercise24;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Middle {

    obj obj  ;
    boolean flag = false;
    boolean read ;
    Thread thread11 = new Thread(new Producer(this));
    Thread thread22 = new Thread(new Consumer(this));
    Thread thread12 = new Thread(new Producer(this));
    Thread thread23 = new Thread(new Consumer(this));


    public Middle() {
        thread11.start();
        thread12.start();
        thread22.start();
        thread23.start();
    }

    public static void main(String[] args) throws InterruptedException {
            Middle middle = new Middle();

    }

}
