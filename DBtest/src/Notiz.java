import java.util.Date;

/**
 * Klasse zum Erstellen einer Notiz im Projekt
 * @author Sarah Diekhaus
 */
public class Notiz {
    
    private String text;
    private Date datum;
    
    protected Mitarbeiter notiz;
    
    public Notiz (String t, Date d){
        this.text = t;
        this.datum = d;
    }
    
    public String toString(){       //UML
        return datum+":\n"+text;
    }
    
}