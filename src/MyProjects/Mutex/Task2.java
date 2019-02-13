package MyProjects.Mutex;

public class Task2 implements Runnable  {
      static Mutex mutex ;

    public Task2(Mutex mutex) {
        this.mutex = mutex;
    }
    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(getCharB());
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");

        }
    }

    public char getCharB(){
        return 'B';
    }
    synchronized void notifier(){
        notify();
    }
}
