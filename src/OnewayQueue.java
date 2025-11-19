import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Абстрактный класс односторонней очереди
 */
public abstract class OnewayQueue {

    /**
     * Односторонняя очередь
     */
    public final static Queue<DoubleValue> _QUEUE = new ArrayDeque<>();

    /**
     * Статический метод добавления значения в очередь
     *
     * @param value - значение, которое нужно добавить в очередь
     * @return сообщение о выполнении/ошибке добавления
     */
    public static String add(DoubleValue value) {
        try {
            _QUEUE.add(value);
            return "Значение успешно добавлено в очередь";
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }

    /**
     * Статический метод заполнения очереди значениями по умолчанию
     *
     * @return сообщение о добавлении значений в очередь
     */
    public static String fill() {
        add(new DoubleValue(1.5));
        add(new DoubleValue(12.5));
        add(new DoubleValue(3.5));
        add(new DoubleValue(2.5));
        add(new DoubleValue(5.5));
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
            DoubleValue value = iterator.nextValue();
            sb.append(value.getValue());
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
            DoubleValue firstElement = _QUEUE.poll();
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

        double maxValue = _QUEUE.stream().map(DoubleValue::getValue).max(Double::compareTo).get();
        while (_QUEUE.peek().getValue() != maxValue) {
            cycleShift();
        }
        return "Циклический сдвиг успешно завершен";
    }
}
