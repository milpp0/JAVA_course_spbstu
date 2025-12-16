package practice;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Практика по потокам ввода-вывода (I/O Streams).
 * Демонстрирует работу с InputStream, OutputStream, Reader, Writer и AutoCloseable.
 */
public class Practice10_1 {

    /**
     * Практика #1: Пример использования подкласса InputStream.
     * Демонстрация работы метода read().
     */
    private static void demonstrateInputStream() {
        System.out.println("=== Практика #1: InputStream.read() ===\n");
        
        // Используем ByteArrayInputStream как простой пример
        String text = "Hello, InputStream!";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        
        // Создаем поток ввода из массива байтов
        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
            System.out.println("Чтение данных из ByteArrayInputStream:");
            System.out.println("Исходная строка: " + text);
            System.out.println("Байты: " + bytesToHex(bytes));
            
            System.out.println("\nЧтение по одному байту:");
            int byteData;
            System.out.print("Прочитанные байты (в HEX): ");
            while ((byteData = inputStream.read()) != -1) {
                System.out.print(String.format("%02X ", byteData));
            }
            
            // Сбросим поток для следующего чтения
            System.out.println("\n\nЧтение в массив байтов:");
            InputStream inputStream2 = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[10];
            int bytesRead = inputStream2.read(buffer);
            System.out.println("Прочитано байт: " + bytesRead);
            System.out.println("Содержимое буфера: " + new String(buffer, 0, bytesRead));
            
        } catch (IOException e) {
            System.out.println("Ошибка при чтении: " + e.getMessage());
        }
    }

    /**
     * Практика #2: Пример использования подкласса OutputStream.
     * Демонстрация работы метода write(int).
     */
    private static void demonstrateOutputStream() {
        System.out.println("\n=== Практика #2: OutputStream.write(int) ===\n");
        
        // Используем ByteArrayOutputStream как простой пример
        try (OutputStream outputStream = new ByteArrayOutputStream()) {
            System.out.println("Запись данных в ByteArrayOutputStream:");
            
            // Запись отдельных байтов
            String text = "Java I/O";
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            
            System.out.println("Записываем строку: " + text);
            System.out.println("Байты для записи: " + bytesToHex(bytes));
            
            for (byte b : bytes) {
                // Метод write(int) записывает младший байт переданного int
                outputStream.write(b);
            }
            
            // Получаем записанные данные
            ByteArrayOutputStream baos = (ByteArrayOutputStream) outputStream;
            byte[] result = baos.toByteArray();
            
            System.out.println("\nЗаписанные данные:");
            System.out.println("Как строка: " + new String(result, StandardCharsets.UTF_8));
            System.out.println("Как байты: " + bytesToHex(result));
            
            // Демонстрация write(byte[])
            System.out.println("\nДополнительно: запись массива байтов");
            try (OutputStream os2 = new ByteArrayOutputStream()) {
                byte[] data = "Массив".getBytes(StandardCharsets.UTF_8);
                os2.write(data);
                
                ByteArrayOutputStream baos2 = (ByteArrayOutputStream) os2;
                System.out.println("Результат: " + new String(baos2.toByteArray()));
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка при записи: " + e.getMessage());
        }
    }

    /**
     * Практика #3: Зачем нужны Reader и Writer?
     * Сравнение потоков байтов и символьных потоков.
     */
    private static void explainReaderWriter() {
        System.out.println("\n=== Практика #3: Reader и Writer vs InputStream и OutputStream ===\n");
        
        String text = "Привет, мир! 🌍";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        
        System.out.println("Тестовая строка: " + text);
        System.out.println("Длина строки (символов): " + text.length());
        System.out.println("Байты в UTF-8: " + bytesToHex(bytes));
        System.out.println("Длина в байтах: " + bytes.length);
        
        System.out.println("\n1. Проблема с InputStream/OutputStream для текста:");
        System.out.println("---------------------------------------------------");
        
        // Демонстрация проблемы с кодировкой
        try (InputStream is = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            
            // Читаем по одному байту
            int byteData;
            while ((byteData = is.read()) != -1) {
                os.write(byteData);
            }
            
            // Пытаемся прочитать как строку без указания кодировки
            String result = os.toString(); // Использует кодировку платформы по умолчанию!
            System.out.println("Чтение через byte streams: " + result);
            System.out.println("Символы могут отображаться некорректно!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n2. Решение с Reader/Writer:");
        System.out.println("----------------------------");
        
        try (Reader reader = new InputStreamReader(
                new ByteArrayInputStream(bytes), StandardCharsets.UTF_8);
             Writer writer = new StringWriter()) {
            
            // Читаем по одному символу
            int charData;
            while ((charData = reader.read()) != -1) {
                writer.write(charData);
            }
            
            String result = writer.toString();
            System.out.println("Чтение через char streams: " + result);
            System.out.println("Символы отображаются корректно!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n3. Ключевые отличия:");
        System.out.println("---------------------");
        System.out.println("InputStream/OutputStream:");
        System.out.println("- Работают с БАЙТАМИ (8 бит)");
        System.out.println("- Для бинарных данных: изображения, аудио, видео");
        System.out.println("- Не заботятся о кодировке текста");
        System.out.println("- Методы: read() возвращает int (0-255), write(int)");
        
        System.out.println("\nReader/Writer:");
        System.out.println("- Работают с СИМВОЛАМИ (Unicode, 16 бит)");
        System.out.println("- Для текстовых данных");
        System.out.println("- Учитывают кодировку (UTF-8, UTF-16, etc.)");
        System.out.println("- Методы: read() возвращает int (0-65535), write(int)");
        System.out.println("- Автоматически обрабатывают многобайтовые символы");
        
        System.out.println("\n4. Когда что использовать:");
        System.out.println("--------------------------");
        System.out.println("Использовать InputStream/OutputStream для:");
        System.out.println("- Файлов изображений (.jpg, .png)");
        System.out.println("- Аудио/видео файлов");
        System.out.println("- Бинарных форматов (zip, pdf)");
        System.out.println("- Сетевых сокетов (сырые данные)");
        
        System.out.println("\nИспользовать Reader/Writer для:");
        System.out.println("- Текстовых файлов (.txt, .csv, .xml, .json)");
        System.out.println("- Конфигурационных файлов");
        System.out.println("- Логов");
        System.out.println("- HTML страниц");
    }

    /**
     * Практика #4: Интерфейс AutoCloseable.
     * Демонстрация необходимости и использования.
     */
    private static void demonstrateAutoCloseable() {
        System.out.println("\n=== Практика #4: Интерфейс AutoCloseable ===\n");
        
        System.out.println("1. Проблема: Ручное закрытие ресурсов");
        System.out.println("--------------------------------------");
        
        FileWriter writer1 = null;
        try {
            writer1 = new FileWriter("test1.txt");
            writer1.write("Старый способ: нужно закрывать вручную");
            System.out.println("Файл записан");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (writer1 != null) {
                try {
                    writer1.close();
                    System.out.println("Ресурс закрыт вручную");
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии: " + e.getMessage());
                }
            }
        }
        
        System.out.println("\n2. Решение: try-with-resources (Java 7+)");
        System.out.println("------------------------------------------");
        
        // Автоматическое закрытие благодаря AutoCloseable
        try (FileWriter writer2 = new FileWriter("test2.txt")) {
            writer2.write("Новый способ: автоматическое закрытие");
            System.out.println("Файл записан");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // writer2 автоматически закрывается здесь
        
        System.out.println("\n3. Несколько ресурсов:");
        System.out.println("------------------------");
        
        try (FileReader reader = new FileReader("test2.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer3 = new FileWriter("test3.txt")) {
            
            String line = bufferedReader.readLine();
            writer3.write("Прочитано: " + line);
            System.out.println("Данные скопированы");
            
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        // Все три ресурса автоматически закрываются
        
        System.out.println("\n4. Собственный класс с AutoCloseable:");
        System.out.println("--------------------------------------");
        
        try (DatabaseConnection db = new DatabaseConnection("my-db")) {
            db.query("SELECT * FROM users");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n5. Как это работает:");
        System.out.println("---------------------");
        System.out.println("AutoCloseable объявляет один метод:");
        System.out.println("  void close() throws Exception");
        System.out.println("\ntry-with-resources гарантирует вызов close():");
        System.out.println("- Даже при исключении в try блоке");
        System.out.println("- Даже при исключении в close()");
        System.out.println("- Ресурсы закрываются в обратном порядке создания");
    }

    /**
     * Вспомогательный метод для преобразования байтов в HEX строку.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X ", b));
        }
        return hex.toString();
    }

    /**
     * Пример собственного класса, реализующего AutoCloseable.
     */
    static class DatabaseConnection implements AutoCloseable {
        private String connectionName;
        private boolean isOpen = true;
        
        public DatabaseConnection(String name) {
            this.connectionName = name;
            System.out.println("Соединение с БД '" + name + "' установлено");
        }
        
        public void query(String sql) {
            if (!isOpen) {
                throw new IllegalStateException("Соединение закрыто");
            }
            System.out.println("Выполняем запрос: " + sql);
        }
        
        @Override
        public void close() throws Exception {
            if (isOpen) {
                isOpen = false;
                System.out.println("Соединение с БД '" + connectionName + "' закрыто");
            }
        }
        
        // Финализатор (на всякий случай)
        @Override
        protected void finalize() throws Throwable {
            if (isOpen) {
                System.err.println("ВНИМАНИЕ: Соединение не было закрыто!");
                close();
            }
            super.finalize();
        }
    }

    /**
     * Главный метод для запуска всех практик.
     */
    public static void main(String[] args) {
        System.out.println("=== Практика по потокам ввода-вывода ===\n");
        
        // Практика 1: InputStream
        demonstrateInputStream();
        
        // Практика 2: OutputStream
        demonstrateOutputStream();
        
        // Практика 3: Reader и Writer
        explainReaderWriter();
        
        // Практика 4: AutoCloseable
        demonstrateAutoCloseable();
        
        System.out.println("\n=== Завершение практики ===");
        
        // Очистка тестовых файлов
        cleanupTestFiles();
    }
    
    /**
     * Удаление тестовых файлов, созданных во время выполнения.
     */
    private static void cleanupTestFiles() {
        String[] files = {"test1.txt", "test2.txt", "test3.txt"};
        for (String file : files) {
            File f = new File(file);
            if (f.exists()) {
                if (f.delete()) {
                    System.out.println("Файл удален: " + file);
                }
            }
        }
    }
}