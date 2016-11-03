/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Evelyne
 */
public class myfirsthsqlconnection {

    public static void main(String args[]) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
// Verbindungsaufbau mit einer HSQLDB-Datei:
            Connection c = DriverManager.getConnection("jdbc:hsqldb:file:data/Artikel", "SA", "");
            Statement stmt = c.createStatement();
            ResultSet rst = stmt.executeQuery(
                    "SELECT * FROM Artikel, \"Lieferant_in\" WHERE Artikel.lieferant_in = \"Lieferant_in\".\"id\"");
            while (rst.next()) {
                System.out.println(rst.getString("Lieferant_in.name") + ": " + rst.getString("Artikel.name"));
            }
            stmt.execute("SHUTDOWN");
            stmt.close();
            c.close();
        } catch (Exception exc) {
            System.err.println("Fehler beim Datenbankzugriff: " + exc.getMessage());
            exc.printStackTrace();
            return;
        }
    }
}
