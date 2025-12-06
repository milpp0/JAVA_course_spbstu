package practice;
/**
 * Оператор выбора
 * Две практики
 * 
 * @author Vladislav Nikiforov
 */
public class Practice2_6 {
	// enum для реализации примера switch
	enum Status { ACTIVE, INACTIVE, PENDING }

	public static void main(String[] args) {
		// Далее представленны варианты переменных для switch разных типов
		
		// 1. byte
        byte b = 1;
        switch(b) {
            case 1: System.out.println("byte: 1"); break;
        }
        
        // 2. short
        short s = 100;
        switch(s) {
            case 100: System.out.println("short: 100"); break;
        }
        
        // 3. int
        int i = 1000;
        switch(i) {
            case 1000: System.out.println("int: 1000"); break;
        }
        
        // 4. char
        char c = 'X';
        switch(c) {
            case 'X': System.out.println("char: X"); break;
        }
        
        // 5. String (Java 7+)
        String str = "test";
        switch(str) {
            case "test": System.out.println("String: test"); break;
        }
        
        // 6. Enum
        Status status = Status.ACTIVE;
        switch(status) {
            case ACTIVE: System.out.println("Status: ACTIVE"); break;
        }
        
        // 7. Обёртки (автораспаковка)
        Integer integer = 50;
        switch(integer) {
            case 50: System.out.println("Integer: 50"); break;
        }
        
        // 8. Switch expression
        int code = 404;
        String message = switch(code) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 500 -> "Internal Error";
            default -> "Unknown";
        };
        System.out.println("HTTP " + code + ": " + message);
        /**
         * Если в некоторых частях case отсутствует break,
         * произойдет "проваливание" (fall-through) — выполнение перейдет
         * к следующему case без проверки условия.
         */
	}

}
