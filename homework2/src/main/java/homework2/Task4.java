package homework2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// К калькулятору из предыдущего ДЗ добавить логирование.
public class Task4 {
    private static Logger logger = Logger.getLogger(Task4.class.getName());

    public static void main(String[] args) throws IOException {
        initLogger();
        Scanner scanner = new Scanner(System.in);
        //один раз создали и пользуемся!
        System.out.println("Enter the first number...");
        double a = scanner.nextDouble();
        System.out.println("Enter the operator (+ - * /)...");
        char op = scanner.next().charAt(0);
        System.out.println("Enter the second number...");
        double b = scanner.nextDouble();
        switch (op) {
            case '+':
                logger.log(Level.INFO, a + " + " + b + " = " + add(a, b));
                break;
            case '-':
                logger.log(Level.INFO, a + " - " + b + " = " + minus(a, b));
                break;
            case '*':
                logger.log(Level.INFO, a + " * " + b + " = " + mult(a, b));
                break;
            case '/':
                logger.log(Level.INFO, a + " / " + b + " = " + divide(a, b));
                break;
            default:
                logger.log(Level.INFO, "Wrong operation!");
        }
        scanner.close();
    }

    private static void initLogger() throws IOException {
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
    }

    private static double divide(double a, double b) {
        if (b != 0) return a / b;
        else
            return -1;
    }

    private static double mult(double a, double b) {
        return a * b;
    }

    private static double minus(double a, double b) {
        return a - b;
    }

    private static double add(double a, double b) {
        return a + b;
    }
}

