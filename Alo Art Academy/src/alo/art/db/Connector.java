/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alo.art.db;

import static alo.art.db.Constants.PASSWORD;
import static alo.art.db.Constants.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuski-Revolve
 */
public class Connector {
    
    public Connection getConnection() {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dbURL2 = "jdbc:derby://localhost:1527/AloArtDB;";
        String user = "HabibDB";
        String password = "habib2017";
        //Connection conn = DriverManager.getConnection(dbURL2, user, password);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby:AloArtDB;", USERNAME, PASSWORD);
            // call me
        } catch (Exception ex) {
            try {
                conn = DriverManager.getConnection("jdbc:derby:AloArtDB;create=true;", USERNAME, PASSWORD);
             PreparedStatement prpd = conn.prepareStatement("CREATE TABLE SUBLIST(SUBJECT VARCHAR(20)");
            ResultSet rs = prpd.executeQuery();
   PreparedStatement prpd2 = conn.prepareStatement("CREATE TABLE BATCHLIST(BATCH VARCHAR(20)");
            ResultSet rs2 = prpd2.executeQuery();
            } catch (SQLException exx) {}
        }
        return conn;   
    }
    
}
