package MyProjects.Mutex.Producer;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    private  LinkedBlockingQueue queue ;
    private  volatile boolean flag ;
    private String message;

    public Producer(LinkedBlockingQueue queue, boolean flag , String message) {
        this.queue = queue;
        this.flag = flag;
        this.message = message ;
    }

    @Override
    public synchronized void run() {
        while (true) {
            synchronized (queue) {
                if (!flag){
                    try {
                        System.out.println( message + " Put By  " + Thread.currentThread());
                        queue.put(message);
                        flag = true;
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
