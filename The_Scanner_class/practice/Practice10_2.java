package practice;

import java.io.*;
import java.util.Scanner;

/**
 * Практика по использованию класса Scanner для чтения данных.
 * Демонстрирует чтение данных из текстового файла с помощью Scanner.
 */
public class Practice10_2 {

    /**
     * Главный метод приложения.
     */
    public static void main(String[] args) {
        System.out.println("=== Практика #1: Чтение файла с помощью Scanner ===\n");
        
        // Создаем тестовый файл для демонстрации
        createTestFile("test_data.txt");
        
        // Пример 1: Базовое чтение файла
        System.out.println("Пример 1: Базовое чтение файла построчно");
        readFileWithScannerBasic("test_data.txt");
        
        System.out.println("\n---\n");
        
        // Пример 2: Чтение разных типов данных
        System.out.println("Пример 2: Чтение разных типов данных из файла");
        readDifferentDataTypes("test_data.txt");
        
        System.out.println("\n---\n");
        
        // Пример 3: Использование разделителей
        System.out.println("Пример 3: Чтение с использованием разделителей");
        readWithDelimiters("test_data.txt");
        
        System.out.println("\n---\n");
        
        // Пример 4: Обработка ошибок
        System.out.println("Пример 4: Обработка ошибок при чтении");
        readFileWithErrorHandling("test_data.txt");
        
        System.out.println("\n---\n");
        
        // Пример 5: Сравнение с BufferedReader
        System.out.println("Пример 5: Сравнение Scanner и BufferedReader");
        compareWithBufferedReader("test_data.txt");
        
        // Очистка тестового файла
        cleanupTestFile("test_data.txt");
    }
    
