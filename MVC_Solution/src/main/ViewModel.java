package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ViewModel implements ActionListener{
	Model model = new Model();
	MainWindow mainView ;
	ViewModel(MainWindow view) {
		mainView=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Reset")) {
			model.Reset(mainView);
			
		}
		else if (action.equals("OK")) {
			model.OkAction(mainView);
		}
	}
	
	

}
