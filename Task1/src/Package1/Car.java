package Package1;

import java.io.PrintStream;

//Класс автомобилейd
public class Car {
	// Производитель (марка)
	String manufacturer;
	// Модель автомобиля
	String model;
	// Цена, рублей
	float price;
	// Год выпуска
	int year;
	
	// Конструктор класса без параметров
	public Car() {
		this.manufacturer = "";
		this.model = "";
		this.price = 0f;
		this.year = 0;
	}
		
	// Конструктор класса с параметрами
	public Car(String manufacturer, String model, float price, int year) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.price = price;
		this.year = year;
	}
	
	// Вывод в поток записи об автомобиле
	void printToFile(PrintStream stream) {
		stream.printf("%10s, %16s, %10.1f руб., %4d год\n", 
				this.manufacturer, this.model, this.price, this.year);
		System.out.printf("%10s, %16s, %10.1f руб., %4d год\n",
				this.manufacturer, this.model, this.price, this.year);
	}
}
