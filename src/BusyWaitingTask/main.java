package BusyWaitingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main {
    private static volatile boolean flag = false;


    public static void main(String[] args) throws InterruptedException {

//        new Thread(){
////            private volatile boolean flag = false;
//            @Override
//            public void run(){
////                synchronized ()
//                try{
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(" flag set ");
//                this.notifyAll();
//            }
//        }.start();
//
//
//
//        new Thread(){
////            private volatile boolean flag ;
//            @Override
//            public void run() {
//                synchronized (this) {
//                    Long t1 = System.currentTimeMillis();
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
////                    e.printStackTrace();
//                    }
////                while (!flag){
//////                    System.out.println("BUSYWAITING");
////                }
//                    Long t2 = System.currentTimeMillis();
//                    System.out.println("Execution Time " + (t2 - t1));
//                    System.out.println(" flag Changed ");
//                    flag = false;
//                }
//            }
//        }.start();


        Task2 task2 = new Task2();
        TimeUnit.MILLISECONDS.sleep(1000);
        Task1 task1 = new Task1(task2);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task1);
        exec.execute(task2);
        exec.shutdownNow();
//        System.out.println(task1.getT2() - task2.getT1());


    }
}
