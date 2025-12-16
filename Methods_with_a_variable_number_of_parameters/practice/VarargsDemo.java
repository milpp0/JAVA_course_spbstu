package practice;

/**
 * Демонстрация перегруженных методов с переменным числом параметров (varargs)
 * С правильной обработкой null значений
 */
public class VarargsDemo {
    
    static class MathUtils {
        // 1. Сумма целых чисел
        public static int sum(int... numbers) {
            System.out.print("sum(int...): ");
            // Проверка на null (хотя для примитивов маловероятно)
            if (numbers == null) {
                System.out.print("null array! ");
                return 0;
            }
            int total = 0;
            for (int num : numbers) {
                total += num;
            }
            return total;
        }
        
        // 2. Сумма вещественных чисел - ПЕРЕГРУЗКА
        public static double sum(double... numbers) {
            System.out.print("sum(double...): ");
            if (numbers == null) {
                System.out.print("null array! ");
                return 0.0;
            }
            double total = 0.0;
            for (double num : numbers) {
                total += num;
            }
            return total;
        }
        
        // 3. Сумма двух чисел - другая сигнатура (без varargs)
        public static int sum(int a, int b) {
            System.out.print("sum(int, int): ");
            return a + b;
        }
        
        // 4. Сумма трех чисел - другая сигнатура
        public static int sum(int a, int b, int c) {
            System.out.print("sum(int, int, int): ");
            return a + b + c;
        }
        
        // 5. Среднее значение - с начальным параметром
        public static double average(int count, double... values) {
            System.out.print("average(int, double...): ");
            if (values == null || count <= 0) {
                return 0.0;
            }
            double total = 0.0;
            for (double val : values) {
                total += val;
            }
            return total / count;
        }
    }
    
    static class StringUtils {
        // 6. Конкатенация строк
        public static String concat(String... strings) {
            System.out.print("concat(String...): ");
            if (strings == null) {
                return "[null array]";
            }
            StringBuilder result = new StringBuilder();
            for (String str : strings) {
                result.append(str != null ? str : "null");
            }
            return result.toString();
        }
        
        // 7. Конкатенация с разделителем
        public static String join(String delimiter, String... strings) {
            System.out.print("join(String, String...): ");
            if (strings == null) {
                return "[null array]";
            }
            // String.join не обрабатывает null элементы, поэтому используем свой метод
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (i > 0) {
                    result.append(delimiter);
                }
                result.append(strings[i] != null ? strings[i] : "null");
            }
            return result.toString();
        }
        
        // 8. Безопасная версия join с обработкой null
        public static String safeJoin(String delimiter, String... strings) {
            if (strings == null) {
                return "";
            }
            return joinInternal(delimiter, strings);
        }
        
