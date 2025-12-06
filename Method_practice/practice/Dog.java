package practice;

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    // Переопределение метода суперкласса
    @Override
    public void makeSound() {
        System.out.println(name + " гавкает: Гав-гав!");
    }
    
    // Перегрузка метода eat (разные параметры)
    public void eat(String food) {
        System.out.println(name + " ест " + food);
    }
}
