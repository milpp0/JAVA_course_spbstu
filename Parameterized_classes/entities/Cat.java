package entities;

/**
 * Класс Cat, расширяющий Animal
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Meow!");
    }
    
    public void purr() {
        System.out.println("Purr...");
    }
}
