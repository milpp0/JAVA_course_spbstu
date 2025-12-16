package practice;

/**
 * Примеры перегрузки и переопределения
 */
public class Practice4_4 {
    
    // Практика 1: Перегрузка
    static class MathOps {
        // 1. Сложение двух чисел
        int sum(int a, int b) {
            return a + b;
        }
        
        // 2. ПЕРЕГРУЗКА: сложение трех чисел
        int sum(int a, int b, int c) {
            return a + b + c;
        }
        
        // 3. ПЕРЕГРУЗКА: сложение дробных чисел
        double sum(double a, double b) {
            return a + b;
        }
    }
    
    // Практика 2: Переопределение
    static class Vehicle {
        void move() {
            System.out.println("Транспорт движется");
        }
    }
    
    static class Car extends Vehicle {
        // ПЕРЕОПРЕДЕЛЕНИЕ метода move()
        @Override
        void move() {
            System.out.println("Машина едет по дороге");
        }
    }
    
    static class Boat extends Vehicle {
        @Override
        void move() {
            System.out.println("Лодка плывет по воде");
        }
    }
    
    // Практика 3: @Override помогает найти ошибки
    static class ParentClass {
        void show() {
            System.out.println("Parent show");
        }
    }
    
    static class ChildClass extends ParentClass {
        // ПРАВИЛЬНО - есть такой метод в ParentClass
        @Override
        void show() {
            System.out.println("Child show");
        }
        
        // ОШИБКА - раскомментируйте чтобы увидеть
        // Метода show2() нет в ParentClass
        /*
        @Override
        void show2() {  // ОШИБКА компиляции благодаря @Override
            System.out.println("Не существует");
        }
        */
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ===\n");
        
        // 1. Перегрузка
        System.out.println("1. ПЕРЕГРУЗКА:");
        System.out.println("--------------");
        MathOps ops = new MathOps();
        System.out.println("sum(2, 3) = " + ops.sum(2, 3));
        System.out.println("sum(2, 3, 4) = " + ops.sum(2, 3, 4));
        System.out.println("sum(2.5, 3.5) = " + ops.sum(2.5, 3.5));
        
        // 2. Переопределение
        System.out.println("\n2. ПЕРЕОПРЕДЕЛЕНИЕ:");
        System.out.println("------------------");
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();    // Полиморфизм
        Vehicle v3 = new Boat();   // Полиморфизм
        
        v1.move(); // Транспорт движется
        v2.move(); // Машина едет по дороге
        v3.move(); // Лодка плывет по воде
        
        // 3. @Override
        System.out.println("\n3. @OVERRIDE:");
        System.out.println("-------------");
        ParentClass p = new ParentClass();
        ChildClass c = new ChildClass();
        
        p.show(); // Parent show
        c.show(); // Child show
        
        System.out.println("\nЕсли типы возвращаемых значений не совпадают:");
        System.out.println("→ ОШИБКА КОМПИЛЯЦИИ");
        
        System.out.println("\n=== КРАТКИЕ ВЫВОДЫ ===");
        System.out.println("\nПерегрузка (Overloading):");
        System.out.println("• Одно имя, разные параметры");
        System.out.println("• Внутри одного класса");
        System.out.println("• Определяется при компиляции");
        
        System.out.println("\nПереопределение (Overriding):");
        System.out.println("• Одинаковая сигнатура");
        System.out.println("• В подклассе");
        System.out.println("• Определяется при выполнении");
        System.out.println("• Реализует полиморфизм");
        
        System.out.println("\n@Override:");
        System.out.println("• Помогает найти ошибки");
        System.out.println("• Всегда используйте при переопределении");
    }
}