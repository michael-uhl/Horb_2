package a06_tableModel;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class JTableDemo2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3764260924257473648L;

	JTableDemo2Data tableModel;

	public JTableDemo2() {
		super("JTableDemo2");
		tableModel = new JTableDemo2Data(10000);
		JTable table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		Container cp = getContentPane();
		cp.add(new JScrollPane(table), "Center");
		JButton button = new JButton("Ausgabe");
		button.addActionListener(this);
		cp.add(button, "South");
	}

	public void actionPerformed(ActionEvent event) {
		tableModel.printData();
	}

	public static void main(String[] args) {
		JTableDemo2 frame = new JTableDemo2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(320, 200);
		frame.setVisible(true);
	}
}
