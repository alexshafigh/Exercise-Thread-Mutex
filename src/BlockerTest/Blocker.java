package BlockerTest;

public class Blocker {
    synchronized void waitingCall() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(Thread.currentThread()  + " Going 2 Wait ");
                wait();
                System.out.println(Thread.currentThread() + " Going out Wait ");
            }
        } catch(InterruptedException e) {
            }
    }
    synchronized void prod() { notify(); }
    synchronized void prodAll() { notifyAll(); }
}
