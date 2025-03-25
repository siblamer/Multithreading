package lt.sdc.task4;

import lt.sdc.task1.ChildThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class T4Thread extends Thread{
    private final List<String> messages;
    private static final Logger logger = LogManager.getLogger(T4Thread.class);

    public T4Thread(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        for (String message : messages) {
            logger.info(message);
        }
    }
}