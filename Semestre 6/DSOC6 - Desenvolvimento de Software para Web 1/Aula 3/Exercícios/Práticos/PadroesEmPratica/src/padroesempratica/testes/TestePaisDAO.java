/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.testes;

import padroesempratica.dao.FrutaDAO;
import padroesempratica.entidades.Fruta;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class TestePaisDAO {
    
    public static void main(String[] args) {
        
        Fruta fruta = new Fruta();
        
        fruta.setNome("Maca");
        fruta.setCorPredominante("Vermelho");
        
        FrutaDAO dao = null;
        
        try {
            
            dao = new FrutaDAO();
            dao.salvar( fruta );
            
        } catch ( SQLException exc ) {
            
            exc.printStackTrace();
            
        } finally {
            
            if (dao != null) {
                
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    System.err.println("Erro ao fechar a conexão!");
                    exc.printStackTrace();
                }
                
            }
        }
    }
    
}
