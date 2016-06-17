package a05_jTable;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableDemo1 extends JFrame implements JTableDemo1Data {

	private static final long serialVersionUID = 1L;

	public JTableDemo1() {
		super("JTableDemo1");
		JTable table = new JTable(DATA, COLHEADS);
		Container cp = getContentPane();
		cp.add(new JLabel("Titelthemen Javamagazin:"), "North");
		cp.add(table);
		//cp.add(new JScrollPane(table), "Center");
	}

	public static void main(String[] args) {
		JTableDemo1 frame = new JTableDemo1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}