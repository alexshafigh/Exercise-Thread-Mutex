package MyExerecise;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private Mutex mutex;
    private int count = 0;

    public Producer(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this) {
                    while (!mutex.queue.isEmpty())
                        wait();
                }
                synchronized (mutex.consumer){
                    Meal meal = new Meal(++count);
                    mutex.queue.offer(meal);
                    System.out.println( meal.toString() +  " By Producer " + Thread.currentThread());
                    mutex.consumer.notifyAll();
                }
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
