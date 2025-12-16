package practice;
/**
 * Демонстрация ошибок компиляции с final
 */
public class Practice4_2 {
    
    // Пример 1: Ошибка при попытке переопределить final метод
    class A {
        final void method() {}  // final метод
    }
    
    class B extends A {
        // Раскомментируйте следующую строку чтобы увидеть ошибку:
        // void method() {}  // ОШИБКА: method() in B cannot override method() in A
    }
    
    // Пример 2: Ошибка при попытке наследовать final класс
    final class C {}  // final класс
    
    // Раскомментируйте следующую строку чтобы увидеть ошибку:
    // class D extends C {}  // ОШИБКА: cannot inherit from final C
    
    // Пример 3: Ошибка при изменении final поля
    class E {
        final int x = 10;  // final поле
        
        void change() {
            // Раскомментируйте следующую строку чтобы увидеть ошибку:
            // x = 20;  // ОШИБКА: cannot assign a value to final variable x
        }
    }
    
    // Пример 4: Ошибка при изменении final параметра
    void test(final int y) {
        // Раскомментируйте следующую строку чтобы увидеть ошибку:
        // y = 30;  // ОШИБКА: final parameter y may not be assigned
    }
    
    // Рабочий пример для сравнения
    class F {
        int z = 40;  // не final поле
        
        void modify() {
            z = 50;  // Это работает
        }
    }
    
    class G extends F {
        void modify() {
            z = 60;  // И это тоже работает
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Этот код демонстрирует ошибки компиляции с final.");
        System.out.println("Раскомментируйте строки с ошибками чтобы увидеть их.");
    }
}