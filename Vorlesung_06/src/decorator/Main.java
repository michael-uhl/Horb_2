package decorator;

import decorator.beilagen.Nudeln;
import decorator.beilagen.Salat;
import decorator.beilagen.Suppe;
import decorator.gerichte.Hueftsteak;

public class Main {
    public static void main(String[] args) { 
        Gericht gericht = new Salat(new Nudeln(new Hueftsteak())); 
        gericht.druckeBeschreibung(); 
        //H�ftsteak, Nudeln, Salat 
        System.out.println(" f�r "+gericht.getPreis() + " Euro"); 
        // f�r 19.75 Euro 

        gericht = new Suppe(gericht); 
        gericht.druckeBeschreibung(); 
        //H�ftsteak, Nudeln, Salat, Suppe 
        System.out.println(" f�r "+gericht.getPreis() + " Euro"); 
        // f�r 21.25 Euro 
    } 
}
