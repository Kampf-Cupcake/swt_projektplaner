package swt_projektplaner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jan Beuster
 */
public class ProjektVerwaltung {

    
    private Datenbank datenbank;
    
    public ProjektVerwaltung(){
         datenbank = MainFrame.db;
    }
    // Daten von der GUI werden für die Laufzeit NetBeans übergeben und 
    // per Methode speicherProjekt der Datenbank übergeben
    public void anlegenProjekt(String name, String beschreibung, int tag, int monat, int jahr) {        //'int name' zu 'String name' geändert, beschreibung in UML
        System.out.println(name);
        System.out.println(beschreibung);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat-1, tag);
       
        Projekt projekt = new Projekt(name, beschreibung, greg);
        System.out.println(greg);
       // Date datum =  new Date(greg.getGregorianChange().getTime());
        try{
            datenbank.speicherProjekt(projekt);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
             
    }

    public void verwaltenArbeitspaket() {

    }

    public void bearbeiteDeadline(Projekt p, int tag, int monat, int jahr) {
        GregorianCalendar greg = new GregorianCalendar(jahr, monat - 1, tag);
        p.setDeadline(greg);
       // datenbank.bearbeiteProjektDeadline(p, greg);
    }
    
   
    
     public List<Projekt> getProjekte(){
      List<Projekt> projekte = datenbank.selectAllProjects();
      for (Projekt p : projekte){
          p.setArbeitspakete(datenbank.selectAllArbeitspakete(p));
      }
      return projekte;
    }
     //Evelyne neu
     public void weiseMitarbeiterZu(Projekt p, Mitarbeiter m){
        
         try{
             p.setMitarbeiter(m);
            datenbank.weiseProjektMitarbeiterZu(p, m);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
     }
}
