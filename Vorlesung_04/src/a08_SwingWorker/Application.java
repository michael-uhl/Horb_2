package a08_SwingWorker;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Application extends JFrame {

	// The UI Components
	private JLabel label;
	private JProgressBar progressBar;
	private JTextArea textArea;

	private void initComponents() {
		// The interface will update the text of the UI components
		Informable informable = new Informable() {
			@Override
			public void messageChanged(String message) {
				label.setText(message);
				textArea.append(message + "\n");
			}
		};

		// The UI components
		label = new JLabel("");
		add(label, BorderLayout.NORTH);

		textArea = new JTextArea(5, 30);
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		add(progressBar, BorderLayout.SOUTH);

		// The worker parameters
		String word = "License";
		File[] documents = { new File("textfile.txt"), new File("big.file")};

		// The worker
		SearchForWordWorker worker = new SearchForWordWorker(word, documents, informable) {
			// This method is invoked when the worker is finished
			// its task
			@Override
			protected void done() {
				try {
					// Get the number of matches. Note that the
					// method get will throw any exception thrown
					// during the execution of the worker.
					int matches = get();
					label.setText("Found: " + matches);

					textArea.append("Done\n");
					textArea.append("Matches Found: " + matches + "\n");

					progressBar.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(Application.this, "Error",
							"Search", JOptionPane.ERROR_MESSAGE);
				}
			}
		};

		// A property listener used to update the progress bar
		PropertyChangeListener listener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if ("progress".equals(event.getPropertyName())) {
					progressBar.setValue((Integer) event.getNewValue());
				}
			}
		};
		worker.addPropertyChangeListener(listener);

		// Start the worker. Note that control is
		// returned immediately
		worker.execute();
	}

	// The main method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application();
				app.initComponents();
				app.setDefaultCloseOperation(EXIT_ON_CLOSE);
				app.pack();
				app.setVisible(true);
			}
		});
	}
}