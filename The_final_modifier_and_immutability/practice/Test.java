package practice;

class Test {
    public static void main(String[] args) {
        A obj1 = new A();          // a = 10
        A obj2 = new A(20);        // a = 20
        
        System.out.println("obj1.a = " + obj1.a);
        System.out.println("obj2.a = " + obj2.a);
        
        // Нельзя изменить final поле:
        // obj1.a = 30; // Ошибка компиляции!
        
        // final локальная переменная
        // final int localFinal = 50;
        // localFinal = 60; // Ошибка компиляции!
        
        // final параметр метода
        printValue(100);
    }
    
    static void printValue(final int x) {
        // x = 200; // Ошибка компиляции!
        System.out.println(x);
    }
}
