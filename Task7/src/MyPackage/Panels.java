package MyPackage;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panels {
	// Создание списков игроков
	private JList<String> playerList, teamList;
	private DefaultListModel<String> playerModel, teamModel;
	
	// Создание кнопок
	private JButton buttonRight;
	private JButton buttonRightRight;
	private JButton buttonLeft;
	private JButton buttonLeftLeft;
	
	// Создание панели для размещения кнопок
	private JPanel buttonPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	// Конструктор
	public Panels() {
		// Создание списков игроков
		playerModel = new DefaultListModel<String>();
		playerList = new JList<String>(playerModel);
		playerList.setMinimumSize(new Dimension(200, 200));
		teamModel = new DefaultListModel<String>();
		teamList = new JList<String>(teamModel);
		teamList.setMinimumSize(new Dimension(200, 200));
		// Создание панелей
		buttonPanel = new JPanel();
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0, 1));
		leftPanel.add(playerList);
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(0, 1));
		rightPanel.add(teamList);
		// Создание кнопок
		buttonRight = new JButton(">");
		buttonRight.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Создание списка выбранных элементов
				List<String> selection = playerList.getSelectedValuesList();
				// Перемещение элемента вправо
				for (String player : selection) {
					teamModel.addElement(player);
					playerModel.removeElement(player);
				}
			}
		});
		buttonRightRight = new JButton(">>");
		buttonRightRight.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Создание списка игроков
				Enumeration<String> elements = playerModel.elements();
				// Добавление игроков в правую часть
				while (elements.hasMoreElements())
					teamModel.addElement(elements.nextElement());
				// Удаление всех элементов
				playerModel.removeAllElements();
			}
		});
		buttonLeft = new JButton("<");
		buttonLeft.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Создание списка выбранных элементов
				List<String> selection = teamList.getSelectedValuesList();
				// Перемещение элемента вправо
				for (String player : selection) {
					playerModel.addElement(player);
					teamModel.removeElement(player);
				}
			}
		});
		buttonLeftLeft = new JButton("<<");
		buttonLeftLeft.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Создание списка игроков
				Enumeration<String> elements = teamModel.elements();
				// Добавление игроков в правую часть
				while (elements.hasMoreElements())
					playerModel.addElement(elements.nextElement());
				// Удаление всех элементов
				teamModel.removeAllElements();
			}
		});
		// Настройка панели кнопок
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(buttonRight);
		buttonPanel.add(buttonRightRight);
		buttonPanel.add(buttonLeft);
		buttonPanel.add(buttonLeftLeft);
		// Сброс панелей
		this.reset();
	}
	
	// Сохранить выбранных игроков
	public void save() {
		String all = "";
		Enumeration<String> elements = teamModel.elements();
		while (elements.hasMoreElements()) {
			all += elements.nextElement() + "\n";
		}
		if (all.length() > 0) 
			JOptionPane.showConfirmDialog(rightPanel, all, 
					"Сохранить игроков?", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null);
		else
			JOptionPane.showMessageDialog(playerList, 
					"Вы не выбрали ни одного игрока", 
					"Сохранить невозможно", 
					JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Провести сброс всех панелей
	public void reset() {
		playerModel.removeAllElements();
		teamModel.removeAllElements();
		for (String player : PlayersList.getNames()) 
			playerModel.addElement(player);
	}
	
	// Получить левую панель
	public JPanel getLeftPanel() {
		return leftPanel;
	}
	
	// Получить правую панель
	public JPanel getRightPanel() {
		return rightPanel;
	}

	// Получить центральную панель
	public JPanel getCenterPanel() {
		return buttonPanel;
	}
}
