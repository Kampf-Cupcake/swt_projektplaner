package swt_projektplaner;

import java.util.Date;

/**
 * Klasse zum Erstellen einer Notiz im Projekt
 * @author Sarah Diekhaus
 */
public class Notiz {
    
    private String text;
    private Date datum;
    private int notizID;
    
    protected Mitarbeiter notiz;
    
    public Notiz (String t, Date d, int id){
        this.text = t;
        this.datum = d;
        this.notizID = id;
    }
    
    public String toString(){       //UML
        return datum+":\n"+text;
    }
    
}