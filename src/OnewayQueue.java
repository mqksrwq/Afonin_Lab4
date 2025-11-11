import java.util.LinkedList;
import java.util.Queue;

public class OnewayQueue {
    private double _value;
    private final static Queue<Double> _QUEUE = new LinkedList<>();

    public static void fillQueue() {
        _QUEUE.add(0.6);
        _QUEUE.add(3.4);
        _QUEUE.add(8.7);
        _QUEUE.add(12.4);
        _QUEUE.add(5.12);
    }

    public double getValue() {
        return this._value;
    }

    public String valueToString(double value) {
        return Double.toString(value);
    }

    public static String showQueue() {
        QueueIterator iterator = new QueueIterator(_QUEUE);
        if (!iterator.hasNextValue()) {
            return "Очередь пустая";
        }
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNextValue()) {
            double value = iterator.nextValue();
            sb.append(value).append("\t");
        }
        return sb.toString();
    }
}