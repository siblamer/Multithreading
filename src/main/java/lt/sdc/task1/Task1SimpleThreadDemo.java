package lt.sdc.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task1SimpleThreadDemo extends Thread {
    private static final Logger logger = LogManager.getLogger(Task1SimpleThreadDemo.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("task1_input.txt").toURI());
        List<String> lines = Files.readAllLines(path);

        System.out.println(lines);
        int n = Integer.parseInt(lines.get(0));

        ParentThread parentThread = new ParentThread(100);
        parentThread.start();

    }
}
