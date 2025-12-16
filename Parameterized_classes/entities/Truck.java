package entities;

/**
 * Класс Truck, расширяющий Vehicle
 */
public class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }
    
    public void loadCargo() {
        System.out.println(getName() + " загружает груз");
    }
}