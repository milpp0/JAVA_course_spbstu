package Main;

import entities.*;          // Импорт всех классов из entities
import genericutils.*;      // Импорт всех классов из genericutils

/**
 * Демонстрационный класс для практики по параметризованным классам
 * и оператору instanceof
 * 
 * Цель: продемонстрировать различные сценарии использования
 * оператора instanceof с объектами параметризованных классов
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА: instanceof с generic типами ===\n");
        
        // 1. Демонстрация с простыми типами
        System.out.println("1. ПРОСТЫЕ ТИПЫ:");
        
        Box<String> stringBox = new Box<>("Hello, World!");
        stringBox.checkContentType();
        
        Box<Integer> intBox = new Box<>(42);
        intBox.checkContentType();
        
        Box<Double> doubleBox = new Box<>(3.14);
        TypeChecker.checkBoxType(doubleBox);
        
        // 2. Демонстрация с массивами
        System.out.println("\n2. МАССИВЫ:");
        
        Integer[] numbers = {1, 2, 3, 4, 5};
        Box<Integer[]> arrayBox = new Box<>(numbers);
        TypeChecker.checkBoxType(arrayBox);
        
        // 3. Демонстрация с иерархией классов
        System.out.println("\n3. ИЕРАРХИЯ КЛАССОВ:");
        
        Cat cat = new Cat("Whiskers");
        Box<Cat> catBox = new Box<>(cat);
        catBox.checkContentType();
        
        Dog dog = new Dog("Rex");
        Box<Dog> dogBox = new Box<>(dog);
        TypeChecker.checkAnimalBox(dogBox);
        
        // 4. Демонстрация с GenericContainer
        System.out.println("\n4. GENERICCONTAINER ДЕМО:");
        
        GenericContainer<Number> numberContainer = new GenericContainer<>(100);
        System.out.println("isNumber: " + numberContainer.isNumber());
        System.out.println("isInteger: " + numberContainer.isInteger());
        
        GenericContainer<String> stringContainer = new GenericContainer<>("Test");
        System.out.println("isCharSequence: " + stringContainer.isCharSequence());
        System.out.println("getAsString: " + stringContainer.getAsString());
        
        GenericContainer<Integer[]> arrayContainer = new GenericContainer<>(numbers);
        System.out.println("isArray: " + arrayContainer.isArray());
        System.out.println("isIntegerArray: " + arrayContainer.isIntegerArray());
        
        // 5. Проверка различных типов через TypeChecker
        System.out.println("\n5. КОМПЛЕКСНЫЕ ПРОВЕРКИ:");
        
        TypeChecker.checkContainerType(new GenericContainer<>(12345));
        TypeChecker.checkContainerType(new GenericContainer<>("Generic Text"));
        TypeChecker.checkContainerType(new GenericContainer<>(cat));
        
        // 6. Демонстрация с null значениями
        System.out.println("\n6. ПРОВЕРКА NULL ЗНАЧЕНИЙ:");
        
        Box<Object> nullBox = new Box<>(null);
        TypeChecker.checkBoxType(nullBox);
        
        GenericContainer<Object> nullContainer = new GenericContainer<>(null);
        System.out.println("isNumber на null: " + nullContainer.isNumber());
        System.out.println("isArray на null: " + nullContainer.isArray());
        
        System.out.println("\n=== ПРАКТИКА ЗАВЕРШЕНА ===");
    }
}