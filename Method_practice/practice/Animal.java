package practice;

//Пример переопределения методов (overriding)
class Animal {
	protected String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	// Этот метод будет переопределен в подклассах
	public void makeSound() {
		System.out.println("Животное издает звук");
	}
	
	public void eat() {
		System.out.println(name + " ест");
	}
}