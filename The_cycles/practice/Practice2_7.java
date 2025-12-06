package practice;
/**
 * Циклы
 * Две практики
 * 
 * @author Vladislav Nikiforov
 */
public class Practice2_7 {

	public static void main(String[] args) {
		//Бесконечный цикл с условием true
		while (true) {
			//Примеры выполнения Бесконечныхциклов
		    System.out.println("Этот цикл выполняется вечно!");
		    // Для остановки программы нужно нажать Ctrl+C
		}
		//Цикл с условием, которое всегда истинно
		int counter = 0;
		while (counter >= 0) { // counter всегда >= 0
		    System.out.println("Итерация: " + counter);
		    counter++; // Условие никогда не станет false
		}
		//Бесконечный цикл из-за отсутствия изменения условия
		int temperature = 25;
		while (temperature > 20) {
		    System.out.println("Температура: " + temperature + "°C");
		    // Забыли изменить temperature - цикл вечный!
		}
		//Бесконечный цикл с изменением в неправильную сторону
		int number = 10;
		while (number > 0) {
		    System.out.println(number);
		    number++;
		}
		
		//Классический бесконечный do-while
		do {
		    System.out.println("Этот цикл тоже вечный!");
		} while (true);
		//do-while с постоянным условием
		int attempts = 0;
		do {
		    System.out.println("Попытка #" + attempts);
		    // attempts никогда не достигает 5
		} while (attempts < 5);
		//Бесконечный цикл из-за сброса счетчика
		int progress = 0;
		do {
		    System.out.println("Прогресс: " + progress + "%");
		    progress++;
		    if (progress > 50) {
		        progress = 0; // Сбрасываем прогресс!
		    }
		} while (progress < 100);
		//break - выход из цикла при условии
		int[] numbers = {10, 5, 8, -3, 7, 15};
		int firstNegativeIndex = -1;

		for (int i = 0; i < numbers.length; i++) {
		    if (numbers[i] < 0) {
		        firstNegativeIndex = i;
		        break; // Нашли отрицательное - выходим из цикла
		    }
		}
		System.out.println("Первое отрицательное число на позиции: " + firstNegativeIndex);
		//continue - пропуск итерации
		for (int i = 1; i <= 10; i++) {
		    if (i % 2 != 0) {
		        continue; // Пропускаем нечетные числа
		    }
		    System.out.println("Четное число: " + i);
		}
	}

}
