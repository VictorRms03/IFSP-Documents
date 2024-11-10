/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author victo
 */
public class ClassificacaoEtariaServices {
    
    public List<ClassificacaoEtaria> getTodos() {
        
        List<ClassificacaoEtaria> classificacaoEtarias = new ArrayList<>();
        ClassificacaoEtariaDAO dao = null;
        
        try {
            
            dao = new ClassificacaoEtariaDAO();
            classificacaoEtarias = dao.listarTodos();
            
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
        
        return classificacaoEtarias;
    }
}
