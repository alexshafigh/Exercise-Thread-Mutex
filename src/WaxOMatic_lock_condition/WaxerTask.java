package WaxOMatic_lock_condition;

import WaxOMatic_lock_condition.Car;

import java.util.concurrent.TimeUnit;

public class WaxerTask implements Runnable {
    Car car;

    public WaxerTask(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
            while (!Thread.interrupted()) {
                    car.waxzadan();
                    car.waitForPolish();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
    }
