package practice;

/**
 * Демонстрация исключений
 */
public class Practice9_1 {
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ИСКЛЮЧЕНИЙ ===\n");
        
        System.out.println("1. ИЕРАРХИЯ ИСКЛЮЧЕНИЙ:");
        System.out.println("----------------------\n");
        
        System.out.println("Throwable");
        System.out.println("├── Error (фатальные ошибки)");
        System.out.println("└── Exception (можно обрабатывать)");
        System.out.println("    └── RuntimeException (ошибки программиста)");
        
        System.out.println("\n2. ПРИМЕРЫ ИСКЛЮЧЕНИЙ:");
        System.out.println("---------------------\n");
        
        // 1. ArithmeticException
        System.out.println("1. ArithmeticException - деление на ноль:");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Поймано: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        
        // 2. ArrayIndexOutOfBoundsException
        System.out.println("\n2. ArrayIndexOutOfBoundsException - выход за границы массива:");
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Поймано: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        
        // 3. IllegalArgumentException
        System.out.println("\n3. IllegalArgumentException - недопустимый аргумент:");
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("   Поймано: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        
        // 4. ClassCastException
        System.out.println("\n4. ClassCastException - неправильное приведение типа:");
        try {
            Object obj = "строка";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("   Поймано: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        
        // 5. NullPointerException
        System.out.println("\n5. NullPointerException - обращение к null:");
        try {
            String text = null;
            int length = text.length();
        } catch (NullPointerException e) {
            System.out.println("   Поймано: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }
        
        // finally блок
        System.out.println("\n6. Блок finally:");
        try {
            System.out.println("   В try блоке");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   В catch блоке");
        } finally {
            System.out.println("   В finally блоке (выполняется всегда)");
        }
        
        System.out.println("\n=== ОТВЕТЫ НА ПРАКТИКИ ===");
        
        System.out.println("\nПрактика #1: Классы исключений:");
        System.out.println("• Throwable - базовый класс для всех исключений");
        System.out.println("• Error - фатальные ошибки (OutOfMemoryError, StackOverflowError)");
        System.out.println("• Exception - исключения, которые можно обработать");
        System.out.println("• RuntimeException - непроверяемые исключения (ошибки программиста)");
        
        System.out.println("\nПрактика #2: Примеры исключений:");
        System.out.println("• ArithmeticException - деление на ноль");
        System.out.println("• ArrayIndexOutOfBoundsException - выход за границы массива");
        System.out.println("• IllegalArgumentException - недопустимый аргумент метода");
        System.out.println("• ClassCastException - неправильное приведение типа");
        System.out.println("• NullPointerException - обращение к null ссылке");
    }
    
    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        System.out.println("   Возраст: " + age);
    }
}