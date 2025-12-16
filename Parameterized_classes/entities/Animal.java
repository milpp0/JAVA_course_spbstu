package entities;

/**
 * Базовый класс Animal для демонстрации наследования
 * с generic-типами
 */
public class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}
