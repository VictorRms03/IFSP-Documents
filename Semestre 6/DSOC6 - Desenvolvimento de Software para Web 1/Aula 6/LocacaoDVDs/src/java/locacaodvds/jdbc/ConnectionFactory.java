/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author victo
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection( 
                "jdbc:mariadb://localhost/locacao_dvds", 
                "root", 
                "" );
    }
}
