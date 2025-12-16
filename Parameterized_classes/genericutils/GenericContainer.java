package genericutils;

/**
 * Утилитный параметризованный класс для демонстрации
 * различных сценариев использования instanceof
 * @param <T> тип хранимых данных
 */
public class GenericContainer<T> {
    private T value;
    
    public GenericContainer(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    /**
     * Проверка типа хранимого значения с помощью instanceof
     * @return true если значение является Number
     */
    public boolean isNumber() {
        // Проверка с raw type (без каста)
        return value instanceof Number;
    }
    
    /**
     * Проверка типа с последующим кастом
     * @return значение как Number или null
     */
    public Number getAsNumber() {
        if (value instanceof Number) {
            return (Number) value;
        }
        return null;
    }
    
    /**
     * Проверка на конкретный тип Number
     * @return true если значение Integer
     */
    public boolean isInteger() {
        return value instanceof Integer;
    }
    
    /**
     * Проверка на принадлежность к иерархии классов
     * @return true если значение CharSequence (String, StringBuilder и т.д.)
     */
    public boolean isCharSequence() {
        return value instanceof CharSequence;
    }
    
    /**
     * Безопасное приведение типа с проверкой
     * @return значение как String или null
     */
    public String getAsString() {
        if (value instanceof String) {
            return (String) value;
        } else if (value instanceof CharSequence) {
            return value.toString();
        }
        return null;
    }
    
    /**
     * Проверка массива с generic типом
     * @return true если значение является массивом
     */
    public boolean isArray() {
        return value != null && value.getClass().isArray();
    }
    
    /**
     * Проверка типа массива элементов
     * @return true если значение является массивом Integer
     */
    public boolean isIntegerArray() {
        return value instanceof Integer[];
    }
}