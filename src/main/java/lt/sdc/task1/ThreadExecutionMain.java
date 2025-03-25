package lt.sdc.task1;

import java.util.concurrent.TimeUnit;

public class ThreadExecutionMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Фиксируем время создания потоков

        Thread highPriorityThread = new Thread(new PriorityThreadTask(startTime, "High-Priority Thread"));
        Thread lowPriorityThread = new Thread(new PriorityThreadTask(startTime, "Low-Priority Thread"));

        // Устанавливаем приоритеты
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Максимальный приоритет (10)
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);  // Минимальный приоритет (1)

        highPriorityThread.start();
        lowPriorityThread.start();

        try {
            highPriorityThread.join(); // Ждем завершения обоих потоков
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread started");
    }

    static class PriorityThreadTask implements Runnable {
        private final long startTime;
        private final String threadName;

        public PriorityThreadTask(long startTime, String threadName) {
            this.startTime = startTime;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            long runTime = System.currentTimeMillis(); // Фиксируем время запуска потока
            long elapsedTime = runTime - startTime; // Вычисляем разницу между созданием и запуском

            System.out.println(threadName + " started after " + elapsedTime + " ms");

            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + ": " + i);
            }

            long endTime = System.currentTimeMillis(); // Фиксируем время завершения потока
            long executionTime = endTime - runTime; // Вычисляем, сколько времени заняло выполнение потока

            System.out.println(threadName + " finished! Execution time: " + executionTime + " ms");
        }
    }
}
