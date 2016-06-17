package main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	
	ViewModel viewModel = new ViewModel(this);
	JLabel enterX = new JLabel("Eingabe X");
	JLabel enterY = new JLabel("Eingabe Y");
	JTextField textY = new JTextField();
	JTextField textX = new JTextField();
	JButton resetButton = new JButton("Reset");
	JButton okButton = new JButton("OK");
	
	public MainWindow(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3,4));
		pane.add(enterX);
		pane.add(textX);
		pane.add(enterY);
		pane.add(textY);
		pane.add(resetButton);
		pane.add(okButton);
		resetButton.addActionListener(viewModel);
		okButton.addActionListener(viewModel);
		this.addWindowListener(new ProgramExitOnWindowClose());
	}
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow("MVC Pattern");
		mainWindow.setSize(250,100);
		mainWindow.setVisible(true);
		
	}
	
	private static final class ProgramExitOnWindowClose extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}
