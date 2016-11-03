/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;
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

    private final List<Projekt> projekte;
    private Datenbank datenbank;
    
    public ProjektVerwaltung(){
         datenbank = new Datenbank();
         projekte = new LinkedList<>();
        try {
            datenbank.init();
        } catch (Exception e) {
            System.err.println("Fehler beim Datenbankzugriff: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void anlegenProjekt(String name, String beschreibung, int tag, int monat, int jahr) {        //'int name' zu 'String name' geändert, beschreibung in UML
        System.out.println(name);
        System.out.println(beschreibung);
        GregorianCalendar greg = new GregorianCalendar(jahr, monat-1, tag);
        Projekt projekt = new Projekt(name, beschreibung, greg);
        Date datum =  new Date(greg.getGregorianChange().getTime());
        try{
            datenbank.speicherProjekt(name, beschreibung, datum);
        } catch (Exception e){
            System.err.print("Fehler beim Einspeichern: " + e.getMessage());
        }
        projekte.add(projekt);
        
                
    }

    public void verwaltenArbeitspaket() {

    }

    public void eintragenDeadline(String deadline) {
        System.out.println(deadline);

    }
}
