package swt_projektplaner;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Jan Beuster
 */
public class ArbeitspaketVerwaltung {
    
    protected List<Arbeitspaket> arbeitspakete;
    protected Datenbank datenbank;
    
     public ArbeitspaketVerwaltung(){
         datenbank = new Datenbank();
         arbeitspakete = new LinkedList<>();
        try {
            datenbank.init();
        } catch (Exception e) {
            System.err.println("Fehler beim Datenbankzugriff: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void anlegeArbeitspaket(String name, boolean fertig, String beschreibung, int tag, int monat, int jahr){    //'int name' zu 'String name' geändert
        System.out.println(name);
        System.out.println(beschreibung);
        System.out.println("Status des Paketes "+ fertig);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat-1, tag);
        
        //Date datum =  new Date(greg.getGregorianChange().getTime());
        Arbeitspaket arbeitspaket = new Arbeitspaket(name, fertig, beschreibung, greg);
        
        try{
            datenbank.speicherArbeitspaket(arbeitspaket);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
       // arbeitspakete.add(arbeitspaket);
    }
    
    public void verwaltenArbeitspaket(){
        
    }
    
    public void eintragenDeadline(){
        
    }
    
  
    
    
    public List<Arbeitspaket> getArbeitspaket(){
        return this.arbeitspakete;
    }
}
