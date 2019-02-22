package Exercise26;

public class BusBoy implements Runnable {
    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this) {
                    while ( !restaurant.waitPerson.delivered )
                        wait();
                }
//            System.out.println(" Before Clean Up");
            synchronized (restaurant.chef) {
                System.out.println(" Cleaning Up ");
//                restaurant.meal = null;
//                restaurant.chef_busboy = 0 ;
                restaurant.waitPerson.delivered = false;
                restaurant.chef.notifyAll(); // Ready for another
            }
        }
        }catch (InterruptedException e) {
            System.out.println();
        }
    }
}
