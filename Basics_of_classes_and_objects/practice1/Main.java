package practice1;

public class Main {
    public static void main(String[] args) {
        A alpha = new B();
        alpha.setX(5);
        alpha.setY(10);
        
        // Ожидаем 50 (5 * 10), но получаем 100 (10 * 10)
        System.out.println("x * y: " + alpha.getA());
        
        // Демонстрация проблемы
        System.out.println("x: " + alpha.x);
        System.out.println("y: " + alpha.y);
    }
}