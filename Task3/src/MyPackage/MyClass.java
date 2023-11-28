package MyPackage;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

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
		frame.setSize(400, 100);
		// Название окна
		frame.setTitle("LogicCalc");
		Font font = new Font("Arial", Font.BOLD, 16);
		// Расположение элементов
		frame.setLayout(new FlowLayout());
		
		// Объявление операций
		IOperation operations[] = new IOperation[4];
		operations[0] = new XOR();
		operations[1] = new OR();
		operations[2] = new AND();
		operations[3] = new NAND();
		
		// Создание графических объектов
		JTextField operandA = new JTextField("0", 5);
		JTextField operandB = new JTextField("0", 5);
		JTextField resultText = new JTextField("0", 5);
		JLabel resultLabel = new JLabel("");
		JButton calculate = new JButton("=");
		JComboBox<String> operation = new JComboBox<String>();
		
		operandA.setFont(font);
		operandB.setFont(font);
		resultText.setFont(font);
		resultLabel.setFont(font);
		calculate.setFont(font);
		operation.setFont(font);
		
		// Добавление операторов
		for (IOperation op : operations) operation.addItem(op.getSign());
		
		// Добавление объектов на окно приложения
		frame.add(operandA);
		frame.add(operation);
		frame.add(operandB);
		frame.add(calculate);
		frame.add(resultText);
		frame.add(resultLabel);
		
		// Выполнение расчетов по нажатию кнопки
		calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = operations[operation.getSelectedIndex()]
						.estimate(
								Integer.parseInt(operandA.getText()), 
								Integer.parseInt(operandB.getText())
						);
				resultLabel.setText(operandA.getText() + " " + 
						operations[operation.getSelectedIndex()].getName() + 
						" " + operandB.getText() + " будет " + Integer.toString(result));
				
				resultText.setText(Integer.toString(result));
			}
		});
		
		
		// Видимость окна
		frame.setVisible(true);
	}
}
