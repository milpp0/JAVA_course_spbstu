package practice;

public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void main(String[] args) {
        // 1. Вызов через имя класса (рекомендуемый способ)
        A.printVars();
        
        // 2. Вызов из другого static метода того же класса
        printVars(); // без указания имени класса
        
        // 3. Вызов из подкласса
        B.callParentStatic();
        
        // 4. Вызов через null-ссылку
        A nullRef = null;
        nullRef.printVars(); // Не вызовет NullPointerException!
    }
}