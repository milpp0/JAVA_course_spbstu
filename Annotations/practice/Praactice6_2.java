package practice;

import java.lang.annotation.*;

/**
 * Максимально простые примеры
 */
public class Praactice6_2 {
    
    // Встроенные аннотации
    static class Example {
        @Override
        public String toString() {
            return "Пример";
        }
        
        @Deprecated
        public void oldMethod() {
            System.out.println("Устарело!");
        }
        
        @SuppressWarnings("unused")
        public void test() {
            int x = 10; // Без предупреждения
        }
    }
    
    // Создаем свою аннотацию
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation {
        String author();
        String version() default "1.0";
    }
    
    // Используем аннотацию
    @MyAnnotation(author = "Иван", version = "2.0")
    static class MyClass {
        public void show() {
            System.out.println("Мой класс");
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ АННОТАЦИЙ ===\n");
        
        // 1. Встроенные аннотации
        System.out.println("1. ВСТРОЕННЫЕ АННОТАЦИИ:");
        System.out.println("-----------------------\n");
        
        Example ex = new Example();
        System.out.println("toString(): " + ex.toString());
        ex.oldMethod(); // Предупреждение при компиляции
        
        System.out.println("\n• @Override - проверяет переопределение");
        System.out.println("• @Deprecated - помечает устаревшее");
        System.out.println("• @SuppressWarnings - скрывает предупреждения");
        
        // 2. Собственная аннотация
        System.out.println("\n\n2. СОБСТВЕННАЯ АННОТАЦИЯ:");
        System.out.println("------------------------\n");
        
        // Читаем аннотацию через рефлексию
        Class<MyClass> clazz = MyClass.class;
        
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("Аннотация класса MyClass:");
            System.out.println("  Автор: " + annotation.author());
            System.out.println("  Версия: " + annotation.version());
        }
        
        // 3. Создание аннотации
        System.out.println("\n\n3. КАК СОЗДАТЬ АННОТАЦИЮ:");
        System.out.println("------------------------\n");
        
        System.out.println("Шаг 1: Объявить аннотацию");
        System.out.println("""
            @interface MyAnnotation {
                String value();
            }
            """);
        
        System.out.println("\nШаг 2: Добавить мета-аннотации");
        System.out.println("""
            @Target(ElementType.TYPE)       // Для классов
            @Retention(RetentionPolicy.RUNTIME) // Сохранять в runtime
            @interface MyAnnotation {
                String value();
            }
            """);
        
        System.out.println("\nШаг 3: Использовать");
        System.out.println("""
            @MyAnnotation(value = "Тест")
            class MyClass {
                // ...
            }
            """);
        
        System.out.println("\nШаг 4: Читать через рефлексию");
        System.out.println("""
            MyAnnotation ann = MyClass.class.getAnnotation(MyAnnotation.class);
            System.out.println(ann.value()); // "Тест"
            """);
        
        System.out.println("\n=== КРАТКИЕ ОТВЕТЫ ===");
        System.out.println("\n@Override:");
        System.out.println("  • Проверяет правильность переопределения");
        System.out.println("  • Находит опечатки");
        
        System.out.println("\n@Deprecated:");
        System.out.println("  • Помечает устаревший код");
        System.out.println("  • Показывает предупреждение");
        
        System.out.println("\n@SuppressWarnings:");
        System.out.println("  • Скрывает предупреждения компилятора");
        System.out.println("  • Используйте осторожно!");
    }
}