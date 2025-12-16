package practice;

public class Practice3_5 {

	public static void main(String[] args) {
		/**
		 * Вывод программы:
		 * text
		 * static logic
		 * logic (1) id= 0
		 * logic (2) id= 1
		 * ctor id= 100
		 * 
		 * Объяснение:
		 * static logic - static блок выполняется первым, при загрузке класса A в память JVM
		 * logic (1) id= 0 - первый нестатический блок выполняется вторым
		 * this.id равен 0 (значение по умолчанию для int)
		 * Поля еще не инициализированы
		 * logic (2) id= 1 - второй нестатический блок выполняется третьим
		 * id уже равен 1 (после инициализации поля private int id = 1;)
		 * ctor id= 100 - конструктор выполняется последним
		 * Параметр конструктора (100) присваивается полю id
		 */
	}

}
