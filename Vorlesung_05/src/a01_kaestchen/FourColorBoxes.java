package a01_kaestchen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class FourColorBoxes extends JFrame {
	
	private Map<Integer, Color> colours = new HashMap<Integer, Color>();
	
	public FourColorBoxes() {
		for (int i = 0; i < 3; i++) {
			colours.put(0, Color.RED);
			colours.put(1, Color.BLUE);
			colours.put(2, Color.YELLOW);
			colours.put(3, Color.LIGHT_GRAY);
		}
	}
	
	public void paint(Graphics g) {
		for (int j = 30; j < (size().height - 25); j += 30)
			for (int i = 5; i < (size().width - 25); i += 30) {
				Color cur = colours.get((int)(Math.random() * 4));
				g.setColor(cur);
				g.fillRect(i, j, 30, 30);
				g.setColor(Color.black);
				g.drawRect(i - 1, j - 1, 30, 30);
			}
	}
	
	public static void main(String ... args) {
		FourColorBoxes cb = new FourColorBoxes();
		cb.paint(cb.getGraphics());
		cb.setVisible(true);	
	}
}
