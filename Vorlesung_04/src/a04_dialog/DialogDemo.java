package a04_dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class DialogDemo {
	
	  public static void main(String[] argv) {
		     JFrame frame = new JFrame("Test");
		     frame.setSize(100, 200);
		  
		     JMenuBar menuBar = new JMenuBar();
		     menuBar.add(new JMenu("JFrame")).
		        add(new JMenuItem("Beenden"));
		     frame.setJMenuBar(menuBar);
		  
		     JDialog dialog = new JDialog(frame, "Tites des Dialogs", true);
		     menuBar = new JMenuBar();
		     menuBar.add(new JMenu("Datei")).
		        add(new JMenuItem("Beenden"));
		     dialog.setJMenuBar(menuBar);
		     dialog.setSize(100,200);
		     dialog.setDefaultCloseOperation(
		                 WindowConstants.DISPOSE_ON_CLOSE);
		     
		     frame.setVisible(true);
		     dialog.setVisible(true);
		   
		   
		     // Hier wird erst weitergemacht, wenn der
		     // Dialog geschlossen wurde (aufgrund der
		     // Modalität
		     System.out.println("Dialog closed");
		  }
}
