package practice;

import java.util.Date;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Демонстрация форматирования
 */
public class Practice8_3 {
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ ФОРМАТИРОВАНИЯ ===\n");
        
        // Практика 1: Спецификаторы формата
        System.out.println("1. СПЕЦИФИКАТОРЫ ФОРМАТА:");
        System.out.println("------------------------\n");
        
        // %s - строки
        System.out.println("%s - строки:");
        System.out.println(String.format("Имя: %s, Фамилия: %s", "Иван", "Иванов"));
        
        // %d - целые числа
        System.out.println("\n%d - целые числа:");
        System.out.println(String.format("Возраст: %d лет", 25));
        
        // %f - числа с плавающей точкой
        System.out.println("\n%f - числа с плавающей точкой:");
        System.out.println(String.format("Пи: %.2f", Math.PI));
        
        // %b - логические значения
        System.out.println("\n%b - логические значения:");
        System.out.println(String.format("Включен: %b", true));
        
        // %c - символы
        System.out.println("\n%c - символы:");
        System.out.println(String.format("Символ: %c", 'A'));
        
        // %% - знак процента
        System.out.println("\n%% - знак процента:");
        System.out.println(String.format("Скидка: 20%%"));
        
        // %n - новая строка
        System.out.println("\n%n - новая строка:");
        System.out.print(String.format("Строка 1%nСтрока 2%n"));
        
        // Практика 2: Метод flush()
        System.out.println("\n\n2. МЕТОД FLUSH():");
        System.out.println("----------------\n");
        
        System.out.println("flush() принудительно записывает буферизированные данные.");
        System.out.println("Важно для файлов и сетевых потоков.");
        
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            
            pw.print("Данные в буфере");
            System.out.println("До flush(): \"" + sw.toString() + "\"");
            
            pw.flush(); // Записываем из буфера
            System.out.println("После flush(): \"" + sw.toString() + "\"");
            
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Практика 3: Спецификаторы даты/времени
        System.out.println("\n\n3. СПЕЦИФИКАТОРЫ ДАТЫ/ВРЕМЕНИ:");
        System.out.println("----------------------------\n");
        
        Date now = new Date();
        
        // %tH - час (00-23)
        System.out.println("%tH - час (24-часовой):");
        System.out.println(String.format("%tH", now));
        
        // %tI - час (01-12)
        System.out.println("\n%tI - час (12-часовой):");
        System.out.println(String.format("%tI", now));
        
        // %tM - минуты
        System.out.println("\n%tM - минуты:");
        System.out.println(String.format("%tM", now));
        
        // %tS - секунды
        System.out.println("\n%tS - секунды:");
        System.out.println(String.format("%tS", now));
        
        // %tY - год (4 цифры)
        System.out.println("\n%tY - год (4 цифры):");
        System.out.println(String.format("%tY", now));
        
        // %tm - месяц (число)
        System.out.println("\n%tm - месяц (число):");
        System.out.println(String.format("%tm", now));
        
        // Комбинированный формат
        System.out.println("\nКомбинированный формат:");
        System.out.println(String.format("Время: %tH:%tM:%tS", now, now, now));
        System.out.println(String.format("Дата: %td.%tm.%tY", now, now, now));
        
        System.out.println("\n=== КРАТКИЕ ОТВЕТЫ ===");
        System.out.println("\nПрактика #1: 5 спецификаторов");
        System.out.println("• %s - строки");
        System.out.println("• %d - целые числа");
        System.out.println("• %f - числа с плавающей точкой");
        System.out.println("• %b - логические значения");
        System.out.println("• %c - символы");
        
        System.out.println("\nПрактика #2: flush()");
        System.out.println("• Принудительно записывает буферизированные данные");
        System.out.println("• Гарантирует, что данные достигли назначения");
        System.out.println("• Важен для файлов и сетевых операций");
        
        System.out.println("\nПрактика #3: 5 спецификаторов даты/времени");
        System.out.println("• %tH - час (00-23)");
        System.out.println("• %tM - минуты (00-59)");
        System.out.println("• %tS - секунды (00-59)");
        System.out.println("• %tY - год (4 цифры)");
        System.out.println("• %tm - месяц (01-12)");
    }
}