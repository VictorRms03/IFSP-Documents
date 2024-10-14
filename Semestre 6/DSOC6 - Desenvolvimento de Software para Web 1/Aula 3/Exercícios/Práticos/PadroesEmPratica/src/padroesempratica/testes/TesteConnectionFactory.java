/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.testes;

import java.sql.SQLException;
import padroesempratica.jdbc.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author victo
 */
public class TesteConnectionFactory {
    
    public static void main(String[] args) {
        
        try {
            
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão criada com sucesso!");
            
        } catch(SQLException exc) {
            
            System.err.println("Erro ao tentar criar a conexão!");
            exc.printStackTrace();
            
        }
    }
    
}
