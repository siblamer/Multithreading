package lt.sdc.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParentThread extends Thread {
    private static final Logger logger = LogManager.getLogger(ParentThread.class);
    public static int N = 100;

    public ParentThread(Integer N) {
    }

    @Override
    public void run() {
        Thread childThread = new Thread(new ChildThread(N));
        childThread.start();
        for (int i = 0; i < N; i++) {
            logger.info("Parent-Thread  " + i);
        }
    }
}