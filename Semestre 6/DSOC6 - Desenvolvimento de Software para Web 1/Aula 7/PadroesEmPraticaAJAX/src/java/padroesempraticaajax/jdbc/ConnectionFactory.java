/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempraticaajax.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection("jdbc:mariadb://localhost/testes_padroes",
                "root",
                "");
        
    }
}
