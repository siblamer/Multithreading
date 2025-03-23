package lt.sdc.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadVsRunnable {
    private static final Logger logger = LogManager.getLogger(ThreadVsRunnable.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1Thread();
        Thread t2 = new Thread(new T1RunnableThread());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        logger.info("Both threads finished.");
    }
}
