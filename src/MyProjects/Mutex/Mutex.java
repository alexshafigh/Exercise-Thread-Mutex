package MyProjects.Mutex;

public class Mutex { // blocker
    synchronized void notifier(){
        notify();
    }
}
