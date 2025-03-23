package lt.sdc.task7;

public class Task7Yield {
    public static void main(String[] args) {
        Runnable yielding = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Yielding thread");
                Thread.yield();
            }
        };

        Runnable normal = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Normal thread");
            }
        };

        new Thread(yielding).start();
        new Thread(normal).start();
    }
}
