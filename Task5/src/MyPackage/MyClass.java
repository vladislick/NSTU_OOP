package MyPackage;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
		frame.setSize(600, 50);
		// Название окна
		frame.setTitle("Справочник");
		// Создание общего шрифта
		Font font = new Font("Arial", Font.BOLD, 16);
		// Расположение элементов
		frame.setLayout(new GridLayout(1, 0, 10, 10));
		
		// Создание графических объектов
		JLabel label1 = new JLabel("Array at ");
		label1.setHorizontalAlignment(JLabel.RIGHT);
		JTextField index = new JTextField("0", 2);
		JLabel label2 = new JLabel(" is -");
		
		// Выбор шрифта для элементов
		label1.setFont(font);
		label2.setFont(font);
		index.setFont(font);
		
		// Добавление объектов на окно приложения
		frame.add(label1);
		frame.add(index);
		frame.add(label2);
		
		// Выполнение расчетов по нажатию кнопки
		index.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					// Если что-то введено
					if (index.getText().length() != 0) {
						label2.setText(" is " + Integer.toString(MyArray.array[Integer.parseInt(index.getText())]));
					}
				} catch (ArrayIndexOutOfBoundsException exeption) {
					label2.setText("NO SUCH INDEX");
				} catch (Exception bad_exception) {
					label2.setText("VERY BAD INDEX");
				}
			}
		});
		
		
		// Видимость окна
		frame.setVisible(true);
	}
}
