package a03_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
	}

}