    /**
     * Пример 1: Базовое чтение файла построчно с помощью Scanner.
     * 
     * @param filename имя файла для чтения
     */
    private static void readFileWithScannerBasic(String filename) {
        System.out.println("Чтение файла: " + filename);
        System.out.println("--------------------------------");
        
        Scanner scanner = null;
        try {
            // Создаем Scanner для чтения из файла
            // Используем File для создания FileInputStream
            scanner = new Scanner(new File(filename));
            
            int lineNumber = 1;
            
            // Чтение файла построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.printf("Строка %d: %s%n", lineNumber, line);
                lineNumber++;
            }
            
            System.out.println("--------------------------------");
            System.out.println("Файл прочитан полностью.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + filename);
        } finally {
            // Важно закрыть Scanner
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner закрыт.");
            }
        }
    }
    
    /**
     * Пример 2: Чтение разных типов данных из файла.
     * Демонстрирует методы nextInt(), nextDouble(), next() и др.
     * 
     * @param filename имя файла для чтения
     */
    private static void readDifferentDataTypes(String filename) {
        System.out.println("Чтение разных типов данных из: " + filename);
        System.out.println("------------------------------------------");
        
        // Используем try-with-resources для автоматического закрытия
        try (Scanner scanner = new Scanner(new File(filename))) {
            
            int totalNumbers = 0;
            double sum = 0.0;
            int wordCount = 0;
            
            System.out.println("Содержимое файла:");
            System.out.println("-----------------");
            
            // Чтение файла по токенам (словам/числам)
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    // Если следующий токен - целое число
                    int number = scanner.nextInt();
                    totalNumbers++;
                    sum += number;
                    System.out.printf("Найдено целое число: %d%n", number);
                    
                } else if (scanner.hasNextDouble()) {
                    // Если следующий токен - дробное число
                    double number = scanner.nextDouble();
                    totalNumbers++;
                    sum += number;
                    System.out.printf("Найдено дробное число: %.2f%n", number);
                    
                } else if (scanner.hasNextBoolean()) {
                    // Если следующий токен - булево значение
                    boolean value = scanner.nextBoolean();
                    System.out.printf("Найдено булево значение: %b%n", value);
                    
                } else {
                    // Если следующий токен - строка
                    String word = scanner.next();
                    wordCount++;
                    System.out.printf("Найдено слово: %s%n", word);
                }
            }
            
            System.out.println("-----------------");
            System.out.printf("Статистика:%n");
            System.out.printf("- Найдено чисел: %d%n", totalNumbers);
            System.out.printf("- Сумма чисел: %.2f%n", sum);
            System.out.printf("- Найдено слов: %d%n", wordCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + filename);
        }
    }
    
    /**
     * Пример 3: Чтение с использованием разделителей.
     * Демонстрирует использование метода useDelimiter().
     * 
     * @param filename имя файла для чтения
     */
    private static void readWithDelimiters(String filename) {
        System.out.println("Чтение с разными разделителями из: " + filename);
        System.out.println("---------------------------------------------");
        
        // Создаем файл с CSV данными для демонстрации
        String csvFile = "test_csv.csv";
        createCSVFile(csvFile);
        
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            
            // Устанавливаем разделитель - запятая
            scanner.useDelimiter(",");
            
            System.out.println("Чтение CSV файла с разделителем ',':");
            System.out.println("--------------------------------------");
            
            int recordCount = 0;
            while (scanner.hasNext()) {
                String token = scanner.next().trim();
                if (!token.isEmpty()) {
                    System.out.printf("Токен %d: '%s'%n", recordCount + 1, token);
                    recordCount++;
                }
            }
            
            System.out.println("--------------------------------------");
            System.out.printf("Всего токенов: %d%n", recordCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + csvFile);
        }
        
        // Демонстрация с регулярным выражением
        System.out.println("\nЧтение с разделителем по умолчанию (пробел):");
        System.out.println("--------------------------------------------");
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            // По умолчанию Scanner использует шаблон пробелов как разделитель
            System.out.println("Разделители по умолчанию: \\s+ (пробелы, табуляции, переводы строк)");
            
            int tokenCount = 0;
            while (scanner.hasNext()) {
                String token = scanner.next();
                System.out.printf("Токен %d: '%s'%n", tokenCount + 1, token);
                tokenCount++;
            }
            
            System.out.println("--------------------------------------------");
            System.out.printf("Всего токенов: %d%n", tokenCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + filename);
        }
        
        // Удаляем временный CSV файл
        new File(csvFile).delete();
    }
    
    /**
     * Пример 4: Обработка ошибок при чтении.
     * Демонстрирует проверку наличия данных перед чтением.
     * 
     * @param filename имя файла для чтения
     */
    private static void readFileWithErrorHandling(String filename) {
        System.out.println("Обработка ошибок при чтении: " + filename);
        System.out.println("-------------------------------------");
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            
            System.out.println("Попытка чтения несуществующих данных:");
            
            // Пытаемся прочитать данные после конца файла
            while (scanner.hasNextLine()) {
                scanner.nextLine(); // Пропускаем все строки
            }
            
            // Теперь файл закончился
            System.out.println("Файл закончился.");
            
            // Проверка перед чтением (безопасный способ)
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println("Прочитано число: " + number);
            } else {
                System.out.println("Нет целых чисел для чтения.");
            }
            
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Прочитана строка: " + line);
            } else {
                System.out.println("Больше нет строк для чтения.");
            }
            
            System.out.println("\nПопытка чтения без проверки (может вызвать исключение):");
            
            // Создаем новый Scanner для демонстрации
            Scanner scanner2 = new Scanner("test 123");
            scanner2.next(); // "test"
            scanner2.next(); // "123"
            
            try {
                // Попытка прочитать, когда данных больше нет
                String next = scanner2.next(); // Вызовет NoSuchElementException
                System.out.println("Прочитано: " + next);
            } catch (Exception e) {
                System.out.println("Исключение: " + e.getClass().getSimpleName());
                System.out.println("Сообщение: " + e.getMessage());
            } finally {
                scanner2.close();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + filename);
        }
    }
    
    /**
     * Пример 5: Сравнение Scanner и BufferedReader.
     * 
     * @param filename имя файла для чтения
     */
    private static void compareWithBufferedReader(String filename) {
        System.out.println("Сравнение Scanner и BufferedReader:");
        System.out.println("------------------------------------");
        
        // Создаем тестовый файл с большим количеством данных
        String largeFile = "large_test.txt";
        createLargeTestFile(largeFile, 10000);
        
        System.out.println("Тест с файлом из 10,000 строк:");
        System.out.println();
        
        // Тест 1: BufferedReader
        long startTime = System.currentTimeMillis();
        int brLineCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(largeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                brLineCount++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка BufferedReader: " + e.getMessage());
        }
        
        long brTime = System.currentTimeMillis() - startTime;
        System.out.printf("BufferedReader:%n");
        System.out.printf("- Прочитано строк: %,d%n", brLineCount);
        System.out.printf("- Время: %d мс%n", brTime);
        
        // Тест 2: Scanner
        startTime = System.currentTimeMillis();
        int scannerLineCount = 0;
        
        try (Scanner scanner = new Scanner(new File(largeFile))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                scannerLineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка Scanner: " + e.getMessage());
        }
        
        long scannerTime = System.currentTimeMillis() - startTime;
        System.out.printf("%nScanner:%n");
        System.out.printf("- Прочитано строк: %,d%n", scannerLineCount);
        System.out.printf("- Время: %d мс%n", scannerTime);
        
        System.out.println("\nВыводы:");
        System.out.println("- BufferedReader обычно быстрее для простого чтения строк");
        System.out.println("- Scanner удобнее для разбора данных разных типов");
        System.out.println("- Scanner имеет встроенные методы для проверки типов данных");
        System.out.println("- Scanner может быть медленнее из-за дополнительной обработки");
        
        // Удаляем временный файл
        new File(largeFile).delete();
    }
    
    /**
     * Создает тестовый файл с данными для демонстрации.
     * 
     * @param filename имя создаваемого файла
     */
    private static void createTestFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Java Scanner Практика 2024");
            writer.println("Целые числа: 100 200 300");
            writer.println("Дробные числа: 3.14 2.71 1.618");
            writer.println("Булевы значения: true false true");
            writer.println("Разные типы в одной строке: 42 3.14 true Строка");
            writer.println("Последняя строка файла");
            
            System.out.println("Создан тестовый файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка создания тестового файла: " + e.getMessage());
        }
    }
    
    /**
     * Создает CSV файл для демонстрации разделителей.
     * 
     * @param filename имя создаваемого файла
     */
    private static void createCSVFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Имя,Фамилия,Возраст,Город");
            writer.println("Иван,Иванов,30,Москва");
            writer.println("Анна,Петрова,25,Санкт-Петербург");
            writer.println("Петр,Сидоров,35,Казань");
        } catch (IOException e) {
            System.out.println("Ошибка создания CSV файла: " + e.getMessage());
        }
    }
    
    /**
     * Создает большой тестовый файл для сравнения производительности.
     * 
     * @param filename имя создаваемого файла
     * @param lineCount количество строк
     */
    private static void createLargeTestFile(String filename, int lineCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 1; i <= lineCount; i++) {
                writer.printf("Строка %d: Тестовые данные для сравнения производительности %d%n", i, i);
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания большого тестового файла: " + e.getMessage());
        }
    }
    
    /**
     * Удаляет тестовый файл после использования.
     * 
     * @param filename имя удаляемого файла
     */
    private static void cleanupTestFile(String filename) {
        File file = new File(filename);
        if (file.exists() && file.delete()) {
            System.out.println("\nТестовый файл удален: " + filename);
        }
    }
}