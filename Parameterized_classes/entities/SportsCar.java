package entities;

/**
 * Класс SportsCar, расширяющий Car
 */
public class SportsCar extends Car {
    public SportsCar(String name) {
        super(name);
    }
    
    public void turboBoost() {
        System.out.println(getName() + " включает турбо-ускорение!");
    }
}