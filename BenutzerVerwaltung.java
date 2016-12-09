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
public class BenutzerVerwaltung {
    
    private Datenbank datenbank;
    
    public BenutzerVerwaltung(){
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
    
    public void bearbeitePasswort(Mitarbeiter ma, String pw){
        
    }
    
    
    /**
     * ruft die Methode zum Auslesen aller Mitarbeiter aus der DB auf
     * @return eine Liste aller bestehenden Mitarbeiterprofile 
     */
    public List<Mitarbeiter> getMitarbeiter(){
        return datenbank.selectAllMitarbeiters();
    }
    
    public List<Projekt> getMyProjects(Mitarbeiter ma){
        return datenbank.selectAllMyProjects(ma);
    }
    
    public List<Notiz> getMyNotizen(Mitarbeiter ma){
        return datenbank.selectAllMyNotizen(ma);
    }
}
