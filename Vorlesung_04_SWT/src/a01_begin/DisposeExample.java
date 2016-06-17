package a01_begin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class DisposeExample {
	static int pageNum = 0;

	static Composite pageComposite;

	public static void main(String args[]) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Push");
		pageComposite = new Composite(shell, SWT.NONE);
		pageComposite.setLayout(new GridLayout());
		pageComposite.setLayoutData(new GridData());

		button.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if ((pageComposite != null) && (!pageComposite.isDisposed())) {
					pageComposite.dispose();
				}
				pageComposite = new Composite(shell, SWT.NONE);
				pageComposite.setLayout(new GridLayout());
				pageComposite.setLayoutData(new GridData());
				if (pageNum++ % 2 == 0) {
					Table table = new Table(pageComposite, SWT.BORDER);
					table.setLayoutData(new GridData());
					for (int i = 0; i < 5; i++) {
						new TableItem(table, SWT.NONE).setText("table item "
								+ i);
					}
				} else {
					new Button(pageComposite, SWT.RADIO).setText("radio");
				}
				shell.layout(true);
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
