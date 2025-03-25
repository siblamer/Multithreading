package lt.sdc.task5;

import lt.sdc.task4.T4Thread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Task5Interrupted extends Thread{
    private static final Logger logger = LogManager.getLogger(Task5Interrupted.class);

    public static void main(String[] args) {
        Thread sleeper = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                logger.info("Thread was interrupted: " + e);
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
