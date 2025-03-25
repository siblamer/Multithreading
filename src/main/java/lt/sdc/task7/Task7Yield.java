package lt.sdc.task7;

import lt.sdc.task6.Task6Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task7Yield {
    private static final Logger logger = LogManager.getLogger(Task6Priority.class);

    public static void main(String[] args) {

        Runnable yielding = () -> {
            for (int i = 0; i < 5; i++) {
                logger.info("Yielding thread");
                Thread.yield();
            }
        };

        Runnable normal = () -> {
            for (int i = 0; i < 5; i++) {
                logger.info("Normal thread");
            }
        };

        new Thread(yielding).start();
        new Thread(normal).start();
    }
}
