import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class View {

	JButton reset;
	JButton ok;
	JTextField tfx;
	JTextField tfy;

	public void zeigefenster() {

		// Konfiguration der fenster und erstellen der elemente

		System.out.println("zeige Fenster");
		JFrame hauptfenster = new JFrame();
		JPanel mainpanel = new JPanel();

		hauptfenster.add(mainpanel);
		hauptfenster.setSize(300, 200);
		hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		reset = new JButton();
		ok = new JButton();

		reset.setText("Reset");
		ok.setText("ok");

		JLabel eingabex = new JLabel();
		JLabel eingabey = new JLabel();

		tfx = new JTextField();
		tfy = new JTextField();

		eingabex.setText("Eingabe x");
		eingabey.setText("Eingabe y");

		mainpanel.setLayout(new BorderLayout());

		JPanel suedpanel = new JPanel();
		JPanel centerpanel = new JPanel();

		suedpanel.setLayout(new GridLayout(1, 2));
		centerpanel.setLayout(new GridLayout(2, 2));

		centerpanel.add(eingabex);
		centerpanel.add(tfx);
		centerpanel.add(eingabey);
		centerpanel.add(tfy);

		mainpanel.add(BorderLayout.CENTER, centerpanel);
		mainpanel.add(BorderLayout.SOUTH, suedpanel);

		suedpanel.add(reset);
		suedpanel.add(ok);

		hauptfenster.setTitle("MVC Pattern");

		hauptfenster.setVisible(true);

	}

	public void fehlermeldungzahl() {
		JDialog fehlerm = new JDialog();
		fehlerm.setTitle("Bitte geben Sie eine zahl ein");
		fehlerm.setSize(400, 200);
		fehlerm.setVisible(true);
		System.out.println("anzeige Dialog");

	}

	public void fehlermeldungungeradezahl() {
		JDialog fehlerm = new JDialog();
		fehlerm.setTitle("Bitte geben Sie eine Gerade Zahl ein");
		fehlerm.setSize(400, 200);
		fehlerm.setVisible(true);

	}

	public void fehlermeldungallg(String fehler) {
		JDialog fehlerm = new JDialog();
		fehlerm.setTitle("Fehler");
		JLabel x = new JLabel();
		x.setText(fehler);
		fehlerm.add(x);
		fehlerm.setSize(400, 200);
		fehlerm.setVisible(true);
	}

}
