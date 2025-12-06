package practice;

public class A {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }
    
    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }
    
    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }
    
    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }
}