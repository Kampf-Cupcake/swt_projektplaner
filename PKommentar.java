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
    
    public PKommentar (String t, GregorianCalendar d){
        this.text = t;
        this.datum = d;
        this.pkommentarNr = -1;
    }
    
    public String toString(){
        return "Verfasst am "+datum+" von "+verfasser+ "\n"+text;   //In UML
    }
    
    public String getText(){
        return text;
    }
    public void setText(String t){
        this.text = t;
    }
    
    public GregorianCalendar getDatum(){
        return datum;
    }
    public void setDatum(GregorianCalendar date){
        this.datum = date;
    }
    
    public int getID(){
        return pkommentarNr;
    }
    public void setID(int id){
        this.pkommentarNr = id;
    }
    
    public Projekt getKomemntar(){
        return this.kommentar;
    }
    
    public Mitarbeiter getVerfasser(){
        return this.verfasser;
    }
}
