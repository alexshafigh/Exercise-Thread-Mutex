package MyProjects.Mutex;

public class Task1 implements Runnable {
     static Mutex mutex ;

    public Task1(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(getCharA());
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
    }

    public char getCharA(){
        return 'A';
    }

}
