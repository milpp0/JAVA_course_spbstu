package practice;

/**
 * Примеры
 */
public class Practice7_1 {
    
    // Практика 1: Default и статические методы
    interface MyInterface {
        // Абстрактный метод
        void abstractMethod();
        
        // Default метод
        default void defaultMethod() {
            System.out.println("Default метод из интерфейса");
        }
        
        // Статический метод
        static void staticMethod() {
            System.out.println("Статический метод из интерфейса");
        }
    }
    
    static class MyClass implements MyInterface {
        @Override
        public void abstractMethod() {
            System.out.println("Реализация абстрактного метода");
        }
        
        // Можно переопределить default метод (не обязательно)
        @Override
        public void defaultMethod() {
            System.out.println("Переопределенный default метод");
        }
    }
    
    // Практика 2: Конфликт default методов
    interface InterfaceA {
        default void show() {
            System.out.println("show() из InterfaceA");
        }
    }
    
    interface InterfaceB {
        default void show() {
            System.out.println("show() из InterfaceB");
        }
    }
    
    // ОШИБКА: конфликт default методов
    /*
    class ConflictClass implements InterfaceA, InterfaceB {
        // Должен переопределить show()
    }
    */
    
    // Решение 1: Переопределить
    class Solution1 implements InterfaceA, InterfaceB {
        @Override
        public void show() {
            System.out.println("Моя реализация show()");
        }
    }
    
    // Решение 2: Выбрать конкретный интерфейс
    class Solution2 implements InterfaceA, InterfaceB {
        @Override
        public void show() {
            InterfaceA.super.show(); // Используем метод из InterfaceA
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ===\n");
        
        // Практика 1
        System.out.println("1. DEFAULT И СТАТИЧЕСКИЕ МЕТОДЫ:");
        System.out.println("-------------------------------\n");
        
        MyClass obj = new MyClass();
        
        System.out.println("Вызов методов:");
        obj.abstractMethod();    // Абстрактный метод
        obj.defaultMethod();     // Default метод
        
        // Статический метод - только через интерфейс!
        MyInterface.staticMethod();
        // obj.staticMethod(); // ОШИБКА
        // MyClass.staticMethod(); // ОШИБКА
        
        // Практика 2
        System.out.println("\n\n2. КОНФЛИКТ DEFAULT МЕТОДОВ:");
        System.out.println("---------------------------\n");
        
        Practice7_1 demo = new Practice7_1();
        
        System.out.println("Проблема: два интерфейса с одинаковым default методом");
        System.out.println("Решение 1 - переопределить:");
        Solution1 sol1 = demo.new Solution1();
        sol1.show();
        
        System.out.println("\nРешение 2 - выбрать конкретный интерфейс:");
        Solution2 sol2 = demo.new Solution2();
        sol2.show();
        
        System.out.println("\n=== ОТВЕТЫ ===");
        System.out.println("\nПрактика 1:");
        System.out.println("• Default метод: имеет реализацию, можно переопределить");
        System.out.println("• Static метод: вызывается через Interface.method()");
        
        System.out.println("\nПрактика 2:");
        System.out.println("• Если два интерфейса имеют одинаковые default методы,");
        System.out.println("  класс ДОЛЖЕН переопределить этот метод");
        System.out.println("• Можно использовать InterfaceName.super.method()");
        System.out.println("  для вызова конкретной реализации");
    }
}