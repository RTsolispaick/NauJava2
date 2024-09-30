package homework.task5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Реализуйте интерфейс “Task” для выполнения функции обратного
 * отсчёта таймера. Таймер должен начинаться с заданного значения и
 * уменьшаться каждую секунду до нуля, печатая остаток времени в консоль.
 * При вызове метода start() таймер начинает свою работу, при вызове метода
 * stop() таймер останавливается. Для выполнения задания рекомендуется
 * использовать метод “java.lang.Thread#sleep(long)”.
 */
public class Timer implements Task {
    private final AtomicInteger startTime;
    public Thread thread;

    public Timer(int startTime) {
        this.startTime = new AtomicInteger(startTime);
    }

    /**
     * Запускает таймер. В случае отсановки таймера запоминает время.
     */
    @Override
    public void start() {
        if (thread != null) {
            System.out.println("Повторная попытка запуска таймера!");
            return;
        }

        thread = new Thread(() -> {
            while (startTime.get() > 0) {
                if (Thread.currentThread().isInterrupted())
                    return;

                System.out.println("Осталось времени: " + startTime.get() + " секунд");
                startTime.getAndDecrement();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }

            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("Время вышло!");
            }
        });
        thread.start();

        System.out.println("Таймер запущен!");
    }

    /**
     * Останавливает таймер.
     */
    @Override
    public void stop() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
            System.out.println("Таймер остановлен!");
        } else {
            System.out.println("Повторная попытка остановить таймер!");
        }
    }

    /**
     * Пример работы таймера
     */
    public static void example() {
        Timer timer = new Timer(10); // Таймер на 10 секунд
        timer.start();
        timer.start();

        // Пример повторного заупуска таймера через 1 секунду во время работы
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.start();

        // Пример остановки таймера через 4 секунд
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.stop();
        timer.stop();

        // Пример повторной остановки таймера через 1 секунду, когда он остановлен
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.stop();

        // Повторный запуск таймера через 1 секунду, когда он остановлен
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.start();
        timer.stop();
        timer.start();
        timer.stop();
        timer.start();
    }
}
