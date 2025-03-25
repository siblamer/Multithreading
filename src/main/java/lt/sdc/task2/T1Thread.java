package lt.sdc.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class T1Thread extends Thread {
    private static final Logger logger = LogManager.getLogger(T1Thread.class);

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            logger.info("T1Thread running: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                logger.error("T1Thread interrupted", e);
            }
        }
    }
}
