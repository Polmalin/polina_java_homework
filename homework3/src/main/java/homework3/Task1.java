package homework3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
Задание

Пусть дан произвольный список целых чисел.

1) Найти максимальное значение
2) Найти минимальное значение
3) Найти среднее значение
4) Нужно удалить из него чётные числа
 */
public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(20));
        }
        for (Integer value : list) {
            System.out.println(value);
        }
        int size = list.size();
        int max = list.get(0);
        int min = list.get(0);
        int index = 0;
        double avg = 0;
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            int value = iterator.next();
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            avg += value;
            if (++index % 2 == 0) {
                iterator.remove();
            }
        }
        avg /= size;
        System.out.println("maximum - " + max);
        System.out.println("minimum - " + min);
        System.out.println("average - " + avg);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
