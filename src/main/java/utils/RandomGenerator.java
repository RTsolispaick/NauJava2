package utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс для генерации случайных чисел и заполнения массивов или коллекций.
 */
public class RandomGenerator {
    private static final Random rand = new Random();

    private RandomGenerator() {}

    /**
     * Возвращает массив случайных целых чисел.
     *
     * @param size размер массива
     * @return массив int[], заполненный случайными целыми числами
     */
    public static int[] getRandomIntArray(int size) {
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextInt();
        }

        return nums;
    }

    /**
     * Возвращает ArrayList, заполненный случайными числами типа Double.
     *
     * @param size размер списка
     * @return ArrayList<Double>, заполненный случайными числами
     */
    public static ArrayList<Double> getRandomDoubleList(int size) {
        ArrayList<Double> nums = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            nums.add(rand.nextDouble());
        }

        return nums;
    }
}
