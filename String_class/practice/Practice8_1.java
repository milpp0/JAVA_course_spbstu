package practice;

import java.util.StringJoiner;

/**
 * Демонстрация работы со строками
 */
public class Practice8_1 {
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ СО СТРОКАМИ ===\n");
        
        // Практика 1: Методы String
        System.out.println("1. МЕТОДЫ STRING:");
        System.out.println("----------------\n");
        
        String text = "Hello, Java World!";
        
        System.out.println("Исходная строка: \"" + text + "\"");
        System.out.println("length(): " + text.length());
        System.out.println("charAt(7): '" + text.charAt(7) + "'");
        System.out.println("substring(7): \"" + text.substring(7) + "\"");
        System.out.println("toUpperCase(): \"" + text.toUpperCase() + "\"");
        System.out.println("toLowerCase(): \"" + text.toLowerCase() + "\"");
        System.out.println("contains(\"Java\"): " + text.contains("Java"));
        System.out.println("replace(\"World\", \"мир\"): \"" + 
                          text.replace("World", "мир") + "\"");
        System.out.println("startsWith(\"Hello\"): " + text.startsWith("Hello"));
        System.out.println("endsWith(\"!\"): " + text.endsWith("!"));
        
        // Практика 2: StringJoiner
        System.out.println("\n\n2. STRINGJOINER:");
        System.out.println("---------------\n");
        
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Яблоко");
        joiner.add("Банан");
        joiner.add("Апельсин");
        System.out.println("StringJoiner результат: " + joiner.toString());
        
        // Практика 3: Текстовые блоки
        System.out.println("\n\n3. ТЕКСТОВЫЕ БЛОКИ (\"\"\"):");
        System.out.println("-------------------------\n");
        
        // Без текстовых блоков
        String oldJson = "{\n" +
                        "  \"name\": \"Иван\",\n" +
                        "  \"age\": 25\n" +
                        "}";
        System.out.println("Старый способ:\n" + oldJson);
        
        // С текстовыми блоками
        String newJson = """
                         {
                           "name": "Иван",
                           "age": 25
                         }
                         """;
        System.out.println("\nТекстовый блок:\n" + newJson);
        
        System.out.println("\n=== ОТВЕТЫ НА ПРАКТИКИ ===");
        System.out.println("\nПрактика #1: Методы String");
        System.out.println("• length() - длина строки");
        System.out.println("• charAt() - символ по индексу");
        System.out.println("• substring() - часть строки");
        System.out.println("• toUpperCase()/toLowerCase() - регистр");
        System.out.println("• contains() - проверка наличия");
        System.out.println("• replace() - замена");
        System.out.println("• startsWith()/endsWith() - проверка начала/конца");
        System.out.println("• split() - разделение на массив");
        System.out.println("• equals() - сравнение содержимого");
        
        System.out.println("\nПрактика #2: StringJoiner");
        System.out.println("• Для объединения строк с разделителем");
        System.out.println("• Можно задать префикс и суффикс");
        System.out.println("• Удобно для CSV, SQL IN clauses, etc.");
        
        System.out.println("\nПрактика #3: Три двойные кавычки");
        System.out.println("• Для создания текстовых блоков (многострочного текста)");
        System.out.println("• Упрощает форматирование JSON, HTML, SQL");
        System.out.println("• Автоматически удаляет общие отступы");
        System.out.println("• Доступно с Java 13+");
    }
}