package practice;

import java.util.Objects;

/**
 * Максимально простой пример equals()
 */
public class Practice4_6 {
    
    static class Student {
        private String name;
        private int id;
        
        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
        
        // ПРАВИЛЬНАЯ реализация equals()
        @Override
        public boolean equals(Object obj) {
            // 1. Сам с собой
            if (this == obj) return true;
            
            // 2. Не null и того же класса
            if (obj == null || getClass() != obj.getClass()) return false;
            
            // 3. Приведение типа
            Student other = (Student) obj;
            
            // 4. Сравнение полей
            return id == other.id && Objects.equals(name, other.name);
        }
        
        // hashCode() должен быть переопределен вместе с equals()
        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
        
        // toString() для удобства
        @Override
        public String toString() {
            return "Student{name='" + name + "', id=" + id + "}";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТОЙ ПРИМЕР EQUALS() ===\n");
        
        Student s1 = new Student("Иван", 101);
        Student s2 = new Student("Иван", 101);
        Student s3 = new Student("Мария", 102);
        
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println();
        
        System.out.println("Сравнение:");
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1.equals(null): " + s1.equals(null));
        System.out.println("s1.equals(\"строка\"): " + s1.equals("строка"));
        
        System.out.println("\nХэш-коды:");
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());
        
        System.out.println("\n=== СОГЛАШЕНИЯ EQUALS() ===");
        System.out.println("\n1. Рефлексивность: x.equals(x) = true");
        System.out.println("2. Симметричность: если x.equals(y) то y.equals(x)");
        System.out.println("3. Транзитивность: если x.equals(y) и y.equals(z) то x.equals(z)");
        System.out.println("4. Консистентность: всегда одинаковый результат");
        System.out.println("5. С null: всегда false");
        System.out.println("6. С hashCode(): если equals = true, то hashCode одинаков");
    }
}