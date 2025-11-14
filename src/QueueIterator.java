import java.util.Iterator;
import java.util.Queue;

/**
 * Класс итератора односторонней очереди
 */
public class QueueIterator {

    /**
     * Статический объект интерфейса итератора
     */
    private static Iterator<Double> _iterator;

    /**
     * Конструктор с параметром
     *
     * @param q - объект односторонней очереди
     */
    QueueIterator(Queue<Double> q) {
        _iterator = q.iterator();
    }

    /**
     * Метод, возвращающий следующий элемент структуры
     *
     * @return следующий элемент структуры
     */
    public double nextValue() {
        return _iterator.next();
    }

    /**
     * Метод, проверяющий существование следующего элемента структуры
     *
     * @return true/false, если элемент существует/не существует
     */
    public boolean hasNextValue() {
        return _iterator.hasNext();
    }
}
