package Exercise24;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    Middle middle;

    public Producer(Middle middle) {
        this.middle = middle;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (middle.board) {
                    int z = new Random().nextInt();
                    middle.board.setBoard(z);
                    System.out.println(" Write " + z + " By " + Thread.currentThread());
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

