package swt_projektplaner;

import java.util.GregorianCalendar;
/**
 * Klasse zur Vorwarnung von Projekten und Arbeitspakten
 * @author Sarah Diekhaus
 */
public class Vorwarnung {
    
    private GregorianCalendar datum;    //In UML
    private boolean gewarnt;
    private int vorwarnungID;
    
    private Projekt warnen;
    private Arbeitspaket erinnern; 
    private Mitarbeiter mitarbeiter;    // In UML    

    
    public Vorwarnung (GregorianCalendar d, boolean g){
        this.datum = d;
        this.gewarnt = g;
        this.vorwarnungID = -1;
    }
    
    public GregorianCalendar getDatum(){
        return datum;
    }
    public void setDatum(GregorianCalendar d){
        this.datum = d;
    }
    
    public boolean getGewarnt(){
        return gewarnt;
    }
    public void setGewarnt(boolean gw){
        this.gewarnt = gw;
    }
    
    public int getVorwarnungID(){
        return vorwarnungID;
    }
    public void setVorwarnungID(int id){
        this.vorwarnungID = id;
    }
    
    public Projekt getWarnen(){
        return this.warnen;
    }
    
    public Arbeitspaket getErinnern(){
        return this.erinnern;
    }
    
    public Mitarbeiter getMitarbeiter(){
        return this.mitarbeiter;
    }
    //public boolean vergleiche(Projekt w){
    //    warnen = w;
     //
       // if(datum.before(new GregorianCalendar()));
    //}
    
}
