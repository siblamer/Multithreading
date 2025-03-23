package lt.sdc.task1;

import java.util.concurrent.TimeUnit;

public class YieldThreadDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Фиксируем общее начало работы потоков

        Thread highPriorityThread = new Thread(new Task("High-Priority Thread", startTime));
        Thread lowPriorityThread = new Thread(new Task("Low-Priority Thread", startTime));

        // Устанавливаем разные приоритеты
//        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10
//        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);  // 1

        highPriorityThread.start();
        lowPriorityThread.start();

        try {
            highPriorityThread.join(); // Ждем завершения потоков
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nMain thread finished execution.");
    }

    static class Task implements Runnable {
        private final String threadName;
        private final long startTime;

        public Task(String threadName, long startTime) {
            this.threadName = threadName;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long threadStartTime = System.currentTimeMillis(); // Фиксируем время старта потока
            long elapsedSinceMainStart = threadStartTime - startTime; // Разница между созданием потока и его запуском

            System.out.println(threadName + " started after " + elapsedSinceMainStart + " ms");

            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " is executing step " + i);

                // Уступаем процессор другим потокам
                Thread.yield();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis(); // Фиксируем время завершения потока
            long executionTime = endTime - threadStartTime; // Вычисляем, сколько времени заняло выполнение

            System.out.println(threadName + " finished! Execution time: " + executionTime + " ms");
        }
    }
}
