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
    
    public void aendereRang(){
        
    }
    
   //public void aendereBenutzername(){     //Fällt möglicherweise weg
        
    //}
    
    public void aenderePasswort(String passwort){
        
    }
    
    public void aendereName(){
        
    }
    
    /**
     * ruft die Methode zum Auslesen aller Mitarbeiter aus der DB auf
     * @return eine Liste aller bestehenden Mitarbeiterprofile 
     */
    public List<Mitarbeiter> getMitarbeiter(){
        return datenbank.selectAllMitarbeiters();
    }
    
}
