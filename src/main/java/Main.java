import homework.Task1;
import homework.Task2;
import homework.Task3;
import homework.Task4;
import homework.task5.Timer;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Маслов Артемий. 1 вариант.");
        System.out.println();
        System.out.println("Первое задание. Введите размер массива:");
        new Task1().solve(scanner);
        System.out.println();
        System.out.println("Второе задание. Введите размер массива:");
        new Task2().solve(scanner);
        System.out.println();
        System.out.println("Третье задание:");
        new Task3().solve();
        System.out.println();
        System.out.println("Четвёртое задание:");
        new Task4().solve();
        System.out.println();
        System.out.println("Пятое задание. Пример таймера на 10 секунд:");
        Timer.example();
    }
}
