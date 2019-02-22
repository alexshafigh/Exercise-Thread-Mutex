package MyExerecise;

public class Consumer implements Runnable {
    private Mutex mutex;

    public Consumer(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this) {
                    while (mutex.queue.isEmpty())
                    {
                        System.out.println(Thread.currentThread() + "Goes Into Wait ");
                        wait();
                }
                }
                System.out.println(Thread.currentThread() + "Goes out of Wait ");
                synchronized (mutex.producer){
                    Meal meal = (Meal)mutex.queue.poll();
                    System.out.println(meal.toString() +  " By Consumer " + Thread.currentThread());
                    mutex.producer.notifyAll();
                }
        }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
