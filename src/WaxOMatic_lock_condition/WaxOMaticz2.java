package WaxOMatic_lock_condition;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMaticz2 {
    public static void main(String[] args) throws InterruptedException {
        Car  car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxerTask(car));
        TimeUnit.MILLISECONDS.sleep(100);
        exec.execute(new PolisherTask(car));

    }
}

