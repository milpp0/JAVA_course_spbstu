package practice;

//Пример перегрузки методов (overloading)
class Calculator {
	// Перегрузка: разные параметры, одно имя
	int add(int a, int b) {
     return a + b;
	}

	// Перегрузка - разные типы параметров
	double add(double a, double b) {
     return a + b;
	}
	
	// Перегрузка - разное количество параметров
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// НЕ перегрузка - только разный возвращаемый тип!
	// double add(int a, int b) { return a + b; } // Ошибка компиляции!
}