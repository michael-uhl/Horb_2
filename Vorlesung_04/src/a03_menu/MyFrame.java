package a03_menu;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame {

	public MyFrame() { 
		JFrame mainFrame = new JFrame();
		JMenuBar menubar = new JMenuBar();
		mainFrame.setJMenuBar(menubar);
		JMenu menu1 = new JMenu("Menu1");
		JMenu menu2 = new JMenu("Menu2");
		menubar.add(menu1);
		menubar.add(menu2);
		
		ActionListener myMenuListener = new MyMenuListener();
		JMenuItem one = new JMenuItem("One");
		one.setActionCommand("One");
		one.addActionListener(myMenuListener);
		JMenuItem two = new JMenuItem("Two");
		two.setActionCommand("Two");
		two.addActionListener(myMenuListener);
		JMenuItem three = new JMenuItem("Three");
		three.setActionCommand("Three");
		three.addActionListener(myMenuListener);
		
		menu1.add(one);
		menu1.add(two);
		menu1.add(three);
		menu2.add(new JMenuItem("A"));
		menu2.add(new JMenuItem("B"));
		
		mainFrame.setSize(300, 200);
		mainFrame.setVisible(true);
	}
	
	public static void main(String [] args){
		new MyFrame();
	}
}
