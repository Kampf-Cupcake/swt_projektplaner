package swt_projektplaner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Evelyne
 */
public class Datenbank {

    private ProjektVerwaltung projektV;
    private ArbeitspaketVerwaltung arbeitspaketV;
    private BenutzerVerwaltung mitarbeiterV;

    Connection con = null;

    public Datenbank() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (Exception e) {
            System.err.println("Treiber nicht gefunden: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    private void connect() throws SQLException {
        con = DriverManager.getConnection("jdbc:hsqldb:file:data/swt", "SA", "");
    }

    private ResultSet executeSQL(String sql) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        return res;
        /*} catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
    }
    /**
     * Schließt die Verbindung zu hsqldb
     */
     public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim Schließen: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

     /**
      * wandelt ein Datum vom Datentyp Date in GregorianCalender für hsql um
      * @param date
      * @return ein Datum vom Datentyp GregorianCalender
      */
    public GregorianCalendar dateZuGreg(Date date) {
        GregorianCalendar greg = new GregorianCalendar();
        greg.setGregorianChange(date);

        return greg;
    }

/*Block für Projekt*/
    
   /**
    * Speichert ein Projekt in der Datenbank
    * @param projekt
    * @throws Exception 
    */
    public void speicherProjekt(Projekt projekt) throws Exception {
        connect();
        int year = projekt.getDeadline().get(Calendar.YEAR);
        int month = projekt.getDeadline().get(Calendar.MONTH) + 1;
        int day = projekt.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Projekt (name,beschreibung,deadline) "
                + "VALUES ('" + projekt.getname() + "','" + projekt.getbeschreibung() + "','" + year + "-" + month + "-" + day + "')";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * Liest alle vorhandenen Projekte der Datenbank aus und "speichert" sie zur Laufzeit in die Projektliste von NetBeans
     * @return eine Liste mit allen vorhandenen Projekten
     */
    public List<Projekt> selectAllProjects() {
        List<Projekt> projekte = new LinkedList<Projekt>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Projekt";

            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {

                String name = res.getString(1);
                String beschreibung = res.getString(2);
                Date deadline = res.getDate(3);
                int id = res.getInt(4);
                GregorianCalendar greg = dateZuGreg(deadline);

                Projekt diesProjekt = new Projekt(name, beschreibung, greg);
                diesProjekt.setName(name);
                diesProjekt.setBeschreibung(beschreibung);
                diesProjekt.setDeadline(greg);
                diesProjekt.setProjektNr(id);
                // System.out.println("Das Projekt heißt: "+name+"\nHier die Beschreibung: "+beschreibung);

                projekte.add(diesProjekt);
            }
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projekte;
    }

    /*brauchen wir die Methode???*/
    public void abrufeProjekt(String sql) throws Exception {
        connect();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * weist einem Projekt einen Mitarbeiter zu
     * @param p Projekt dem ein MA zugewiesen werden soll
     * @param m Mitarbeiter der einem Projekt zugewiesen soll
     * @throws Exception 
     */
    public void weiseProjektMitarbeiterZu(Projekt p, Mitarbeiter m)throws Exception{
        connect();
        String sql = "INSERT INTO P_MA (arbeitet_an, wird_bearbeitet_von) VALUES ("+p.getProjektNr()+","+m.getPersonalNr()+")";
        ResultSet r = executeSQL(sql);
        con.close();
    };
    
    /**
     * bearbeitet die Zelle, hier der Name, von dem ausgewählten, bestehenden Projekt
     * @param projekt in dem der Name geändert werden soll 
     * @param neuName den das Projekt bekommen soll
     * @throws Exception 
     */
    public void bearbeiteProjektName(Projekt projekt, String neuName) throws Exception {
        connect();
        String sql = "UPDATE Projekt SET name ='" + neuName + "' WHERE ProjektNr =" + projekt.getProjektNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * bearbeitet die Zelle, hier die Beschreibung, von dem ausgewählten, bestehenden Projekt
     * @param projekt in dem die Beschreibung geändert werden soll 
     * @param neuBeschreibung die das Projekt bekommen soll
     * @throws Exception 
     */
    public void bearbeiteProjektBeschreibung(Projekt projekt, String neuBeschreibung) throws Exception {
        connect();
        String sql = "UPDATE Projekt SET beschreibung ='" + neuBeschreibung + "' WHERE ProjektNr =" + projekt.getProjektNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * bearbeitet die Zelle, hier die Deadline, von dem ausgewählten, bestehenden Projekt
     * @param projekt in dem die Deadline geändert werden soll 
     * @param neugreg neue Deadline die das Projekt bekommen soll
     * @throws Exception 
     */
    public void bearbeiteProjektDeadline(Projekt projekt, GregorianCalendar neugreg) throws Exception {
        connect();
        int year = neugreg.get(Calendar.YEAR);
        int month = neugreg.get(Calendar.MONTH) + 1;
        int day = neugreg.get(Calendar.DAY_OF_MONTH);
        String sql = "UPDATE Projekt SET deadline ='" + year + "-" + month + "-" + day + "' WHERE ProjektNr =" + projekt.getProjektNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * löscht ein bestehendes Projekt aus der Datenbank
     * @param projekt das gelöscht werden soll
     * @throws Exception 
     */
    public void loeschenProjekt(Projekt projekt)throws Exception{
        connect();
        String sql = "DELETE FROM Projekt WHERE ProjektNr ="+ projekt.getProjektNr();
        con.close();
    }
    
    
/*Block für die Arbeitspakete*/
    
    /**
     * speichert ein Arbeitspaket in der Datenbank
     * @param arbeitspaket das in hsql gespeichert werden soll
     * @throws Exception 
     */
    public void speicherArbeitspaket(Arbeitspaket arbeitspaket) throws Exception {
        connect();
        int year = arbeitspaket.getDeadline().get(Calendar.YEAR);
        int month = arbeitspaket.getDeadline().get(Calendar.MONTH) + 1;
        int day = arbeitspaket.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Arbeitspaket (name,fertig,beschreibung,deadline, gehört_zu) "
                + "VALUES ('" + arbeitspaket.getName() + "'," + arbeitspaket.getFertig() + ",'"
                + arbeitspaket.getBeschreibung() + "','" + year + "-" + month + "-" + day + "'," + arbeitspaket.getProjekt().getProjektNr() + ")";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * Liest alle Arbeitspakete eines Projektes aus der Datenbank
     * @param projekt dessen Arbeitspakete ausgelesen werden sollen
     * @return eine Liste der zum Projekt zugehörigen Arbeitspakete
     */
    public List<Arbeitspaket> selectAllArbeitspakete(Projekt projekt) {
        List<Arbeitspaket> arbeitspakete = new LinkedList<Arbeitspaket>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Arbeitspaket WHERE Arbeitspaket.gehört_zu=" + projekt.getProjektNr();

            ResultSet res = stmt.executeQuery(sql);

            //String sqlProjekt = "SELECT * FROM Projekt, Arbeitspaket WHERE Arbeitspaket.gehört_zu=Projekt.projektNr";
            //ResultSet resProjekt = stmt.executeQuery(sqlProjekt);
            while (res.next()) {

                String name = res.getString(1);
                boolean fertig = res.getBoolean(2);
                String beschreibung = res.getString(3);
                Date deadline = res.getDate(4);
                int id = res.getInt(5);

                GregorianCalendar greg = dateZuGreg(deadline);

                Arbeitspaket diesArbeitspaket = new Arbeitspaket(name, fertig, beschreibung, greg, projekt);
                diesArbeitspaket.setName(name);
                diesArbeitspaket.setFertig(fertig);
                diesArbeitspaket.setBeschreibung(beschreibung);
                diesArbeitspaket.setDeadline(greg);
                diesArbeitspaket.setArbeitspaketNr(id);
                diesArbeitspaket.setProjekt(projekt);

                arbeitspakete.add(diesArbeitspaket);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arbeitspakete;
    }

    /*brauchen wir die Methode???*/
    public void abrufeArbeitspaket(String sql) throws Exception {
        connect();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    
/*Block für die Mitarbeiter-Methoden*/
    
    /**
     * speichert einen Mitarbeiter in der Datenbank
     * @param mitarbeiter 
     * @throws Exception 
     */
    public void speicherMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
        connect();

        String sql = "INSERT INTO Mitarbeiter (name, vorname, rang, benutzername, passwort) "
                + "VALUES ('" + mitarbeiter.getName() + "','" + mitarbeiter.getVorname() + "','" + mitarbeiter.getRang() + "','" + mitarbeiter.getBenutzername() + "','"+ mitarbeiter.getPasswort() + "','" + "')";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * weist einem Arbeitspaket einen Mitarbeiter zu
     * @param a Arbeitspaket, das einen Mitarbeiter zugewiesen werden soll
     * @param m Mitarbeiter der dem Arbeitspaket zugewiesen werden soll
     * @throws Exception 
     */
    public void weiseArbeitspaketMitarbeiterZu(Arbeitspaket a, Mitarbeiter m)throws Exception{
        connect();
        String sql = "INSERT INTO AP_MA (arbeitet_an, wird_bearbeitet_von) VALUES ("+a.getArbeitspaketNr()+","+m.getPersonalNr()+")";
        ResultSet r = executeSQL(sql);
        con.close();
    };
   
    /**
     * liest alle Mitarbeiter aus der Datenbank aus
     * @return eine Liste aller bestehenden Mitarbeiter
     */
    public List<Mitarbeiter> selectAllMitarbeiters() {
        List<Mitarbeiter> mitarbeiters = new LinkedList<Mitarbeiter>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Mitarbeiter";

            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {

                String name = res.getString(1);
                String vorname = res.getString(2);
                String rang = res.getString(3);
                String benutzername = res.getString(4);
                String passwort = res.getString(5);
                int id = res.getInt(6);

                Mitarbeiter dieserMA = new Mitarbeiter(name, vorname, rang, benutzername, passwort);
                dieserMA.setName(name);
                dieserMA.setVorname(vorname);
                dieserMA.setRang(rang);
                dieserMA.setBenutzername(benutzername);
                dieserMA.setPasswort(passwort);
                dieserMA.setPersonalNr(id);

                mitarbeiters.add(dieserMA);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mitarbeiters;
    }

    /*Brauchen wir diese Methode???*/
    public void abrufeMitarbeiter(String sql) throws Exception {
        connect();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * Speichert ein Kommentar zu einem Arbeitspaket in der DB
     * @param ak Kommentar zum Arbeitspaket
     * @throws Exception 
     */
    public void erstelleAKommentar(AKommentar ak)throws Exception{
        connect();
        int year = ak.getDatum().get(Calendar.YEAR);
        int month = ak.getDatum().get(Calendar.MONTH) + 1;
        int day = ak.getDatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO AKommentar (text,datum) "
                + "VALUES ('" + ak.getText() + "','" + year + "-" + month + "-" + day + "')";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    public void erstellePKommentar(PKommentar pk)throws Exception{
        connect();
        int year = pk.getDatum().get(Calendar.YEAR);
        int month = pk.getDatum().get(Calendar.MONTH) + 1;
        int day = pk.getDatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO PKommentar (text,datum) "
                + "VALUES ('" + pk.getText() + "','" + year + "-" + month + "-" + day + "')";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
   

}
