import java.util.ArrayDeque;
import java.util.Queue;

public class OnewayQueue {
    private double _value;
    public final static Queue<Double> _QUEUE = new ArrayDeque<>();

    public static String add(double value) {
        try {
            _QUEUE.add(value);
            return "Значение успешно добавлено в очередь";
        } catch (NumberFormatException e) {
            return "Значение не может быть пустым или строковым!";
        }
    }

    public static String fill() {
        add(1.0);
        add(2.0);
        add(3.0);
        add(4.0);
        add(5.0);
        add(6.0);
        return "Значения по умолчанию успешно добавлены в очередь";
    }

    public double getValue() {
        return _value;
    }

    public static boolean isEmptyQueue() {
        return _QUEUE.isEmpty();
    }

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

    public static void cycleShift() {
        if (!isEmptyQueue()) {
            Double firstElement = _QUEUE.poll();
            add(firstElement);
        }
    }

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