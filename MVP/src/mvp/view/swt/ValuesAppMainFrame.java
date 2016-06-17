package mvp.view.swt;

import mvp.view.interfaces.ErrorDialogShower;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ValuesAppMainFrame implements ErrorDialogShower {
	
	private Text textFieldX;
	private Text textFieldY;
	
	private Display display;
	private Shell shell;

	public ValuesAppMainFrame() {
		display = new Display();
		shell = new Shell(display);
		
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				shell.setText("MVP Pattern");
				shell.setSize(220, 120);
				
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 3;
				shell.setLayout(gridLayout);	

				Label labelX = new Label(shell, SWT.BORDER);
				labelX.setText("Eingabe X");
				
				textFieldX = new Text(shell, SWT.SINGLE);
				
				new Label (shell,SWT.NONE); 
				
				Label labelY = new Label(shell, SWT.BORDER);
				labelY.setText("Eingabe Y");		
				
				textFieldY = new Text(shell, SWT.SINGLE);
				
				new Label (shell,SWT.NONE); 
				new Label (shell,SWT.NONE); 
				new Label (shell,SWT.NONE); 
				new Label (shell,SWT.NONE); 
				new Label (shell,SWT.NONE); 
				
				Button resetButton = new Button(shell, SWT.PUSH);
				resetButton.setText("Reset");
				
				Button okButton = new Button(shell, SWT.PUSH);
				okButton.setText("OK");
				
				textFieldX.addModifyListener(new DependantElementsStateChanger(textFieldY));
				textFieldY.addModifyListener(new DependantElementsStateChanger(textFieldX));
				textFieldX.addModifyListener(new IsInputANumberValidatorImpl(textFieldX));
				textFieldY.addModifyListener(new IsInputNumberEvenValidatorImpl(textFieldY));
				okButton.addSelectionListener(new OkButtonClickedListener(textFieldX, textFieldY, ValuesAppMainFrame.this));
				resetButton.addSelectionListener(new ResetButtonClickedListener(textFieldX, textFieldY));
			}
		});
	}
	
	public void start() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				shell.open();

			}
		});
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
	
	@Override
	public void showErrorDialogue(String msg) {
		MessageBox messageBox = new MessageBox(Display.getCurrent()
				.getActiveShell(), SWT.ICON_WARNING | SWT.OK);

		messageBox.setText("Warning");
		messageBox.setMessage(msg);
		messageBox.open();
	}

	public void setValues(final String x, final String y) {
		Display.getDefault().asyncExec(new Runnable() {
		    public void run() {
				textFieldX.setText(x);
				textFieldY.setText(y);
		    }
		});	
	}
}