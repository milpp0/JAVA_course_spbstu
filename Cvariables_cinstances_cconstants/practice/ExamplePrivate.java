package practice;

// private - доступен только внутри своего класса
class ExamplePrivate {
    private String secret = "Секретная информация";
    
    public void showSecret() {
        System.out.println(secret); // Доступно внутри класса
    }
}