public class OnewayQueue {
    private static Node _front;
    private static Node _rear;
    private static int _size;

    private OnewayQueue() {
    }

    public static void add(double value) {
        Node newNode = new Node(value);

        if (_rear == null) {
            _front = _rear = newNode;
        } else {
            _rear.next = newNode;
            _rear = newNode;
        }
        _size++;
    }

    public static double remove() {
        if (_front == null) {
            throw new IllegalStateException("Очередь пустая");
        }

        double value = _front.value;
        _front = _front.next;

        if (_front == null) {
            _rear = null;
        }

        _size--;
        return value;
    }

    public static void fill() {
        add(0.6);
        add(3.4);
        add(8.7);
        add(12.4);
        add(5.12);
    }

    public static double peek() {
        if (_front == null) {
            throw new IllegalStateException("Очередь пустая");
        }
        return _front.value;
    }

    public static boolean isEmpty() {
        return _front == null;
    }

    public static int size() {
        return _size;
    }

//    public static String showQueue() {
//        if (isEmpty()) {
//            return "Очередь пустая";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        QueueIterator iterator = new QueueIterator(_front);
//    }
}