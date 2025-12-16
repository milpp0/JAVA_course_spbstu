package Main;

import entities.*;
import genericutils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный демонстрационный класс для объединенной практики
 * Параметризация и Wildcards в Java Generics
 * 
 * Цель: продемонстрировать:
 * 1. Использование instanceof с параметризованными классами
 * 2. Wildcards <? extends T> и <? super T>
 * 3. Принцип PECS (Producer Extends, Consumer Super)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ОБЪЕДИНЕННАЯ ПРАКТИКА: PARAMETRIZATION И WILDCARDS ===\n");
        
        // Часть 1: Параметризация и instanceof
        System.out.println("ЧАСТЬ 1: PARAMETRIZATION И INSTANCEOF\n");
        
        // 1.1 Демонстрация с простыми типами
        System.out.println("1.1 ПРОСТЫЕ ТИПЫ С INSTANCEOF:");
        
        Box<String> stringBox = new Box<>("Hello, World!");
        stringBox.checkContentType();
        
        Box<Integer> intBox = new Box<>(42);
        intBox.checkContentType();
        
        Box<Double> doubleBox = new Box<>(3.14);
        TypeChecker.checkBoxType(doubleBox);
        
        // 1.2 Демонстрация с массивами
        System.out.println("\n1.2 МАССИВЫ:");
        
        Integer[] numbers = {1, 2, 3, 4, 5};
        Box<Integer[]> arrayBox = new Box<>(numbers);
        TypeChecker.checkBoxType(arrayBox);
        
        // 1.3 Демонстрация с иерархией классов
        System.out.println("\n1.3 ИЕРАРХИЯ КЛАССОВ:");
        
        Car car = new Car("Седан");
        Box<Car> carBox = new Box<>(car);
        carBox.checkContentType();
        
        Truck truck = new Truck("Грузовик");
        Box<Truck> truckBox = new Box<>(truck);
        TypeChecker.checkVehicleBox(truckBox);
        
        Bicycle bicycle = new Bicycle("Горный велосипед");
        Box<Bicycle> bicycleBox = new Box<>(bicycle);
        bicycleBox.checkContentType();
        
        // 1.4 Демонстрация с GenericContainer
        System.out.println("\n1.4 GENERICCONTAINER:");
        
        GenericContainer<Number> numberContainer = new GenericContainer<>(100);
        System.out.println("isNumber: " + numberContainer.isNumber());
        System.out.println("isInteger: " + numberContainer.isInteger());
        System.out.println("getAsNumber: " + numberContainer.getAsNumber());
        
        GenericContainer<String> stringContainer = new GenericContainer<>("Test String");
        System.out.println("isCharSequence: " + stringContainer.isCharSequence());
        System.out.println("getAsString: " + stringContainer.getAsString());
        
        GenericContainer<Integer[]> arrayContainer = new GenericContainer<>(numbers);
        System.out.println("isArray: " + arrayContainer.isArray());
        System.out.println("isIntegerArray: " + arrayContainer.isIntegerArray());
        
        // Часть 2: Wildcards <? extends T> и <? super T>
        System.out.println("\n\nЧАСТЬ 2: WILDCARDS <? EXTENDS T> И <? SUPER T>\n");
        
        // 2.1 Демонстрация <? extends Vehicle>
        System.out.println("2.1 <? EXTENDS Vehicle>:");
        
        SportsCar sportsCar = new SportsCar("Спортивный автомобиль");
        Box<SportsCar> sportsCarBox = new Box<>(sportsCar);
        
        // Все эти вызовы работают благодаря <? extends Vehicle>
        Box.processVehicleBox(carBox);
        Box.processVehicleBox(truckBox);
        Box.processVehicleBox(bicycleBox);
        Box.processVehicleBox(sportsCarBox);
        
        TypeChecker.checkVehicleBox(sportsCarBox);
        
        // 2.2 Демонстрация <? super Car>
        System.out.println("\n2.2 <? SUPER Car>:");
        
        Box<Vehicle> vehicleBox = new Box<>();
        Box<Car> carBoxForSuper = new Box<>();
        Box<Object> objectBox = new Box<>();
        
        // Все эти вызовы работают благодаря <? super Car>
        Box.fillCarBox(vehicleBox, new Car("Обычный автомобиль"));
        Box.fillCarBox(carBoxForSuper, new Car("Другой автомобиль"));
        Box.fillCarBox(objectBox, new Car("Автомобиль в Object Box"));
        
        // 2.3 Демонстрация PECS принципа
        TypeChecker.demonstratePECS();
        
        // 2.4 Дополнительные примеры wildcards
        System.out.println("\n2.4 ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ:");
        
        TypeChecker.demonstrateExtendsNumber();
        TypeChecker.demonstrateSuperT();
        
        // 2.5 Проверка различных типов через TypeChecker
        System.out.println("\n2.5 КОМПЛЕКСНЫЕ ПРОВЕРКИ:");
        
        TypeChecker.checkContainerType(new GenericContainer<>(12345));
        TypeChecker.checkContainerType(new GenericContainer<>("Generic Text"));
        TypeChecker.checkContainerType(new GenericContainer<>(sportsCar));
        
        // Часть 3: Ограничения generic типов
        System.out.println("\n\nЧАСТЬ 3: ОГРАНИЧЕНИЯ GENERIC ТИПОВ\n");
        
        // 3.1 Демонстрация с null значениями
        System.out.println("3.1 NULL ЗНАЧЕНИЯ:");
        
        Box<Object> nullBox = new Box<>(null);
        nullBox.checkContentType();
        
        GenericContainer<Object> nullContainer = new GenericContainer<>(null);
        System.out.println("isNumber на null: " + nullContainer.isNumber());
        System.out.println("isArray на null: " + nullContainer.isArray());
        
        // 3.2 Демонстрация ограничений extends в объявлении класса
        System.out.println("\n3.2 ОГРАНИЧЕНИЯ EXTENDS В ОБЪЯВЛЕНИИ КЛАССА:");
        
        VehicleGarage<Car> carGarage = new VehicleGarage<>();
        carGarage.park(new Car("Тойота"));
        carGarage.park(new SportsCar("Порше"));
        carGarage.showAll();
        
        // 3.3 Попытка использовать несовместимые типы (закомментировано)
        System.out.println("\n3.3 НЕСОВМЕСТИМЫЕ ТИПЫ (закомментировано):");
        System.out.println("// VehicleGarage<String> stringGarage = new VehicleGarage<>(); // Ошибка компиляции!");
        System.out.println("// VehicleGarage<Integer> intGarage = new VehicleGarage<>(); // Ошибка компиляции!");
        
        // Итоги и выводы
        System.out.println("\n\n=== ИТОГИ И ВЫВОДЫ ===");
        printConclusions();
        
        System.out.println("\n=== ПРАКТИКА ЗАВЕРШЕНА ===");
    }
    
    /**
     * Класс с ограничением типа в объявлении (T extends Vehicle)
     * Демонстрирует использование extends для ограничения generic параметра
     */
    static class VehicleGarage<T extends Vehicle> {
        private List<T> vehicles = new ArrayList<>();
        
        public void park(T vehicle) {
            vehicles.add(vehicle);
            System.out.println("Припаркован: " + vehicle.getName());
        }
        
        public void showAll() {
            System.out.println("В гараже " + vehicles.size() + " транспортных средств:");
            for (T vehicle : vehicles) {
                System.out.println("  - " + vehicle.getName() + " (" + vehicle.getClass().getSimpleName() + ")");
            }
        }
    }
    
    /**
     * Выводы и объяснения
     */
    private static void printConclusions() {
        System.out.println("\n1. INSTANCEOF С PARAMETRIZED КЛАССАМИ:");
        System.out.println("   - Позволяет проверять runtime-тип объектов");
        System.out.println("   - Необходим для безопасного приведения типов");
        System.out.println("   - Работает с generic типами после type erasure");
        
        System.out.println("\n2. <? EXTENDS T> (UPPER BOUNDED WILDCARD):");
        System.out.println("   - Используется когда нужно ЧИТАТЬ данные");
        System.out.println("   - Принимает T и все его подклассы");
        System.out.println("   - НЕ позволяет добавлять новые элементы (кроме null)");
        System.out.println("   - Пример: List<? extends Number>");
        
        System.out.println("\n3. <? SUPER T> (LOWER BOUNDED WILDCARD):");
        System.out.println("   - Используется когда нужно ЗАПИСЫВАТЬ данные");
        System.out.println("   - Принимает T и все его суперклассы");
        System.out.println("   - Позволяет добавлять T и его подклассы");
        System.out.println("   - Можно читать только как Object");
        System.out.println("   - Пример: List<? super Integer>");
        
        System.out.println("\n4. PECS ПРИНЦИП (PRODUCER EXTENDS, CONSUMER SUPER):");
        System.out.println("   - Если параметр производит T -> используйте <? extends T>");
        System.out.println("   - Если параметр потребляет T -> используйте <? super T>");
        System.out.println("   - Улучшает гибкость и безопасность типов");
        
        System.out.println("\n5. ОГРАНИЧЕНИЯ GENERIC В JAVA:");
        System.out.println("   - Невозможно создать массив generic типа: new T[]");
        System.out.println("   - Невозможно использовать instanceof с generic типом: obj instanceof T<String>");
        System.out.println("   - Невозможно создать экземпляр generic типа: new T()");
        System.out.println("   - Ограничения на статические члены");
    }
}