package Package2;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
		frame.setSize(600, 200);
		// Название окна
		frame.setTitle("Справочник");
		// Создание общего шрифта
		Font font = new Font("Arial", Font.BOLD, 16);
		// Расположение элементов
		frame.setLayout(new GridLayout(5, 0));
		
		// Создание графических объектов
		JCheckBox defaultData = new JCheckBox("Использовать данные по умолчанию");
		JTextField firstName = new JTextField("Введите имя");
		JTextField lastName = new JTextField("Введите фамилию");
		JRadioButton mrb = new JRadioButton("Мужской", true);
		JRadioButton frb = new JRadioButton("Женский");
		ButtonGroup group = new ButtonGroup();
		group.add(frb); group.add(mrb);
		
		// Выбор шрифта для элементов
		defaultData.setFont(font);
		firstName.setFont(font);
		lastName.setFont(font);
		mrb.setFont(font);
		frb.setFont(font);
		
		// Добавление объектов на окно приложения
		frame.add(defaultData);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(mrb);
		frame.add(frb);
		
		// Создание слушателя
		CheckListener listener = new CheckListener();
		listener.box = defaultData;
		listener.components.add(firstName);
		listener.components.add(lastName);
		listener.components.add(mrb);
		listener.components.add(frb);
		
		// Привязка слушателя к событию
		defaultData.addActionListener(listener);
		
		// Видимость окна
		frame.setVisible(true);
	}
}
