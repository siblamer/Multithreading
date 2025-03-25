package lt.sdc.task1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildThread extends Thread {

    private static final Logger logger = LogManager.getLogger(ChildThread.class);

    public static int N = 100;

    public ChildThread(Integer N) {
        ChildThread.N = N;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; i++) {
            logger.info("ChildThread  " + i);
        }
    }
}