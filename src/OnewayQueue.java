import java.util.ArrayDeque;
import java.util.Queue;

public class OnewayQueue {
    private double _value;
    public final static Queue<Double> _QUEUE = new ArrayDeque<>();

    public static void fillQueue() {
        _QUEUE.add(1.0);
        _QUEUE.add(2.0);
        _QUEUE.add(3.0);
        _QUEUE.add(4.0);
        _QUEUE.add(5.0);
        _QUEUE.add(6.0);
    }

    public double getValue() {
        return _value;
    }

    public static boolean isEmptyQueue() {
        return _QUEUE.isEmpty();
    }

    public static String showQueue() {
        return _QUEUE.toString();
    }

    public static void cycleShift() {
        if (!_QUEUE.isEmpty()) {
            Double firstElement = _QUEUE.poll();
            _QUEUE.add(firstElement);
        }
    }
}