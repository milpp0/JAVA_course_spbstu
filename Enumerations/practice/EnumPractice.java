package practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/**
 * Практика по использованию перечислений (enum) в Java
 * Демонстрирует инициализацию элементов и собственные методы
 */
public class EnumPractice {
    
    // ==================== ПРАКТИКА #1: ИНИЦИАЛИЗАЦИЯ ЭЛЕМЕНТОВ ====================
    
    /**
     * Пример 1: Перечисление дней недели с инициализацией
     * Каждый элемент имеет числовое значение и русское название
     */
    public enum DayOfWeek {
        MONDAY(1, "Понедельник", false) {
            @Override
            public String getMood() {
                return "Начало недели...";
            }
        },
        TUESDAY(2, "Вторник", false) {
            @Override
            public String getMood() {
                return "Рабочие будни";
            }
        },
        WEDNESDAY(3, "Среда", false) {
            @Override
            public String getMood() {
                return "Маленькая пятница";
            }
        },
        THURSDAY(4, "Четверг", false) {
            @Override
            public String getMood() {
                return "Скоро пятница!";
            }
        },
        FRIDAY(5, "Пятница", false) {
            @Override
            public String getMood() {
                return "Ура, пятница!";
            }
        },
        SATURDAY(6, "Суббота", true) {
            @Override
            public String getMood() {
                return "Выходной!";
            }
        },
        SUNDAY(7, "Воскресенье", true) {
            @Override
            public String getMood() {
                return "Отдых и подготовка к неделе";
            }
        };
        
        // Поля для инициализации
        private final int number;
        private final String russianName;
        private final boolean isWeekend;
        
        // Конструктор для инициализации элементов
        DayOfWeek(int number, String russianName, boolean isWeekend) {
            this.number = number;
            this.russianName = russianName;
            this.isWeekend = isWeekend;
        }
        
        // Геттеры
        public int getNumber() {
            return number;
        }
        
        public String getRussianName() {
            return russianName;
        }
        
        public boolean isWeekend() {
            return isWeekend;
        }
        
        // Абстрактный метод - каждый элемент реализует свою версию
        public abstract String getMood();
        
        // Статический метод для поиска по номеру
        public static DayOfWeek fromNumber(int number) {
            for (DayOfWeek day : values()) {
                if (day.getNumber() == number) {
                    return day;
                }
            }
            throw new IllegalArgumentException("Неверный номер дня: " + number);
        }
        
        // Метод для получения следующего дня
        public DayOfWeek next() {
            int nextOrdinal = (this.ordinal() + 1) % values().length;
            return values()[nextOrdinal];
        }
        
        // Метод для получения предыдущего дня
        public DayOfWeek previous() {
            int prevOrdinal = (this.ordinal() - 1 + values().length) % values().length;
            return values()[prevOrdinal];
        }
    }
    
    /**
     * Пример 2: Перечисление планет Солнечной системы
     * С инициализацией физическими характеристиками
     */
    public enum Planet {
        MERCURY(3.303e+23, 2.4397e6, 57.9e6, 88),
        VENUS(4.869e+24, 6.0518e6, 108.2e6, 225),
        EARTH(5.976e+24, 6.37814e6, 149.6e6, 365) {
            @Override
            public boolean hasLife() {
                return true;
            }
        },
        MARS(6.421e+23, 3.3972e6, 227.9e6, 687),
        JUPITER(1.9e+27, 7.1492e7, 778.3e6, 4331),
        SATURN(5.688e+26, 6.0268e7, 1427.0e6, 10747),
        URANUS(8.686e+25, 2.5559e7, 2870.0e6, 30589),
        NEPTUNE(1.024e+26, 2.4746e7, 4497.0e6, 59800);
        
        // Физические характеристики
        private final double mass;      // в килограммах
        private final double radius;    // в метрах
        private final double distance;  // расстояние от Солнца в метрах
        private final int orbitDays;    // период обращения в днях
        
        // Гравитационная постоянная (м³/кг·с²)
        private static final double G = 6.67300E-11;
        
