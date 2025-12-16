package practice;

/**
 * Демонстрация StringBuilder/StringBuffer
 */
public class Practice8_2 {
    
    public static void main(String[] args) {
        System.out.println("=== ПРОСТЫЕ ПРИМЕРЫ STRINGBUILDER/STRINGBUFFER ===\n");
        
        // Практика 1: Методы StringBuilder
        System.out.println("1. МЕТОДЫ STRINGBUILDER:");
        System.out.println("------------------------\n");
        
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Начальная строка: \"" + sb + "\"");
        
        // 1. append() - добавление в конец
        sb.append(" World");
        System.out.println("append(\" World\"): \"" + sb + "\"");
        
        // 2. insert() - вставка
        sb.insert(5, ",");
        System.out.println("insert(5, ','): \"" + sb + "\"");
        
        // 3. delete() - удаление
        sb.delete(5, 6);
        System.out.println("delete(5, 6): \"" + sb + "\"");
        
        // 4. replace() - замена
        sb.replace(6, 11, "Java");
        System.out.println("replace(6, 11, \"Java\"): \"" + sb + "\"");
        
        // 5. reverse() - обратный порядок
        System.out.println("reverse(): \"" + sb.reverse() + "\"");
        sb.reverse(); // Возвращаем обратно
        
        // 6. charAt() - получение символа
        System.out.println("charAt(0): '" + sb.charAt(0) + "'");
        
        // 7. setCharAt() - изменение символа
        sb.setCharAt(0, 'h');
        System.out.println("setCharAt(0, 'h'): \"" + sb + "\"");
        
        // 8. substring() - подстрока
        System.out.println("substring(6): \"" + sb.substring(6) + "\"");
        
        // 9. length() - длина
        System.out.println("length(): " + sb.length());
        
        // 10. capacity() - емкость
        System.out.println("capacity(): " + sb.capacity());
        
        // Практика 2: Преобразования
        System.out.println("\n\n2. ПРЕОБРАЗОВАНИЯ:");
        System.out.println("------------------\n");
        
        // String → StringBuilder
        String str = "Текст";
        StringBuilder builder = new StringBuilder(str);
        System.out.println("String → StringBuilder:");
        System.out.println("   new StringBuilder(\"" + str + "\")");
        
        // StringBuilder → String
        String fromBuilder = builder.toString();
        System.out.println("\nStringBuilder → String:");
        System.out.println("   builder.toString() = \"" + fromBuilder + "\"");
        
        // String → StringBuffer
        StringBuffer buffer = new StringBuffer(str);
        System.out.println("\nString → StringBuffer:");
        System.out.println("   new StringBuffer(\"" + str + "\")");
        
        // StringBuffer → String
        String fromBuffer = buffer.toString();
        System.out.println("\nStringBuffer → String:");
        System.out.println("   buffer.toString() = \"" + fromBuffer + "\"");
        
        // StringBuilder ↔ StringBuffer (только через String)
        System.out.println("\nStringBuilder ↔ StringBuffer:");
        System.out.println("   Только через String:");
        System.out.println("   StringBuilder → String → StringBuffer");
        System.out.println("   StringBuffer → String → StringBuilder");
        
        System.out.println("\n=== ОТВЕТЫ НА ПРАКТИКИ ===");
        System.out.println("\nПрактика #1: Основные методы");
        System.out.println("• append() - добавить в конец");
        System.out.println("• insert() - вставить в позицию");
        System.out.println("• delete()/deleteCharAt() - удалить");
        System.out.println("• replace() - заменить часть");
        System.out.println("• reverse() - обратить порядок");
        System.out.println("• charAt()/setCharAt() - работа с символами");
        System.out.println("• substring() - получить часть");
        System.out.println("• length()/capacity() - размеры");
        System.out.println("• toString() - преобразовать в String");
        
        System.out.println("\nПрактика #2: Преобразования");
        System.out.println("• String → StringBuilder: конструктор или append()");
        System.out.println("• String → StringBuffer: конструктор или append()");
        System.out.println("• StringBuilder → String: toString()");
        System.out.println("• StringBuffer → String: toString()");
        System.out.println("• StringBuilder ↔ StringBuffer: только через String");
        
        System.out.println("\nРазница StringBuilder/StringBuffer:");
        System.out.println("• StringBuilder - быстрее, не потокобезопасный");
        System.out.println("• StringBuffer - медленнее, потокобезопасный");
    }
}