package a01_lesbarkeit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OddEven {
	
	public boolean CheckValue(boolean myValue)
	{
	   boolean myErgebnis;
	
	   if(myValue == true)
	   {
	      myErgebnis = true;
	   }
	   else
	   {
	   
	   myErgebnis = false;
	}
	return myErgebnis;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		System.out.print("Eingabe einer Zahl: ");
		int eingabe = scanner.nextInt();
	
		try {
			if (eingabe % 2 == 0) {
				throw new ZahlGerade();
			} else {
				throw new ZahlUngerade();
			}
		} catch (ZahlGerade zg) {
			System.out.println("Zahl ist gerade");
		} catch (ZahlUngerade zu) {
			System.out.println("Zahl ist ungerade");
		} catch (InputMismatchException e) {
			System.out.println("Eingabe war wohl falsch.");
		}
	}
}
