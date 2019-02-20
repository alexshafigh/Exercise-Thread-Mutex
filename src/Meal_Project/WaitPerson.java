package Meal_Project;


public class WaitPerson implements Runnable {
    private Restaurant restaurant; //The restaurant This belongs to
    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null)
                        wait(); // ... while The meal not produced every Thread must wait for the chef to produce a meal
                }
                System.out.println( "Waitperson got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

}
