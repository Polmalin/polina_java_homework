package homework1;

import java.util.Arrays;
import java.util.Random;

//1. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
public class Task1 {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        System.out.println("array: " + Arrays.toString(array));

        int max = array[0];
        int min = max;
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        System.out.println("min value: " + min + ", max value: " + max);
    }
}
