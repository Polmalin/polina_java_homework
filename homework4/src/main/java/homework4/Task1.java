package homework4;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

/*
Реализовать консольное приложение, которое:
1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти.
4. Если введено exit, то программа завершается

> - ввод в консоль (stdin), < - вывод на консоль (stdout)
> java
> python
> c#
> print
< [c#, python, java]
> revert
> print
< [python, java]
> revert
> revert
> print
< []
> revert -> throw new NoSuchElementException
 */
public class Task1 {
    private static final Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String word = scanner.nextLine();
            switch (word) {
                case "print":
                    print();
                    break;
                case "revert":
                    revert();
                    break;
                case "exit":
                    return;
                default:
                    add(word);
            }
        }
    }

    private static void print() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (ListIterator<String> iter = stack.listIterator(stack.size()); iter.hasPrevious(); ) {
            stringJoiner.add(iter.previous());
        }
        System.out.println(stringJoiner);
    }

    private static void revert() {
        stack.pop();
    }

    private static void add(String word) {
        stack.add(word);
    }
}
