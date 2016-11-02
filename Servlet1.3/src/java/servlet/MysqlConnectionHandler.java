/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tonix
 */
public class MysqlConnectionHandler {

    private Connection conn = null;
    private final String url = "jdbc:mysql://localhost:3306/accesdades";
    private final String user = "root";
    private final String password = "";

    public Connection doConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conectado a " + conn.toString());
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Conexión no válida url, usuario o clave incorrecta ");
            //if (e.Number == 18456) { // invalid login
            e.printStackTrace();
            return null;
        }catch (ClassNotFoundException e) {
            System.out.println("Error driver");
            //if (e.Number == 18456) { // invalid login
            e.printStackTrace();
            return null;
        
        }
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo al cerrar la conexión");
        }
    }
}
