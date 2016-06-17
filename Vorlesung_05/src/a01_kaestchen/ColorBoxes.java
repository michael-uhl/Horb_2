package a01_kaestchen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ColorBoxes extends JFrame {

	public void paint(Graphics g) {
		int rval, gval, bval;
		for (int j = 30; j < (size().height - 25); j += 30)
			for (int i = 5; i < (size().width - 25); i += 30) {
				rval = (int) Math.floor(Math.random() * 256);
				gval = (int) Math.floor(Math.random() * 256);
				bval = (int) Math.floor(Math.random() * 256);
				g.setColor(new Color(rval, gval, bval));
				g.fillRect(i, j, 30, 30);
				g.setColor(Color.black);
				g.drawRect(i - 1, j - 1, 30, 30);
			}
	}
	
	public static void main(String ... args) {
		ColorBoxes cb = new ColorBoxes();
		cb.paint(cb.getGraphics());
		cb.setVisible(true);	
	}
}