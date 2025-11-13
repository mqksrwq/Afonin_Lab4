import java.util.Iterator;
import java.util.Queue;

public class QueueIterator {
    private static Iterator<Double> _iterator;

    QueueIterator(Queue<Double> q) {
        _iterator = q.iterator();
    }

    public double nextValue() {
        return _iterator.next();
    }

    public boolean hasNextValue() {
        return _iterator.hasNext();
    }

    public int length() {
        int length = 0;
        while (hasNextValue()) {
            nextValue();
            length++;
        }
        return length;
    }
}