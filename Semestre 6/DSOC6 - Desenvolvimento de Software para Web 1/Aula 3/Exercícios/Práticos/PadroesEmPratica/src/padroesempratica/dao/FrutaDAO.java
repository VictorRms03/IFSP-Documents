/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import padroesempratica.entidades.Fruta;

/**
 *
 * @author victo
 */
public class FrutaDAO extends DAO<Fruta> {

    public FrutaDAO() throws SQLException {
        super();
    }
    
    @Override
    public void salvar(Fruta obj) throws SQLException {
        
        String sql = "INSERT INTO fruta( nome, corPredominante ) VALUES ( ?, ? );";
        
        PreparedStatement stmt =  getConnection().prepareStatement( sql );
        stmt.setString(1, obj.getNome() );
        stmt.setString(2, obj.getCorPredominante());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(Fruta obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Fruta obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Fruta> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fruta obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
