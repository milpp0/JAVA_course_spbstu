package practice;

class B {
    // Статическая final переменная
    public static final int CONSTANT = 100;
    
    // final с вычисляемым значением
    public final double PI = Math.PI;
    
    // final объект (ссылка не меняется, но объект можно менять)
    public final StringBuilder builder = new StringBuilder();
}