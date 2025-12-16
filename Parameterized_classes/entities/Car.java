package entities;

/**
 * Класс Car, расширяющий Vehicle
 */
public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }
    
    public void honk() {
        System.out.println(getName() + " сигналит: Би-бип!");
    }
}