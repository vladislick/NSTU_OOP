package MyPackage;

import MyPackage.Generators.IMatrix;

public class Matrix {
	private int rows, columns;
	public int[][] data;
	private IMatrix generator;
	
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		data = new int[rows][columns];
	}
	
	// Получить элемент матрицы
	public int getElement(int row, int column) {
		return data[row][column];
	}
	
	// Получить ширину матрицы
	public int getWidth() {
		return columns;
	} 
	
	// Получить высоту матрицы
	public int getHeight() {
		return rows;
	}
	
	// Обновисть содержимое матрицы
	public void update() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				data[i][j] = generator.getElement(i, j);
	}
	
	// Выбрать текущий генератор матрицы
	public void setGenerator(IMatrix gen) {
		this.generator = gen;
	}
}
