package ArrayBlockingQueueTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class MyQueue extends LinkedBlockingQueue{
    volatile boolean writable = true ;

}
