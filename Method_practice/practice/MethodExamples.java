package practice;

//Main класс для демонстрации
public class MethodExamples {
 public static void main(String[] args) {
     System.out.println("=== Перегрузка методов ===");
     Calculator calc = new Calculator();
     System.out.println("calc.add(2, 3) = " + calc.add(2, 3));
     System.out.println("calc.add(2.5, 3.7) = " + calc.add(2.5, 3.7));
     System.out.println("calc.add(1, 2, 3) = " + calc.add(1, 2, 3));
     
     System.out.println("\n=== Переопределение методов ===");
     Animal myDog = new Dog("Бобик");
     Animal myCat = new Cat("Мурзик");
     Animal genericAnimal = new Animal("Неизвестное животное");
     
     // Полиморфизм: один метод, разное поведение
     myDog.makeSound();    // Вызов переопределенного метода
     myCat.makeSound();    // Вызов переопределенного метода
     genericAnimal.makeSound(); // Вызов метода суперкласса
     
     // Вызов непереопределенного метода
     myDog.eat();
     myCat.eat();
     
     // Пример с перегрузкой в подклассе
     Dog dog = new Dog("Шарик");
     dog.eat("кость"); // Вызов перегруженного метода
 }
}