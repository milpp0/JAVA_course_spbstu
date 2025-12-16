package practice;

/**
 * Практика по обработке исключений.
 * Демонстрирует:
 * 1. Перехват и обработку одного исключения
 * 2. Неперехваченное исключение, которое приводит к аварийной остановке
 */
public class Practice9_2 {

    /**
     * Главный метод приложения.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("=== Начало работы программы ===");
        
        try {
            // Вызываем метод, который может генерировать исключения
            processData();
        } catch (ArithmeticException e) {
            // Это исключение будет перехвачено здесь
            System.out.println("Перехвачено исключение в main: " + e.getMessage());
        }
        
        System.out.println("=== Конец работы программы ===");
    }
    
    /**
     * Метод для обработки данных, который может генерировать исключения.
     * 
     * @throws ArithmeticException если происходит деление на ноль
     */
    private static void processData() {
        System.out.println("\nВход в метод processData()");
        
        // Пример 1: Исключение, которое будет перехвачено
        try {
            int result = divideNumbers(10, 0); // Деление на ноль
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            // Перехватываем исключение и выводим сообщение
            System.out.println("Перехвачено исключение в processData(): " + e.getMessage());
        }
        
        // Пример 2: Исключение, которое НЕ будет перехвачено
        // Создаем массив из 3 элементов
        int[] numbers = {1, 2, 3};
        
        System.out.println("\nПопытка доступа к несуществующему элементу массива...");
        
        // Пытаемся обратиться к элементу с индексом 5 (которого не существует)
        // Это вызовет ArrayIndexOutOfBoundsException
        int value = numbers[5];
        System.out.println("Значение элемента: " + value); // Эта строка не выполнится
        
        System.out.println("Выход из метода processData()"); // Эта строка также не выполнится
    }
    
    /**
     * Метод для деления двух чисел.
     * 
     * @param a делимое
     * @param b делитель
     * @return результат деления a на b
     * @throws ArithmeticException если делитель равен нулю
     */
    private static int divideNumbers(int a, int b) {
        if (b == 0) {
            // Генерируем исключение при делении на ноль
            throw new ArithmeticException("Деление на ноль! Делитель b = " + b);
        }
        return a / b;
    }
}