import java.time.LocalDateTime;
import java.util.Scanner;

/*
3. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
"Доброе утро, <Имя>!", если время от 05:00 до 11:59
"Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
* */
public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваше имя ");
        String name = scanner.nextLine();

        LocalDateTime localDateTime = LocalDateTime.now();
        String greeting;
        if (localDateTime.getHour() >= 5 && localDateTime.getHour() < 12) {
            greeting = "Доброе утро";
        } else if (localDateTime.getHour() >= 12 && localDateTime.getHour() < 18) {
            greeting = "Добрый день";
        } else if (localDateTime.getHour() >= 18 && localDateTime.getHour() < 23) {
            greeting = "Добрый вечер";
        } else {
            greeting = "Доброй ночи";
        }
        System.out.println(greeting + ", " + name);
    }
}
