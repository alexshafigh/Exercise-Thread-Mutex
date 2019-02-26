package WaxOMatic_lock_condition;

import WaxOMatic_lock_condition.Car;

import java.util.concurrent.TimeUnit;

public class PolisherTask implements Runnable {
    Car car;

    public PolisherTask(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
                car.waitForPolish();
                car.polishzadan();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
    }