        private static String joinInternal(String delimiter, String... strings) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (i > 0) {
                    result.append(delimiter);
                }
                result.append(strings[i] != null ? strings[i] : "");
            }
            return result.toString();
        }
    }
    
    static class PrintUtils {
        // 9. Универсальный метод печати с безопасной обработкой null
        public static void print(Object... objects) {
            System.out.print("print(Object...): ");
            // Критически важная проверка!
            if (objects == null) {
                System.out.println("null (весь массив null)");
                return;
            }
            
            if (objects.length == 0) {
                System.out.println("[] (пустой массив)");
                return;
            }
            
            for (int i = 0; i < objects.length; i++) {
                System.out.print(objects[i] != null ? objects[i].toString() : "null");
                if (i < objects.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        // 10. Печать с префиксом и безопасной обработкой
        public static void printWithPrefix(String prefix, Object... objects) {
            System.out.print("printWithPrefix(String, Object...): ");
            System.out.print(prefix + ": ");
            
            if (objects == null) {
                System.out.println("null");
                return;
            }
            
            for (Object obj : objects) {
                System.out.print(obj != null ? obj.toString() : "null");
                System.out.print(" ");
            }
            System.out.println();
        }
        
        // 11. Безопасная печать для пользовательского ввода
        public static void safePrint(Object... objects) {
            // Всегда безопасно, даже если передали null
            Object[] safeObjects = objects != null ? objects : new Object[]{null};
            
            System.out.print("safePrint(Object...): ");
            for (Object obj : safeObjects) {
                System.out.print(obj != null ? obj.toString() : "[null]");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ПЕРЕГРУЖЕННЫХ VARARGS МЕТОДОВ ===\n");
        
        // Пример 1: Разные типы параметров
        System.out.println("1. ПЕРЕГРУЗКА ПО ТИПУ:");
        System.out.println(MathUtils.sum(1, 2, 3));
        System.out.println(MathUtils.sum(1.5, 2.5, 3.5));
        
        // Пример 2: Разное количество параметров
        System.out.println("\n2. ПЕРЕГРУЗКА ПО КОЛИЧЕСТВУ:");
        System.out.println(MathUtils.sum(10, 20));
        System.out.println(MathUtils.sum(10, 20, 30));
        System.out.println(MathUtils.sum(1, 2, 3, 4, 5));
        
        // Пример 3: Смешанные параметры
        System.out.println("\n3. СМЕШАННЫЕ ПАРАМЕТРЫ:");
        System.out.println(MathUtils.average(3, 10.0, 20.0, 30.0));
        
        // Пример 4: Работа со строками
        System.out.println("\n4. РАБОТА СО СТРОКАМИ:");
        System.out.println(StringUtils.concat("Hello", " ", "World"));
        System.out.println(StringUtils.join(", ", "Apple", "Banana", "Cherry"));
        
        // Пример 5: Печать различных объектов
        System.out.println("\n5. УНИВЕРСАЛЬНАЯ ПЕЧАТЬ:");
        PrintUtils.print(1, "text", 3.14, true);
        PrintUtils.printWithPrefix("Данные", 42, "ответ");
        
        // Пример 6: Граничные случаи - ИСПРАВЛЕННЫЕ!
        System.out.println("\n6. ГРАНИЧНЫЕ СЛУЧАИ:");
        
        // Пустой varargs
        System.out.println("Пустой varargs - sum(): " + MathUtils.sum());
        
        // Один аргумент
        System.out.println("Один аргумент - sum(5): " + MathUtils.sum(5));
        
        // Пустая печать
        PrintUtils.print();
        
        // Null как varargs параметр - ТЕПЕРЬ РАБОТАЕТ!
        System.out.println("\nВажные примеры с null:");
        
        // Способ 1: Явное приведение к массиву
        PrintUtils.print((Object) null); // Один null объект
        PrintUtils.print((Object[]) null); // null массив (теперь безопасно!)
        
        // Способ 2: Массив с null элементами
        PrintUtils.print(null, "text", null);
        
        // Способ 3: Использование safePrint
        PrintUtils.safePrint((Object[]) null);
        PrintUtils.safePrint(null, null, null);
        
        // Пример с массивом строк
        System.out.println("\nРабота с null в строках:");
        System.out.println("concat с null: " + StringUtils.concat(null, "Hello", null, "World"));
        System.out.println("join с null: " + StringUtils.join(", ", "A", null, "C"));
        System.out.println("safeJoin с null: " + StringUtils.safeJoin(", ", "A", null, "C"));
        
        // Пример 7: Массивы как varargs
        System.out.println("\n7. МАССИВЫ КАК VARARGS:");
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Сумма массива: " + MathUtils.sum(numbers));
        
        String[] words = {"Java", "is", "great"};
        System.out.println("Конкатенация массива: " + StringUtils.concat(words));
        
        // Пример 8: Разные способы передачи null
        System.out.println("\n8. РАЗНЫЕ СПОСОБЫ ПЕРЕДАЧИ NULL:");
        
        // Опасные способы (могут вызвать NPE без проверки):
        System.out.println("Опасный вызов (закомментирован):");
        System.out.println("// PrintUtils.print(null); // Неоднозначно!");
        System.out.println("// MathUtils.sum(null);   // Не работает с примитивами");
        
        // Безопасные способы:
        System.out.println("\nБезопасные способы:");
        
        // 1. Явное создание массива
        PrintUtils.print(new Object[]{null});
        
        // 2. Использование нескольких параметров
        PrintUtils.print(null, null);
        
        // 3. Использование безопасного метода
        PrintUtils.safePrint(null);
        
        // 4. Переменная с явным типом
        Object[] nullArray = null;
        PrintUtils.print(nullArray);
        
        // Пример 9: Демонстрация проблемы и решения
        System.out.println("\n9. ПРОБЛЕМА И РЕШЕНИЕ:");
        demonstrateNullProblem();
        
        System.out.println("\n=== ВЫВОДЫ И РЕКОМЕНДАЦИИ ===");
        printConclusions();
    }
    
    /**
     * Демонстрация проблемы с null в varargs
     */
    private static void demonstrateNullProblem() {
        System.out.println("ПРОБЛЕМА: NullPointerException в varargs методах");
        System.out.println("\nРассмотрим метод:");
        System.out.println("  void printAll(Object... objects) {");
        System.out.println("      for (Object obj : objects) { ... }");
        System.out.println("  }");
        
        System.out.println("\nОПАСНЫЙ ВЫЗОВ:");
        System.out.println("  printAll(null);");
        System.out.println("  // Это интерпретируется как null-массив, не как массив с null!");
        
        System.out.println("\nПОЧЕМУ ЭТО ПРОИСХОДИТ:");
        System.out.println("  При вызове printAll(null):");
        System.out.println("  1. Компилятор видит один аргумент - null");
        System.out.println("  2. Он создает массив Object[] и помещает туда null");
        System.out.println("  3. Но если передать (Object[])null - это null ссылка на массив!");
        
        System.out.println("\nРЕШЕНИЕ:");
        System.out.println("  1. ВСЕГДА проверяйте varargs параметр на null:");
        System.out.println("     if (objects == null) { ... }");
        
        System.out.println("\n  2. Используйте безопасные обертки:");
        System.out.println("     public void safePrint(Object... objects) {");
        System.out.println("         Object[] safe = objects != null ? objects : new Object[]{null};");
        System.out.println("         ...");
        System.out.println("     }");
        
        System.out.println("\n  3. Явно указывайте тип при передаче null:");
        System.out.println("     printAll((Object) null);    // Один null элемент");
        System.out.println("     printAll(new Object[]{null}); // Массив с null");
        System.out.println("     printAll(null, null);       // Два null элемента");
    }
    
    /**
     * Выводы и рекомендации
     */
    private static void printConclusions() {
        System.out.println("\n1. ВАЖНЫЕ ПРАВИЛА ДЛЯ VARARGS С NULL:");
        System.out.println("   ✓ ВСЕГДА проверяйте varargs параметр на null в начале метода");
        System.out.println("   ✓ null как отдельный аргумент != null как массив");
        System.out.println("   ✓ Для примитивных типов (int..., double...) null вызывает ошибку");
        
        System.out.println("\n2. БЕЗОПАСНЫЕ СПОСОБЫ ПЕРЕДАЧИ NULL:");
        System.out.println("   ✓ print((Object) null)        - один null объект");
        System.out.println("   ✓ print(null, null)           - два null объекта");
        System.out.println("   ✓ print(new Object[]{null})   - массив с null");
        System.out.println("   ✓ Использовать safe-версии методов");
        
        System.out.println("\n3. ОПАСНЫЕ СИТУАЦИИ:");
        System.out.println("   ✗ print(null)                 - неоднозначно!");
        System.out.println("   ✗ sum(null)                   - для примитивов");
        System.out.println("   ✗ Не проверять objects == null в цикле for-each");
        
        System.out.println("\n4. ЛУЧШИЕ ПРАКТИКИ:");
        System.out.println("   • Создавайте safe-версии методов для публичного API");
        System.out.println("   • Документируйте поведение с null");
        System.out.println("   • Используйте аннотации @Nullable/@NonNull если возможно");
        System.out.println("   • Проверяйте varargs в начале метода и обрабатывайте специальные случаи");
        
        System.out.println("\n5. ШАБЛОН ДЛЯ БЕЗОПАСНЫХ VARARGS МЕТОДОВ:");
        System.out.println("   public void safeMethod(Object... params) {");
        System.out.println("       // 1. Проверка на null");
        System.out.println("       if (params == null) {");
        System.out.println("           params = new Object[]{null}; // или другая обработка");
        System.out.println("       }");
        System.out.println("       ");
        System.out.println("       // 2. Работа с данными");
        System.out.println("       for (Object param : params) {");
        System.out.println("           // 3. Проверка элементов на null");
        System.out.println("           process(param != null ? param : DEFAULT_VALUE);");
        System.out.println("       }");
        System.out.println("   }");
        
        System.out.println("Varargs создает скрытый массив.");
        System.out.println("Null может быть либо массивом, либо элементом массива.");
    }
    
    /**
     * Дополнительный пример: фабрика для безопасной работы с varargs
     */
    static class SafeVarargsFactory {
        
        // Безопасный конструктор массива
        public static <T> T[] safeArray(T... elements) {
            // elements никогда не будет null внутри метода
            // (если передать null, он станет массивом с null ссылкой)
            return elements != null ? elements : (T[]) new Object[0];
        }
        
        // Безопасная обработка varargs
        public static void processSafely(String... items) {
            String[] safeItems = items != null ? items : new String[0];
            System.out.println("Обработка " + safeItems.length + " элементов:");
            for (String item : safeItems) {
                System.out.println("  - " + (item != null ? item : "[null]"));
            }
        }
        
        // Утилита для безопасного объединения
        public static String safeConcat(String... parts) {
            if (parts == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String part : parts) {
                sb.append(part != null ? part : "");
            }
            return sb.toString();
        }
    }
}