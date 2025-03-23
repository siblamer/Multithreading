package lt.sdc.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

public class ParamThreads {
    private static final Logger logger = LogManager.getLogger(ParamThreads.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("task3_input.txt").toURI());
        List<String> messages = Files.readAllLines(path);
        ExecutorService executor = Executors.newFixedThreadPool(messages.size());

        for (String message : messages) {
            executor.submit(() -> {
                for (int i = 0; i < 3; i++) {
                    logger.info(Thread.currentThread().getName() + ": " + message);
                    TimeUnit.MILLISECONDS.sleep(300);
                }
                return null;
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
