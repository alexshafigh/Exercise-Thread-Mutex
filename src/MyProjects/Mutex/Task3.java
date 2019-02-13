package MyProjects.Mutex;

public class Task3 implements Runnable {
     static Mutex mutex ;

    public Task3(Mutex mutex) {
        this.mutex = mutex;
    }
    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(getCharC());
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");

        }
    }


    public char getCharC(){
        return 'C';
    }

    synchronized void notifier(){
        notify();
    }
}
