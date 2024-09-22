package homework;

import utils.RandomGenerator;

import java.util.Arrays;

/**
 * Заполните массив (тип элементов “int”) случайными числами и выполните задание в соответствии со своим вариантом.
 * Вариант 1: Найти максимальное значение по модулю в массиве.
 */
public class Task1
{
    private static int parserArgs(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("""
                    Программа принимает один обязательный аргумент! Ввдите количество чисел в массиве.
                    """);
        }

        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("""
                    Нужно ввести одно любое целое положительное число!
                    """);
        }
    }

    /**
     * Запуск программы
     * @param args ожидается одно целое число, которое будет являться размером массива
     */
    public static void main(String[] args)
    {
        int size = parserArgs(args);

        int[] nums = RandomGenerator.getRandomIntArray(size);

        System.out.println(Arrays.toString(nums));

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}
