/**
 * Практика по использованию блока finally.
 * Демонстрирует различные конструкции try-catch-finally.
 */
public class FinallyBlockPractice {

    /**
     * Главный метод приложения.
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация блока finally ===\n");
        
        // Практика #1: try без catch и finally
        System.out.println("Практика #1: try без catch и finally");
        demonstrateTryWithoutCatchAndFinally();
        
        System.out.println("\n---\n");
        
        // Практика #2: try только с finally
        System.out.println("Практика #2: try только с finally");
        demonstrateTryWithFinallyOnly();
        
        System.out.println("\n---\n");
        
        // Практика #3: Попытка использовать два блока finally
        System.out.println("Практика #3: Попытка использовать два блока finally");
        demonstrateTwoFinallyBlocks();
        
        System.out.println("\n=== Конец демонстрации ===");
    }
    
    /**
     * Практика #1: Демонстрация try без catch и finally.
     * Вопрос: Можно ли использовать конструкцию try { ... } ?
     * 
     * Ответ: НЕТ, такая конструкция недопустима.
     * Каждый блок try должен иметь хотя бы один блок catch или блок finally.
     * 
     * Закомментированный код ниже вызовет ошибку компиляции.
     */
    private static void demonstrateTryWithoutCatchAndFinally() {
        System.out.println("Следующая конструкция НЕдопустима и вызовет ошибку компиляции:");
        System.out.println("/*");
        System.out.println("try {");
        System.out.println("    System.out.println(\"Этот код не скомпилируется\");");
        System.out.println("}");
        System.out.println("*/");
        
        System.out.println("\nОшибка компиляции будет примерно такой:");
        System.out.println("Error: 'try' without 'catch', 'finally' or resource declarations");
        
        // Раскомментируйте для проверки:
        /*
        try {
            System.out.println("Этот код не скомпилируется");
        }
        */
    }
    
    /**
     * Практика #2: Демонстрация try только с finally.
     * Вопрос: Можно ли использовать конструкцию try { ... } finally { ... } ?
     * 
     * Ответ: ДА, такая конструкция допустима и часто используется.
     * finally выполняется всегда, независимо от того, было исключение или нет.
     */
    private static void demonstrateTryWithFinallyOnly() {
        System.out.println("Конструкция try-finally ДОПУСТИМА:");
        
        // Пример 1: Без исключения
        System.out.println("\nПример 1: Без исключения в try");
        try {
            System.out.println("  try: Выполняем код без исключений");
            int result = 10 / 2;
            System.out.println("  try: Результат деления: " + result);
        } finally {
            System.out.println("  finally: Этот блок выполнится ВСЕГДА");
        }
        
        // Пример 2: С исключением
        System.out.println("\nПример 2: С исключением в try");
        try {
            System.out.println("  try: Пытаемся разделить на ноль...");
            int result = 10 / 0; // ArithmeticException
            System.out.println("  try: Эта строка не выполнится");
        } finally {
            System.out.println("  finally: Этот блок выполнится ДАЖЕ при исключении");
        }
        
        // Пример 3: try-finally с возвратом значения
        System.out.println("\nПример 3: try-finally с возвратом значения");
        int value = getValueWithFinally();
        System.out.println("  Возвращенное значение: " + value);
    }
    
    /**
     * Метод демонстрирует поведение return в try-finally.
     * finally выполняется ДО возврата значения из метода.
     * 
     * @return значение, которое будет возвращено
     */
    private static int getValueWithFinally() {
        try {
            System.out.println("  try: Возвращаем значение 1");
            return 1;
        } finally {
            System.out.println("  finally: Выполняется перед возвратом значения");
            // Код в finally выполнится, даже если в try есть return
            // Но изменить возвращаемое значение уже нельзя
        }
    }
    
    /**
     * Практика #3: Попытка использовать два блока finally.
     * Вопрос: Можно ли использовать конструкцию с двумя finally?
     * 
     * Ответ: НЕТ, у одного блока try может быть только ОДИН блок finally.
     * finally должен быть последним блоком после всех catch-блоков.
     */
    private static void demonstrateTwoFinallyBlocks() {
        System.out.println("Следующая конструкция НЕдопустима:");
        System.out.println("/*");
        System.out.println("try {");
        System.out.println("    // какой-то код");
        System.out.println("} finally {");
        System.out.println("    System.out.println(\"Первый finally\");");
        System.out.println("} finally {"); // ОШИБКА!
        System.out.println("    System.out.println(\"Второй finally\");");
        System.out.println("}");
        System.out.println("*/");
        
        System.out.println("\nОшибка компиляции будет примерно такой:");
        System.out.println("Error: 'finally' without 'try'");
        System.out.println("Error: 'try' without 'catch', 'finally' or resource declarations");
        
        System.out.println("\nПравильная конструкция с одним finally:");
        try {
            System.out.println("  try: Выполняем основной код");
            // Может быть исключение или нет
            String str = null;
            if (Math.random() > 0.5) {
                str.length(); // Может вызвать NullPointerException
            }
        } catch (NullPointerException e) {
            System.out.println("  catch: Перехватили NullPointerException");
        } finally {
            System.out.println("  finally: Единственный блок finally выполняется всегда");
        }
    }
    
    /**
     * Дополнительный пример: Комплексное использование try-catch-finally.
     * Демонстрирует полную конструкцию.
     */
    private static void demonstrateCompleteTryCatchFinally() {
        System.out.println("\n--- Дополнительный пример ---");
        System.out.println("Полная конструкция try-catch-finally:");
        
        try {
            System.out.println("try: Начало выполнения");
            
            // Симулируем разные сценарии
            int scenario = (int)(Math.random() * 3);
            
            switch (scenario) {
                case 0:
                    System.out.println("try: Сценарий 0 - без исключений");
                    break;
                case 1:
                    System.out.println("try: Сценарий 1 - ArithmeticException");
                    int result = 10 / 0; // Вызовет исключение
                    break;
                case 2:
                    System.out.println("try: Сценарий 2 - ArrayIndexOutOfBoundsException");
                    int[] arr = new int[3];
                    arr[5] = 10; // Вызовет исключение
                    break;
            }
            
            System.out.println("try: Конец выполнения (без исключений)");
            
        } catch (ArithmeticException e) {
            System.out.println("catch: Перехвачено ArithmeticException: " + e.getMessage());
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch: Перехвачено ArrayIndexOutOfBoundsException: " + e.getMessage());
            
        } finally {
            System.out.println("finally: Этот код выполнится ВСЕГДА");
            System.out.println("finally: Очистка ресурсов, закрытие файлов и т.д.");
        }
        
        System.out.println("Продолжение работы после try-catch-finally");
    }
}