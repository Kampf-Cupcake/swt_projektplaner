package swt_projektplaner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Jan Beuster
 */
public class MitarbeiterVerwaltung {
    
    private Datenbank datenbank;
    
    public MitarbeiterVerwaltung(){
         datenbank = MainFrame.db;
    }
    
    /**
     * Daten eines neues Profils eines Mitarbeiters von der GUI werden für die Laufzeit NetBeans übergeben
     * und per Methode "speicherMitarbeiter" der Datenbank dauerhaft übergeben
     * @param name
     * @param vorname
     * @param Rang
     * @param benutzername
     * @param passwort 
     */
    public void erstelleProfil(String name, String vorname, String Rang, String benutzername, String passwort){
       System.out.println(vorname);
        System.out.println(name);
       
        Mitarbeiter mitarbeiter = new Mitarbeiter(name, vorname, Rang, benutzername, passwort);
        System.out.println(Rang);
       // Date datum =  new Date(greg.getGregorianChange().getTime());
        try{
            datenbank.speicherMitarbeiter(mitarbeiter);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Name wird geändert
     * und per "bearbeiteMitarbeiterName" dauerhaft in der DB geändert
     * @param ma der Mitarbeiter dessen Name geändert werden soll
     * @param n der neue Name
     */
    public void bearbeiteName(Mitarbeiter ma, String n){
        ma.setName(n);
        try {
            datenbank.bearbeiteMitarbeiterName(ma, n);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Name wird geändert
     * und per "bearbeiteMitarbeiterName" dauerhaft in der DB geändert
     * @param ma der Mitarbeiter dessen Name geändert werden soll
     * @param vn der neue Vorname
     */
    public void bearbeiteVorname(Mitarbeiter ma, String vn){
        ma.setName(vn);
        try {
            datenbank.bearbeiteMitarbeiterVorname(ma, vn);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Rang wird geändert
     * und per "bearbeiteMitarbeiterRang" dauerhaft in der DB geändert
     * @param ma der Mitarbeiter dessen Rang geändert werden soll
     * @param r der neue Rang
     */
    public void bearbeiteRang(Mitarbeiter ma, String r){
        ma.setRang(r);
        try {
            datenbank.bearbeiteMitarbeiterVorname(ma, r);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * Name wird geändert
     * und per "bearbeiteMitarbeiterBenutzername" dauerhaft in der DB geändert
     * @param ma der Mitarbeiter dessen Benutzername geändert werden soll
     * @param bn der neue Benutzername
     */
    public void bearbeiteBenutzername(Mitarbeiter ma, String bn){
        ma.setName(bn);
        try {
            datenbank.bearbeiteMitarbeiterBenutzername(ma, bn);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    /**
     * hier noch eine abfrage ob das eingegebene passwort mit dem eingespeicherten übereinstimmt
     * wenn nicht dann kan der neue nicht eingespeichert werden, 
     * wenn es passt dann wird das neue eingespeichert
     * @param ma der Mitarbeiter dessen Passwort geändert werden soll
     * @param altespw das alte Passwort
     * @param neuespw das neue Passwort
     */

    public void bearbeitePasswort(Mitarbeiter ma, String altespw, String neuespw){
        
        ma.setPasswort(neuespw);
        try {
            datenbank.bearbeiteMitarbeiterPasswort(ma, neuespw);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
    
    /**
     * ruft die Methode zum Auslesen aller Mitarbeiter aus der DB auf
     * @return eine Liste aller bestehenden Mitarbeiterprofile 
     */
    public List<Mitarbeiter> getMitarbeiter(){
        return datenbank.selectAllMitarbeiters();
    }
    
    /**
     * ruft die Methode zum Auslesen aller Projekte aus der DB, an denen 1 Mitarbeiter arbeitet auf
     * @param ma Mitarbeiter
     * @return 
     */
    public List<Projekt> getMyProjects(Mitarbeiter ma){
        return datenbank.selectAllMyProjects(ma);
    }

    
    /**
     * ruft die Methode zum Auslesen aller Arbeitspakete zu einem Projekt aus der DB 
     * die zu einem Mitarbeiter gehören
     * @param p Projekt zu dem die Arbeitspakete gehören
     * @param m Mitarbeiter dessen Arbeitspakete ausgelesen werden sollen
     * @return eine Liste aller Arbeitspakete eines Projektes die zu einem Mitarbeiter gehören
     */
    public List<Arbeitspaket> getMyAPvonProjekt (Projekt p, Mitarbeiter m){
        return datenbank.selectMyArbeitspaketeVonProjekt(p, m);
    }
    
      /**
      * löscht ein Mitarbeiter und alle Datensätze die ohne dieses Mitarbeiter kein Sinn machen würde, aus der DB
      * @param m Mitarbeiter
      */
     public void löscheMitarbeiter (Mitarbeiter m){
        //aus NetBeans in Listen löschen?
         try {
            datenbank.loeschenMitarbeiter(m);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
     }
}
