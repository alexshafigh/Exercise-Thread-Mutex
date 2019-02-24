package Exercise24;


import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    Middle middle;

    public Consumer(Middle middle) {
        this.middle = middle;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (middle.board) {
                    int number = middle.board.getBoard();
                    System.out.println(" Read By " + Thread.currentThread() + " " + number);
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

