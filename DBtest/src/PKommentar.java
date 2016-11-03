import java.util.GregorianCalendar;
/**
 * Klasse zum Erstellen der Kommentare
 * @author Sarah Diekhaus, Mille
 */
public class PKommentar {
    
    private String text;
    private GregorianCalendar datum;        //In UML-eingetragen EM
    
    protected Projekt kommentar;
    protected Mitarbeiter verfasser;
    
    public PKommentar (String t, GregorianCalendar d){
        this.text = t;
        this.datum = d;
    }
    
    public String toString(){
        return "Verfasst am "+datum+" von "+verfasser+ "\n"+text;   //In UML-eingetragen EM
    }
}
