package entities;

/**
 * Параметризованный класс Box для хранения объектов любого типа
 * @param <T> тип хранимого объекта
 */
public class Box<T> {
    private T content;
    
    public Box() {
        this.content = null;
    }
    
    public Box(T content) {
        this.content = content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
    
    public T getContent() {
        return content;
    }
    
    public boolean isEmpty() {
        return content == null;
    }
    
    /**
     * Метод демонстрирует использование instanceof
     * с параметризованным полем
     */
    public void checkContentType() {
        if (content instanceof String) {
            System.out.println("Box contains String: " + content);
        } else if (content instanceof Integer) {
            System.out.println("Box contains Integer: " + content);
        } else if (content instanceof Animal) {
            System.out.println("Box contains Animal: " + ((Animal) content).getName());
        } else if (content instanceof Cat) {
            System.out.println("Box contains specifically a Cat!");
            ((Cat) content).purr();
        } else {
            System.out.println("Box contains object of type: " + content.getClass().getSimpleName());
        }
    }
}