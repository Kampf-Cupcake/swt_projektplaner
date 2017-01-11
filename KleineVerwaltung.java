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
 * verwaltet die Klassen AKommentar, PKommentar, Notiz
 * @author Evelyne
 */
public class KleineVerwaltung {
    private Datenbank datenbank;
    
     public KleineVerwaltung(){
         datenbank = MainFrame.db;
     }
        
        /**
         * Daten eines neues Kommentares in einem Projekt von der GUI werden für die Laufzeit NetBeans übergeben
         * und per Methode "erstelleProjekt" der Datenbank dauerhaft übergeben
         * @param text
         * @param tag
         * @param monat
         * @param jahr
         * @param verfasser
         * @param projekt 
         */
        public void erstellePKommentar(String text, int tag, int monat, int jahr, Mitarbeiter verfasser, Projekt projekt){    
        
        System.out.println("Kommentar "+ text);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
        
        PKommentar pk = new PKommentar(text, greg, verfasser, projekt);
        
        try{
            datenbank.erstellePKommentar(pk);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
        /**
         * hier wird die Methode zum Auslesen aller Kommentare eines Projektes aus der DB abgerufen
         * @param projekt dessen Kommentare ausgelesen werden sollen
         * @param vf Verfasser des Kommentares
         * @return eine List aller Kommentare die zu einem Projekt erstellt wurden
         */
        public List<PKommentar> getPKommentare(Projekt projekt, Mitarbeiter vf){
            return datenbank.selectAllPKommentare(projekt, vf);
        }
        
        /**
         * Daten eines neues Kommentars in einem Arbeitspaket von der GUI werden für die Laufzeit NetBeans übergeben
         * und per Methode "speicherProjekt" der Datenbank dauerhaft übergeben
         * @param text
         * @param tag
         * @param monat
         * @param jahr
         * @param verfasser
         * @param ap 
         */
        public void erstelleAKommentar(String text, int tag, int monat, int jahr, Mitarbeiter verfasser, Arbeitspaket ap){    
        
        System.out.println("Kommentar "+ text);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
        
        AKommentar ak = new AKommentar(text, greg, verfasser, ap);
        
        try{
            datenbank.erstelleAKommentar(ak);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
        /**
         * hier wird die Methode zum Auslesen aller Kommentare eines Projektes aus der DB abgerufen
         * @param projekt dessen Kommentare ausgelesen werden sollen
         * @param  vf Verfasser des Kommentares
         * @return eine List aller Kommentare die zu einem Projekt erstellt wurden
         */
        public List<AKommentar> getAKommentare(Arbeitspaket ap, Mitarbeiter vf){
            return datenbank.selectAllAKommentare(ap, vf);
        }
        
        /**
         * Daten einer neuen Notiz von der GUI werden für die Laufzeit an NetBeans übergeben
         * und per Methode "erstelleNotiz" der Datenbank dauerhaft übergeben
         * @param text
         * @param tag
         * @param monat
         * @param jahr
         * @param verfasser 
         * @param bezeichnung
         */
        public void erstelleNotiz(String text, int tag, int monat, int jahr, Mitarbeiter verfasser, String bezeichnung){
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
        Notiz n = new Notiz (text, greg, verfasser, bezeichnung);
        
        try{
            datenbank.erstelleNotiz(n);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
    }
            
        /**
        * ruft die Methode zum Auslesen aller Notizen eines Mitarbeiters aus der DB auf
        * @param ma
        * @return 
        */
        public List<Notiz> getMyNotizen(Mitarbeiter ma){
            return datenbank.selectAllMyNotizen(ma);
    }
        
        public void loescheNotiz (Notiz n){
            //nicht sicher ob es nötig ist, aus der Liste in NetBeans zu löschen:
           n.getMitarbeiter().getNotiz().remove(n);
            try{
            datenbank.loescheNotiz(n);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
        }
       
        /**
         * ruft die Methode zum Auslesen aller Statusberichte eines Projektes aus der DB auf
         * @param p Projekt dessen Statusberichte aufgerufen werden sollen
         * @return eine Liste mit allen vergangen Statusberichte eines Projektes
         */
        public List<Statusbericht> getAllStatusberichte(Projekt p){
            return datenbank.selectAllStatusberichte(p);
        }
        
       /**
        * berechnet einen Statusbericht eines Projektes 
        * und speichert diesen per "speicherStatusbericht" dauerhaft in der DB
        * @param tag des heutigen Datums
        * @param monat es heutigen Datums
        * @param jahres heutigen Datums
        * @param p Projekt dessen Status berechnet und gespeichert werden soll
        * @return einen (gerundeten) Integer der den prozentuale Status des Projektes darstellt
        */
        public Integer berechne_und_speicherStatus (int tag, int monat, int jahr, Projekt p){
            double anzahl_allerAp = datenbank.selectAllArbeitspakete(p).size();
            double anzahl_fertigeAP = datenbank.selectAllUnfertige_oder_FertigeArbeitspakete(p, true).size();
            int status = (int) Math.round((anzahl_fertigeAP /anzahl_allerAp) * 100) ;
            
            GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
            Statusbericht sb = new Statusbericht(status, greg, p);
       
        try{
            datenbank.speicherStatusbericht(sb);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
            e.printStackTrace();
        }
        return status;
        }
 
    }
    

