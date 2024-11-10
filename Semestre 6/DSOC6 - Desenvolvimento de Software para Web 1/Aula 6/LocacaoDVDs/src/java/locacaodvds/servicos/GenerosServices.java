/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author victo
 */
public class GenerosServices {
    
    public List<Genero> getTodos() {
        
        List<Genero> generos = new ArrayList<>();
        GeneroDAO dao = null;
        
        try {
            
            dao = new GeneroDAO();
            generos = dao.listarTodos();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            if ( dao != null ) {
                try {
                    dao.closeConnection();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }
        
        return generos;
    }
}
