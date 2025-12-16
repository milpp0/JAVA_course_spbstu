package practice;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    // Переопределение метода суперкласса
    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу!");
    }
}