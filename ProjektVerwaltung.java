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

    /**
     * Daten eines neues Projektes von der GUI werden für die Laufzeit NetBeans übergeben
     * und per Methode "speicherProjekt" der Datenbank dauerhaft übergeben
     * @param name
     * @param beschreibung
     * @param tag der Deadline
     * @param monat der Deadline
     * @param jahr der Deadline
     */
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

<<<<<<< HEAD
    public void bearbeiteDeadline(Projekt p, int tag, int monat, int jahr){
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
=======
    /**
     * Deadline wird geändert 
     * und per "bearbeiteProjektDeadline" dauerhaft in der DB geändert
     * @param p Projekt dessen Deadline geändert werden soll
     * @param tag der neuen Deadline
     * @param monat der neuen Deadline
     * @param jahr der neuen Deadline
     */
    public void bearbeiteDeadline(Projekt p, int tag, int monat, int jahr) {
        GregorianCalendar greg = new GregorianCalendar(jahr, monat - 1, tag);
>>>>>>> origin/master
        p.setDeadline(greg);
        try {
            datenbank.bearbeiteProjektDeadline(p, greg);
        } catch (Exception e) {
<<<<<<< HEAD
           System.err.print("Fehler beim Einspeichern: " + e.getMessage());
=======
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
>>>>>>> origin/master
        }
    }
    
   /**
    * Füllt für die Laufzeit eine Liste in NetBeans mit allen Projekten der DB
    * und weist ihnen ihre zugehörigen Arbeitspakete zu
    * @return die Liste aller in der DB vorhandenen Projekte
    */
     public List<Projekt> getProjekte(){
      List<Projekt> projekte = datenbank.selectAllProjects();
      for (Projekt p : projekte){
          p.setArbeitspakete(datenbank.selectAllArbeitspakete(p));
      }
      return projekte;
    }
     
     /**
      * Verbindung zwischen einem Projekt und einem Mitarbeiter (Daten der GUI) werden zur Laufzeit in 
      * die Liste der Mitarbeiter von einem Projekt in NetBeans angefügt
      * und per "weiseProjektMitarbeiterZu" dauerhaft in der Datenbank gespeichert
      * @param p
      * @param m 
      */
     public void weiseMitarbeiterZu(Projekt p, Mitarbeiter m){
        
         try{
             p.setMitarbeiter(m);
            datenbank.weiseProjektMitarbeiterZu(p, m);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
     }
}
