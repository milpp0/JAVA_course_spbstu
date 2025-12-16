package entities;

/**
 * Базовый класс Vehicle для демонстрации иерархии классов
 * с generic-типами
 */
public class Vehicle {
    private String name;
    
    public Vehicle(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void move() {
        System.out.println(name + " двигается");
    }
    
    @Override
    public String toString() {
        return "Транспорт: " + name;
    }
}