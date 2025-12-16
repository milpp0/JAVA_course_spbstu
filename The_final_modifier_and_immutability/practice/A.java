package practice;

public class A {
    public final int a;
    
    // Вариант 1: При объявлении
    // public final int a = 10;
    
    // Вариант 2: В конструкторе
    public A() {
        a = 10;
    }
    
    // Вариант 3: В блоке инициализации
    // {
    //     a = 10;
    // }
    
    // Вариант 4: Через параметр конструктора
    public A(int value) {
        a = value;
    }
}