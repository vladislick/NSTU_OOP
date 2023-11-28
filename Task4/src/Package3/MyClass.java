package Package3;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Package1.Helper;

import java.awt.BorderLayout;
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
		frame.setSize(400, 150);
		// Название окна
		frame.setTitle("Справочник");
		// Создание общего шрифта
		Font font = new Font("Arial", Font.BOLD, 16);
		// Расположение элементов
		frame.setLayout(new GridLayout(2, 0));
		
		// Создание графических объектов
		JTextField userField = new JTextField();
		JTextField welcomeField = new JTextField("Привет!");
		userField.setEditable(true);
		welcomeField.setEditable(false);
		
		// Выбор шрифта для элементов
		userField.setFont(font);
		welcomeField.setFont(font);
		
		// Добавление объектов на окно приложения
		frame.add(userField);
		frame.add(welcomeField);
		
		// Добавление обработчика события ввода текста
		userField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				welcomeField.setText("Привет, " + userField.getText() + "!");
			}
		});

		// Видимость окна
		frame.setVisible(true);
	}
}
