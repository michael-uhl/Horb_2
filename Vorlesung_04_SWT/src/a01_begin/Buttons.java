package a01_begin;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Buttons {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Hello World");
		shell.setSize(250, 100);
		shell.setLayout(new GridLayout(2, true));

		new Button(shell, SWT.PUSH | SWT.FLAT).setText("Flat Push Button");
		new Button(shell, SWT.CHECK).setText("Check Button");
		new Button(shell, SWT.TOGGLE).setText("Toggle Button");
		new Button(shell, SWT.RADIO).setText("Radio Button");	

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
