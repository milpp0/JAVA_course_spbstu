package practice;

/**
 * Пример со статическими методами
 */
public class Practice4_5 {
    
    static class Parent {
        // Статический метод
        static void show() {
            System.out.println("Parent static show");
        }
        
        // Обычный метод
        void display() {
            System.out.println("Parent display");
        }
    }
    
    static class Child extends Parent {
        // Это НЕ переопределение, а сокрытие
        static void show() {
            System.out.println("Child static show");
        }
        
        // Это настоящее переопределение
        @Override
        void display() {
            System.out.println("Child display");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТОЙ ПРИМЕР ===\n");
        
        // Создаем объекты
        Parent parent = new Parent();
        Child child = new Child();
        
        // Ссылка Parent на объект Child
        Parent poly = new Child();
        
        System.out.println("1. Статические методы:");
        System.out.println("---------------------");
        parent.show();  // Parent static show
        child.show();   // Child static show
        poly.show();    // Parent static show! (не Child!)
        
        System.out.println("\n2. Обычные методы:");
        System.out.println("-----------------");
        parent.display();  // Parent display
        child.display();   // Child display
        poly.display();    // Child display! (полиморфизм)
        
        System.out.println("\n3. Вызов через классы:");
        System.out.println("----------------------");
        Parent.show();     // Parent static show
        Child.show();      // Child static show
        
        System.out.println("\n=== ОТВЕТ НА ВОПРОС ===");
        System.out.println("\nПочему нет полиморфизма со статическими методами?");
        System.out.println("\n1. Статические методы принадлежат КЛАССУ, а не объекту");
        System.out.println("2. Вызов определяется типом ПЕРЕМЕННОЙ (компиляция)");
        System.out.println("3. Нет vtable для статических методов");
        System.out.println("\nВ примере выше:");
        System.out.println("poly.show() вызывает Parent.show()");
        System.out.println("хотя poly указывает на объект Child");
        System.out.println("\npoly.display() вызывает Child.display()");
        System.out.println("потому что display() - обычный метод");
    }
}