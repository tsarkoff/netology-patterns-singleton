import java.util.*;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Logger.setVerbal(true);

        // Приветствие
        logger.log("Запускаем программу...");
        logger.log("Просим пользователя ввести входные данные для списка");

        // Ввод размера списка
        int listSize = inputNumber("Введите размер списка: ");

        // Ввод верхней границы списка
        int maxValue = inputNumber("Введите верхнюю границу для значений: ");

        // Создание и наполнение списка
        logger.log("Создаём и наполняем список...");
        List<Integer> list = new Random().ints(listSize, 0, maxValue).boxed().toList();
        logger.log("Вот случайный список: ");
        System.out.println(list);

        // Ввод порога для фильтра
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int threshold = inputNumber("Введите порог для фильтра (исключим все элементы, которые меньше введенного): ");

        // Фильтрация и вывод отфильтрованного списка
        logger.log("Запускаем фильтрацию...");
        Filter filter = new Filter(threshold);
        list = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: ");
        System.out.println(list);

        logger.log("Завершаем программу.");
    }

    // Метод ввода и проверки вводимого числового значения с логом ошибок
    private static int inputNumber(String requestMessage) {
        Scanner scanner = new Scanner(System.in);
        String strInput = "error";
        int intInput;
        while (true) {
            System.out.print(requestMessage);
            try {
                strInput = scanner.nextLine();
                intInput = Integer.parseInt(strInput);
                if (intInput < 1) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (Exception e) {
                Logger logger = Logger.getInstance();
                logger.log(format("\u001B[31m" + "Ошибка. (%s) Вводимое значение должно быть числом больше нуля. Повторите ввод" + "\u001B[0m", strInput));
            }
        }
        return intInput;
    }
}