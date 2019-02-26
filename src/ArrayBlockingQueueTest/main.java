package ArrayBlockingQueueTest;

import java.util.TimerTask;
import java.util.concurrent.*;

public class main {

    static MyQueue queue ;

    public main() {
        queue = new MyQueue();
        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
        StrConsumer  srtconsumer = new StrConsumer(queue);


        ExecutorService exec = Executors.newFixedThreadPool(6);

        while (true) {
            exec.execute(new AProducer(queue));
            exec.execute(new BProducer(queue));
            exec.execute(new CProducer(queue));

            exec.execute(srtconsumer);
            exec.execute(srtconsumer);
            exec.execute(srtconsumer);
        }

//
//        Thread p1 = new Thread(producer);
//        Thread p2 = new Thread(producer);
//        Thread p3 = new Thread(producer);
////-------------------------------------------
//        Thread c1 = new Thread(consumer);
//        Thread c2 = new Thread(consumer);
//        Thread c3 = new Thread(consumer);
//        //------------------------------------------
//
//
//
//    p1.start();
//    p2.start();
//    p3.start();
//    c1.start();
//    c2.start();
//    c3.start();




    }

    public static void main(String[] args) throws InterruptedException {
        main main = new main();

//        TimeUnit.SECONDS.sleep(5);
//        System.exit(1);
    }
}
