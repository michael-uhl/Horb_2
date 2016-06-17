package mvc.view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvc.model.interfaces.ValueChangedEvent;
import mvc.model.interfaces.ValueChangedListener;
import mvc.model.interfaces.ValueModelInterfaceFactory;
import mvc.view.interfaces.ErrorDialogShower;

public class ValuesAppMainFrame implements ValueChangedListener, ErrorDialogShower {

	private JFrame appFrame;
	private Container rootPane;
	
	private JLabel labelX;
	private JLabel labelY;
	
	private JTextField textInputX;
	private JTextField textInputY;
	
	private JButton okButton;
	private JButton resetButton;

	public ValuesAppMainFrame() {
		appFrame = new JFrame("MVC Pattern");
		rootPane = appFrame.getContentPane();
		
		labelX = new JLabel("Eingabe X");
		labelX.setHorizontalAlignment(JLabel.CENTER);
		textInputX =  new JTextField();
		labelY = new JLabel("Eingabe Y");
		labelY.setHorizontalAlignment(JLabel.CENTER);
		textInputY =  new JTextField();
		appFrame.getContentPane().setLayout(new GridLayout(0, 3));
		okButton = new JButton("OK");
		resetButton = new JButton("Reset");
		
		rootPane.add(labelX);
		rootPane.add(textInputX);
		rootPane.add(new JPanel());
		rootPane.add(labelY);
		rootPane.add(textInputY);
		rootPane.add(new JPanel());
		rootPane.add(new JPanel());
		rootPane.add(new JPanel());
		rootPane.add(new JPanel());
		rootPane.add(new JPanel());
		rootPane.add(resetButton);
		rootPane.add(okButton);
		
		textInputX.getDocument().addDocumentListener(new IsInputANumberValidation(textInputX));
		textInputX.getDocument().addDocumentListener(new DependantElementsStateChanger(textInputY));
		textInputY.getDocument().addDocumentListener(new DependantElementsStateChanger(textInputX));
		textInputY.getDocument().addDocumentListener(new IsInputNumberEvenValidation(textInputY));
		
		okButton.addActionListener(new OkButtonClickedListener(textInputX, textInputY, this));
		resetButton.addActionListener(new ResetInputListener(textInputX, textInputY));
		
		appFrame.addWindowListener(new ExitWindowListener());
		
		appFrame.setSize(400, 100);
		appFrame.setVisible(true);
		
		ValueModelInterfaceFactory.getValueChangedProvider().addValueChangedListener(this);
	}

	@Override
	public void valueChanged(ValueChangedEvent evt) {
		textInputX.setText("" + evt.getX());
		textInputY.setText("" + evt.getY());
	}

	@Override
	public void showErrorDialogue(String msg) {
		JOptionPane.showMessageDialog(rootPane, msg);
	}
}