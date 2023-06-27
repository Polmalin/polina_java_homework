package homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
Создать множество ноутбуков (ArrayList).
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
 Выводить только те ноутбуки, что соответствуют условию
 */
public class Task1 {
    private static final List<Laptop> laptops = init();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Laptop filterLaptop = new Laptop();
            System.out.println("Введите модель: ");
            filterLaptop.setModel(toNull(scanner.nextLine()));
            System.out.println("Введите цвет: ");
            filterLaptop.setColor(toNull(scanner.nextLine()));
            System.out.println("Введите минимальную память: ");
            filterLaptop.setRam(parseToInteger(toNull(scanner.nextLine())));
            System.out.println("Введите минимальное количество ядер: ");
            filterLaptop.setCpuCores(parseToInteger(toNull(scanner.nextLine())));
            print(filter(filterLaptop));
        }
    }

    private static void print(List<Laptop> laptops) {
        if (laptops == null || laptops.isEmpty()) {
            System.out.println("nichego net");
            return;
        }
        for (Laptop laptop : laptops) {
            System.out.println(laptop.toString());
        }
    }

    private static List<Laptop> filter(Laptop filterLaptop) {
        List<Laptop> laptops = new ArrayList<>();
        for (Laptop laptop : Task1.laptops) {
            if ((filterLaptop.getModel() == null || filterLaptop.getModel().equals(laptop.getModel()))
                    && (filterLaptop.getColor() == null || filterLaptop.getColor().equals(laptop.getColor()))
                    && (filterLaptop.getRam() == null || filterLaptop.getRam() < laptop.getRam())
                    && (filterLaptop.getCpuCores() == null || filterLaptop.getCpuCores() < laptop.getCpuCores())) {
                laptops.add(laptop);
            }
        }
        return laptops;
    }

    private static Integer parseToInteger(String input) {
        return input == null ? null : Integer.parseInt(input);
    }

    private static String toNull(String input) {
        return "".equals(input) ? null : input;
    }

    private static List<Laptop> init() {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("hp", "red", 4096, 4));
        laptops.add(new Laptop("hp", "blue", 8192, 4));
        laptops.add(new Laptop("samsung", "pink", 4096, 8));
        laptops.add(new Laptop("hp", "white", 4096, 4));
        laptops.add(new Laptop("samsung", "grey", 8192, 4));
        laptops.add(new Laptop("lenovo", "red", 4096, 4));
        laptops.add(new Laptop("honor", "blue", 4096, 8));
        laptops.add(new Laptop("asus", "white", 8762, 16));
        laptops.add(new Laptop("asus", "orange", 4578, 4));
        laptops.add(new Laptop("honor", "green", 6789, 4));
        return laptops;
    }
}
