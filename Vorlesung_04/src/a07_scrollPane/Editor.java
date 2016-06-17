package a07_scrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Editor extends JFrame {
	protected JPanel contentPane;
	protected JScrollPane scrollPane = new JScrollPane();
	protected JToolBar toolBar = new JToolBar();
	protected JButton butne = new JButton("Neu"),
			butof = new JButton("Oeffnen"), butsp = new JButton("Speichern"),
			butsu = new JButton("Sp. unter"), buthl = new JButton("Hilfe"),
			butex = new JButton("Beenden");
	protected JTextArea textFeld = new JTextArea();
	protected JLabel meldungen = new JLabel("");
	protected JFileChooser fileChooser = new JFileChooser(
			System.getProperty("user.dir"));
	protected String dateiName = null, hilfeDatei = "Hilfe.html";
	protected boolean dirty = false;
	protected Document document;
	protected static final int b = 800, h = 600, bb = 110, bh = 25, x = 100,
			y = 100;

	public Editor() {
		contentPane = (JPanel) this.getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.add(butne);
		toolBar.add(butof);
		toolBar.add(butsp);
		toolBar.add(butsu);
		toolBar.add(buthl);
		toolBar.add(butex);
		butne.setMaximumSize(new Dimension(bb, bh));
		butne.setMinimumSize(new Dimension(bb, bh));
		butof.setMaximumSize(new Dimension(bb, bh));
		butof.setMinimumSize(new Dimension(bb, bh));
		butsp.setMaximumSize(new Dimension(bb + 5, bh));
		butsp.setMinimumSize(new Dimension(bb, bh));
		butsu.setMaximumSize(new Dimension(bb, bh));
		butsu.setMinimumSize(new Dimension(bb, bh));
		buthl.setMaximumSize(new Dimension(bb, bh));
		buthl.setMinimumSize(new Dimension(bb, bh));
		butex.setMaximumSize(new Dimension(bb, bh));
		butex.setMinimumSize(new Dimension(bb, bh));
		butne.addActionListener(new NeuMenu());
		butof.addActionListener(new OeffMenu());
		butsp.addActionListener(new SichMenu());
		butsu.addActionListener(new SichUntMenu());
		buthl.addActionListener(new Helfen());
		butex.addActionListener(new BeendMenu());
		contentPane.add(meldungen, BorderLayout.SOUTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.getViewport().add(textFeld, null);
		textFeld.setBackground(Color.white);
		textFeld.setFont(new Font("Courier", 0, 14));
		document = textFeld.getDocument();
		document.addDocumentListener(new MyDocument());
		setTitle(" Text-Editor");
		meldungen.setText("neues Dokument");
		setLocation(x, y);
		setSize(b, h);
		setVisible(true);
	}

	protected void newDocument() {
		if (okToAbandon()) {
			textFeld.setText("");
			dateiName = null;
			dirty = false;
			updateCaption();
			textFeld.requestFocus();
		}
	}

	protected void fileOpen() {
		if (!okToAbandon())
			return;
		fileChooser.setDialogTitle("Datei Öffnen");
		fileChooser.setApproveButtonText("Öffnen");
		if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
			openFile(fileChooser.getSelectedFile().getPath());
		}
		repaint();
	}

	protected void openFile(String fileName) {
		try {
			File file = new File(fileName);
			int size = (int) file.length();
			int chars_read = 0;
			FileReader in = new FileReader(file);
			char[] data = new char[size];
			while (in.ready()) {
				chars_read += in.read(data, chars_read, size - chars_read);
			}
			in.close();
			textFeld.setText(new String(data, 0, chars_read));
			this.dateiName = fileName;
			dirty = false;
			updateCaption();
		} catch (IOException e) {
			meldungen.setText(" Fehler beim Oeffnen von " + fileName);
		}
	}

	protected boolean saveFile() {
		if (dateiName == null) {
			return saveAsFile();
		}
		try {
			File file = new File(dateiName);
			FileWriter out = new FileWriter(file);
			String text = textFeld.getText();
			out.write(text);
			out.close();
			dirty = false;
			updateCaption();
			return true;
		} catch (IOException e) {
			meldungen.setText(" Fehler beim Speichern von " + dateiName);
		}
		return false;
	}

	protected boolean saveAsFile() {
		this.repaint();
		fileChooser.setDialogTitle("Datei speichern unter");
		fileChooser.setApproveButtonText("Speichern");
		if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(this)) {
			dateiName = fileChooser.getSelectedFile().getPath();
			repaint();
			return saveFile();
		} else {
			repaint();
			return false;
		}
	}

	protected boolean okToAbandon() {
		if (!dirty)
			return true;
		int value = JOptionPane.showConfirmDialog(this, "Änderungen sichern?",
				"Editor", JOptionPane.YES_NO_CANCEL_OPTION);
		switch (value) {
		case JOptionPane.YES_OPTION:
			return saveFile();
		case JOptionPane.NO_OPTION:
			return true;
		case JOptionPane.CANCEL_OPTION:
		default:
			return false;
		}
	}

	protected void updateCaption() {
		String caption;
		if (dateiName == null) {
			caption = "neues Dokument";
		} else {
			caption = dateiName;
		}
		if (dirty) {
			caption = "* " + caption;
		}
		meldungen.setText(caption);
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			if (okToAbandon())
				System.exit(0);
		}
	}

	protected class NeuMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newDocument();
		}
	}

	protected class OeffMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileOpen();
		}
	}

	protected class SichMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saveFile();
		}
	}

	protected class SichUntMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saveAsFile();
		}
	}

	protected class Hilfe {
		private String hilfeDatei;

		public Hilfe(String hilfeDatei) {
			this.hilfeDatei = hilfeDatei;
		}

	}

	protected class MyDocument implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			if (!dirty) {
				dirty = true;
				updateCaption();
			}
		}

		public void insertUpdate(DocumentEvent e) {
			if (!dirty) {
				dirty = true;
				updateCaption();
			}
		}

		public void removeUpdate(DocumentEvent e) {
			if (!dirty) {
				dirty = true;
				updateCaption();
			}
		}
	}

	private class Helfen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Hilfe(hilfeDatei);
		}
	}

	protected class BeendMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (okToAbandon())
				System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Editor();
	}
}
