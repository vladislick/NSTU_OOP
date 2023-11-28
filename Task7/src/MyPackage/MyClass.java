package MyPackage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class MyClass {
	
	public static void main(String[] args) {
		// Создание окна
		JFrame frame = new JFrame();
		// Завершить приложение при закрытии окна
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// Размер окна
		frame.setSize(600, 600);
		// Название окна
		frame.setTitle("Выбиратор");
		// Расположение элементов
		frame.setLayout(new BorderLayout(30,0));
		
		// Добавление объектов на окно приложения
		Panels mainPanels = new Panels();
		frame.add(mainPanels.getLeftPanel(), BorderLayout.WEST);
		frame.add(mainPanels.getRightPanel(), BorderLayout.EAST);
		frame.add(mainPanels.getCenterPanel(), BorderLayout.CENTER);
		
		
		// Создание строки меню
		MenuBar mainMenuBar = new MenuBar(mainPanels);
		frame.setJMenuBar(mainMenuBar.getMenuBar());
		
		// Видимость окна
		frame.setVisible(true);
	}
}
