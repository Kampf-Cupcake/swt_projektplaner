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
    
    protected Mitarbeiter notiz;
    
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
    
    public GregorianCalendar getDatum() {
        return datum;
    }
    
    public Mitarbeiter getNotiz(){
        return this.notiz;
    }
    
    
    
}