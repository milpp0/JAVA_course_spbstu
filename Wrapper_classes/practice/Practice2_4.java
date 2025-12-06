package practice;
/**
 * Классы-оболочки
 * Четыре практики
 * 
 * @author Vladislav Nikiforov
 */

public class Practice2_4 {

	public static void main(String[] args) {
		//Примеры использования методы decode().		
		Integer dec = Integer.decode("100");		System.out.println(dec);
		Integer oct = Integer.decode("0100");		System.out.println(oct);
		Integer hex = Integer.decode("0xFF");		System.out.println(hex);
		//Все способы создания экземпляра класса Boolean.
		Boolean b1 = Boolean.valueOf(true);   		System.out.println(b1);
		Boolean b2 = Boolean.valueOf(false);  		System.out.println(b2);
		Boolean b3 = Boolean.valueOf("true");   	System.out.println(b3);
		Boolean b4 = Boolean.valueOf("TRUE");		System.out.println(b4);
		Boolean b5 = Boolean.valueOf("True"); 		System.out.println(b5);
		Boolean b6 = Boolean.valueOf("false");		System.out.println(b6);
		Boolean b7 = Boolean.valueOf("FALSE");		System.out.println(b7);
		Boolean b8 = Boolean.valueOf("anything");	System.out.println(b8);
		Boolean b9 = Boolean.valueOf(null); 		System.out.println(b9);
		boolean b10 = Boolean.parseBoolean("true");	System.out.println(b10);
		boolean b11 = Boolean.parseBoolean("TRUE");	System.out.println(b11);
		boolean b12 = Boolean.parseBoolean("True");	System.out.println(b12);
		boolean b13 = Boolean.parseBoolean("false");System.out.println(b13);
		boolean b14 = Boolean.parseBoolean("yes");	System.out.println(b14);
		boolean b15 = Boolean.parseBoolean("on"); 	System.out.println(b15);
		boolean b16 = Boolean.parseBoolean("1");   	System.out.println(b16);
		boolean b17 = Boolean.parseBoolean(null);  	System.out.println(b17);
		Boolean b18 = Boolean.TRUE;					System.out.println(b18);
		Boolean b19 = Boolean.FALSE;  				System.out.println(b19);
		Class<Boolean> b20 = Boolean.class;			System.out.println(b20);
		Boolean b21 = true;   						System.out.println(b21);
		Boolean b22 = false;						System.out.println(b22);
		
		/**
		 * Когда Java пытается автоматически преобразовать null в примитив,
		 * она вызывает метод типа intValue(), booleanValue() и т.д. на null объекте,
		 * что вызывает NullPointerException.
		 */
		//Автораспаковка при присваивании
		Integer nullInteger = null;
        
        try {
            // Попытка распаковать null в int
            int primitive = nullInteger; // NullPointerException здесь!
            System.out.println("Это не будет выполнено");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        
        /**
         * Код выведет:
         * a1==i1 true  			Происходит автораспаковка a1 в int. Сравниваются два int
		 * b1==i1 true				Происходит автораспаковка b1 в int. Сравниваются два int
		 * a1==b1 false				Cравниваются ссылки, а не значения.
		 * 							Значение i1 выходит за IntegerCache, следовательно ссылаются на разные объекты
		 * a1.equals(i1) -> true	.equals() сравнивает значения. Происходит автоупаковка в Integer
		 * b1.equals(i1) -> true	.equals() сравнивает значения. Происходит автоупаковка в Integer
		 * a1.equals(b1) -> true	.equals() сравнивает значения
		 * a2==i2 true				Происходит автораспаковка a2 в int. Сравниваются два int
		 * b2==i2 true				Происходит автораспаковка И2 в int. Сравниваются два int
		 * a2==b2 true				Cравниваются ссылки, а не значения.Значение i2 В ПРЕДЕЛАХ IntegerCache,
		 * 							следовательно ссылаются на ОДИН и тот же кэшированный объект
		 * a2.equals(i2) -> true	.equals() сравнивает значения. Происходит автоупаковка в Integer
		 * b2.equals(i2) -> true	.equals() сравнивает значения. Происходит автоупаковка в Integer
		 * a2.equals(b2) -> true	.equals() сравнивает значения
         */
        
	}

}
