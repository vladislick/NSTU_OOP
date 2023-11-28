package MyPackage;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
