import java.util.GregorianCalendar;
/**
 * Klasse zur Vorwarnung von Projekten und Arbeitspakten
 * @author Sarah Diekhaus
 */
public class Vorwarnung {
    
    private GregorianCalendar datum;    //In UML-geändert EM
    private boolean gewarnt;
    
    private Projekt warnen;
    private Arbeitspaket erinnern; 
    private Mitarbeiter mitarbeiter;    // In UML-geändert EM    
    
    public Vorwarnung (GregorianCalendar d, boolean g){
        this.datum = d;
        this.gewarnt = g;
    }
    
    public boolean vergleiche(Projekt w){
        warnen = w;
        if(warnen.getDeadline().equals(datum));
        return true;//Rest in GUI;
    }

}
