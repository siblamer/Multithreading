package lt.sdc.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task4ParamThreads {
    private static final Logger logger = LogManager.getLogger(Task4ParamThreads.class);
    private static final int N = 10;
    public static void main(String[] args) throws Exception {

        Path path = Paths.get(ClassLoader.getSystemResource("task1_input.txt").toURI());
        List<String> lines = Files.readAllLines(path);

        for (int i = 1; i <= N; i++) {
            T4Thread thread = new T4Thread(lines);
            thread.start();
        }
    }
}
