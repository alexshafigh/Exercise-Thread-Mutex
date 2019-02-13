import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService  exec = Executors.newCachedThreadPool();
        Runnable1 runnable1 = new Runnable1();
        exec.execute(runnable1);
        Runnable2 runnable2 = new Runnable2(runnable1);
        exec.execute(runnable2);
        Runnable1 runnable12 = new Runnable1();
        exec.execute(runnable12);

        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();

    }
}
