import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Control implements ActionListener, KeyListener {

	public View ansicht;
	public Model model; 
	

	public Control() {

		ansicht = new View();
		ansicht.zeigefenster();
		
		model = new Model(); 
		

		addListener();
		enableview();

	}

	public void addListener() {
		final String okk = "akldjfadklfjasd";
		
		ansicht.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ansicht.ok.setEnabled(false);
				ansicht.ok.setText(okk);
			}
		});
		
		
		
		ansicht.reset.addActionListener(this);
		ansicht.tfx.addKeyListener(this);
		ansicht.tfy.addKeyListener(this);
	}

	public void enableview() {
		ansicht.ok.setEnabled(true);
		ansicht.reset.setEnabled(true);
		ansicht.tfx.setEnabled(true);
		ansicht.tfy.setEnabled(true);

	}

	public void cleartf() {
		ansicht.tfx.setText("");
		ansicht.tfy.setText("");

		System.out.println("Textfelder reset");

	}

	public void checkeingabe() {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("pressed");

	}

	@Override
	public void keyReleased(KeyEvent eventtf) {
		// TODO Auto-generated method stub
        System.out.println("released" + ansicht.tfy.getText());
       
        //prüft auf Eingabe auf Zahl
        int xy = (int) eventtf.getKeyChar();
		System.out.println(xy);

		if (((xy < 48 == true | xy > 57 == true )) & ( xy != 8 | xy!= 27)) {
			cleartf();
			ansicht.fehlermeldungallg("Bitte geben Sie eine Zahl ein");

		}
		
		
		// prüft und sperrt felder
		if (ansicht.tfx.getText().equals("") == false) {
			ansicht.tfy.setEditable(false);
			
		}
		if(ansicht.tfy.getText().equals("") == false) { 
			ansicht.tfx.setEditable(false);
			
		}
		
		if(ansicht.tfx.getText().equals("") == true & ansicht.tfy.getText().equals("") == true) {
			ansicht.tfx.setEditable(true);
			ansicht.tfy.setEditable(true);
		}
		
		
        
	}

	@Override
	public void keyTyped(KeyEvent eventtf) {
		// Fallunterscheidung Key Typed
		Object textfeld = eventtf.getSource();

		if (textfeld == ansicht.tfx) {
			System.out.println("Eingabe in Textfeld x");

		}

		if (textfeld == ansicht.tfy) {
			System.out.println("Eingabe in Textfeld y");
			System.out.println(ansicht.tfy.getText());

			String zahlx = ansicht.tfy.getText();
			zahlx = zahlx + eventtf.getKeyChar();
			System.out.println("zahlx " + zahlx);
			int zahlxx = Integer.parseInt(zahlx);

			if (zahlxx % 2 == 1) {
				System.out.println("bitte geben Sie eine gerade Zahl ein");
				ansicht.fehlermeldungallg("Bitte geben Sie eine gerade Zahl ein");
			}

		}

		/*int xy = (int) eventtf.getKeyChar();
		System.out.println(xy);

		if (((xy < 48 == true | xy > 57 == true )) & ( xy != 8 | xy!= 27)) {
			cleartf();
			ansicht.fehlermeldungallg("Bitte geben Sie eine Zahl ein");

		}*/
System.out.println("typed");
	}

	@Override
	public void actionPerformed(ActionEvent eventx) {
		// Fallunterscheidung Schalter:
		String schalter;
		schalter = eventx.getActionCommand();

		if (schalter.equals(ansicht.ok.getText())) {
			System.out.println("ok gedrückt");
			if (ansicht.tfx.getText().equals("")
					& ansicht.tfx.getText().equals("")) {
				ansicht.fehlermeldungallg("Bitte machen Sie eine Eingabe");
			}
			
			if (ansicht.tfx.getText().equals("") == false & ansicht.tfy.getText().equals("") == true) {
				int eingabe = Integer.parseInt(ansicht.tfx.getText());
				int ergebnis = model.malnehmen(eingabe);
				ansicht.tfy.setText(Integer.toString(ergebnis));
				System.out.println(ergebnis);
				
			}
			if (ansicht.tfx.getText().equals("") == true & ansicht.tfy.getText().equals("") == false) {
				int eingabe = Integer.parseInt(ansicht.tfy.getText()); 
				int ergebnis = model.teilen(eingabe); 
				ansicht.tfx.setText(Integer.toString(ergebnis));
				System.out.println(ergebnis);
			}
			
			
			

		}

		if (schalter.equals(ansicht.reset.getText()) == true) {
			System.out.println("reset gedrückt");
			cleartf();
			enableview();

		}

	}
	
	private static class GGG implements ActionListener {
		
		private View ansicht;
		
		public GGG(View ansicht) {
			this.ansicht = ansicht;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			ansicht.ok.setEnabled(false);
			
		}
		
	}

}
