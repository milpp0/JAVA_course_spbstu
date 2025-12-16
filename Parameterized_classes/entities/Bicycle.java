package entities;

/**
 * Класс Bicycle, расширяющий Vehicle
 */
public class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }
    
    public void ringBell() {
        System.out.println(getName() + " звонит в звонок: Дзинь-дзинь!");
    }
}