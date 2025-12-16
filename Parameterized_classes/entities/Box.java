package entities;

/**
 * Параметризованный класс Box для хранения объектов любого типа
 * Демонстрирует ограничения generic-типов с помощью extends
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
        System.out.println("=== Проверка содержимого Box с instanceof ===");
        
        if (content instanceof String) {
            System.out.println("Box содержит String: " + content);
        } else if (content instanceof Integer) {
            System.out.println("Box содержит Integer: " + content);
        } else if (content instanceof Double) {
            System.out.println("Box содержит Double: " + content);
        } else if (content instanceof Vehicle) {
            System.out.println("Box содержит Vehicle: " + ((Vehicle) content).getName());
            // Дополнительные проверки с использованием наследования
            if (content instanceof Car) {
                System.out.println("  -> Это автомобиль!");
                ((Car) content).honk();
            } else if (content instanceof Truck) {
                System.out.println("  -> Это грузовик!");
                ((Truck) content).loadCargo();
            } else if (content instanceof Bicycle) {
                System.out.println("  -> Это велосипед!");
                ((Bicycle) content).ringBell();
            }
        } else if (content instanceof Object[]) {
            System.out.println("Box содержит массив, длина: " + ((Object[]) content).length);
        } else {
            System.out.println("Box содержит объект типа: " + 
                (content != null ? content.getClass().getSimpleName() : "null"));
        }
    }
    
    /**
     * Пример метода с wildcard <? extends Vehicle>
     * Может читать Vehicle и его подклассы
     */
    public static void processVehicleBox(Box<? extends Vehicle> vehicleBox) {
        Vehicle vehicle = vehicleBox.getContent();
        if (vehicle != null) {
            System.out.println("Обработка транспортного средства: " + vehicle.getName());
            vehicle.move();
        }
    }
    
    /**
     * Пример метода с wildcard <? super Car>
     * Может принимать Box с Car или его суперклассами
     */
    public static void fillCarBox(Box<? super Car> carBox, Car car) {
        carBox.setContent(car);
        System.out.println("В Box добавлен автомобиль: " + car.getName());
    }
}