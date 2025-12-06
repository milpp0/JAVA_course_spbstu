package practice;
/**
 * Вывод программы
 * === Цикл for ===
 * Number=1
 * Number=11
 * Number=1.11
 * Number=11.11
 * 
 * === Прямые вызовы ===
 * Integer = 1
 * int = 11
 * Float = 1.1100
 * Number=11.11
 * 
 * В цикле for (1) тип переменной n в цикле - Number. Компилятор на этапе компиляции выбирает printNum(Number n)
 * Полиморфизм не работает для перегрузки. Все вызовы идут в printNum(Number n).
 * 
 * В прямых вызовах (2) каждый вызов анализируется компилятором отдельн. Выбирается наиболее специфичный метод:
 * new Integer(1) - printNum(Integer i)
 * 11 - printNum(int i) (приоритет над автобоксингом)
 * 1.11f - printNum(Float f)
 * 11.11 - printNum(Number n) (Double → Number)
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        
        // Массив Number[] - все элементы приводятся к типу Number
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};
        
        // Цикл for (1) - ВСЕГДА вызывается printNum(Number n)
        System.out.println("=== Цикл for ===");
        for (Number n : num) {
            a.printNum(n); // Компилятор видит тип Number
        }
        
        // (2) - вызываются разные перегруженные методы
        System.out.println("\n=== Прямые вызовы ===");
        a.printNum(new Integer(1)); // printNum(Integer i)
        a.printNum(11);             // printNum(int i) - автобоксинг
        a.printNum(1.11f);          // printNum(Float f)
        a.printNum(11.11);          // printNum(Number n) - 11.11 это Double
    }
}
