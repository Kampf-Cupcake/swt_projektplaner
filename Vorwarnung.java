package swt_projektplaner;

import java.util.GregorianCalendar;
/**
 * Klasse zur Vorwarnung von Projekten und Arbeitspakten
 * @author Sarah Diekhaus
 */
public class Vorwarnung {
    
    private GregorianCalendar datum;    //In UML
    private boolean gewarnt;
    
    private Projekt warnen;
    private Arbeitspaket erinnern; 
    private Mitarbeiter mitarbeiter;    // In UML    
    private int vorwarnungID;
    
    public Vorwarnung (GregorianCalendar d, boolean g, int id){
        this.datum = d;
        this.gewarnt = g;
        this.vorwarnungID = id;
    }
    
    //public boolean vergleiche(Projekt w){
    //    warnen = w;
     //
       // if(datum.before(new GregorianCalendar()));
    //}
    
}
