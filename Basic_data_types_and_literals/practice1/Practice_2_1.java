package practice1;

public class Practice_2_1 {
	public static void main(String[] args) {
		// Базовые типы данных
		System.out.println("Практика №1");
		byte bZero = 0; byte bValue = 127;
		short sZero = 0; short sValue = 32000;
		int iZero = 0; int iValue = 10324658;
		long lZero = 0; long lValue = 123456789L;
		float fZero = 0.0f; float fValue = 3.14f;
		double dZero =0.0; double dValue = 2.321;
		char cZero = '\0'; char cValue= 'A';
		boolean boZero = false; boolean boValue = true;
		System.out.println("BYTE" + "\n--Нулевое значение: "+ bZero +"\n--Пример значения: "+ bValue);
        System.out.println("SHORT--" + "\n--Нулевое значение: "+ sZero +"\n--Пример значения: "+ sValue);
        System.out.println("INT--" + "\n--Нулевое значение: "+ iZero +"\n--Пример значения: "+ iValue);
        System.out.println("LONG--" + "\n--Нулевое значение: "+ lZero +"\n--Пример значения: "+ lValue);
        System.out.println("FLOAT--" + "\n--Нулевое значение: "+ fZero +"\n--Пример значения: "+ fValue);
        System.out.println("DOUBLE--" + "\n--Нулевое значение: "+ dZero +"\n--Пример значения: "+ dValue);
        System.out.println("CHAR--" + "\n--Нулевое значение: "+ cZero +"\n--Пример значения: "+ cValue);
        System.out.println("BOOLEAN--" + "\n--Нулевое значение: "+ boZero +"\n--Пример значения: "+ boValue);
        // Моё имя через символы Unicode
        System.out.println("Практика №2");
        System.out.println("Имя в Unicode: \u0412\u043b\u0430\u0434");
        System.out.println("Практика №3");
        System.out.println("Будет ошибка и код нескомпелируется,так как переменная b не была объявленна вне локальной области");
        System.out.println("Практика №4");
        System.out.println("Сумма: " + 10 + 5);
        System.out.println("Сумма: " + (10 + fValue));
        System.out.println(boValue + " - boolean");
        System.out.println("Практика №5");
        byte a1 = 120; short a2 = 32701; int a3 = 2147483647; byte a4 = 4;
        System.out.println(((Object) a2).getClass().getSimpleName()+ " + " + ((Object) a3).getClass().getSimpleName() + " = " + ((Object) (a2+a3)).getClass().getSimpleName());
        System.out.println("В данном случае участвовали переменные двух типов short и int. При работе с int нельзя получить расширяющее преобразование типов, так как операции всёравно выдают тип int");
        System.out.println(((Object) a1).getClass().getSimpleName()+ " + " + ((Object) a1).getClass().getSimpleName() + " = " + ((Object) (a1+a1)).getClass().getSimpleName());
        System.out.println(((Object) a1).getClass().getSimpleName()+ " + " + ((Object) a2).getClass().getSimpleName() + " = " + ((Object) (a1+a2)).getClass().getSimpleName());
        System.out.println(((Object) a1).getClass().getSimpleName()+ " + " + ((Object) a4).getClass().getSimpleName() + " = " + ((Object) (a1+a4)).getClass().getSimpleName());
        System.out.println("В данном случае участвовали переменные двух типов byte и short. При операции с ними компилятор сразу преобразует выходное значение в int формат, минуя short и byte");
        System.out.println("Практика №6");
        int b1 = 100;
        System.out.println(((Object) b1).getClass().getSimpleName());
        short b2 = (short) b1;
        System.out.println(((Object) b2).getClass().getSimpleName());
        byte b3 = (byte) b2;
        System.out.println(((Object) b3).getClass().getSimpleName());
        System.out.println("Практика №7");
        int a = 120;
        byte b = (byte)(a + 10);
        byte c = (byte)(a + 10);
        byte d = (byte)(a + 1);
        System.out.println("Без явного преобразования классов во второй и 4 строчках код нескомпелируется. Если же учесть это, то получим следующее:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("Практика №8");
        var p81 = "Влад";
        var p82 = 25;
        var p83 = 5000.50;
        var p84 = true;
        var p85 = 'V';
        System.out.println("Тип p81: " + p81.getClass().getSimpleName());
        System.out.println("Тип p82: " + ((Object)p82).getClass().getSimpleName());
        System.out.println("Тип p83: " + ((Object)p83).getClass().getSimpleName());
        System.out.println("Тип p84: " + ((Object)p84).getClass().getSimpleName());
        System.out.println("Тип p85: " + ((Object)p85).getClass().getSimpleName());
	}
}