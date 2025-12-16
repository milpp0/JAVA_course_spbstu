package practice;


/**
 * Демонстрация this, super и модификаторов доступа
 */
public class Practice4_1 {
    
    // Самый простой пример this
    static class Parent {
        String name;
        
        Parent(String name) {
            this.name = name; // this отличает поле от параметра
        }
        
        void show() {
            System.out.println("Родитель: " + this.name);
        }
    }
    
    // Самый простой пример super
    static class Child extends Parent {
        int age;
        
        Child(String name, int age) {
            super(name); // super вызывает конструктор родителя
            this.age = age; // this для поля Child
        }
        
        @Override
        void show() {
            super.show(); // super вызывает метод родителя
            System.out.println("Ребенок, возраст: " + this.age);
        }
    }
    
    // Простейшие модификаторы доступа
    static class Base {
        public int publicField = 1;
        protected int protectedField = 2;
        int packageField = 3; // по умолчанию
        private int privateField = 4;
        
        public void show() {
            System.out.println("\nВнутри Base:");
            System.out.println("public: " + publicField);
            System.out.println("protected: " + protectedField);
            System.out.println("package: " + packageField);
            System.out.println("private: " + privateField);
        }
    }
    
    static class Derived extends Base {
        public void test() {
            System.out.println("\nВнутри Derived:");
            System.out.println("public: " + publicField);      // ДА
            System.out.println("protected: " + protectedField); // ДА
            System.out.println("package: " + packageField);    // ДА (если в одном файле)
            // System.out.println("private: " + privateField); // НЕТ!
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ НАСЛЕДОВАНИЯ ===\n");
        
        // 1. Пример this и super
        System.out.println("1. THIS и SUPER:");
        Child child = new Child("Иван", 10);
        child.show();
        
        // 2. Пример модификаторов
        System.out.println("\n2. МОДИФИКАТОРЫ ДОСТУПА:");
        Base base = new Base();
        base.show();
        
        Derived derived = new Derived();
        derived.test();
        
        // 3. Доступ через объект
        System.out.println("\n3. ДОСТУП ЧЕРЕЗ ОБЪЕКТ:");
        System.out.println("publicField: " + base.publicField);      // ДА
        // System.out.println(base.protectedField); // Ошибка - protected
        // System.out.println(base.packageField);   // Ошибка - package
        // System.out.println(base.privateField);   // Ошибка - private
        
        System.out.println("\n=== КРАТКИЕ ВЫВОДЫ ===");
        System.out.println("\nTHIS - обращение к текущему объекту");
        System.out.println("SUPER - обращение к родительскому классу");
        System.out.println("\npublic - доступ отовсюду");
        System.out.println("protected - доступ наследникам");
        System.out.println("package - доступ в пакете");
        System.out.println("private - доступ только в классе");
    }
}