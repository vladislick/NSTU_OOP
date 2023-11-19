package MyPackage;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

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
		frame.setSize(600, 150);
		// Название окна
		frame.setTitle("CoffeeCalc");
		// Расположение элементов
		frame.setLayout(new GridLayout(0, 2, 10, 10));
		// Добавление первой строки элементов выбора
		frame.add(new JLabel("Тип кофе:", SwingConstants.CENTER));
		JComboBox<String> coffeeType = new JComboBox<String>(new String[] {"Эспрессо", "Американо", "Каппучино", "Латте"});
		frame.add(coffeeType);
		// Добавление второй строки элементов выбора
		frame.add(new JLabel("Количество чашек:", SwingConstants.CENTER));
		JTextField coffeeCount = new JTextField("1");
		frame.add(coffeeCount);
		// Добавление третьей строки элементов выбора
		JCheckBox coffeeSugar = new JCheckBox("Добавить сахар");
		coffeeSugar.setHorizontalAlignment(JCheckBox.CENTER);
		frame.add(coffeeSugar);
		JCheckBox coffeeCream = new JCheckBox("Добавить сливки");
		coffeeCream.setHorizontalAlignment(JCheckBox.CENTER);
		frame.add(coffeeCream);
		// Добавление строки подсчетов элементов выбора
		JButton coffeeCalculate = new JButton("Рассчитать стоимость");
		JLabel coffeeResult = new JLabel("Итого: - рублей");
		coffeeResult.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(coffeeCalculate);
		frame.add(coffeeResult);
		
		coffeeCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float count = Float.parseFloat(coffeeCount.getText());
				float cost = 30 + coffeeType.getSelectedIndex() * 15;
				float result = cost + ((coffeeSugar.isSelected()) ? 2f : 0f) + ((coffeeCream.isSelected()) ? 4f : 0f);
				result *= count;
				
				
				coffeeResult.setText("Итог: " + result + " рублей");
			}
		});
		
		
		// Видимость окна
		frame.setVisible(true);
	}
}
