package MyPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends Thread {
	private JPanel panel;
	// Добавление координат шарика
	private float x, y;
	// Добавление ускорения шарика
	private float dx, dy;
	// Добавление размера шарика
	private int size;
	// Цвет шарика (по умолчанию синий)
	private Color color = Color.BLUE;
	
	// Создание конструктора шарика
	public Ball(JPanel panel, float x, float y, float dx, float dy, int size) {
		super();
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.size = size;
	}
	
	// Изменить цвет шарика
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void run() {
		Graphics gr = panel.getGraphics();
		while (true) {
			// Отрисовка шарика
			gr.setColor(this.color);
			gr.fillOval((int)x, (int)y, size, size);
			
			// Пауза
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Стирание предыдущего положения шарика
			gr.setColor(panel.getBackground());
			gr.fillOval((int)x, (int)y, size, size);
			
			// Изменение направления движения шарика
			if ((int)x > (panel.getWidth() - size) || (int)x < size) dx = -dx;
			if ((int)y > (panel.getHeight() - size) || (int)y < size) dy = -dy;
			
			// Перемещение шарика
			x += dx;
			y += dy;
		}
	}
}
