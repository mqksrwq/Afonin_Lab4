import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Абстрактный класс односторонней очереди
 */
public abstract class OnewayQueue {

    /**
     * Односторонняя очередь
     */
    public final static Queue<Double> _QUEUE = new ArrayDeque<>();

    /**
     * Статический метод добавления значения в очередь
     *
     * @param value - значение, которое нужно добавить в очередь
     * @return сообщение о выполнении/ошибке добавления
     */
    public static String add(double value) {
        try {
            _QUEUE.add(value);
            return "Значение успешно добавлено в очередь";
        } catch (NumberFormatException e) {
            return "Значение не может быть пустым или строковым!";
        }
    }

    /**
     * Статический метод заполнения очереди значениями по умолчанию
     *
     * @return сообщение о добавлении значений в очередь
     */
    public static String fill() {
        add(1.0);
        add(2.0);
        add(3.0);
        add(4.0);
        add(5.0);
        add(6.0);
        return "Значения по умолчанию успешно добавлены в очередь";
    }

    /**
     * Статический метод для проверки на пустую очередь
     *
     * @return true/false, если очередь пустая/заполненная
     */
    public static boolean isEmptyQueue() {
        return _QUEUE.isEmpty();
    }

    /**
     * Статический метод, возвращающий очередь в виде строки
     *
     * @return очередь в виде строки или сообщение об ошибке
     */
    public static String showQueue() {
        QueueIterator iterator = new QueueIterator(_QUEUE);
        if (!iterator.hasNextValue()) {
            return "Очередь пустая";
        }

        StringBuilder sb = new StringBuilder("Очередь: ");

        while (iterator.hasNextValue()) {
            double value = iterator.nextValue();
            sb.append(value);
            sb.append("    ");
        }

        return sb.toString();
    }

    /**
     * Статический метод для циклического сдвига элементов очереди
     * Принцип работы: последний элемент становится первым
     */
    public static void cycleShift() {
        if (!isEmptyQueue()) {
            Double firstElement = _QUEUE.poll();
            add(firstElement);
        }
    }

    /**
     * Статический метод, выполняющий циклические сдвиги до тех пор,
     * пока максимальный элемент не будет первым в очереди
     *
     * @return сообщение об успешном выполнении/ошибке пустой очереди
     */
    public static String taskShift() {
        if (isEmptyQueue()) {
            return "Очередь пустая!";
        }

        double maxValue = _QUEUE.stream().max(Double::compare).get();
        while (_QUEUE.peek() != maxValue) {
            cycleShift();
        }
        return "Циклический сдвиг успешно завершен";
    }
}
