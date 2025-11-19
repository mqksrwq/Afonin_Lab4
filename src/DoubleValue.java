/**
 * Класс вещественного числа
 */
public class DoubleValue {

    /**
     * Значение числа
     */
    private final double value;

    /**
     * Конструктор по умолчанию
     */
    DoubleValue() {
        this.value = 0.0;
    }

    /**
     * Конструктор с параметрами
     *
     * @param value - значение числа
     */
    DoubleValue(double value) {
        this.value = value;
    }

    /**
     * Метод для получения значения
     *
     * @return значение
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Статический метод для парсинга значения
     *
     * @param value - значение
     * @return - объект класса
     */
    public static DoubleValue parseDoubleValue(String value) {
        double newValue = Double.parseDouble(value);
        return new DoubleValue(newValue);
    }
}
