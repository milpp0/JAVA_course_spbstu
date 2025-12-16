package practice;

import java.io.IOException;

/**
 * Практика по обработке исключений с несколькими catch-блоками.
 * Демонстрирует:
 * 1. Обработку нескольких исключений одинаковым образом
 * 2. Иерархию исключений и порядок catch-блоков
 * 3. Вложенные try-блоки
 * 4. Использование final в catch
 */
public class Practice9_3 {
    
    /**
     * Иерархия пользовательских исключений.
     */
    // Базовое исключение
    static class BaseException extends Exception {
        public BaseException(String message) {
            super(message);
        }
    }
    
    // Производное исключение
    static class DerivedException extends BaseException {
        public DerivedException(String message) {
            super(message);
        }
    }
    
    // Самое производное исключение
    static class MoreDerivedException extends DerivedException {
        public MoreDerivedException(String message) {
            super(message);
        }
    }

    /**
     * Главный метод приложения.
     */
    public static void main(String[] args) {
        System.out.println("=== Начало работы программы ===\n");
        
        // Демонстрация 1: Обработка разных исключений одинаковым образом
        System.out.println("1. Демонстрация одинаковой обработки разных исключений:");
        handleMultipleExceptions();
        
        System.out.println("\n---\n");
        
        // Демонстрация 2: Иерархия исключений
        System.out.println("2. Демонстрация иерархии исключений:");
        handleExceptionHierarchy();
        
        System.out.println("\n---\n");
        
        // Демонстрация 3: Вложенные try-блоки
        System.out.println("3. Демонстрация вложенных try-блоков:");
        nestedTryBlocks();
        
        System.out.println("\n=== Конец работы программы ===");
    }
    
    /**
     * Пример 1: Обработка нескольких исключений одинаковым образом.
     * Демонстрирует:
     * - Обработку ArithmeticException и ArrayIndexOutOfBoundsException одинаковым образом
     * - Использование | для объединения НЕсвязанных исключений
     * - Использование final в catch
     */
    private static void handleMultipleExceptions() {
        try {
            // Генерируем одно из исключений (можно изменить на 1 для другого исключения)
            int choice = 0;
            
            if (choice == 0) {
                // ArithmeticException: деление на ноль
                int result = 10 / 0;
            } else {
                // ArrayIndexOutOfBoundsException: выход за границы массива
                int[] arr = new int[3];
                arr[5] = 10;
            }
            
            // Этот блок также может генерировать NullPointerException,
            // но он не будет достигнут в данном примере
            String str = null;
            str.length();
            
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            // Обработка ArithmeticException и ArrayIndexOutOfBoundsException одинаковым образом
            // Эти исключения НЕ связаны иерархически, поэтому использование | допустимо
            System.out.println("Ошибка вычислений или доступа к массиву: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            
        } catch (final NullPointerException e) {
            // Использование final в catch - переменная e не может быть изменена
            // final предотвращает случайное переприсваивание переменной исключения
            System.out.println("Перехвачено NullPointerException с final");
            
            // Попытка изменить e вызовет ошибку компиляции:
            // e = new NullPointerException("Новое исключение"); // Ошибка!
        }
    }
    
    /**
     * Пример 2: Иерархия исключений.
     * Демонстрация правильного порядка catch-блоков для иерархии исключений.
     */
    private static void handleExceptionHierarchy() {
        try {
            // Генерируем самое производное исключение
            throw new MoreDerivedException("Самое производное исключение");
            
        } catch (MoreDerivedException e) {
            // Перехват самого производного исключения
            System.out.println("Перехвачено MoreDerivedException: " + e.getMessage());
            
        } catch (DerivedException e) {
            // Перехват исключения среднего уровня
            System.out.println("Перехвачено DerivedException: " + e.getMessage());
            
        } catch (BaseException e) {
            // Перехват базового исключения
            System.out.println("Перехвачено BaseException: " + e.getMessage());
        }
        
        System.out.println("\nДемонстрация НЕправильного порядка (закомментировано):");
        System.out.println("/*");
        System.out.println("try {");
        System.out.println("    throw new MoreDerivedException(\"test\");");
        System.out.println("} catch (BaseException e) {");  // Базовый класс первый - ОШИБКА!
        System.out.println("    System.out.println(\"BaseException\");");
        System.out.println("} catch (DerivedException e) {");  // Этот блок никогда не выполнится
        System.out.println("    System.out.println(\"DerivedException\");");  // Недостижимый код
        System.out.println("}");
        System.out.println("*/");
        
        System.out.println("\nДемонстрация НЕдопустимого использования | с иерархией:");
        System.out.println("/*");
        System.out.println("try {");
        System.out.println("    // какой-то код");
        System.out.println("} catch (BaseException | DerivedException e) {");  // ОШИБКА компиляции!
        System.out.println("    // DerivedException является подклассом BaseException");
        System.out.println("    // поэтому такое объединение недопустимо");
        System.out.println("}");
        System.out.println("*/");
    }
    
    /**
     * Пример 3: Вложенные try-блоки.
     * Демонстрация использования вложенных конструкций try-catch.
     */
    private static void nestedTryBlocks() {
        System.out.println("Внешний try-блок");
        
        try {
            // Внешний блок
            System.out.println("  Внешний блок: начало");
            
            try {
                // Внутренний блок 1
                System.out.println("    Внутренний блок 1: начало");
                
                // Имитируем исключение во внутреннем блоке
                int[] arr = new int[2];
                arr[3] = 10;  // ArrayIndexOutOfBoundsException
                
                System.out.println("    Внутренний блок 1: конец");  // Не выполнится
                
            } catch (ArrayIndexOutOfBoundsException e) {
                // Обработка исключения во внутреннем блоке
                System.out.println("    Внутренний блок 1: перехвачено ArrayIndexOutOfBoundsException");
                System.out.println("    Сообщение: " + e.getMessage());
            }
            
            try {
                // Внутренний блок 2
                System.out.println("    Внутренний блок 2: начало");
                
                // Имитируем другое исключение
                String str = null;
                str.length();  // NullPointerException
                
                System.out.println("    Внутренний блок 2: конец");  // Не выполнится
                
            } catch (NullPointerException e) {
                // Обработка исключения во втором внутреннем блоке
                System.out.println("    Внутренний блок 2: перехвачено NullPointerException");
                System.out.println("    Сообщение: " + e.getMessage());
                
                // Можно сгенерировать исключение для внешнего блока
                throw new RuntimeException("Исключение из внутреннего блока 2", e);
            }
            
            System.out.println("  Внешний блок: продолжение после внутренних блоков");
            
        } catch (RuntimeException e) {
            // Обработка исключения из внутреннего блока во внешнем блоке
            System.out.println("  Внешний блок: перехвачено RuntimeException");
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Причина: " + e.getCause().getClass().getSimpleName());
        } finally {
            // Блок finally выполнится в любом случае
            System.out.println("  Внешний блок: выполняется finally");
        }
        
        System.out.println("Внешний try-блок: завершение");
    }
}