package a04_eventListenerFrameParam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PrintMessageButtonListener implements ActionListener {
	private MyFirstWindowWithViewUpdate appFrame;
	
	public PrintMessageButtonListener(MyFirstWindowWithViewUpdate appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		appFrame.getLabel().setText("Change Text Button was clicked.");
//		appFrame.dispose();
	}
}