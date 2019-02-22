package Exercise26;


import java.util.concurrent.TimeUnit;

public class WaitPerson implements Runnable {
    private Restaurant restaurant; //The restaurant This belongs to
    public WaitPerson(Restaurant r) {
        restaurant = r;
        delivered = false;
    }
    boolean delivered ;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while( restaurant.meal == null )
                        wait(); // ... while The meal not produced every Thread must wait for the chef to produce a meal
                }
                System.out.println( "Waitperson got " + restaurant.meal);
                synchronized(restaurant.busBoy) {
                    System.out.println(restaurant.meal + " Delivered ");
                    delivered = true;
                    TimeUnit.MILLISECONDS.sleep(50);
                    restaurant.meal = null;
                    restaurant.busBoy.notify();
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

}
