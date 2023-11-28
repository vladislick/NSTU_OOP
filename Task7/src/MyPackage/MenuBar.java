package MyPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBar {
	// Создание непосредственно объекта меню
	private JMenuBar menuBar;
	// Создание ссылки на панель
	private Panels mypanel;
	// Создание меню
	public MenuBar(Panels panel) {
		// Создание строки меню
		menuBar = new JMenuBar();
		// Привязка панели
		this.mypanel = panel;
		// Создание меню "Файл"
		JMenu menuFile = new JMenu("Файл");
		// Создание и настройка элемента меню "Выход"
		JMenuItem menuItemExit = new JMenuItem("Выход");
		menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
		menuItemExit.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Создание подтверждающего окна
				int option = JOptionPane.showConfirmDialog(menuBar, 
						"Вы действительно хотите выйти?", 
						"Подтверждение выхода", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null);
				// Если подтверждение есть, то завершить программу
				if (option == JOptionPane.OK_OPTION) System.exit(0);
			}
		});
		
		// Создание и настройка элемента меню "Сохранить"
		JMenuItem menuItemSave = new JMenuItem("Сохранить");
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		menuItemSave.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.save();
			}
		});
		
		// Создание и настройка элемента меню "Сохранить"
		JMenuItem menuItemReset = new JMenuItem("Сбросить");
		menuItemReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));
		menuItemReset.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				mypanel.reset();
			}
		});
		
		// Связь строки меню с её элементами
		menuFile.add(menuItemSave);
		menuFile.add(menuItemReset);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		menuBar.add(menuFile);
	}
	
	// Получить ссылку на меню бар
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
