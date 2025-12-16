package genericutils;

import entities.Vehicle;

/**
 * Утилитный параметризованный класс для демонстрации
 * различных сценариев использования instanceof и wildcards
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
    
    /**
     * Пример метода с <? extends T> для чтения
     * @param container контейнер с Number или его подклассами
     * @return сумма значений
     */
    public static double sumNumbers(GenericContainer<? extends Number> container) {
        Number num = container.getValue();
        return num != null ? num.doubleValue() : 0.0;
    }
    
    /**
     * Пример метода с <? super T> для записи
     * @param container контейнер для Vehicle или его суперклассов
     * @param vehicle транспортное средство для добавления
     */
    public static <T extends Vehicle> void setVehicle(
            GenericContainer<? super T> container, T vehicle) {
        // Можем установить любое транспортное средство типа T
        System.out.println("Установка транспортного средства: " + vehicle.getName());
        // В реальной реализации здесь было бы сохранение значения
    }
}