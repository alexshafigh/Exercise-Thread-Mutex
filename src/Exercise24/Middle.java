package Exercise24;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Middle {

    obj board ;
    Thread thread1 = new Thread(new Producer(this));
    Thread thread2 = new Thread(new Consumer(this));

    public Middle() {
        board = new obj();
        board.setBoard(-9);
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
            Middle middle = new Middle();
    }

}
