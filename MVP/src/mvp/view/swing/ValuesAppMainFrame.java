package mvp.view.swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import mvp.view.interfaces.ErrorDialogShower;

public class ValuesAppMainFrame implements ErrorDialogShower {

	private JFrame appFrame;
	private Container rootPane;
	
	private JLabel labelX;
	private JLabel labelY;
	
	private JTextField textInputX;
	private JTextField textInputY;
	
	private JButton okButton;
	private JButton resetButton;

	public ValuesAppMainFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				appFrame = new JFrame("MVP Pattern");
				appFrame.getContentPane().setLayout(new GridLayout(0, 3));
				
				rootPane = appFrame.getContentPane();
				
				labelX = new JLabel("Eingabe X");
				labelX.setHorizontalAlignment(JLabel.CENTER);
				textInputX =  new JTextField();
				labelY = new JLabel("Eingabe Y");
				labelY.setHorizontalAlignment(JLabel.CENTER);
				textInputY =  new JTextField();
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
				
				textInputX.getDocument().addDocumentListener(new IsInputANumberValidatorImpl(textInputX));
				textInputX.getDocument().addDocumentListener(new DependantElementsStateChanger(textInputY));
				textInputY.getDocument().addDocumentListener(new DependantElementsStateChanger(textInputX));
				textInputY.getDocument().addDocumentListener(new IsInputNumberEvenValidationImpl(textInputY));
				
				okButton.addActionListener(new OkButtonClickedListener(textInputX, textInputY, ValuesAppMainFrame.this));
				resetButton.addActionListener(new ResetButtonClickedListener(textInputX, textInputY));
				
				appFrame.addWindowListener(new ExitWindowListener());
			}
		});
	}

	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				appFrame.setSize(400, 100);
				appFrame.setVisible(true);
				
			}
		});
	}
	
	public void setValues(final String x, final String y) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				textInputX.setText(x);
				textInputY.setText(y);
				
			}
		});	
	}

	@Override
	public void showErrorDialogue(String msg) {
		JOptionPane.showMessageDialog(rootPane, msg);
	}
}