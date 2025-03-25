package lt.sdc.task6;

import lt.sdc.task1.Task1SimpleThreadDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6Priority {
    private static final Logger logger = LogManager.getLogger(Task6Priority.class);

    public static void main(String[] args) {
        Thread low = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.info("Low priority thread");
            }
        }, "Low");

        Thread high = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.info("High priority thread");
            }
        }, "High");

        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();
    }
}
