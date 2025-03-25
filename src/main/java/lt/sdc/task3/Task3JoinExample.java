package lt.sdc.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task3JoinExample {
    private static final Logger logger = LogManager.getLogger(Task3JoinExample.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("task3_input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        int n = Integer.parseInt(lines.get(0).trim());

        Thread child = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                logger.info("Child thread line: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    logger.error("Child thread interrupted", e);
                }
            }
        });

        child.start();
        child.join();

        for (int i = 1; i <= n; i++) {
            logger.info("Main thread line: " + i);
            Thread.sleep(300);
        }

        logger.info("Main thread finished after child.");
    }
}
