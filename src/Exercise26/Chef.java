package Exercise26;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while( restaurant.meal != null  ) // اگه غذا null نیس صبر کن تا ببرنش
                        wait(); // ... for the meal to be taken
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.meal.status = 1;
                    restaurant.waitPerson.notify();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println(" ShutDown Now Happened ");
        }
    }
}
