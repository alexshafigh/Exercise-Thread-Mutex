package MyExerecise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Mutex {

    ExecutorService exec = Executors.newCachedThreadPool();

    LinkedBlockingQueue queue = new LinkedBlockingQueue();
    Consumer consumer = new Consumer(this);
    Consumer consumer2 = new Consumer(this);
    Producer producer = new Producer(this);
    Producer producer2 = new Producer(this);


    public Mutex() {
      exec.execute(consumer);
      exec.execute(consumer2);
      exec.execute(producer);
//      exec.execute(producer2);

    }

    public static void main(String[] args) {
        new Mutex();
    }
}
