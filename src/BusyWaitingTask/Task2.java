package BusyWaitingTask;



public class Task2 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(" flag Changed ");
            Long t1 = System.currentTimeMillis();
            try {
                this.wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            Long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        }
    }

}
