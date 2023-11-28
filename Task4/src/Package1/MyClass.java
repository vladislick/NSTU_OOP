package Package1;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
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
		frame.setLayout(new BorderLayout());
		
		// Создание графических объектов
		JTextArea infoText = new JTextArea("");
		infoText.setLineWrap(true);
		JComboBox<String> infoLanguage = new JComboBox<String>();
		
		// Выбор шрифта для элементов
		infoText.setFont(font);
		infoLanguage.setFont(font);
		
		// Добавление языков
		for (String str : Helper.language) infoLanguage.addItem(str);
		
		// Добавление объектов на окно приложения
		frame.add(infoText, BorderLayout.CENTER);
		frame.add(infoLanguage, BorderLayout.SOUTH);
		
		// Показать информацию сразу на языке по умолчанию
		infoText.setText(Helper.info[infoLanguage.getSelectedIndex()]);
		
		// Выполнение расчетов по нажатию кнопки
		infoLanguage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoText.setText(Helper.info[infoLanguage.getSelectedIndex()]);
			}
		});
		
		
		// Видимость окна
		frame.setVisible(true);
	}
}
