package Exercise24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Middle {

    ExecutorService exec = Executors.newCachedThreadPool();
    Consumer _consumer = new Consumer(this);
    Producer _producer = new Producer(this);

    public Middle() {
        exec.execute(_consumer);
        exec.execute(_producer);
    }

    public static void main(String[] args) {
        Middle middle = new Middle();
    }

}
