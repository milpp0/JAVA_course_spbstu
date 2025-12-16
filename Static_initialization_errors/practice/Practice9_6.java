package practice;

/**
 * Практика по статическим блокам и исключениям.
 * Демонстрирует поведение при возникновении исключения в статическом блоке инициализации.
 */
public class Practice9_6 {

    /**
     * Класс для демонстрации проблемы.
     * Содержит статическую константу, которая инициализируется в статическом блоке.
     */
    static class App {
        // Статическая константа (final)
        final static int START_COUNTER;
        
        // Статический блок инициализации
        static {
            // Попытка преобразовать строку "Y-" в число
            // Это вызовет NumberFormatException
            START_COUNTER = Integer.parseInt("Y-");
        }
        
        /**
         * Главный метод приложения.
         * Этот метод никогда не выполнится из-за исключения в статическом блоке.
         */
        public static void main(String[] args) {
            System.out.println("Hello");
        }
    }
    
    /**
     * Улучшенная версия с обработкой исключений.
     */
    static class AppFixed {
        final static int START_COUNTER;
        static boolean initialized = false;
        
        static {
            int tempCounter = 0;
            try {
                // Пробуем преобразовать строку
                tempCounter = Integer.parseInt("Y-");
                initialized = true;
            } catch (NumberFormatException e) {
                // Обрабатываем исключение и используем значение по умолчанию
                System.err.println("Ошибка при инициализации START_COUNTER: " + e.getMessage());
                tempCounter = 0; // Значение по умолчанию
                initialized = false;
            }
            START_COUNTER = tempCounter;
        }
        
        public static void main(String[] args) {
            System.out.println("Программа запущена");
            System.out.println("START_COUNTER = " + START_COUNTER);
            System.out.println("initialized = " + initialized);
        }
    }
    
    /**
     * Альтернативная версия с корректной строкой.
     */
    static class AppAlternative {
        final static int START_COUNTER;
        
        static {
            // Корректная строка для преобразования
            START_COUNTER = Integer.parseInt("10");
        }
        
        public static void main(String[] args) {
            System.out.println("Hello from AppAlternative");
            System.out.println("START_COUNTER = " + START_COUNTER);
        }
    }

    /**
     * Главный метод для демонстрации.
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация исключения в статическом блоке ===\n");
        
        System.out.println("1. Попытка запуска класса App (с ошибкой):");
        System.out.println("--------------------------------------------");
        
        try {
            // Попытка обратиться к классу App вызовет исключение
            Class.forName("StaticInitializationPractice$App");
            System.out.println("Класс App загружен успешно");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (ExceptionInInitializerError e) {
            System.out.println("ExceptionInInitializerError: Произошло исключение при инициализации класса");
            System.out.println("Причина: " + e.getCause().getClass().getName());
            System.out.println("Сообщение: " + e.getCause().getMessage());
        } catch (Throwable e) {
            System.out.println("Другая ошибка: " + e.getClass().getName());
        }
        
        System.out.println("\n2. Запуск исправленной версии AppFixed:");
        System.out.println("----------------------------------------");
        AppFixed.main(args);
        
        System.out.println("\n3. Запуск альтернативной версии AppAlternative:");
        System.out.println("------------------------------------------------");
        AppAlternative.main(args);
        
        System.out.println("\n=== Объяснение происходящего ===");
        System.out.println("\nЧто происходит в классе App:");
        System.out.println("1. JVM пытается загрузить класс App");
        System.out.println("2. Выполняется статический блок инициализации");
        System.out.println("3. В строке Integer.parseInt(\"Y-\") возникает NumberFormatException");
        System.out.println("4. Исключение НЕ перехватывается в статическом блоке");
        System.out.println("5. JVM завершает инициализацию класса с ошибкой");
        System.out.println("6. Выбрасывается ExceptionInInitializerError");
        System.out.println("7. Метод main() никогда не выполняется");
        
        System.out.println("\nПочему возникает NumberFormatException?");
        System.out.println("Метод Integer.parseInt() ожидает строку, содержащую:");
        System.out.println("- Необязательный знак (+ или -)");
        System.out.println("- Цифры (0-9)");
        System.out.println("Строка \"Y-\" содержит недопустимые символы 'Y' и '-' в неправильной позиции");
        
        System.out.println("\nКак правильно обрабатывать такие ситуации:");
        System.out.println("1. Использовать try-catch в статическом блоке");
        System.out.println("2. Предоставлять значения по умолчанию");
        System.out.println("3. Использовать статические методы-инициализаторы");
        System.out.println("4. Проверять входные данные перед преобразованием");
    }
    
    /**
     * Дополнительные примеры для понимания.
     */
    private static void demonstrateNumberFormat() {
        System.out.println("\n--- Примеры работы Integer.parseInt() ---");
        
        String[] testCases = {
            "123",      // OK: 123
            "-456",     // OK: -456
            "+789",     // OK: 789
            "0",        // OK: 0
            " 123 ",    // Ошибка: пробелы
            "12.3",     // Ошибка: точка
            "1,234",    // Ошибка: запятая
            "0xFF",     // Ошибка: шестнадцатеричный формат
            "123abc",   // Ошибка: буквы после цифр
            "abc",      // Ошибка: только буквы
            "Y-",       // Ошибка: как в примере
            "",         // Ошибка: пустая строка
            null        // Ошибка: NullPointerException
        };
        
        for (String str : testCases) {
            try {
                int result = Integer.parseInt(str);
                System.out.printf("Integer.parseInt(\"%s\") = %d%n", str, result);
            } catch (NumberFormatException e) {
                System.out.printf("Integer.parseInt(\"%s\") -> NumberFormatException: %s%n", 
                                 str, e.getMessage());
            } catch (NullPointerException e) {
                System.out.printf("Integer.parseInt(null) -> NullPointerException%n");
            }
        }
    }
    
    /**
     * Пример правильной инициализации статических полей.
     */
    static class ProperInitialization {
        // Вариант 1: Прямая инициализация
        static final int DEFAULT_VALUE = 100;
        
        // Вариант 2: Инициализация в статическом блоке с обработкой исключений
        static final int CONFIG_VALUE;
        static {
            int value;
            try {
                // Может читать из файла конфигурации
                value = Integer.parseInt(System.getProperty("app.value", "50"));
            } catch (NumberFormatException e) {
                value = 50; // Значение по умолчанию
            }
            CONFIG_VALUE = value;
        }
        
        // Вариант 3: Использование метода
        static final int CALCULATED_VALUE = calculateValue();
        
        private static int calculateValue() {
            try {
                return Integer.parseInt("42"); // Корректное значение
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        
        public static void main(String[] args) {
            System.out.println("\n--- Пример правильной инициализации ---");
            System.out.println("DEFAULT_VALUE = " + DEFAULT_VALUE);
            System.out.println("CONFIG_VALUE = " + CONFIG_VALUE);
            System.out.println("CALCULATED_VALUE = " + CALCULATED_VALUE);
        }
    }
}