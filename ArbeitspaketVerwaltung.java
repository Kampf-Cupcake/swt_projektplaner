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
    
     /**
      * Daten eines neues Arbeitspaketes von der GUI werden für die Laufzeit NetBeans übergeben
      * und per Methode "speicherArbeitspaket" der Datenbank dauerhaft übergeben
      * @param name
      * @param fertig ob das Arbeitspaket abgschlossen ist
      * @param beschreibung
      * @param tag der Deadline
      * @param monat der Deadline
      * @param jahr der Deadline
      * @param projekt zu dem das Arbeitspaket gehört
      */
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
    
    /**
     * hier wird die Methode zum Auslesen aller Arbeitsprojekte eines Projektes aus der DB abgerufen
     * @param projekt beschreibt das Projekt, dessen Arbeitspakete ausgelesen werden sollen
     * @return eine Liste mit den Arbeitspaketen des Projektes
     */
    public List<Arbeitspaket> getArbeitspaket(Projekt projekt){
        return datenbank.selectAllArbeitspakete(projekt);
    }
    
    /**
     * hier wird die Methode zum Auslesen aller fertigen/unfertigen 
     * Arbeitsprojekte eines Projektes aus der DB aufgerufen
     * @param p Projekt des un-/fertige Arbeitspakete ausgelesen werden soll
     * @param trueOrfalse für fertige AP TRUE übergeben für unfertige FALSE
     * @return eine Liste aller un-/fertigen Arbeitspakete eines Projektes
     */
    public List<Arbeitspaket> getFertige_oder_unfertigeArbeitspakete(Projekt p, boolean trueOrfalse){
        return datenbank.selectAllUnfertige_oder_FertigeArbeitspakete(p, trueOrfalse);
    }
    
    /**
     * Verbindung zwischen einem Arbeitspaket und einem Mitarbeiter (Daten der GUI) werden zur Laufzeit in 
     * die Liste der Mitarbeiter von einem Arbeitspaket in NetBeans angefügt
     * und per "weiseArbeitspaketMitarbeiterZu" dauerhaft in der Datenbank gespeichert
     * @param a Arbeitspaket das einen Mitarbeiter zugewiesen bekommt
     * @param m Mitarbeiter der einem Arbeitspaket zugewiesen wird
     */
    public void weiseMitarbeiterZu(Arbeitspaket a, Mitarbeiter m){
        
         try{
             a.setMitarbeiter(m);
            datenbank.weiseArbeitspaketMitarbeiterZu(a, m);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
     }
    
    /**
     * Name wird geändert
     * und per "bearbeiteArbeitspaketName" dauerhaft in der DB geändert
     * @param ap 
     * @param neuName 
     */
    public void bearbeiteArbeitpaketName (Arbeitspaket ap, String neuName){
        ap.setName(neuName);
        try {
            datenbank.bearbeiteArbeitspaketName(ap, neuName);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    /**
     * Stutus des Arbeitspaketes wird geändert
     * und per "bearbeiteArbeitspaketStatus" dauerhaft in der DB gespeichert
     * @param ap in dem der Status geändert werden soll
     * @param falseOrTrue Status auf false oder true setzen 
     */
    public void bearbeiteArbeitspaketStatus (Arbeitspaket ap, boolean falseOrTrue){
        ap.setFertig(falseOrTrue);
        try {
            datenbank.bearbeiteAbeitspaketStatus(ap, falseOrTrue);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Beschreibung wird geändert
     * und per "bearbeiteArbeitspaketBeschreibung" dauerhaft in der DB geändert
     * @param ap Arbeitpaket in dem geändert wird
     * @param neuB eschreibung
     */
    public void bearbeiteArbeitpaketBeschreibung (Arbeitspaket ap, String neuB){
        ap.setName(neuB);
        try {
            datenbank.bearbeiteArbeitspaketBeschreibung(ap, neuB);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Deadline wird geändert 
     * und per "bearbeiteArbeitspaketDeadline" dauerhaft in der DB geändert
     * @param p Arbeitspaket dessen Deadline geändert werden soll
     * @param tag der neuen Deadline
     * @param monat der neuen Deadline
     * @param jahr der neuen Deadline
     */
    public void bearbeiteDeadline(Arbeitspaket ap, int tag, int monat, int jahr) {
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
        ap.setDeadline(greg);
       
        try {
            datenbank.bearbeiteArbeitspaketDeadline(ap, greg);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Arbeitspaket wird aus der Arbeitspaket-Liste eines Projektes gelöscht 
     * und per "löscheArbeitspaket" dauerhaft in der DB gelöscht
     * @param ap Arbeitpaket in dem geändert wird
     * @param neuB eschreibung
     */
    public void löscheArbeitspaket (Arbeitspaket ap){
        //nötig? störend? fehlt was?
        //ap.getProjekt().removeArbeitspaket(ap);
        try {
            datenbank.loeschenArbeitspaket(ap);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
}
