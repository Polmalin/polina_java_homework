package homework1;

import java.util.Arrays;

/*
4.** Написать метод, которому на вход подается одномерный массив и число n
(может быть положительным, или отрицательным), при этом метод должен сместить все
элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи
нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
(на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
При каком n в какую сторону сдвиг можете выбирать сами.
* */
public class Task4 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3};
        shift(array1, 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{3, 5, 6, 1};
        shift(array2, -2);
        System.out.println(Arrays.toString(array2));
    }

    public static void shift(int[] array, int inputShift) {
        boolean isPositive = inputShift >= 0;
        int shift = Math.abs(inputShift) % array.length;
        if (shift == 0) {
            return;
        }
        if (!isPositive) {
            shift = array.length - shift;
        }
        for (int count = 0; count < shift; count++) {
            int temp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                int tempLocal = array[i + 1];
                array[i + 1] = temp;
                temp = tempLocal;
            }
            array[0] = temp;
        }
    }
}
