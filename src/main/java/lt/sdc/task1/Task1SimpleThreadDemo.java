package lt.sdc.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

public class SimpleThreadDemo {
    private static final Logger logger = LogManager.getLogger(SimpleThreadDemo.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("task1_input.txt").toURI());
        List<String> lines = Files.readAllLines(path);

        System.out.println(lines);
        int n = Integer.parseInt(lines.get(0));

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Void> child = () -> {
            for (int i = 1; i <= n; i++) {
                logger.info("Child thread: Line " + i);
                TimeUnit.MILLISECONDS.sleep(500);
            }
            return null;
        };
        executor.submit(child);
        for (int i = 1; i <= n; i++) {
            logger.info("Main thread: Line " + i);
            TimeUnit.MILLISECONDS.sleep(500);
        }
        executor.shutdown();
    }
}
