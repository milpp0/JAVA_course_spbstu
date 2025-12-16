package genericutils;

import entities.Animal;
import entities.Cat;
import entities.Dog;
import entities.Box;  // Добавлен импорт Box

/**
 * Класс для демонстрации различных сценариев
 * использования instanceof с generic типами
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
        } else if (content instanceof Animal) {
            Animal animal = (Animal) content;
            System.out.println("Animal found: " + animal.getName());
            
            // Дополнительная проверка на конкретный тип животного
            if (content instanceof Cat) {
                System.out.println("  -> Это кот!");
                ((Cat) content).purr();
            } else if (content instanceof Dog) {
                System.out.println("  -> Это собака!");
                ((Dog) content).fetch();
            }
        } else if (content instanceof Object[]) {
            System.out.println("Array found with length: " + ((Object[]) content).length);
        } else {
            System.out.println("Unknown type: " + 
                (content != null ? content.getClass().getName() : "null"));
        }
    }
    
    /**
     * Проверка ограниченного generic типа <? extends Animal>
     * @param animalBox Box с Animal или его потомками
     */
    public static void checkAnimalBox(Box<? extends Animal> animalBox) {
        Animal animal = animalBox.getContent();
        
        System.out.println("\n=== Проверка Box<? extends Animal> ===");
        
        if (animal != null) {
            System.out.println("Animal name: " + animal.getName());
            
            // Всегда безопасно - содержимое гарантированно Animal
            if (animal instanceof Cat) {
                System.out.println("Definitely a Cat instance");
            } else if (animal instanceof Dog) {
                System.out.println("Definitely a Dog instance");
            }
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
    }
}