package practice;

/**
 * Примеры super и this
 */
public class Practice4_3 {
    
    // Практика 1: 3 способа использования super
    static class Parent {
        int x = 10;
        
        Parent() {
            System.out.println("Parent конструктор");
        }
        
        void show() {
            System.out.println("Parent метод: x=" + x);
        }
    }
    
    static class Child extends Parent {
        int x = 20;
        
        // 1. super() - вызов конструктора родителя
        Child() {
            super(); // Должен быть первым
            System.out.println("Child конструктор");
        }
        
        // 2. super.поле - доступ к полю родителя
        void showX() {
            System.out.println("Child x = " + x); // 20
            System.out.println("Parent x = " + super.x); // 10
        }
        
        // 3. super.метод() - вызов метода родителя
        @Override
        void show() {
            System.out.println("Child метод");
            super.show(); // Вызов метода родителя
        }
    }
    
    // Практика 2: Цепочка наследования
    static class A {
        int num = 5;
        void test() { System.out.println("A.test"); }
    }
    
    static class B extends A {
        // Не переопределяет num и test
    }
    
    static class C extends B {
        void demo() {
            // super найдет в A, так как B не переопределяет
            System.out.println(super.num); // 5 из A
            super.test(); // A.test
        }
    }
    
    // Практика 3: this() для конструкторов
    static class Box {
        int width, height, depth;
        
        // Главный конструктор
        Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }
        
        // Конструктор куба (все стороны равны)
        Box(int side) {
            this(side, side, side); // Вызов главного конструктора
        }
        
        // Конструктор по умолчанию
        Box() {
            this(1); // Кубик 1x1x1
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ===\n");
        
        // 1. super
        System.out.println("1. SUPER (3 способа):");
        Child child = new Child();
        child.showX();
        child.show();
        
        // 2. Цепочка наследования
        System.out.println("\n2. ЦЕПОЧКА НАСЛЕДОВАНИЯ:");
        C c = new C();
        c.demo();
        
        // 3. this()
        System.out.println("\n3. THIS() В КОНСТРУКТОРАХ:");
        Box box1 = new Box();
        System.out.println("Box() -> Box(1) -> Box(1,1,1)");
        
        Box box2 = new Box(5);
        System.out.println("Box(5) -> Box(5,5,5)");
        
        Box box3 = new Box(2, 3, 4);
        System.out.println("Box(2,3,4)");
        /**
         * КРАТКИЕ ВЫВОДЫ
         * super - обращение к родителю:
         * 1. super() - конструктор родителя
         * 2. super.поле - поле родителя
         * 3. super.метод() - метод родителя
         * 
         * this - обращение к текущему объекту:
         * 1. this() - другой конструктор этого класса
         * 2. this.поле - поле этого объекта
         * 3. this.метод() - метод этого объекта
         */
    }
}