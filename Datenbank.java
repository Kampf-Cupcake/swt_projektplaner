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
    private MitarbeiterVerwaltung mitarbeiterV;
    private KleineVerwaltung kleineV;

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
        int tag = date.getDate();
        int monat = date.getMonth();
        int jahr = date.getYear() + 1900;
        
        GregorianCalendar greg = new GregorianCalendar(jahr, monat, tag);
        return greg;
    }

/*Block für Projekt*/
    
   /**
    * Speichert ein Projekt in der Datenbank
    * @param projekt
    * @throws Exception 
    */
    public void speicherProjekt(Projekt projekt) throws Exception {
        List <Projekt> vergleichePn = this.selectAllProjects();
        connect();
        int year = projekt.getDeadline().get(Calendar.YEAR);
        int month = projekt.getDeadline().get(Calendar.MONTH) ;
        int day = projekt.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Projekt (name,beschreibung,deadline) "
                + "VALUES ('" + projekt.getname() + "','" + projekt.getbeschreibung() + "','" + year + "-" + month + "-" + day + "')";
        System.out.println(sql);
        LinkedList <String> pN = new LinkedList <String>();
        for (Projekt p : vergleichePn){
            pN.add(p.getname());
        }
        if(!pN.contains(projekt.getname())){
        ResultSet r = executeSQL(sql);}
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
                //System.out.println(greg);

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
    }
    /**
     * weist einem Projekt einen Auftraggeber zu
     * @param p Projekt
     * @param ag Auftraggeber
     * @throws Exception 
     */
    public void weiseProjektAuftraggeberZu(Projekt p, Auftraggeber ag)throws Exception{
        connect();
        String sql = "INSERT INTO beauftragt (beauftragt_von, gibt_in_auftrag) VALUES ("+ ag.getKundenNr() + "," + p.getProjektNr()+")";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
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
        int month = neugreg.get(Calendar.MONTH) ;
        int day = neugreg.get(Calendar.DAY_OF_MONTH);
        String sql = "UPDATE Projekt SET deadline ='" + year + "-" + month + "-" + day + "' WHERE ProjektNr =" + projekt.getProjektNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }

   /**
    * löscht ein Projekt und alle bestehenden Datensätze die ohne das Projekt in der DB keinen Sinn machen
    * @param projekt
    * @throws Exception 
    */
    public void loeschenProjekt(Projekt projekt)throws Exception{
        connect();
        String sql1 = "DELETE FROM Statusbericht WHERE gehört_zu ="+ projekt.getProjektNr();
        String sql2 = "DELETE FROM PKommentar WHERE gehört_zu ="+ projekt.getProjektNr();
        

        
        String sql4 = "DELETE FROM beauftragt WHERE gibt_in_auftrag ="+ projekt.getProjektNr();
        String sql5 = "DELETE FROM P_MA WHERE arbeitet_an ="+ projekt.getProjektNr();
        String sql6 = "DELETE FROM Projekt WHERE ProjektNr ="+ projekt.getProjektNr();
        
        ResultSet r1 = executeSQL(sql1);
        ResultSet r2 = executeSQL(sql2);
        
        
       /* List<Arbeitspaket> löschList = this.selectAllArbeitspakete(projekt);
            if(!löschList.isEmpty()){   
            for(Arbeitspaket ap:löschList){
                System.out.println("bla"+ap);
                String sql1a = "DELETE FROM AKommentar WHERE gehört_zu ="+ ap.getArbeitspaketNr();
                String sql2a = "DELETE FROM AP_MA WHERE arbeitet_an="+ ap.getArbeitspaketNr();
                String sql3a = "DELETE FROM Arbeitspaket WHERE ArbeitspaketNr ="+ ap.getArbeitspaketNr();
                
                ResultSet r1a = executeSQL(sql1a);
                ResultSet r2a = executeSQL(sql2a);
                ResultSet r3a = executeSQL(sql3a);
            //this.loeschenArbeitspaket(ap);
        }}*/
            
        ResultSet r4 = executeSQL(sql4);
        ResultSet r5 = executeSQL(sql5);
        ResultSet r6 = executeSQL(sql6);
        
        con.close();
    }
    

    /**
     * Liest alle Mitarbeiter aus der DB die bei einem Projekt beteiligt sind
     * @param p Projekt
     * @return eine Liste von Mitarbeiter
     */
    public List<Mitarbeiter> selectAllProjektMitarbeiter(Projekt p) {
        List<Mitarbeiter> projektMitarbeiters = new LinkedList<Mitarbeiter>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM P_MA WHERE P_MA.arbeitet_an=" + p.getProjektNr();
            ResultSet res = stmt.executeQuery(sql);
            
            String sql2 = "SELECT * FROM Mitarbeiter WHERE Mitarbeiter.Personalnr="+res.getInt(2);
            ResultSet res2 = stmt.executeQuery(sql2);
            
            while (res2.next()) {
                
                String name = res2.getString(1);
                String vorname = res2.getString(2);
                String rang = res2.getString(3);
                String benutzername = res2.getString(4);
                String passwort = res2.getString(5);
                int id = res2.getInt(6);

                Mitarbeiter dieserMA = new Mitarbeiter(name, vorname, rang, benutzername, passwort);
                dieserMA.setName(name);
                dieserMA.setVorname(vorname);
                dieserMA.setRang(rang);
                dieserMA.setBenutzername(benutzername);
                dieserMA.setPasswort(passwort);
                dieserMA.setPersonalNr(id);

                projektMitarbeiters.add(dieserMA);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projektMitarbeiters;
    }
    
/*Block für die Arbeitspakete*/
    
    /**
     * speichert ein Arbeitspaket in der Datenbank
     * @param arbeitspaket das in hsql gespeichert werden soll
     * @throws Exception 
     */
    public void speicherArbeitspaket(Arbeitspaket arbeitspaket) throws Exception {
        List <Arbeitspaket> vergleicheApN = this.selectAllArbeitspakete(arbeitspaket.getProjekt());
        connect();
        int year = arbeitspaket.getDeadline().get(Calendar.YEAR);
        int month = arbeitspaket.getDeadline().get(Calendar.MONTH) + 1;
        int day = arbeitspaket.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Arbeitspaket (name,fertig,beschreibung,deadline, gehört_zu) "
                + "VALUES ('" + arbeitspaket.getName() + "'," + arbeitspaket.getFertig() + ",'"
                + arbeitspaket.getBeschreibung() + "','" + year + "-" + month + "-" + day + "'," + arbeitspaket.getProjekt().getProjektNr() + ")";
        System.out.println(sql);
        LinkedList <String> apN = new LinkedList <String>();
        for(Arbeitspaket ap : vergleicheApN){
            apN.add(ap.getName());
        }
        if(!apN.contains(arbeitspaket.getName())){
        ResultSet r = executeSQL(sql);}
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
    
    /**
     * Liest alle fertige oder unfertigen Arbeitspake eines Projektes aus der DB
     * @param projekt 
     * @param fertigOderNicht für fertige AP TRUE übergeben für unfertige FALSE
     * @return eine Liste aller un-/fertigen Arbeitspakete eines Projektes
     */
    public List<Arbeitspaket> selectAllUnfertige_oder_FertigeArbeitspakete(Projekt projekt, boolean fertigOderNicht) {
        List<Arbeitspaket> arbeitspakete = new LinkedList<Arbeitspaket>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Arbeitspaket WHERE Arbeitspaket.gehört_zu=" + projekt.getProjektNr()+" AND fertig= "+fertigOderNicht;

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

    /**
     * Name wird geändert
     * @param ap in dem der Name geändert werden soll 
     * @param neuName den das Projekt bekommen soll
     * @throws Exception 
     */
    public void bearbeiteArbeitspaketName(Arbeitspaket ap, String neuName) throws Exception {
        connect();
        String sql = "UPDATE Arbeitspaket SET name ='" + neuName + "' WHERE ArbeitspaketNr =" + ap.getArbeitspaketNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }

    /**
     * Status des Arbeitspaketes wird geändert
     * @param ap Arbeitspaket in dem der Status geändert werden soll
     * @param trueOrFalse Status auf true oder false setzen
     * @throws Exception 
     */
    public void bearbeiteAbeitspaketStatus(Arbeitspaket ap, boolean trueOrFalse)throws Exception{
        connect();
        String sql = "UPDATE Arbeitspaket SET fertig ='" + trueOrFalse + "' WHERE ArbeitspaketNr =" + ap.getArbeitspaketNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Beschreibung wird geändert
     * @param ap in dem die Beschreibung geändert werden soll 
     * @param neuBeschreibung die das Projekt bekommen soll
     * @throws Exception 
     */
    public void bearbeiteArbeitspaketBeschreibung(Arbeitspaket ap, String neuBeschreibung) throws Exception {
        connect();
        String sql = "UPDATE Arbeitspaket SET beschreibung ='" + neuBeschreibung + "' WHERE ArbeitspaketNr =" + ap.getArbeitspaketNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Deadline von Arbeitspaket wird geändert
     * @param ap Arbeitspaket dessen Deadline geändert werden soll
     * @param neugreg das neue Datum
     * @throws Exception 
     */
    public void bearbeiteArbeitspaketDeadline(Arbeitspaket ap, GregorianCalendar neugreg) throws Exception {
        connect();
        int year = neugreg.get(Calendar.YEAR);
        int month = neugreg.get(Calendar.MONTH) + 1;
        int day = neugreg.get(Calendar.DAY_OF_MONTH);
        String sql = "UPDATE Arbeitspaket SET deadline ='" + year + "-" + month + "-" + day + "' WHERE ArbeitspaketNr =" + ap.getArbeitspaketNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * löscht ein bestehendes Arbeitspaket und alle Verbindungen sowie Fremdschlüssel aus der Datenbank
     * @param ap das gelöscht werden soll
     * @throws Exception 
     */
    public void loeschenArbeitspaket(Arbeitspaket ap)throws Exception{
        connect();
        String sql1 = "DELETE FROM AKommentar WHERE gehört_zu ="+ ap.getArbeitspaketNr();
        String sql2 = "DELETE FROM AP_MA WHERE arbeitet_an="+ ap.getArbeitspaketNr();
        String sql3 = "DELETE FROM Arbeitspaket WHERE ArbeitspaketNr ="+ ap.getArbeitspaketNr();
        ResultSet r1 = executeSQL(sql1);
        ResultSet r2 = executeSQL(sql2);
        ResultSet r3 = executeSQL(sql3);
        con.close();
    }
    
/*Block für die Mitarbeiter-Methoden*/
    
    /**
     * speichert einen Mitarbeiter in der Datenbank
     * @param mitarbeiter 
     * @throws Exception 
     */
    public void speicherMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
        List <Mitarbeiter> vergleicheBn = this.selectAllMitarbeiters();
        connect();
        String sql = "INSERT INTO Mitarbeiter (name, vorname, rang, benutzername, passwort) "
                + "VALUES ('" + mitarbeiter.getName() + "','" + mitarbeiter.getVorname() + "','" + mitarbeiter.getRang() + "','" + mitarbeiter.getBenutzername() + "','"+ mitarbeiter.getPasswort()+ "')";
        System.out.println(sql);
        
        LinkedList <String> bn = new LinkedList <String>();
        for(Mitarbeiter m : vergleicheBn){
            bn.add(m.getBenutzername());
        }
        if(!bn.contains(mitarbeiter.getBenutzername())){
        ResultSet r = executeSQL(sql);}
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
    
    /**
     * liest alle Projekte eines Mitarbeiters aus
     * @param ma Mitarbeiter
     * @return 
     */
    public List<Projekt> selectAllMyProjects(Mitarbeiter ma) {
        List<Projekt> myProjects = new LinkedList<Projekt>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM AP_MA WHERE wird_bearbeitet_von=" + ma.getPersonalNr();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
            int apNr = res.getInt(1);
            String sql2 = "SELECT * FROM Arbeitspaket WHERE ArbeitspaketNr="+apNr;
            ResultSet res2 = stmt.executeQuery(sql2);
                while(res2.next()){
                    int pNr = res2.getInt(6);
                    String sql3 = "SELECT * FROM Projekt WHERE ProjektNr="+ pNr;
                    ResultSet res3 = stmt.executeQuery(sql3);
                    while (res3.next()) {
                String name = res3.getString(1);
                String beschreibung = res3.getString(2);
                Date deadline = res3.getDate(3);
                int id = res3.getInt(4);
                GregorianCalendar greg = dateZuGreg(deadline);

                Projekt meinProjekt = new Projekt(name, beschreibung, greg);
                meinProjekt.setName(name);
                meinProjekt.setBeschreibung(beschreibung);
                meinProjekt.setDeadline(greg);
                meinProjekt.setProjektNr(id);
               
                myProjects.add(meinProjekt);
            }
                }
            }
            System.out.println(myProjects.toString() + myProjects.size());
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myProjects;
    }
    
    /**
     * liest alle Arbeitspaketes eines Projektes aus der DB, an denen 1 Mitarbeiter arbeitet
     * @param p Projekt zu dem die Arbeitspakete gehören
     * @param m Mitarbeiter dessen Arbeitspakete ausgelesen werden sollen
     * @return  eine Liste mit allen Arbeitspaketen eines Projektes eines Mitarbeiters
     */
    public List<Arbeitspaket> selectMyArbeitspaketeVonProjekt(Projekt p, Mitarbeiter m) {
        List<Arbeitspaket> myAPvonProjekt = new LinkedList<Arbeitspaket>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM AP_MA, Arbeitspaket WHERE AP_MA.wird_bearbeitet_von=" + m.getPersonalNr()+"AND Arbeitspaket.gehört_zu="+p.getProjektNr();
            ResultSet res = stmt.executeQuery(sql);
            
            while (res.next()) {
                
                String name = res.getString(3);
                boolean fertig = res.getBoolean(4);
                String beschreibung = res.getString(5);
                Date deadline = res.getDate(6);
                int id = res.getInt(7);

                GregorianCalendar greg = dateZuGreg(deadline);

                Arbeitspaket diesArbeitspaket = new Arbeitspaket(name, fertig, beschreibung, greg, p);
                diesArbeitspaket.setName(name);
                diesArbeitspaket.setFertig(fertig);
                diesArbeitspaket.setBeschreibung(beschreibung);
                diesArbeitspaket.setDeadline(greg);
                diesArbeitspaket.setArbeitspaketNr(id);
                diesArbeitspaket.setProjekt(p);

                myAPvonProjekt.add(diesArbeitspaket);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myAPvonProjekt;
    }
    
    /**
     * liest alle Arbeitspakete eines Mitarbeiters aus (VON ALLEN PROJEKTEN) 
     * @param m Mitarbeiter
     * @return eine Liste von allein Arbeitspaketen eines Mitarbeiters
     */
    public List<Arbeitspaket> selectALLMyArbeitspakete(Mitarbeiter m) {
        List<Arbeitspaket> myArbeitspakete = new LinkedList<Arbeitspaket>();
        
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM AP_MA, Arbeitspaket WHERE AP_MA.wird_bearbeitet_von=" + m.getPersonalNr();
            ResultSet res = stmt.executeQuery(sql);
            
            LinkedList <Integer> apIDs = new LinkedList <Integer>();
            while (res.next()) {
                
            int apNr = res.getInt(1);
            if(!apIDs.contains(apNr)){
            apIDs.add(apNr);}
            
            }
            
            for(int i: apIDs){
                System.out.println(i);
            String sql2 = "SELECT * FROM Arbeitspaket WHERE ArbeitspaketNr="+i;
            ResultSet res2 = stmt.executeQuery(sql2);
            
            while (res2.next()) {
                
                String name = res2.getString(1);
                boolean fertig = res2.getBoolean(2);
                String beschreibung = res2.getString(3);
                Date deadline = res2.getDate(4);
                int id = res2.getInt(5);
                // müssen hier die Ergebnisse evt in einer List zwishcengespeichert werden?
                String sql3 = "SELECT * FROM Projekt WHERE ProjektNr="+res2.getInt(6);
                ResultSet res3 = stmt.executeQuery(sql3);
                
                while (res3.next()){
                    String pN = res3.getString(1);
                    String pB = res3.getString(2);
                    Date pD = res3.getDate(3);
                    GregorianCalendar greg2 = dateZuGreg(pD);
                    Projekt diesP = new Projekt(pN, pB, greg2);

                    GregorianCalendar greg = dateZuGreg(deadline);
                    
                    Arbeitspaket diesArbeitspaket = new Arbeitspaket(name, fertig, beschreibung, greg, diesP);
                    diesArbeitspaket.setName(name);
                    diesArbeitspaket.setFertig(fertig);
                    diesArbeitspaket.setBeschreibung(beschreibung);
                    diesArbeitspaket.setDeadline(greg);
                    diesArbeitspaket.setArbeitspaketNr(id);
                    diesArbeitspaket.setProjekt(diesP);

                    myArbeitspakete.add(diesArbeitspaket);
            }}
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myArbeitspakete;
    }
    
/*Block für den Mitarbeiter*/    

    /**
     * Name wird geändert
     * @param ma der Mitarbeiter wessen Name geändert werden soll
     * @param n der neue Name
     * @throws Exception 
     */
    public void bearbeiteMitarbeiterName(Mitarbeiter ma, String n) throws Exception {
        connect();
        String sql = "UPDATE Mitarbeiter SET name ='" + n + "' WHERE PersonalNr =" + ma.getPersonalNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Vorname wird geändert
     * @param ma der Mitarbeiter wessen Vorname geändert werden soll
     * @param vn der neue Vorname
     * @throws Exception 
     */
    public void bearbeiteMitarbeiterVorname(Mitarbeiter ma, String vn) throws Exception {
        connect();
        String sql = "UPDATE Mitarbeiter SET vorname ='" + vn + "' WHERE PersonalNr =" + ma.getPersonalNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    public void bearbeiteMitarbeiterPasswort(Mitarbeiter ma, String pw) throws Exception {
        connect();
        String sql = "UPDATE Mitarbeiter SET passwort ='" + pw + "' WHERE PersonalNr =" + ma.getPersonalNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    public boolean einloggen(String bn, String pw) throws Exception{
        connect();
        Statement stmt = con.createStatement();
        String sql = "SELECT* FROM Mitarbeiter WHERE benutzername ='"+ bn +"'";
        ResultSet res = stmt.executeQuery(sql);
        String passwort = res.getString(5);
        res.close();
        stmt.close();
        con.close();
        if (passwort.equals(pw)){
            return true;}
        else {return false;}
    }
    
    public boolean vergleichePasswort(Mitarbeiter ma, String pw)throws Exception{
        connect();
        Statement stmt = con.createStatement();
        String sql = "SELECT* FROM Mitarbeiter WHERE benutzername ='"+ ma.getBenutzername() +"'";
        ResultSet res = stmt.executeQuery(sql);
        String passwort="";
        while (res.next()) {
        passwort = res.getString(5);
        }
        
        res.close();
        stmt.close();
        con.close();
        if (passwort.equals(pw)){
            return true;}
        else {return false;}
    }
    
    /**
     * Rang wird geändert
     * @param ma der Mitarbeiter wessen Rang geändert werden soll
     * @param ra der neue Rang
     * @throws Exception 
     */
    public void bearbeiteMitarbeiterRang(Mitarbeiter ma, String ra) throws Exception {
        connect();
        String sql = "UPDATE Mitarbeiter SET rang ='" + ra + "' WHERE PersonalNr =" + ma.getPersonalNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Benutzername wird geändert
     * @param ma der Mitarbeiter wessen Benutzername geändert werden soll
     * @param bn der neue Benuttzname
     * @throws Exception 
     */
    public void bearbeiteMitarbeiterBenutzername(Mitarbeiter ma, String bn) throws Exception {
        connect();
        String sql = "UPDATE Mitarbeiter SET benutzername ='" + bn + "' WHERE PersonalNr =" + ma.getPersonalNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * löscht diesen Mitarbeiter und alle Datensätze in anderen Tabellen, die ohne den MA in der DB keinen Sinn machen
     * @param ma der Mitarbeiter
     * @throws Exception 
     */
    public void loeschenMitarbeiter(Mitarbeiter ma)throws Exception{
        List<Notiz> löschList = this.selectAllMyNotizen(ma);
            for(Notiz n:löschList){
                this.loescheNotiz(n);
            }
        connect();   
        String sql1 = "DELETE FROM AKommentar WHERE verfasst_von ="+ ma.getPersonalNr();
        String sql2 = "DELETE FROM PKommentar WHERE verfasst_von ="+ ma.getPersonalNr();
        String sql3 = "DELETE FROM P_MA WHERE wird_bearbeitet_von ="+ ma.getPersonalNr();
        String sql4 = "DELETE FROM AP_MA WHERE wird_bearbeitet_von ="+ ma.getPersonalNr();
        String sql5 = "UPDATE Projekt SET wird_geleitet_von = null WHERE wird_geleitet_von =" + ma.getPersonalNr();
        String sql6 = "DELETE FROM Mitarbeiter WHERE personalNr ="+ ma.getPersonalNr();
        
        ResultSet r1 = executeSQL(sql1);
        ResultSet r2 = executeSQL(sql2);
        ResultSet r3 = executeSQL(sql3);
        ResultSet r4 = executeSQL(sql4);
        ResultSet r5 = executeSQL(sql5);
        ResultSet r6 = executeSQL(sql6);
        con.close();
    }
    
    
/*Block für den Auftraggeber*/
    
    /**
     * Speichert einen Auftraggeberin der DB
     * @param a der Auftraggeber
     * @throws Exception 
     */
    public void speicherAuftraggeber(Auftraggeber a)throws Exception{
        List <Auftraggeber> vergleichAgN = this.selectAllAuftraggebers();
        connect();
        String sql = "INSERT INTO Auftraggeber (name,ansprechpartner,tel,strasse,hausnr,plz,ort) "
               + "VALUES ('" + a.getName() + "','" + a.getAnsprechpartner() + "','" + a.getTel() + "','" + a.getStrasse()
               + "','" + a.getHausNr() + "','" + a.getPlz() + "','" + a.getOrt() + "')";
        LinkedList <String> agN = new LinkedList <String>();
        for (Auftraggeber ag : vergleichAgN){
            agN.add(ag.getName());
        }
        if(!agN.contains(a.getName())){
        ResultSet r = executeSQL(sql);}
        con.close();
    }
    
        /**
         * liest alle Auftrageber aus der DB aus
         * @return eine Liste aller bestehenden Auftraggeber
         */
        public List<Auftraggeber> selectAllAuftraggebers() {
        List<Auftraggeber> auftraggebers = new LinkedList<Auftraggeber>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Auftraggeber";

            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {

                String name = res.getString(1);
                String ansprechpartner = res.getString(2);
                String tel = res.getString(3);
                String str = res.getString(4);
                String hnr = res.getString(5);
                int plz = res.getInt(6);
                String ort = res.getString(7);
                int id = res.getInt(8);
                
                Auftraggeber diesAuftr = new Auftraggeber (name, ansprechpartner, tel, str, hnr, plz, ort);
                diesAuftr.setName(name);
                diesAuftr.setAnsprechpartner(ort);
                diesAuftr.setTel(tel);
                diesAuftr.setStrasse(str);
                diesAuftr.setHausNr(hnr);
                diesAuftr.setPlz(plz);
                diesAuftr.setOrt(ort);
                diesAuftr.setKundenNr(id);
                
                auftraggebers.add(diesAuftr);
            }
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auftraggebers;
    }

    /**
     * Name wird geändert
     * @param a der Auftraggeber wessen Name geändert werden soll
     * @param n der neue Name
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberName(Auftraggeber a, String n)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET name ='" + n + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Ansprechpartner wird geändert
     * @param a der Auftraggeber wessen Ansprechpartner geändert werden soll
     * @param asp der neue Ansprechpartner
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberAnsprechpartner(Auftraggeber a, String asp)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET ansprechpartner ='" + asp + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * tel wird geändert
     * @param a der Auftraggeber wessen tel geändert werden soll
     * @param t die neue tel
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberTel(Auftraggeber a, String t)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET tel ='" + t + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * strasse wird geändert
     * @param a der Auftraggeber wessen strasse geändert werden soll
     * @param s die neue Strasse
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberStrasse(Auftraggeber a, String s)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET strasse ='" + s + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * HausNr wird geändert
     * @param a der Auftraggeber wessen HausNr geändert werden soll
     * @param hnr die neue HausNr
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberHausNr(Auftraggeber a, String hnr)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET hausnr ='" + hnr + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * PLZ wird geändert
     * @param a der Auftraggeber wessen PLZ geändert werden soll
     * @param p die neue PLZ
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberPLZ(Auftraggeber a, int p)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET plz ='" + p + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Ort wird geändert
     * @param a der Auftraggeber wessen Ort geändert werden soll
     * @param o die neue Ort
     * @throws Exception 
     */
    public void bearbeiteAuftraggeberOrt(Auftraggeber a, String o)throws Exception{
        connect();
        String sql = "UPDATE Auftraggeber SET ort ='" + o + "' WHERE KundenNr =" + a.getKundenNr();
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * löscht diesen Auftraggeber
     * @param a der Auftraggeber
     * @throws Exception 
     */
    public void loeschenAuftraggeber(Auftraggeber a)throws Exception{
        connect();
        String sql1 = "DELETE FROM beauftragt WHERE beauftragt_von ="+a.getKundenNr();
        String sql2 = "DELETE FROM Auftraggeber WHERE kundenNr ="+ a.getKundenNr();
        ResultSet r1 = executeSQL(sql1);
        ResultSet r2 = executeSQL(sql2);
        con.close();
    }
    

/*Block für die Kommentare und Notiz*/    
    
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
        String sql = "INSERT INTO AKommentar (text,datum, verfasst_von, gehört_zu) "
                + "VALUES ('" + ak.getText() + "','" + year + "-" + month + "-" + day + "',"+ak.getVerfasser().getPersonalNr()+","+ak.getArbeitspaket().getArbeitspaketNr()+")";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    
    /**
     * Liest alle Kommentare eines Projektes aus der Datenbank
     * @param ap dessen Kommentare ausgelesen werden sollen
     * @param verfasser eine Liste der zum Projekt gehörenden Kommentare
     * @return 
     */
    public List<AKommentar> selectAllAKommentare(Arbeitspaket ap, Mitarbeiter verfasser) {
        List<AKommentar> akommentare = new LinkedList<AKommentar>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM AKommentar WHERE AKommentar.gehört_zu=" + ap.getArbeitspaketNr();

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {

                String text = res.getString(1);
                Date datum = res.getDate(2);
                int id = res.getInt(3);
                int mNr = res.getInt (4);

                GregorianCalendar greg = dateZuGreg(datum);

                AKommentar diesAKommentar = new AKommentar(text, greg, verfasser, ap);
                diesAKommentar.setText(text);
                diesAKommentar.setDatum(greg);
                diesAKommentar.setAKommentarNr(id);
                diesAKommentar.setVerfasser(verfasser);
                diesAKommentar.setArbeitspaket(ap);

                akommentare.add(diesAKommentar);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return akommentare;
    }
    
    /**
     * Speichert ein Kommentar zu einem Projekt in der DB
     * @param pk Kommentar zum projekt
     * @throws Exception 
     */
    public void erstellePKommentar(PKommentar pk)throws Exception{
        connect();
        int year = pk.getDatum().get(Calendar.YEAR);
        int month = pk.getDatum().get(Calendar.MONTH) + 1;
        int day = pk.getDatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO PKommentar (text,datum) "
                + "VALUES ('" + pk.getText() + "','" + year + "-" + month + "-" + day + "'" + pk.getVerfasser().getPersonalNr() + pk.getProjekt().getProjektNr()+")";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Liest alle Kommentare eines Projektes aus der Datenbank
     * @param projekt dessen Kommentare ausgelesen werden sollen
     * @param verfasser eine Liste der zum Projekt gehörenden Kommentare
     * @return 
     */
    public List<PKommentar> selectAllPKommentare(Projekt projekt, Mitarbeiter verfasser) {
        List<PKommentar> pkommentare = new LinkedList<PKommentar>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM PKommentar WHERE PKommentar.gehört_zu=" + projekt.getProjektNr();

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {

                String text = res.getString(1);
                Date datum = res.getDate(2);
                int id = res.getInt(3);
                int mNr = res.getInt (4);

                GregorianCalendar greg = dateZuGreg(datum);

                PKommentar diesPKommentar = new PKommentar(text, greg, verfasser, projekt);
                diesPKommentar.setText(text);
                diesPKommentar.setDatum(greg);
                diesPKommentar.setID(id);
                diesPKommentar.setVerfasser(verfasser);
                diesPKommentar.setProjekt(projekt);

                pkommentare.add(diesPKommentar);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pkommentare;
    }
    
    /**
     * speichert die Notiz in der DB
     * @param n die zu speichernde Notiz
     * @throws Exception 
     */
    public void erstelleNotiz(Notiz n)throws Exception{
        connect();
        int year = n.getDatum().get(Calendar.YEAR);
        int month = n.getDatum().get(Calendar.MONTH) +2;
        int day = n.getDatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO notiz (text,datum, verfasst_von, bezeichnung) "
                + "VALUES ('" + n.getText() + "','" + year + "-" + month + "-" + day + "'," + n.getMitarbeiter().getPersonalNr()+",'"+n.getBez()+"')";
        ResultSet r = executeSQL(sql);
        con.close();
    }
    
    /**
     * Liest alle Notizen eines Mitarbeiters aus der DB
     * @param notiz
     * @param verfasser
     * @return eine Liste aller Notizen die von diesem Mitarbeiter verfasst wurden
     */
    public List<Notiz> selectAllMyNotizen(Mitarbeiter verfasser) {
        List<Notiz> myNotizen = new LinkedList<Notiz>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Notiz WHERE Notiz.verfasst_von=" + verfasser.getPersonalNr();
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {

                String text = res.getString(1);
                Date datum = res.getDate(2);
                int id = res.getInt(3);
                String bez = res.getString(5);

                GregorianCalendar greg = dateZuGreg(datum);
                   
                Notiz dieseNotiz = new Notiz (text, greg, verfasser, bez);
                dieseNotiz.setText(text);
                dieseNotiz.setDatum(greg);
                dieseNotiz.setNotizID(id);
                dieseNotiz.setMitarbeiter(verfasser);
                dieseNotiz.setBez(bez);
                myNotizen.add(dieseNotiz);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myNotizen;
    }
    
    /**
     * löscht eine Notiz
     * @param n Notiz
     * @throws Exception 
     */
    public void loescheNotiz(Notiz n)throws Exception{
        connect();
        String sql = "DELETE FROM Notiz WHERE NotizID ="+ n.getNotitzID();
        ResultSet res = executeSQL(sql);
        con.close();
    }
    
    /**
     * speichert einen Statusbericht in der DB
     * @param sb Statusbericht
     * @throws Exception 
     */
    public void speicherStatusbericht(Statusbericht sb)throws Exception{
        connect();
        int year = sb.getDatum().get(Calendar.YEAR);
        int month = sb.getDatum().get(Calendar.MONTH) + 1;
        int day = sb.getDatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Statusbericht (prozent, gehört_zu, erstellt_am) "
                + "VALUES ('" + sb.getProzent() + "',"+sb.getProjekt().getProjektNr() + ",'"+year + "-" + month + "-" + day + "')";
        ResultSet r = executeSQL(sql);
        con.close();
    }
   
    /**
     * liest alle Statusberichte eines Projektes aus der DB aus
     * @param p Projekt dessen Statusberichte ausgelesen werden sollen
     * @return eine Liste aller vergangenen Statusberichte eines Projektes
     */
    public List<Statusbericht> selectAllStatusberichte(Projekt p){
         List<Statusbericht> projektStatusberichte = new LinkedList<Statusbericht>();
        try {
            connect();
            Statement stmt = con.createStatement();
            String sql = "SELECT* FROM Statusbericht WHERE gehört_zu=" + p.getProjektNr();
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                int prozent = res.getInt(1);
                int id = res.getInt(2);
                Date datum = res.getDate(4);
                
                GregorianCalendar greg = dateZuGreg(datum);
                
                Statusbericht dieserBericht = new Statusbericht (prozent, greg, p);
               
                dieserBericht.setProzent(id);
                dieserBericht.setStatusberichtId(id);
                dieserBericht.setDatum(greg);
                dieserBericht.setProjekt(p);
                
                projektStatusberichte.add(dieserBericht);
            }
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projektStatusberichte;
    }
    
    
}
