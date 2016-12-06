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
    
     public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim Schließen: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    public GregorianCalendar dateZuGreg(Date date) {
        GregorianCalendar greg = new GregorianCalendar();
        greg.setGregorianChange(date);

        return greg;
    }

/*Block für Projekt*/
    
    /*um das Projekt in DB zu speichern*/
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

    /*gibt eine Liste von allen Projekten raus und wird in NetBeans gespeichert*/
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

    /*weist einem Projekt einen Mitarbeiter zu*/
    public void weiseProjektMitarbeiterZu(Projekt p, Mitarbeiter m)throws Exception{
        /*INSERT INTO Store_Information (Store_Name, Sales, Txn_Date)
    SELECT Store_Name, Sales, Txn_Date
    FROM Sales_Information
    WHERE Year (Txn_Date) = 1998;*/
        connect();
        String sql = "INSERT INTO Projekt (wird_bearbeitet_von) VALUES ('"+m.getPersonalNr()+"')"
                + "WHERE Projekt.ProjektNr='" + p.getProjektNr()+"'";
        ResultSet r = executeSQL(sql);
        con.close();
    };
    
    /*bearbeitet die Zelle, hier der Name, von dem ausgewählten Projekt*/
    public void bearbeiteProjektName(Projekt projekt, String neuName) throws Exception {
        connect();
        String sql = "UPDATE Projekt SET name ='" + neuName + "' WHERE ProjektNr ='" + projekt.getProjektNr() + "'";
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /*bearbeitet die Zelle, hier die Beschreibung, von dem ausgewählten Projekt*/
    public void bearbeiteProjektBeschreibung(Projekt projekt, String neuBeschreibung) throws Exception {
        connect();
        String sql = "UPDATE Projekt SET beschreibung ='" + neuBeschreibung + "' WHERE ProjektNr ='" + projekt.getProjektNr() + "'";
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /*bearbeitet die Zelle, hier die Deadline, von dem ausgewählten Projekt*/
    public void bearbeiteProjektDeadline(Projekt projekt, GregorianCalendar neugreg) throws Exception {
        connect();
        int year = neugreg.get(Calendar.YEAR);
        int month = neugreg.get(Calendar.MONTH) + 1;
        int day = neugreg.get(Calendar.DAY_OF_MONTH);
        String sql = "UPDATE Projekt SET deadline ='" + year + "-" + month + "-" + day + "' WHERE ProjektNr ='" + projekt.getProjektNr() + "'";
        ResultSet r = executeSQL(sql);
        con.close();
    }

/*Block für die Arbeitspakete*/
    
    /*um das Arbeitspaket in DB zu speichern*/
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

    /*gibt eine Liste von Arbeitspakten zu einem bestimmten Projekt aus*/
    public List<Arbeitspaket> selectAllArbeitspakete(Projekt projekt) {
        List<Arbeitspaket> arbeitspakete = new LinkedList<Arbeitspaket>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Arbeitspaket WHERE Arbeitspaket.gehört_zu=" + projekt.getProjektNr();

            ResultSet res = stmt.executeQuery(sql);

            //String sqlProjekt = "SELECT * FROM Projekt, Arbeitspaket WHERE Arbeitspaket.gehört_zu=Projekt.projektNr";
            //ResultSet resProjekt = stmt.executeQuery(sqlProjekt);
            int i = 1;
            while (res.next()) {

                String name = res.getString(1);
                boolean fertig = res.getBoolean(2);
                String beschreibung = res.getString(3);
                Date deadline = res.getDate(4);
                int id = res.getInt(5);
                //int gehört_zu = res.getInt(6); das funktioniert leider nicht, da Arbeitspaket ein Projekt braucht und keinen int
                //Hier entnehmen wir HOFFENTLICH das zugehörige Projekt aus der DB und machen daraus ein NetBeansObjekt 
                int projektJustObject = res.getInt(6);
                //Projekt projekt = (Projekt)projektJustObject;
                i++;

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
    
    /*speichert einen Mitarbeiter in DB*/
    public void speicherMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
        connect();

        String sql = "INSERT INTO Mitarbeiter (name, vorname, rang, benutzername, passwort) "
                + "VALUES ('" + mitarbeiter.getName() + "','" + mitarbeiter.getVorname() + "','" + mitarbeiter.getRang() + "','" + mitarbeiter.getBenutzername() + "','"+ mitarbeiter.getPasswort() + "','" + "')";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /*liefert eine Liste von allen Mitarbeiter*/
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

   

}
