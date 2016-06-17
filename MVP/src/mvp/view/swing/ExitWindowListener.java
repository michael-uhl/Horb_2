package mvp.view.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * Wenn jemand das Fenster schlie§t, soll
 * die Applikation beendet werden
 * ('System.exit(0)' wird aufgerufen)
 * 
 * @author Michael Uhl
 *
 */
public class ExitWindowListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
