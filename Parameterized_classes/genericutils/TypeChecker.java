package genericutils;

import entities.Vehicle;
import entities.Car;
import entities.SportsCar;
import entities.Truck;
import entities.Bicycle;
import entities.Box;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для демонстрации различных сценариев
 * использования instanceof и wildcards с generic типами
 */
public class TypeChecker {
    
    /**
     * Проверка типа с wildcard (<?>)
     * @param box Box с любым типом
     */
    public static void checkBoxType(Box<?> box) {
        Object content = box.getContent();
        
        System.out.println("\n=== Проверка Box<?> с instanceof ===");
        
        if (content instanceof String) {
            String str = (String) content;
            System.out.println("String found: " + str.toUpperCase());
        } else if (content instanceof Integer) {
            Integer num = (Integer) content;
            System.out.println("Integer found: " + (num * 2));
        } else if (content instanceof Double) {
            Double dbl = (Double) content;
            System.out.println("Double found: " + (dbl / 2));
        } else if (content instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) content;
            System.out.println("Vehicle found: " + vehicle.getName());
            
            // Дополнительная проверка на конкретный тип
            if (content instanceof Car) {
                System.out.println("  -> Это автомобиль!");
                ((Car) content).honk();
            } else if (content instanceof Truck) {
                System.out.println("  -> Это грузовик!");
                ((Truck) content).loadCargo();
            } else if (content instanceof Bicycle) {
                System.out.println("  -> Это велосипед!");
                ((Bicycle) content).ringBell();
            }
        } else if (content instanceof Object[]) {
            System.out.println("Array found with length: " + ((Object[]) content).length);
        } else {
            System.out.println("Unknown type: " + 
                (content != null ? content.getClass().getName() : "null"));
        }
    }
    
    /**
     * Проверка ограниченного generic типа <? extends Vehicle>
     * @param vehicleBox Box с Vehicle или его потомками
     */
    public static void checkVehicleBox(Box<? extends Vehicle> vehicleBox) {
        Vehicle vehicle = vehicleBox.getContent();
        
        System.out.println("\n=== Проверка Box<? extends Vehicle> ===");
        
        if (vehicle != null) {
            System.out.println("Vehicle name: " + vehicle.getName());
            
            // Всегда безопасно - содержимое гарантированно Vehicle
            if (vehicle instanceof Car) {
                System.out.println("Definitely a Car instance");
                if (vehicle instanceof SportsCar) {
                    System.out.println("Actually a SportsCar!");
                    ((SportsCar) vehicle).turboBoost();
                }
            } else if (vehicle instanceof Truck) {
                System.out.println("Definitely a Truck instance");
            } else if (vehicle instanceof Bicycle) {
                System.out.println("Definitely a Bicycle instance");
            }
        }
    }
    
    /**
     * Проверка с <? super Car> - может принимать Box с Car или его суперклассами
     * @param carBox Box для Car или его суперклассов
     */
    public static void fillWithCar(Box<? super Car> carBox) {
        Car car = new Car("Новый автомобиль");
        carBox.setContent(car);
        System.out.println("\nBox заполнен автомобилем: " + car.getName());
        
        // Можно читать только как Object
        Object content = carBox.getContent();
        if (content instanceof Vehicle) {
            System.out.println("Содержимое Box: " + ((Vehicle) content).getName());
        }
    }
    
    /**
     * Обобщенная проверка типа для любого GenericContainer
     * @param container контейнер с любым типом
     */
    public static <U> void checkContainerType(GenericContainer<U> container) {
        U value = container.getValue();
        
        System.out.println("\n=== Проверка GenericContainer ===");
        System.out.println("Значение: " + value);
        System.out.println("Тип значения: " + 
            (value != null ? value.getClass().getSimpleName() : "null"));
        
        // Проверки с instanceof
        if (value instanceof Number) {
            System.out.println("✓ Это Number");
            Number num = (Number) value;
            System.out.println("  Значение как double: " + num.doubleValue());
        }
        
        if (value instanceof String) {
            System.out.println("✓ Это String");
            System.out.println("  Длина строки: " + ((String) value).length());
        }
        
        if (value instanceof Integer[]) {
            System.out.println("✓ Это массив Integer");
            Integer[] array = (Integer[]) value;
            System.out.println("  Длина массива: " + array.length);
        }
        
        if (value instanceof Vehicle) {
            System.out.println("✓ Это Vehicle");
            System.out.println("  Имя: " + ((Vehicle) value).getName());
        }
    }
    
    /**
     * Демонстрация PECS (Producer Extends, Consumer Super) принципа
     */
    public static void demonstratePECS() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ PECS ПРИНЦИПА ===");
        
        // Producer (extends) - источник данных
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Тойота"));
        cars.add(new SportsCar("Порше"));
        
        // Consumer (super) - приемник данных
        List<Vehicle> vehicles = new ArrayList<>();
        
        // Копирование с использованием wildcards
        copyWithPECS(cars, vehicles);
        
        System.out.println("Скопировано " + vehicles.size() + " транспортных средства");
    }
    
    /**
     * Реализация копирования по PECS принципу
     * @param src источник (Producer - extends)
     * @param dest назначение (Consumer - super)
     */
    public static <T> void copyWithPECS(List<? extends T> src, List<? super T> dest) {
        dest.clear();
        for (T item : src) {
            dest.add(item);
            System.out.println("Скопировано: " + item);
        }
    }
    
    /**
     * Пример использования <? extends Number> для вычислений
     */
    public static void demonstrateExtendsNumber() {
        System.out.println("\n=== <? EXTENDS Number> ДЛЯ ВЫЧИСЛЕНИЙ ===");
        
        GenericContainer<Integer> intContainer = new GenericContainer<>(100);
        GenericContainer<Double> doubleContainer = new GenericContainer<>(50.5);
        
        System.out.println("Сумма int: " + GenericContainer.sumNumbers(intContainer));
        System.out.println("Сумма double: " + GenericContainer.sumNumbers(doubleContainer));
    }
    
    /**
     * Пример использования <? super T> для гибких операций записи
     */
    public static void demonstrateSuperT() {
        System.out.println("\n=== <? SUPER T> ДЛЯ ОПЕРАЦИЙ ЗАПИСИ ===");
        
        GenericContainer<Vehicle> vehicleContainer = new GenericContainer<>(null);
        GenericContainer<Object> objectContainer = new GenericContainer<>(null);
        
        Car car = new Car("Хонда");
        GenericContainer.setVehicle(vehicleContainer, car);
        GenericContainer.setVehicle(objectContainer, car);
    }
}