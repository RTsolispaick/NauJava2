package homework.task5;

/**
 * Реализуйте интерфейс “Task” для выполнения функции обратного
 * отсчёта таймера. Таймер должен начинаться с заданного значения и
 * уменьшаться каждую секунду до нуля, печатая остаток времени в консоль.
 * При вызове метода start() таймер начинает свою работу, при вызове метода
 * stop() таймер останавливается. Для выполнения задания рекомендуется
 * использовать метод “java.lang.Thread#sleep(long)”.
 */
public class Timer implements Task {
    private volatile int startTime;
    private volatile boolean running;

    public Timer(int startTime) {
        this.startTime = startTime;
        this.running = false;
    }

    /**
     * Запускает таймер. В случае отсановки таймера запоминает время.
     */
    @Override
    public void start() {
        if (running) {
            System.out.println("Таймер уже запущен!");
            return;
        }

        running = true;

        new Thread(() -> {
            int timeLeft = startTime;
            while (timeLeft >= 0 && running) {
                System.out.println("Осталось времени: " + timeLeft + " секунд");
                timeLeft--;

                try {
                    Thread.sleep(1000); // Пауза на 1 секунду
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
                    break;
                }
            }
            if (!running) {
                this.startTime = timeLeft;
                System.out.println("Таймер остановлен.");
            } else {
                System.out.println("Время вышло!");
            }
        }).start();
    }

    /**
     * Останавливает таймер.
     */
    @Override
    public void stop() {
        if (running)
            running = false;
        else
            System.out.println("Таймер уже остановлен!");
    }

    /**
     * Пример работы таймера
     */
    public static void main(String[] args) {
        Timer timer = new Timer(10); // Таймер на 10 секунд
        timer.start();

        // Пример повторного заупуска таймера через 1 секунду во время работы
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.start();

        // Пример остановки таймера через 4 секунд
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

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

        // Пример остановки таймера через 4 секунды
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        timer.stop();
    }
}
