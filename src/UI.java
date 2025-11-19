import java.util.Scanner;

/**
 * Класс взаимодействия с пользователем
 */
public class UI {

    /**
     * Объект класса Scanner для считывания данных
     */
    private final Scanner _SC;

    /**
     * Конструктор по умолчанию
     */
    UI() {
        _SC = new Scanner(System.in);
    }

    /**
     * Метод для вывода информации о работе и бригаде
     */
    private void displayInfo() {
        System.out.println("===== Лабораторная работа №4 =====");
        System.out.println("===== Бригада 9: Бояркин М., Мишин А.");
    }

    /**
     * Метод взамодействия с пользователем
     */
    public void run() {
        displayInfo();
        menuUI();
        String input = _SC.nextLine();
        while (!input.equals("6")) {
            try {
                switch (input) {
                    case "1":
                        addUI();
                        break;
                    case "2":
                        fillUI();
                        break;
                    case "3":
                        showUI();
                        break;
                    case "4":
                        shiftUI();
                        break;
                    case "5":
                        saveUI();
                        break;
                    default:
                        System.out.println("Некорректный выбор!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("\n");
            menuUI();
            input = _SC.nextLine();
        }
        System.out.println("===== Завершение программы.... =====");
    }

    /**
     * Метод для вывода меню действий
     */
    private void menuUI() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить значение в очередь");
        System.out.println("2. Заполнить очередь значениями по умолчанию");
        System.out.println("3. Вывести очередь");
        System.out.println("4. Выполнить циклический сдвиг до максимального элемента");
        System.out.println("5. Сохранить репозиторий в файл");
        System.out.println("6. Выход");
        System.out.print("\nВыбор пользователя: ");
    }

    /**
     * Метод для вывода информации о добавлении элемента
     */
    private void addUI() {
        System.out.print("Введите значение: ");
        String input = _SC.nextLine();
        String message = OnewayQueue.add(DoubleValue.parseDoubleValue(input));
        System.out.println(message);
        showUI();
    }

    /**
     * Метод для вывода информации о заполнении по умолчанию
     */
    private void fillUI() {
        String message = OnewayQueue.fill();
        System.out.println(message);
        showUI();
    }

    /**
     * Метод для вывода очереди
     */
    private void showUI() {
        String message = OnewayQueue.showQueue();
        System.out.println(message);
    }

    /**
     * Метод для вывода информации о циклическом сдвиге
     */
    private void shiftUI() {
        String message = OnewayQueue.taskShift();
        System.out.println(message);
        showUI();
    }

    /**
     * Метод для вывода информации о сохранении в файл
     */
    private void saveUI() {
        System.out.print("Введите название файла: ");
        String fileName = _SC.nextLine();
        boolean success = ResultSaver.isFileExist(fileName);

        if (success) {
            success = ResultSaver.saveToFile(fileName);
            if (success) {
                System.out.println("Сохранено в файл " + fileName);
            } else {
                System.out.println("Ошибка при сохранении в файл " + fileName);
            }
        } else {
            System.out.println("Ошибка: файл с именем" + fileName + "не существует!");
            System.out.println("Хотите создать файл с этим названием?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            System.out.print("Выбор пользователя: ");
            String input = _SC.nextLine();

            switch (input) {
                case "1":
                    success = ResultSaver.saveToFile(fileName);
                    if (success) {
                        System.out.println("Сохранено в файл " + fileName);
                    } else {
                        System.out.println("Ошибка при сохранении в файл " + fileName);
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Некорректный выбор!");
                    break;
            }
        }
    }
}
