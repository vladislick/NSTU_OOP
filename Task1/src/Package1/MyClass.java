package Package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyClass {
	
	public static void main(String[] args) {
		
		// Заполнение автосалона
		Car mycars[] = new Car[12];
		mycars[0] = new Car("Toyota", "Celica", 675000f, 1998);
		mycars[1] = new Car("Toyota", "Vista", 376000f, 1994);
		mycars[2] = new Car("Toyota", "Progres", 579000f, 2002);
		mycars[3] = new Car("Nissan", "Serena", 1230000f, 2016);
		mycars[4] = new Car("Nissan", "Almera", 430000f, 2005);
		mycars[5] = new Car("Nissan", "Bluebird Sylphy", 340000f, 2000);
		mycars[6] = new Car("УАЗ", "Патриот", 1826000f, 2023);
		mycars[7] = new Car("УАЗ", "СГР", 1275000f, 2023);
		mycars[8] = new Car("УАЗ", "Хантер", 1140000f, 2023);
		mycars[9] = new Car("Лада", "Веста", 1789000f, 2022);
		mycars[10] = new Car("Лада", "Гранта", 721000f, 2019);
		mycars[11] = new Car("Лада", "Калина", 520000f, 2014);
		
		// Сортировка по цене методом пузырька
		Car tmp = new Car();
		for (int i = 0; i < mycars.length; i++) {
			for (int j = i; j < (mycars.length - 1); j++) {
				if (mycars[j].price > mycars[j + 1].price) {
					tmp = mycars[j];
					mycars[j] = mycars[j + 1];
					mycars[j + 1] = tmp;
				}
			}
		}
		
		try {
			PrintStream out = new PrintStream(new File("DB.txt"));
			for (Car mycar : mycars) {
				mycar.printToFile(out);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.out.println("Не удалось открыть файл!\n");
		}
	}
}
