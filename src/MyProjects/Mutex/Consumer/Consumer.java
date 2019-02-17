package MyProjects.Mutex.Consumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
    private LinkedBlockingQueue queue ;
    private  volatile boolean flag ;

    public Consumer(LinkedBlockingQueue queue, boolean flag) {
        this.queue = queue;
        this.flag = flag;
    }

    @Override
    public synchronized void run() {
        while (true) {
            synchronized (queue) {
                if (flag){
                    try {
                        System.out.println( queue.take() + " Taken By " + Thread.currentThread() + " ------------------------------------------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        flag = false ;
                        queue.notifyAll();
                    }
                }
            }
        }
    }
}
