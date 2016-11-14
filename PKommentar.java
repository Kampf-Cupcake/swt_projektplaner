package swt_projektplaner;

import java.util.GregorianCalendar;
/**
 * Klasse zum Erstellen der Kommentare
 * @author Sarah Diekhaus, Mille
 */
public class PKommentar {
    
    private String text;
    private GregorianCalendar datum;        //In UML
    private int pkommentarNr;
    
    protected Projekt kommentar;
    protected Mitarbeiter verfasser;
    
    public PKommentar (String t, GregorianCalendar d, int pknr){
        this.text = t;
        this.datum = d;
        this.pkommentarNr = pknr;
    }
    
    public String toString(){
        return "Verfasst am "+datum+" von "+verfasser+ "\n"+text;   //In UML
    }
}
