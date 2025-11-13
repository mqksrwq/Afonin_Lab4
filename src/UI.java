import java.util.Scanner;

public class UI {
    private final Scanner _SC;

    UI() {
        _SC = new Scanner(System.in);
    }

    private void displayInfo() {
        System.out.println("===== Лабораторная работа №4 =====");
        System.out.println("===== Бригада 9: Бояркин М., Мишин А.");
    }

    public void run() {
        displayInfo();
        menu();
        String input = _SC.nextLine();
        while (!input.equals("6")) {
            try {
                switch (input) {
                    case "1":
                        addInterface();
                        break;
                    case "2":
                        fillInterface();
                        break;
                    case "3":
                        showInterface();
                        break;
                    case "4":
                        shiftInterface();
                        break;
                    case "5":
                        saveInterface();
                        break;
                    default:
                        System.out.println("Некорректный выбор!");
                }
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
            System.out.print("\n");
            menu();
            input = _SC.nextLine();
        }
        System.out.println("===== Завершение программы.... =====");
    }

    private void menu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить значение в очередь");
        System.out.println("2. Заполнить очередь значениями по умолчанию");
        System.out.println("3. Вывести очередь");
        System.out.println("4. Выполнить циклический сдвиг до максимального элемента");
        System.out.println("5. Сохранить репозиторий в файл");
        System.out.println("6. Выход");
        System.out.print("\nВыбор пользователя: ");
    }

    private void addInterface() {
        System.out.print("Введите значение: ");
        String input = _SC.nextLine();
        String message = OnewayQueue.add(Double.parseDouble(input));
        System.out.println(message);
    }

    private void fillInterface() {
        String message = OnewayQueue.fill();
        System.out.println(message);
    }

    private void showInterface() {
        String message = OnewayQueue.showQueue();
        System.out.println(message);
    }

    private void shiftInterface() {
        String message = OnewayQueue.taskShift();
        System.out.println(message);
    }

    private void saveInterface() {
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
