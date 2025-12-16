package entities;

/**
 * Класс Dog, расширяющий Animal
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Woof!");
    }
    
    public void fetch() {
        System.out.println("Fetching ball...");
    }
}
