package a03_event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyFirstWindowWithClosing extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyFirstWindowWithClosing(String title) {
		super(title);
		this.addWindowListener(new ProgramExitOnWindowClose());
	}
	
	private static final class ProgramExitOnWindowClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	}

	public static void main(String ... args) {
		MyFirstWindowWithClosing theWindow = new MyFirstWindowWithClosing("My first GUI");
		theWindow.setSize(400, 300);
		theWindow.setVisible(true);
		
		System.out.println("Exiting main ...");
	}
}
