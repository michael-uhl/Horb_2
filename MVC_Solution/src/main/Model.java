package main;

import javax.swing.JOptionPane;

public class Model {

	public void Reset(MainWindow mainView) {
		mainView.textX.setText("");
		mainView.textY.setText("");
		mainView.textX.setEnabled(true);
		mainView.textY.setEnabled(true);
		mainView.okButton.setEnabled(true);
		mainView.resetButton.setEnabled(true);
	}

	public void OkAction(MainWindow mainView){
		String enteredX = mainView.textX.getText();
		String enteredY = mainView.textY.getText();
		if(enteredX.isEmpty() && enteredY.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bitte machen Sie eine Eingabe!");
			mainView.okButton.setEnabled(false);
		}
		else if((!isInteger(enteredX) && !enteredX.isEmpty() && mainView.textX.isEnabled())||(!isInteger(enteredY))&& !enteredY.isEmpty()&&mainView.textY.isEnabled() ){
			JOptionPane.showMessageDialog(null, "Bitte geben sie eine Zahl ein!");
		}
		else if(isInteger(enteredY) && (Integer.parseInt(enteredY)%2!=0)){
			JOptionPane.showMessageDialog(null, "Bitte geben sie eine gerade Zahl ein!");
		}
		else if(!enteredX.isEmpty()&&enteredY.isEmpty()|| !mainView.textY.isEnabled()){
			int t = Integer.parseInt(enteredX)*2;
			mainView.textY.setText(String.valueOf(t));
			mainView.textY.setEnabled(false);;
		}
		else if(enteredX.isEmpty()&&!enteredY.isEmpty() || !mainView.textX.isEnabled()){
			double t = 2/Double.parseDouble(enteredY);
			mainView.textX.setText(String.valueOf(t));
			mainView.textX.setEnabled(false);
		}
	}
	
	public static boolean isInteger(String s) {
	    return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
}
