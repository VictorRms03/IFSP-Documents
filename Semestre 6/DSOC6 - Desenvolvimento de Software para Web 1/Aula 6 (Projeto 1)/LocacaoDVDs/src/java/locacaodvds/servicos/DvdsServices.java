/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Dvd;

/**
 *
 * @author victo
 */
public class DvdsServices {
    
    public List<Dvd> getTodos() {
        
        List<Dvd> dvds = new ArrayList<>();
        DvdDAO dao = null;
        
        try {
            
            dao = new DvdDAO();
            dvds = dao.listarTodos();
            
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
        
        return dvds;
    }
    
}
