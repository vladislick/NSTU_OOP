package Package2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class CheckListener implements ActionListener {
	
	// Массив компонентов, которые необходимо включать-выключать
	public ArrayList<JComponent> components = new ArrayList<JComponent>();
	
	// Привязка CheckBox'a
	public JCheckBox box;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JComponent obj : components) {
			obj.setEnabled(!box.isSelected());
		}
	}
}
