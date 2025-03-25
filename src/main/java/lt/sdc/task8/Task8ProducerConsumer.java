package lt.sdc.task8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task8ProducerConsumer {
    private static final Logger logger = LogManager.getLogger(Task8ProducerConsumer.class);

    public static void main(String[] args) {
        AtomicBoolean state = new AtomicBoolean(true);
        int m = 1000;  // задержка переключения состояния (мс)
        int k = 5000;  // общее время обратного отсчёта (мс)

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producer = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                state.set(!state.get());
                logger.info("Producer switched state to: " + state.get());
                try {
                    TimeUnit.MILLISECONDS.sleep(m);
                } catch (InterruptedException e) {
                    logger.warn("Producer interrupted");
                    break;
                }
            }
        };

        Runnable consumer = () -> {
            int remaining = k;
            while (remaining > 0) {
                if (state.get()) {
                    logger.info("Consumer countdown: " + remaining + " ms");
                    try {
                        TimeUnit.MILLISECONDS.sleep(m / 10);
                    } catch (InterruptedException e) {
                        logger.warn("Consumer interrupted");
                        break;
                    }
                    remaining -= m / 10;
                } else {
                    logger.debug("Consumer paused (state is false)");
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        logger.warn("Consumer sleep interrupted");
                        break;
                    }
                }
            }
            executor.shutdownNow();
            logger.info("Countdown complete. Consumer and Producer terminated.");
        };

        executor.submit(producer);
        executor.submit(consumer);
    }
}
