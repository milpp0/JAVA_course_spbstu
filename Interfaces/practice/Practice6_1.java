package practice;

/**
 * Примеры
 */
public class Practice6_1 {
    
    // Практика 1: interface без модификатора
    interface PackageInterface {
        void method();
    }
    
    // Практика 2: public interface
    public interface PublicInterface {
        void method();
    }
    
    // Практика 3-4: protected/private - НЕЛЬЗЯ!
    /*
    protected interface ProtectedInterface { // ОШИБКА
        void method();
    }
    
    private interface PrivateInterface { // ОШИБКА
        void method();
    }
    */
    
    // Пример abstract класса
    interface Animal {
        void eat();
        void sleep();
    }
    
    // Abstract класс - не все методы реализованы
    abstract class AbstractAnimal implements Animal {
        @Override
        public void eat() {
            System.out.println("Ест");
        }
        // sleep() не реализован - поэтому abstract
    }
    
    // Конкретный класс - все методы реализованы
    class Dog extends AbstractAnimal {
        @Override
        public void sleep() {
            System.out.println("Спит");
        }
    }
    
    // Пример с константами
    interface Constants {
        // Неявно public static final
        int MAX = 100;
        String NAME = "Test";
        
        void doSomething();
    }
    
    class MyClass implements Constants {
        @Override
        public void doSomething() {
            System.out.println("Делаю что-то");
            System.out.println("MAX = " + MAX); // Используем константу
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ОТВЕТЫ ===\n");
        
        Practice6_1 demo = new Practice6_1();
        
        System.out.println("1. interface без модификатора:");
        System.out.println("   • package-private (по умолчанию)");
        System.out.println("   • Виден только в пакете");
        
        System.out.println("\n2. public interface:");
        System.out.println("   • Виден везде");
        
        System.out.println("\n3. protected interface:");
        System.out.println("   • НЕЛЬЗЯ на верхнем уровне");
        System.out.println("   • ОШИБКА компиляции");
        
        System.out.println("\n4. private interface:");
        System.out.println("   • НЕЛЬЗЯ на верхнем уровне");
        System.out.println("   • ОШИБКА компиляции");
        
        System.out.println("\n5. Abstract классы:");
        System.out.println("   Если не все методы реализованы,");
        System.out.println("   класс должен быть abstract");
        
        // Демонстрация
        Dog dog = demo.new Dog();
        System.out.println("\nДемонстрация:");
        dog.eat();
        dog.sleep();
        
        System.out.println("\nКонстанты в интерфейсе:");
        System.out.println("Constants.MAX = " + Constants.MAX);
        System.out.println("Constants.NAME = \"" + Constants.NAME + "\"");
        
        System.out.println("\n=== КРАТКИЕ ВЫВОДЫ ===");
        System.out.println("\n• Интерфейсы: public или package-private");
        System.out.println("• protected/private - только внутри классов");
        System.out.println("• Методы: public abstract (по умолчанию)");
        System.out.println("• Поля: public static final (по умолчанию)");
        System.out.println("• Не все методы реализованы → abstract класс");
    }
}