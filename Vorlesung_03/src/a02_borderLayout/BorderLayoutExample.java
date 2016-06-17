package a02_borderLayout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample extends JFrame {

	private static final long serialVersionUID = 1L;

	public BorderLayoutExample(String title) {
		super(title);
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		pane.add(BorderLayout.NORTH, new JButton("North-Button"));
		pane.add(BorderLayout.SOUTH, new JButton("South-Button"));
		pane.add(BorderLayout.EAST, new JButton("East-Button"));
		pane.add(BorderLayout.WEST, new JButton("West-Button"));
		pane.add(BorderLayout.CENTER, new JButton("Center-Button"));
	}

	public static void main(String[] args) {
		BorderLayoutExample borderLayoutExample = 
			new BorderLayoutExample("BorderLayout Example");
		borderLayoutExample.setSize(400, 300);
		borderLayoutExample.pack();
		borderLayoutExample.setVisible(true);
	}
}