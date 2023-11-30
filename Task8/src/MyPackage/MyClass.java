package MyPackage;

import javax.swing.JComboBox;

import MyPackage.Generators.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import MyPackage.Generators.IMatrix;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
		frame.setSize(600, 350);
		// Название окна
		frame.setTitle("Матрицтруктор");
		// Расположение элементов
		frame.setLayout(new BorderLayout());
		
		// Создание общего шрифта
		Font font = new Font("Arial", Font.BOLD, 17);
		
		// Создание объекта матрицы размером 10 x 10
		Matrix mymatrix = new Matrix(10, 10);
		
		// Создание списка генератором матриц
		IMatrix[] generators = { 
				new DiagonalMatrix(),
				new IdentityMatrix(),
				new RandMatrix(),
				new ZeroMatrix(),
				new TriangleBottomMatrix(),
				new TriangleTopMatrix()
		};
		
		// Создание списка слушателей матрицы
		AMatrixListener[] matrixListeners = {
				new MatrixListener(),
				new MaxListener(),
				new SumListener(),
				new TraceListener(),
				new DeterminantListener()
		};
		
		// Добавление элементов на экран приложения
		JComboBox<String> matrixChooser = new JComboBox<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
		matrixChooser.setFont(font);
		
		// Добавление отображателей матрицы на экран
		for (AMatrixListener matrix : matrixListeners) {
			matrix.setFont(font);
			panel.add(matrix);
		}
		
		// Добавление генераторов матрицы на экран
		for (IMatrix matrix : generators) matrixChooser.addItem(matrix.getName());
		
		// Добавление элементов на экран
		frame.add(matrixChooser, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		
		// Событие смены текущего генератора матрицы
		matrixChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Выбор нового генератора матрицы
				mymatrix.setGenerator(generators[matrixChooser.getSelectedIndex()]);
				// Сгенерировать значения матрицы
				mymatrix.update();
				// Обновление всех отображателей матрицы
				for (AMatrixListener matrix : matrixListeners)
					matrix.matrixUpdate(mymatrix);
			}
		});
		
		// Видимость окна
		frame.setVisible(true);
	}
}
