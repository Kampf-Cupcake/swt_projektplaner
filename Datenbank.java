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

/**
 *
 * @author Evelyne
 */
public class Datenbank {

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

    public void speicherProjekt(Projekt projekt) throws Exception{
        int year = projekt.getdatum().get(Calendar.YEAR);
        int month = projekt.getdatum().get(Calendar.MONTH)+1;
        int day = projekt.getdatum().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO Projekt (name,beschreibung,deadline) VALUES ('" + projekt.getname() + "','" + projekt.getbeschreibung() + "','" + year + "-" + month + "-" + day + "')";
        System.out.println(sql);
        ResultSet r = executeSQL(sql);
        //hier wird die ID rein gespeichert
    }

    public void speicherArbeitspaket(String name, boolean fertig, String beschreibung, Date datum) throws Exception {
        String sql = "INSERT INTO Arbeitspaket (name,fertig,beschreibung,deadline) (VALUES (" + name + "," + fertig + "," + beschreibung + "," + datum + ")";
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
