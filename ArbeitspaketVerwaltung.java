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
    
    private Datenbank datenbank;
    
     public ArbeitspaketVerwaltung(){
         datenbank = MainFrame.db;
        
    }
    
    public void anlegeArbeitspaket(String name, boolean fertig, String beschreibung, int tag, int monat, int jahr, Projekt projekt){    
        System.out.println(name);
        System.out.println(beschreibung);
        System.out.println("Status des Paketes "+ fertig);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat-1, tag);
        
        //Date datum =  new Date(greg.getGregorianChange().getTime());
        Arbeitspaket arbeitspaket = new Arbeitspaket(name, fertig, beschreibung, greg, projekt);
        
        try{
            datenbank.speicherArbeitspaket(arbeitspaket);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
       // arbeitspakete.add(arbeitspaket);
    }
    
    public void verwaltenArbeitspaket(){
        
    }
    
    public void eintragenDeadline(){
        
    }
    
  
    
    
    public List<Arbeitspaket> getArbeitspaket(Projekt projekt){
        return datenbank.selectAllArbeitspakete(projekt);
    }
    
    public void weiseMitarbeiterZu(Arbeitspaket a, Mitarbeiter m){
        
         try{
             a.setMitarbeiter(m);
            datenbank.weiseArbeitspaketMitarbeiterZu(a, m);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
     }
}
