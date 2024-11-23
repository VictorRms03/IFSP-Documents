/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class AtoresServices {
    
    public List<Ator> getTodos() {
        
        List<Ator> atores = new ArrayList<>();
        AtorDAO dao = null;
        
        try {
            
            dao = new AtorDAO();
            atores = dao.listarTodos();
            
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
        
        return atores;
    }
    
}
