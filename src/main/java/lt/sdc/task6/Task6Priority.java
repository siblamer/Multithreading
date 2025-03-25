package lt.sdc.task6;

public class Task6Priority {
    public static void main(String[] args) {
        Thread low = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low priority thread");
            }
        }, "Low");

        Thread high = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High priority thread");
            }
        }, "High");

        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();
    }
}
