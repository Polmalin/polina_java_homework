import java.util.Arrays;
import java.util.Random;

/*
2. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
лементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
* */
public class Task2 {

    public static void main(String[] args) {
        int size = 3;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - i - 1] = 1;
        }

        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
