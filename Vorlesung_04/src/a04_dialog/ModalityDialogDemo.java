package a04_dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ModalityDialogDemo {
	public static void main(String args[]) {
		JFrame f1 = new JFrame("Frame 1");
		JFrame f2 = new JFrame("Frame 2");
		f1.add(new JTextField());
		f2.add(new JTextField());
		f1.setSize(200, 100);
		f1.setVisible(true);
		f2.setSize(200, 100);
		f2.setVisible(true);
		JDialog d = new JDialog(); // nicht modal
		d.add(new JTextField());
		d.setSize(200, 100);
		d.setVisible(true);
		JDialog d1 = new JDialog(f1, "Dialog 1", true); // modal
		d1.add(new JTextField());
		d1.setSize(200, 100);
		d1.setVisible(true);
	}
}