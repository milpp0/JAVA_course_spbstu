package practice;

//Тестовый класс
public class AccessModifiersSimple {
 public static void main(String[] args) {
     // 1. private - тест
     ExamplePrivate ex1 = new ExamplePrivate();
     // System.out.println(ex1.secret); // ОШИБКА: private недоступен
     ex1.showSecret(); // Доступ через public метод
     
     // 2. default - доступен (в том же пакете)
     ExampleDefault ex2 = new ExampleDefault();
     System.out.println(ex2.packageData); // Доступно
     
     // 3. protected - доступен (в том же пакете)
     ExampleProtected ex3 = new ExampleProtected();
     System.out.println(ex3.familyData); // Доступно
     
     // 4. public - всегда доступен
     ExamplePublic ex4 = new ExamplePublic();
     System.out.println(ex4.publicData); // Доступно
 }
}