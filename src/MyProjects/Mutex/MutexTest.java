package MyProjects.Mutex;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class MutexTest {


        private static Mutex mutex = new Mutex();



        private static LinkedBlockingQueue queue = new LinkedBlockingQueue();
        private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

//
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                synchronized (queue) {
//                    Insider insider =  (Insider) queue.poll();
//                    System.out.println(" Read " + insider.getaChar() + " By " + Thread.currentThread());
//                    mutex.notify();
//                }
//            }
//        } , 0 , 1000);



//
//        new Thread(){
//            @Override
//            public void run(){
//            while ( queue.peek() != null){
//                synchronized (queue){
//                    System.out.println(" Read " + ((Insider)queue.poll()).getaChar() + " By " + Thread.currentThread());
//                    mutex.notify();
//
//                }
//            }
//            }
//
//        }.start();
//
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new Task1(queue));
//        TimeUnit.MILLISECONDS.sleep(100);
//        exec.execute(new Task2(queue));
//        TimeUnit.MILLISECONDS.sleep(100);
//        exec.execute(new Task3(queue));


//
//        TimeUnit.SECONDS.sleep(3);
//





//        timer.cancel();
//        exec.shutdownNow();
//        thread.interrupt();







//        new Timer().schedule(new TimerTask() {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                        synchronized (queue) {
                            if (!flag){
                                try {
                                System.out.println(" **************** Salam By  " + Thread.currentThread());
                                queue.put(" Salam ");
                                flag = true;
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
    }
        }.start();
//        , 0 , 1*1000);



//        new Timer().schedule(new TimerTask() {
        new Thread(){
        @Override
            public void run() {
                while (true) {
                        synchronized (queue) {
                            if (!flag){
                                try {
                            System.out.println("******************************************* Chetory By   " + Thread.currentThread());
                            queue.put(" Chetory ");
                            flag = true;
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        }
                    }
                }
            }
        }.start();
//        , 0 , 1 * 1000);


//        new Timer().schedule(new TimerTask() {
        new Thread(){
        @Override
            public void run() {
                while (true) {
                    synchronized (queue) {
                        if (flag){
                            try {
                            System.out.println(queue.take() + "By " + Thread.currentThread() + " ------------------------------------------");

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
        }.start();
//        , 0 , 1*1000);

//        new Timer().schedule(new TimerTask() {
        new Thread(){
        @Override
            public void run() {
                while (true) {
                        synchronized (queue) {
                            if (flag){
                                try {
                                System.out.println(queue.take() + "By " + Thread.currentThread() + " ..........................................");

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
        }.start();
//        , 0 , 1*1000);







//
//        new Thread(){
//            @Override
//            public void run() {
//                while (!isInterrupted()) {
//                    if (!flag){
//                        synchronized (queue) {
//                            try {
//                                System.out.println(" Put By Salam " + Thread.currentThread());
////                                System.out.println(queue.isEmpty());
//                                queue.put(" Salam ");
////                                System.out.println(queue.isEmpty());
//                                flag = true;
////                                System.out.println(flag);
//                                queue.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                }
//            }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (!isInterrupted()) {
//                    if (!flag){
//                        synchronized (queue) {
//                        try {
//                            System.out.println(" Put By Chetory " + Thread.currentThread());
////                                System.out.println(queue.isEmpty());
//                            queue.put(" Chetory ");
////                                System.out.println(queue.isEmpty());
//                            flag = true;
////                                System.out.println(flag);
//                                queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        }
//                    }
//                }
//            }
//        }.start();
//
//        TimeUnit.MILLISECONDS.sleep(500);
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (!isInterrupted()) {
//                    if (flag){
//                    synchronized (queue) {
//                        System.out.print(" Poll By " + Thread.currentThread());
//                        try {
//                            System.out.println(queue.take());
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        finally {
//                            flag = false ;
//                        }
//                        queue.notify();
//                    }
//                }
//            }
//            }
//        }.start();




    }
}
