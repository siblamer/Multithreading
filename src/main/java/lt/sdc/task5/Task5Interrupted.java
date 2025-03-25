package lt.sdc.task5;

import java.util.concurrent.TimeUnit;

public class Task5Interrupted extends Thread{
    public static void main(String[] args) {
        Thread sleeper = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e);
            }
        });

        sleeper.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignored) {
        }

        sleeper.interrupt();
    }
}
