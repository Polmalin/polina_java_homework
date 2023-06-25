package homework5;

import javax.sound.midi.Soundbank;
import java.util.*;

/*
Реализовать консольное приложение - телефонный справочник.
У одной фамилии может быть несколько номеров.
Пользователь может вводить команды:
1: ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
2: GET Ivanov - получить список всех номеров по фамилии
3: REMOVE Ivanov - удалить все номера по фамилии
4: LIST - Посмотреть все записи
5: EXIT - Завершить программу

Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
.

Пример взаимодействия (=> - это вывод на консоль):
ADD Ivanov 8 800 555 35 35
ADD Ivanov 8 800 100 10 10
GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
ADD Petrov 8 555 12 34
LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
REMOVE Ivanov
LIST => Petrov = [8 555 12 34]
GET NoName => Не найдена запись с фамилией "NoName"
REMOVE NoName => Не найдена запись с фамилией "NoName"3
 */
public class Task1 {
    private static final Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Input input = parse(scanner.nextLine().trim());
            switch (input.command.toUpperCase()) {
                case "ADD":
                    add(input);
                    break;
                case "GET":
                    get(input.name);
                    break;
                case "REMOVE":
                    remove(input.name);
                    break;
                case "LIST":
                    list();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("unknown command: " + input.command);
                    break;
            }
        }
    }

    private static void list() {
        map.forEach((k, v) -> System.out.println(k + " " + toString(v)));
    }

    private static void remove(String name) {
        if (!map.containsKey(name)) {
            System.out.println("Не найдена запись с фамилией \"" + name + "\"");
            return;
        }
        map.remove(name);
    }

    private static void get(String name) {
        List<String> list = map.get(name);
        if (list == null) {
            System.out.println("Не найдена запись с фамилией \"" + name + "\"");
            return;
        }
        System.out.println(toString(list));
    }

    private static String toString(List<String> list) {
        return Arrays.toString(list.toArray());
    }

    private static Input parse(String line) {
        Input input = new Input();
        int firstSpace = line.indexOf(' ');
        if (firstSpace == -1) {
            input.command = line;
            return input;
        }
        input.command = line.substring(0, firstSpace);
        int secondSpace = line.indexOf(' ', firstSpace + 1);
        if (secondSpace == -1) {
            input.name = line.substring(firstSpace + 1);
            return input;
        }
        input.name = line.substring(firstSpace + 1, secondSpace);
        input.phone = line.substring(secondSpace + 1);
        return input;
    }

    private static void add(Input input) {
        List<String> list = map.computeIfAbsent(input.name, k -> new ArrayList<>());
        list.add(input.phone);
    }
}
