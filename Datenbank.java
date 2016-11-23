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

/**
 *
 * @author Evelyne
 */
public class Datenbank {
    
    private ProjektVerwaltung projektV;
    private ArbeitspaketVerwaltung arbeitspaketV;
    private BenutzerVerwaltung mitarbeiterV;
    
    Connection con = null;

    public void init() throws Exception {
    //    try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
// Verbindungsaufbau mit einer HSQLDB-Datei:
            con = DriverManager.getConnection("jdbc:hsqldb:file:data/swt", "SA", "");
/*
        } catch (Exception e) {
            throw new Exception();
            System.err.println("Fehler beim Datenbankzugriff: " + e.getMessage());
            e.printStackTrace();
            return;
        }
*/
    }

    private ResultSet executeSQL(String sql) throws Exception{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            return res;
        /*} catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
    }
    public GregorianCalendar dateZuGreg(Date date){
        GregorianCalendar greg = new GregorianCalendar(); 
        greg.setGregorianChange(date);
        
        return greg;
    }
    
    public void speicherProjekt(Projekt projekt) throws Exception{
        int year = projekt.getDeadline().get(Calendar.YEAR);
        int month = projekt.getDeadline().get(Calendar.MONTH)+1;
        int day = projekt.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Projekt (name,beschreibung,deadline) "
                + "VALUES ('" + projekt.getname() + "','" + projekt.getbeschreibung() + "','" + year + "-" + month + "-" + day + "')";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        //hier wird die ID rein gespeichert
    }
    // Nur zum Testen:
    public static void main (String[]args){
        Datenbank m =new Datenbank();
        m.selectAllProjects();
    }
    public void selectAllProjects(){
        
        try{
            Statement stmt = con.createStatement();
            String sql= "SELECT* FROM Projekt";
        
            ResultSet res = stmt.executeQuery(sql);
            while(res.next()){
         
                String name = res.getString(1);
                String beschreibung = res.getString(2);
                Date deadline = res.getDate(3);
                int id = res.getInt(4);
                GregorianCalendar greg = dateZuGreg(deadline);
                
                Projekt neuesProjekt = new Projekt(name, beschreibung, greg);
                neuesProjekt.setName(name);
                neuesProjekt.setBeschreibung(beschreibung);
                neuesProjekt.setDeadline(greg);
                neuesProjekt.setProjektNr(id);
               // System.out.println("Das Projekt heißt: "+name+"\nHier die Beschreibung: "+beschreibung);
                projektV.getProjekte().add(neuesProjekt);
            }
            res.close();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();}
        }
    
    public void abrufeProjekt(String sql)throws Exception{
        ResultSet r = executeSQL(sql);
    }

    public void speicherArbeitspaket(Arbeitspaket arbeitspaket) throws Exception {
        int year = arbeitspaket.getDeadline().get(Calendar.YEAR);
        int month = arbeitspaket.getDeadline().get(Calendar.MONTH)+1;
        int day = arbeitspaket.getDeadline().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Arbeitspaket (name,fertig,beschreibung,deadline) "
                + "(VALUES (" + arbeitspaket.getName() + "," + arbeitspaket.getFertig() + "," 
                + arbeitspaket.getBeschreibung() + "," + year + "-" + month + "-" + day + "')";
        ResultSet r = executeSQL(sql);
    }
    
    public void abrufeArbeitspaket(String sql)throws Exception{
        ResultSet r = executeSQL(sql);
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
    
     
    }



   

