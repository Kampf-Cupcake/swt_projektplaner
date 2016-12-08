package swt_projektplaner;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Klasse zum Erstellen einer Notiz im Projekt
 * @author Sarah Diekhaus
 */
public class Notiz {
    
    private String text;
    private GregorianCalendar datum;
    private int notizID;
    
    private Mitarbeiter mitarbeiter;
    
    public Notiz (String t, GregorianCalendar d){
        this.text = t;
        this.datum = d;
        this.notizID = -1;
    }
    
    public String toString(){       //UML
        return datum+":\n"+text;
    }
    
    public String getText(){
        return text;
    }
    public void setText(String t){
        this.text = t;
    }
    
    public GregorianCalendar getDatum() {
        return datum;
    }
    
    public void setDatum(GregorianCalendar d){
        this.datum = d;
    }
    
    public Mitarbeiter getMitarbeiter(){
        return this.mitarbeiter;
    }
    public void setMitarbeiter(Mitarbeiter m){
        this.mitarbeiter = m;
    }
    
    public int getNotitzID(){
        return this.notizID;
    }
    public void setNotizID(int id){
        this.notizID = id;
    }
    
    
    
}