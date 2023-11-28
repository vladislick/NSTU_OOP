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
		frame.setTitle("Почти DVD");
		// Расположение элементов
		frame.setLayout(new GridLayout());
		
		// Создание графических объектов
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		// Добавление объектов на окно приложения
		frame.add(panel);
		
		// Видимость окна
		frame.setVisible(true);
		
		// Создание шариков
		Ball ball1 = new Ball(panel, 50, 50, 2f, 5f, 30);
		ball1.setColor(Color.RED);
		Ball ball2 = new Ball(panel, 50, 100, 4f, -10f, 60);
		ball2.setColor(Color.GREEN);
		Ball ball3 = new Ball(panel, 200, 150, -7f, -8f, 20);
		
		// Запуск шариков
		ball1.start();
		ball2.start();
		ball3.start();
	}
}
