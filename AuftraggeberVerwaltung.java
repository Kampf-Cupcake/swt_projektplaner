/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swt_projektplaner;

import java.util.List;


/**
 *
 * @author Evelyne
 */
public class AuftraggeberVerwaltung {
    private Datenbank datenbank;
    
    public AuftraggeberVerwaltung(){
        datenbank = MainFrame.db;
    }
    /*
    private String name;
    private String ansprechpartner;
    private String tel;
    private String strasse;
    private String hausNr;
    private int plz;
    private String ort;
    private int kundenNr;
    */
    
    /**
     * Daten eines neues Auftraggebers von der GUI werden für die Laufzeit NetBeans übergeben
     * und per Methode "speicherAuftraggeber" der Datenbank dauerhaft übergeben
     * @param name
     * @param ansprechpartner
     * @param tel
     * @param str
     * @param hnr
     * @param plz
     * @param ort 
     */
    public void anlegenAuftraggeber (String name, String ansprechpartner, String tel, String str, String hnr, int plz, String ort){
        Auftraggeber auftraggeber = new Auftraggeber(name, ansprechpartner, tel, str, hnr, plz, ort);

        try{
            datenbank.speicherAuftraggeber(auftraggeber);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        /**
         * hier wird die Methode zum Auslesen aller Auftraggeber aus der DB abgerufen
         * @return eine Liste aller bestehenden Kunden
         */
        public List<Auftraggeber> getAuftraggeber(){
            return datenbank.selectAllAuftraggebers();
    }
    
        public void bearbeiteName(Auftraggeber ag, String name){
        ag.setName(name);
        try {
            datenbank.bearbeiteAuftraggeberName(ag, name);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        
        public void bearbeiteAnsprechpartner(Auftraggeber ag, String ap){
        ag.setAnsprechpartner(ap);
        try {
            datenbank.bearbeiteAuftraggeberAnsprechpartner(ag, ap);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
    
        public void bearbeiteTel(Auftraggeber ag, String tel){
        ag.setTel(tel);
        try {
            datenbank.bearbeiteAuftraggeberTel(ag, tel);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        public void bearbeiteStrasse(Auftraggeber ag, String str){
        ag.setStrasse(str);
        try {
            datenbank.bearbeiteAuftraggeberStrasse(ag, str);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        public void bearbeiteHausNr(Auftraggeber ag, String hnr){
        ag.setHausNr(hnr);
        try {
            datenbank.bearbeiteAuftraggeberHausNr(ag, hnr);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        public void bearbeitePlz(Auftraggeber ag, int plz){
        ag.setPlz(plz);
        try {
            datenbank.bearbeiteAuftraggeberPLZ(ag, plz);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        public void bearbeiteOrt(Auftraggeber ag, String ort){
        ag.setName(ort);
        try {
            datenbank.bearbeiteAuftraggeberOrt(ag, ort);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
        
        public void löscheAuftraggeber (Auftraggeber ag){
        try {
            datenbank.loeschenAuftraggeber(ag);
        } catch (Exception e) {
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
    }
}
