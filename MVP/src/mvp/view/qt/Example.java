package mvp.view.qt;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QPushButton;

public class Example {
	
	private static final Logger LOG = null;
	
    public  void main(String args[]) throws Exception{
        QApplication.initialize(args);
 
        QPushButton hello = new QPushButton("Hello World!");
        hello.show();
 
        QApplication.exec();
        int j;
        
        int cardGame_deckSize= 52;
        
        
        for (int i = 1; i < 52; i++)
        {
          j = i + randomInt(53 - i) - 1;
          swapEntries(i, j);
        }
        
        
        
        for (int i = 1; i <= cardGame_deckSize; i++)
        {
          j = i + randomInt(cardGame_deckSize + 1 - i) - 1;
          swapEntries(i, j);
          
           Integer[] arr = Collections.nCopies(81, 1).toArray(new Integer[81]);
        }
        
        boolean isHarmful = true;
        
        if (isHarmful) {
        	// ...
        	if (!isHarmful) {
        		
        	}
        }
        
        try {
			method();
		} catch (FileNotFoundException e) {
			LOG.error("File was not found.");
		}
        
        try {
			method();
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage());
		}
        
        try {
			method();
		} catch (FileNotFoundException e) {
			LOG.error("File was not found.", e);
		}       
        
        
    }
    
    public static boolean isValidDate(final String stringDateValue) {
        String exp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        boolean isValid = false;
        try {
            if (Pattern.matches(exp, stringDateValue)) {
                String[] dateArray = stringDateValue.split("/");
                if (dateArray.length == 3) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    int year = new Integer(dateArray[2]).intValue();
                    int month = new Integer(dateArray[1]).intValue();
                    int day = new Integer(dateArray[0]).intValue();

                    gregorianCalendar = new GregorianCalendar(year, month - 1, day);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.get(GregorianCalendar.YEAR);
                    gregorianCalendar.get(GregorianCalendar.MONTH);
                    gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
                    isValid = true;
                }
            }
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }   
    
    public void method() throws FileNotFoundException {
    	throw new FileNotFoundException();
    }
    
    public static int randomInt(int i) {
    	return 0;
    }
    
    public static void swapEntries(int i, int j) {}
    
    public static final class MyException extends RuntimeException
    {

		public MyException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
    	
    }
}
