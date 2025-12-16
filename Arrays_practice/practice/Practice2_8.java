package practice;

import java.util.Arrays;

/**
 * Демонстрация работы с массивами в Java
 * 
 * @author Vladislav Nikiforov
 */
public class Practice2_8 {

    /**
     * Основной метод демонстрации
     */
    public static void main(String[] args) {
        // Практика #1: Демонстрация работы ссылок на массивы
        System.out.println("=== Практика #1 ===");
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {6, 7, 8, 9, 10};
        
        System.out.println("До присваивания:");
        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("a2: " + Arrays.toString(a2));
        
        a1 = a2; // a1 теперь ссылается на тот же массив, что и a2
        a1[0] = 100; // Изменяем через a1
        
        System.out.println("\nПосле a1 = a2 и a1[0] = 100:");
        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("a2: " + Arrays.toString(a2));
        
        // Практика #2: Методы класса Arrays
        System.out.println("\n=== Практика #2 ===");
        
        int[] arr1 = {5, 3, 9, 1, 7};
        int[] arr2 = {5, 3, 9, 1, 7};
        int[] arr3 = {1, 3, 5, 7, 9};
        
        // toString()
        System.out.println("Arrays.toString(): " + Arrays.toString(arr1));
        
        // sort()
        Arrays.sort(arr1);
        System.out.println("После sort(): " + Arrays.toString(arr1));
        
        // binarySearch()
        int index = Arrays.binarySearch(arr1, 7);
        System.out.println("binarySearch(7): индекс = " + index);
        
        // equals()
        boolean areEqual = Arrays.equals(arr1, arr2);
        System.out.println("equals(arr1, arr2): " + areEqual);
        
        // compare() (появился в Java 9)
        int comparison = Arrays.compare(arr1, arr3);
        System.out.println("compare(arr1, arr3): " + comparison + 
                         " (0 = равны, <0 = arr1 меньше, >0 = arr1 больше)");
        
        // Дополнительный пример с двумерным массивом
        System.out.println("\n=== Двумерный массив ===");
        int[][] multiArray = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        System.out.println("Двумерный массив: " + Arrays.deepToString(multiArray));
        System.out.println("multiArray[2][1] = " + multiArray[2][1]);
        
        // Демонстрация поля length
        System.out.println("\n=== Поле length ===");
        System.out.println("Длина arr1: " + arr1.length);
        System.out.println("Количество строк в multiArray: " + multiArray.length);
        System.out.println("Длина строки 2 в multiArray: " + multiArray[2].length);
    }
}