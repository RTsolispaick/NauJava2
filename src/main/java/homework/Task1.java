package homework;

import utils.RandomGenerator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Заполните массив (тип элементов “int”) случайными числами и выполните задание в соответствии со своим вариантом.
 * Вариант 1: Найти максимальное значение по модулю в массиве.
 */
public class Task1
{
    /**
     * Запуск программы
     */
    public void solve(Scanner scanner) {
        int size = scanner.nextInt();

        int[] nums = RandomGenerator.getRandomIntArray(size);

        System.out.println("Исходный спискок:");
        System.out.println(Arrays.toString(nums));

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, Math.abs(num));
        }

        System.out.println(max);
    }
}
