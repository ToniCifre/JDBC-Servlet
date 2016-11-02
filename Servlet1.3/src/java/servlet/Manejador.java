/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tonix
 */
public class Manejador {

    MysqlConnectionHandler mc = new MysqlConnectionHandler();
    Connection conn = mc.doConnection();

    public ResultSet getResultSet() {
        try {
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM alumne");
            return rs;
        } catch (Exception e) {
            System.err.println("Errir en getStamen()");
        }
        return null;
    }
    
    public ResultSet getAlumne(String alumnCode) throws SQLException {
        Statement st = (Statement) conn.createStatement();
        ResultSet rs;
        String query = "select nom from alumne where codi=" + alumnCode + ";";
        rs = st.executeQuery(query);
        return rs;
    }

    public ResultSet getTutories(String alumnCode) throws SQLException {
        Statement st = (Statement) conn.createStatement();
        ResultSet rs;
        String query = "select nom from tutoria left join tutoriaalumne on "
                + "tutoria.codi=tutoriaalumne.codiTutoria where "
                + "tutoriaalumne.codiAlumne=" + alumnCode + ";";
        rs = st.executeQuery(query);
        return rs;
    }

    public ResultSet getAsignatures(String alumnCode) throws SQLException {
        Statement st = (Statement) conn.createStatement();
        ResultSet rs;
        String query = "select assignatura.nom from assignatura "
                + "inner join tutoria on assignatura.codi=tutoria.codiAssignatura "
                + "inner join tutoriaalumne on tutoriaalumne.codiTutoria=tutoria.codi "
                + "where tutoriaalumne.codiAlumne=" + alumnCode + ";";
        rs = st.executeQuery(query);
        return rs;
    }
}