        // Конструктор
        Planet(double mass, double radius, double distance, int orbitDays) {
            this.mass = mass;
            this.radius = radius;
            this.distance = distance;
            this.orbitDays = orbitDays;
        }
        
        // Геттеры
        public double getMass() {
            return mass;
        }
        
        public double getRadius() {
            return radius;
        }
        
        public double getDistance() {
            return distance;
        }
        
        public int getOrbitDays() {
            return orbitDays;
        }
        
        // Расчет силы тяжести на поверхности
        public double surfaceGravity() {
            return G * mass / (radius * radius);
        }
        
        // Расчет веса объекта на планете
        public double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }
        
        // Метод по умолчанию - может быть переопределен
        public boolean hasLife() {
            return false;
        }
        
        // Получение планеты по названию (регистронезависимо)
        public static Planet fromName(String name) {
            for (Planet planet : values()) {
                if (planet.name().equalsIgnoreCase(name)) {
                    return planet;
                }
            }
            throw new IllegalArgumentException("Неизвестная планета: " + name);
        }
        
        // Получение планет земной группы
        public static List<Planet> getTerrestrialPlanets() {
            return Arrays.asList(MERCURY, VENUS, EARTH, MARS);
        }
        
        // Получение газовых гигантов
        public static List<Planet> getGasGiants() {
            return Arrays.asList(JUPITER, SATURN, URANUS, NEPTUNE);
        }
    }
    
    /**
     * Пример 3: Перечисление статусов заказа с инициализацией
     */
    public enum OrderStatus {
        NEW(0, "Новый", "Заказ создан") {
            @Override
            public boolean canTransitionTo(OrderStatus next) {
                return next == PROCESSING || next == CANCELLED;
            }
        },
        PROCESSING(1, "В обработке", "Заказ обрабатывается") {
            @Override
            public boolean canTransitionTo(OrderStatus next) {
                return next == SHIPPED || next == CANCELLED;
            }
        },
        SHIPPED(2, "Отправлен", "Заказ отправлен клиенту") {
            @Override
            public boolean canTransitionTo(OrderStatus next) {
                return next == DELIVERED;
            }
        },
        DELIVERED(3, "Доставлен", "Заказ доставлен") {
            @Override
            public boolean canTransitionTo(OrderStatus next) {
                return false; // Конечный статус
            }
        },
        CANCELLED(-1, "Отменен", "Заказ отменен") {
            @Override
            public boolean canTransitionTo(OrderStatus next) {
                return false; // Конечный статус
            }
        };
        
        private final int code;
        private final String description;
        private final String message;
        
        OrderStatus(int code, String description, String message) {
            this.code = code;
            this.description = description;
            this.message = message;
        }
        
        public int getCode() {
            return code;
        }
        
        public String getDescription() {
            return description;
        }
        
        public String getMessage() {
            return message;
        }
        
        // Абстрактный метод для проверки допустимости перехода
        public abstract boolean canTransitionTo(OrderStatus next);
        
        // Получение статуса по коду
        public static OrderStatus fromCode(int code) {
            for (OrderStatus status : values()) {
                if (status.getCode() == code) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Неизвестный код статуса: " + code);
        }
    }
    
    // ==================== ПРАКТИКА #2: СОБСТВЕННЫЕ МЕТОДЫ ====================
    
    /**
     * Пример 4: Перечисление математических операций с собственным методом execute
     */
    public enum MathOperation {
        ADD("+") {
            @Override
            public double execute(double a, double b) {
                return a + b;
            }
        },
        SUBTRACT("-") {
            @Override
            public double execute(double a, double b) {
                return a - b;
            }
        },
        MULTIPLY("*") {
            @Override
            public double execute(double a, double b) {
                return a * b;
            }
        },
        DIVIDE("/") {
            @Override
            public double execute(double a, double b) {
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            }
        },
        POWER("^") {
            @Override
            public double execute(double a, double b) {
                return Math.pow(a, b);
            }
        },
        MODULUS("%") {
            @Override
            public double execute(double a, double b) {
                return a % b;
            }
        };
        
        private final String symbol;
        
        MathOperation(String symbol) {
            this.symbol = symbol;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        // Абстрактный метод - каждый элемент реализует свою операцию
        public abstract double execute(double a, double b);
        
        // Статический метод для поиска по символу
        public static MathOperation fromSymbol(String symbol) {
            for (MathOperation op : values()) {
                if (op.getSymbol().equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Неизвестная операция: " + symbol);
        }
        
        // Метод для вычисления выражения в строковом формате
        public static double calculate(String expression) {
            String[] parts = expression.split("\\s+");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректный формат выражения");
            }
            
            double a = Double.parseDouble(parts[0]);
            MathOperation op = fromSymbol(parts[1]);
            double b = Double.parseDouble(parts[2]);
            
            return op.execute(a, b);
        }
    }
    
    /**
     * Пример 5: Перечисление уровней доступа с методами проверки прав
     */
    public enum AccessLevel {
        GUEST(0, "Гость") {
            @Override
            public boolean canRead() {
                return true;
            }
            
            @Override
            public boolean canWrite() {
                return false;
            }
            
            @Override
            public boolean canDelete() {
                return false;
            }
            
            @Override
            public boolean canAdmin() {
                return false;
            }
        },
        USER(1, "Пользователь") {
            @Override
            public boolean canRead() {
                return true;
            }
            
            @Override
            public boolean canWrite() {
                return true;
            }
            
            @Override
            public boolean canDelete() {
                return false;
            }
            
            @Override
            public boolean canAdmin() {
                return false;
            }
        },
        MODERATOR(2, "Модератор") {
            @Override
            public boolean canRead() {
                return true;
            }
            
            @Override
            public boolean canWrite() {
                return true;
            }
            
            @Override
            public boolean canDelete() {
                return true;
            }
            
            @Override
            public boolean canAdmin() {
                return false;
            }
        },
        ADMIN(3, "Администратор") {
            @Override
            public boolean canRead() {
                return true;
            }
            
            @Override
            public boolean canWrite() {
                return true;
            }
            
            @Override
            public boolean canDelete() {
                return true;
            }
            
            @Override
            public boolean canAdmin() {
                return true;
            }
        };
        
        private final int level;
        private final String description;
        
        AccessLevel(int level, String description) {
            this.level = level;
            this.description = description;
        }
        
        public int getLevel() {
            return level;
        }
        
        public String getDescription() {
            return description;
        }
        
        // Абстрактные методы для проверки прав
        public abstract boolean canRead();
        public abstract boolean canWrite();
        public abstract boolean canDelete();
        public abstract boolean canAdmin();
        
        // Метод для проверки, имеет ли текущий уровень права другого уровня
        public boolean hasAccess(AccessLevel required) {
            return this.level >= required.level;
        }
        
        // Получение уровня по названию
        public static AccessLevel fromString(String name) {
            for (AccessLevel level : values()) {
                if (level.name().equalsIgnoreCase(name) || 
                    level.getDescription().equalsIgnoreCase(name)) {
                    return level;
                }
            }
            throw new IllegalArgumentException("Неизвестный уровень доступа: " + name);
        }
    }
    
    /**
     * Пример 6: Перечисление для работы с HTTP статусами
     */
    public enum HttpStatus {
        // 1xx: Информационные
        CONTINUE(100, "Continue"),
        SWITCHING_PROTOCOLS(101, "Switching Protocols"),
        
        // 2xx: Успешные
        OK(200, "OK"),
        CREATED(201, "Created"),
        ACCEPTED(202, "Accepted"),
        NO_CONTENT(204, "No Content"),
        
        // 3xx: Перенаправления
        MOVED_PERMANENTLY(301, "Moved Permanently"),
        FOUND(302, "Found"),
        NOT_MODIFIED(304, "Not Modified"),
        
        // 4xx: Ошибки клиента
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
        
        // 5xx: Ошибки сервера
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        NOT_IMPLEMENTED(501, "Not Implemented"),
        BAD_GATEWAY(502, "Bad Gateway"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable");
        
        private final int code;
        private final String reason;
        
        HttpStatus(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }
        
        public int getCode() {
            return code;
        }
        
        public String getReason() {
            return reason;
        }
        
        // Метод для определения категории статуса
        public StatusCategory getCategory() {
            if (code >= 100 && code < 200) return StatusCategory.INFORMATIONAL;
            if (code >= 200 && code < 300) return StatusCategory.SUCCESS;
            if (code >= 300 && code < 400) return StatusCategory.REDIRECTION;
            if (code >= 400 && code < 500) return StatusCategory.CLIENT_ERROR;
            if (code >= 500 && code < 600) return StatusCategory.SERVER_ERROR;
            return StatusCategory.UNKNOWN;
        }
        
        // Получение статуса по коду
        public static HttpStatus fromCode(int code) {
            for (HttpStatus status : values()) {
                if (status.getCode() == code) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Неизвестный HTTP код: " + code);
        }
        
        // Проверка, является ли статус успешным
        public boolean isSuccess() {
            return code >= 200 && code < 300;
        }
        
        // Проверка, является ли статус ошибкой
        public boolean isError() {
            return code >= 400;
        }
        
        // Вложенное перечисление для категорий
        public enum StatusCategory {
            INFORMATIONAL, SUCCESS, REDIRECTION, CLIENT_ERROR, SERVER_ERROR, UNKNOWN
        }
    }
    
    // ==================== ДЕМОНСТРАЦИОННЫЙ КЛАСС ====================
    
    /**
     * Класс для демонстрации использования перечислений
     */
    static class EnumDemo {
        private DayOfWeek currentDay;
        
        public EnumDemo() {
            // Установка текущего дня на основе реальной даты
            DayOfWeek realDay = DayOfWeek.fromNumber(LocalDate.now().getDayOfWeek().getValue());
            this.currentDay = realDay;
        }
        
        public void demonstrateDayOfWeek() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ ДНЕЙ НЕДЕЛИ ===");
            System.out.println("Текущий день: " + currentDay.getRussianName());
            System.out.println("Настроение: " + currentDay.getMood());
            System.out.println("Выходной? " + currentDay.isWeekend());
            System.out.println("Завтра будет: " + currentDay.next().getRussianName());
            
            // Использование switch с enum
            System.out.println("\nSwitch по дням недели:");
            switch (currentDay) {
                case MONDAY:
                    System.out.println("Понедельник - день тяжелый!");
                    break;
                case FRIDAY:
                    System.out.println("Пятница! Можно расслабиться.");
                    break;
                case SATURDAY: case SUNDAY:
                    System.out.println("Выходные! Отдыхаем!");
                    break;
                default:
                    System.out.println("Обычный рабочий день");
            }
            
            // Перебор всех дней
            System.out.println("\nВсе дни недели:");
            for (DayOfWeek day : DayOfWeek.values()) {
                System.out.printf("%d. %s (%s) - %s%n", 
                    day.getNumber(), 
                    day.getRussianName(),
                    day,
                    day.isWeekend() ? "выходной" : "рабочий"
                );
            }
        }
        
        public void demonstratePlanets() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ ПЛАНЕТ ===");
            
            double earthWeight = 70; // вес на Земле в кг
            System.out.printf("Вес человека на Земле: %.2f кг%n", earthWeight);
            
            System.out.println("\nВес на других планетах:");
            for (Planet planet : Planet.values()) {
                double weight = planet.surfaceWeight(earthWeight);
                System.out.printf("%-10s: %8.2f кг (гравитация: %.2f м/с²)%n",
                    planet, weight, planet.surfaceGravity());
            }
            
            System.out.println("\nПланеты с возможной жизнью:");
            for (Planet planet : Planet.values()) {
                if (planet.hasLife()) {
                    System.out.println(planet + " - возможна жизнь!");
                }
            }
        }
        
        public void demonstrateOrderStatus() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ СТАТУСОВ ЗАКАЗА ===");
            
            OrderStatus status = OrderStatus.NEW;
            System.out.println("Начальный статус: " + status.getDescription());
            System.out.println("Сообщение: " + status.getMessage());
            
            // Пытаемся перейти к другим статусам
            OrderStatus[] nextStatuses = {OrderStatus.PROCESSING, OrderStatus.SHIPPED, 
                                         OrderStatus.DELIVERED, OrderStatus.CANCELLED};
            
            for (OrderStatus next : nextStatuses) {
                if (status.canTransitionTo(next)) {
                    System.out.printf("Можно перейти из %s в %s%n", 
                        status.getDescription(), next.getDescription());
                } else {
                    System.out.printf("НЕЛЬЗЯ перейти из %s в %s%n", 
                        status.getDescription(), next.getDescription());
                }
            }
        }
        
        public void demonstrateMathOperations() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ МАТЕМАТИЧЕСКИХ ОПЕРАЦИЙ ===");
            
            double a = 10;
            double b = 3;
            
            System.out.println("Операции с числами " + a + " и " + b + ":");
            for (MathOperation op : MathOperation.values()) {
                try {
                    double result = op.execute(a, b);
                    System.out.printf("%.1f %s %.1f = %.2f%n", a, op.getSymbol(), b, result);
                } catch (ArithmeticException e) {
                    System.out.printf("%.1f %s %.1f = Ошибка: %s%n", 
                        a, op.getSymbol(), b, e.getMessage());
                }
            }
            
            // Вычисление выражения из строки
            String expression = "10 / 2";
            System.out.println("\nВычисление выражения: " + expression);
            try {
                double result = MathOperation.calculate(expression);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        
        public void demonstrateAccessLevels() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ УРОВНЕЙ ДОСТУПА ===");
            
            AccessLevel userLevel = AccessLevel.USER;
            System.out.println("Уровень: " + userLevel.getDescription());
            System.out.println("Права пользователя:");
            System.out.println("  Чтение: " + userLevel.canRead());
            System.out.println("  Запись: " + userLevel.canWrite());
            System.out.println("  Удаление: " + userLevel.canDelete());
            System.out.println("  Администрирование: " + userLevel.canAdmin());
            
            System.out.println("\nПроверка доступа к другим уровням:");
            for (AccessLevel required : AccessLevel.values()) {
                System.out.printf("  Доступ к %s: %s%n",
                    required.getDescription(),
                    userLevel.hasAccess(required) ? "ЕСТЬ" : "НЕТ"
                );
            }
        }
        
        public void demonstrateHttpStatus() {
            System.out.println("\n=== ДЕМОНСТРАЦИЯ HTTP СТАТУСОВ ===");
            
            int[] statusCodes = {200, 404, 500, 302, 100};
            
            for (int code : statusCodes) {
                try {
                    HttpStatus status = HttpStatus.fromCode(code);
                    System.out.printf("Код %d: %s (%s)%n",
                        status.getCode(),
                        status.getReason(),
                        status.getCategory()
                    );
                    System.out.printf("  Успех: %s, Ошибка: %s%n",
                        status.isSuccess(),
                        status.isError()
                    );
                } catch (IllegalArgumentException e) {
                    System.out.println("Неизвестный код: " + code);
                }
            }
        }
    }
    
    // ==================== ГЛАВНЫЙ МЕТОД ====================
    
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА ПО ПЕРЕЧИСЛЕНИЯМ (ENUM) В JAVA ===\n");
        
        EnumDemo demo = new EnumDemo();
        
        // Демонстрация всех примеров
        demo.demonstrateDayOfWeek();
        demo.demonstratePlanets();
        demo.demonstrateOrderStatus();
        demo.demonstrateMathOperations();
        demo.demonstrateAccessLevels();
        demo.demonstrateHttpStatus();
        
        // Дополнительные примеры
        demonstrateAdditionalFeatures();
        
    }
    
    /**
     * Демонстрация дополнительных возможностей enum
     */
    private static void demonstrateAdditionalFeatures() {
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ВОЗМОЖНОСТИ ===");
        
        // 1. Методы values() и valueOf()
        System.out.println("\n1. Методы values() и valueOf():");
        DayOfWeek[] days = DayOfWeek.values();
        System.out.println("Все дни: " + Arrays.toString(days));
        
        DayOfWeek monday = DayOfWeek.valueOf("MONDAY");
        System.out.println("valueOf(\"MONDAY\"): " + monday.getRussianName());
        
        // 2. Порядковый номер (ordinal)
        System.out.println("\n2. Порядковые номера:");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.printf("%s: ordinal=%d, наш номер=%d%n",
                day, day.ordinal(), day.getNumber());
        }
        
        // 3. Сравнение enum
        System.out.println("\n3. Сравнение перечислений:");
        DayOfWeek day1 = DayOfWeek.MONDAY;
        DayOfWeek day2 = DayOfWeek.FRIDAY;
        
        System.out.println(day1 + " == " + day2 + ": " + (day1 == day2));
        System.out.println(day1 + " equals " + day2 + ": " + day1.equals(day2));
        System.out.println(day1 + " compareTo " + day2 + ": " + day1.compareTo(day2));
        
        // 4. Использование в коллекциях
        System.out.println("\n4. Использование в коллекциях:");
        Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        System.out.println("Выходные дни: " + weekend);
        
        Map<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);
        schedule.put(DayOfWeek.MONDAY, "Работа");
        schedule.put(DayOfWeek.FRIDAY, "Подготовка к выходным");
        System.out.println("Расписание: " + schedule);
        
        // 5. Реализация интерфейсов
        System.out.println("\n5. Реализация интерфейсов:");
        Operation add = BasicOperation.PLUS;
        System.out.println("5 + 3 = " + add.apply(5, 3));
    }
    
    /**
     * Интерфейс для демонстрации реализации интерфейсов enum
     */
    interface Operation {
        double apply(double x, double y);
    }
    
    /**
     * Enum, реализующий интерфейс
     */
    enum BasicOperation implements Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };
        
        private final String symbol;
        
        BasicOperation(String symbol) {
            this.symbol = symbol;
        }
        
        @Override
        public String toString() {
            return symbol;
        }
    }
    
    /**
     * Выводы и ограничения enum
     * 1. ПРЕИМУЩЕСТВА ENUM:
     * - Типобезопасность - компилятор проверяет допустимые значения
     * - Читаемость - именованные константы вместо магических чисел
     * - Расширяемость - можно добавлять поля, методы, конструкторы
     * - Поддержка switch
     * - Методы values() и valueOf() из коробки
     * - Можно реализовывать интерфейсы
     * 
     * 2. ОГРАНИЧЕНИЯ ENUM (чего НЕЛЬЗЯ):
     * - Нельзя наследовать от других классов
     *      public enum MyEnum extends SomeClass {} // ОШИБКА!
     * - Нельзя быть суперклассом"
     *      class MyClass extends DayOfWeek {} // ОШИБКА!
     * - Нельзя создавать экземпляры с new
     *      DayOfWeek day = new DayOfWeek(); // ОШИБКА!
     * - Нельзя быть абстрактным (но методы внутри могут быть)
     *      abstract enum MyEnum {} // ОШИБКА!
     * - Нельзя параметризировать (как generic)
     *      enum MyEnum<T> {} // ОШИБКА!
     *      
     * 3. ЛУЧШИЕ ПРАКТИКИ:
     * - Используйте enum для фиксированного набора значений
     * - Добавляйте полезные методы в enum
     * - Используйте EnumSet и EnumMap для коллекций
     * - Избегайте зависимости от ordinal() - создавайте свои поля
     * - Реализуйте интерфейсы, если нужно полиморфное поведение
     * 
     * 4. КОГДА ИСПОЛЬЗОВАТЬ ENUM:
     * - Дни недели, месяцы, времена года
     * - Состояния объектов (статусы заказов, задачи)
     * - Конфигурационные параметры
     * - Коды ошибок, статусные коды
     * -Режимы работы приложения
     * - Любой фиксированный набор связанных констант
     * 
     * 5. ПРИМЕРЫ ИЗ СТАНДАРТНОЙ БИБЛИОТЕКИ:
     *     java.time.DayOfWeek
     *     java.time.Month
     *     java.util.concurrent.TimeUnit
     *     java.lang.Thread.State
     *     java.nio.file.StandardOpenOption
     *     
     * Enum в Java - это полноценный класс, который может иметь поля, методы и конструкторы.
     * Это мощный инструмент для создания безопасных,самодокументируемых наборов констант.
     */
}