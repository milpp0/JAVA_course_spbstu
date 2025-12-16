package practice;

/**
 * Максимально простые примеры
 */
public class Practice5_2 {
    
    // Практика 1: Вложенный класс в интерфейсе
    interface MathOperations {
        // Константа
        String NAME = "Math Operations";
        
        // Вложенный класс (неявно public static)
        class Calculator {
            public int add(int a, int b) {
                return a + b;
            }
            
            public int subtract(int a, int b) {
                return a - b;
            }
            
            // Может использовать константу интерфейса
            public void showName() {
                System.out.println("Название: " + NAME);
            }
        }
    }
    
    // Другой пример
    interface Vehicle {
        class Factory {
            public static Vehicle createCar() {
                return new Car();
            }
            
            public static Vehicle createBike() {
                return new Bike();
            }
        }
        
        void move();
    }
    
    static class Car implements Vehicle {
        public void move() {
            System.out.println("Машина едет");
        }
    }
    
    static class Bike implements Vehicle {
        public void move() {
            System.out.println("Велосипед едет");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ===\n");
        
        // Пример 1: Создание и использование вложенного класса
        System.out.println("1. СОЗДАНИЕ ВЛОЖЕННОГО КЛАССА:");
        System.out.println("----------------------------\n");
        
        // Способ вызова: Интерфейс.ВложенныйКласс
        MathOperations.Calculator calc = new MathOperations.Calculator();
        
        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("5 - 3 = " + calc.subtract(5, 3));
        calc.showName();
        
        // Пример 2: Фабричный метод
        System.out.println("\n2. ФАБРИЧНЫЙ МЕТОД:");
        System.out.println("------------------\n");
        
        Vehicle car = Vehicle.Factory.createCar();
        Vehicle bike = Vehicle.Factory.createBike();
        
        car.move();
        bike.move();
        
        System.out.println("\n=== ОТВЕТ НА ПРАКТИКУ ===");
        System.out.println("\nСПОСОБ ВЫЗОВА МЕТОДА ВЛОЖЕННОГО КЛАССА:");
        System.out.println("\n1. Создать объект вложенного класса:");
        System.out.println("   InterfaceName.NestedClassName obj = new InterfaceName.NestedClassName();");
        System.out.println("   obj.methodName();");
        
        System.out.println("\n2. Если метод статический:");
        System.out.println("   InterfaceName.NestedClassName.staticMethod();");
        
        System.out.println("\nПример из кода:");
        System.out.println("   MathOperations.Calculator calc = new MathOperations.Calculator();");
        System.out.println("   calc.add(5, 3);");
        
        System.out.println("\n=== ВАЖНЫЕ МОМЕНТЫ ===");
        System.out.println("\n• Вложенные классы в интерфейсах неявно public static");
        System.out.println("• Имеют доступ только к static членам интерфейса");
        System.out.println("• Не требуют реализации интерфейса для использования");
        System.out.println("• Полезны для утилитных классов и фабрик");
    }
}