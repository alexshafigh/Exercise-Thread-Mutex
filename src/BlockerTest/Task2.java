package BlockerTest;

public class Task2 implements Runnable{
    static Blocker blocker = new Blocker();
    public void run() { blocker.waitingCall(); }
}
