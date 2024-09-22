package homework;

import utils.RandomGenerator;

import java.util.ArrayList;

/**
 * Заполните список (тип “ArrayList<Double>”) случайным числами и отсортируйте его.
 * Вариант 1: Сортировка слиянием (Merge Sort).
 */
public class Task2 {
    /**
     * Сливает два подмассива ArrayList<Double>.
     * Первый подмассив — это arr[l..m], второй — arr[m+1..r].
     *
     * @param arr список с элементами типа Double, который будет сортироваться
     * @param l   начало первого подмассива
     * @param m   середина, где первый подмассив заканчивается и второй начинается
     * @param r   конец второго подмассива
     */
    static private void merge(ArrayList<Double> arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Double> L = new ArrayList<>(n1);
        ArrayList<Double> R = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m + 1 + j));

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    /**
     * Рекурсивно сортирует подсписок arr[l..r] используя сортировку слиянием.
     *
     * @param arr список с элементами типа Double, который нужно отсортировать
     * @param l   начало подсписка для сортировки
     * @param r   конец подсписка для сортировки
     */
    static private void sort(ArrayList<Double> arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

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
    public static void main(String[] args) {
        int size = parserArgs(args);

        ArrayList<Double> arr = RandomGenerator.getRandomDoubleList(size);

        System.out.println("Исходный список:");
        System.out.println(arr);

        sort(arr, 0, arr.size() - 1);

        System.out.println("Отсортированный список:");
        System.out.println(arr);
    }
}
