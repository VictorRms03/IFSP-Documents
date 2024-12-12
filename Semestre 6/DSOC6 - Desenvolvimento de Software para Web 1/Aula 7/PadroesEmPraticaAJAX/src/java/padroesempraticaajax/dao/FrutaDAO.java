/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempraticaajax.dao;

import padroesempraticaajax.entidades.Fruta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class FrutaDAO extends DAO<Fruta> {
    
    public FrutaDAO() throws SQLException{
        super();
    }

    @Override
    public void salvar(Fruta obj) throws SQLException {
        String sql = "INSERT INTO fruta(nome, cor) " +
                "VALUES(?, ?);";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNomeFruta());
        stmt.setString(2, obj.getCorFruta());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Fruta obj) throws SQLException {
        String sql = "UPDATE fruta " +
                "SET" +
                "   nome = ?, " +
                "   cor = ?" +
                "WHERE" +
                "   idfruta = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNomeFruta());
        stmt.setString(2, obj.getCorFruta());
        stmt.setInt(3, obj.getIdFruta());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Fruta obj) throws SQLException {
        String sql = "DELETE FROM fruta WHERE idfruta = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, obj.getIdFruta());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Fruta> listarTodos() throws SQLException {
        List<Fruta> lista = new ArrayList<>();
        String sql = "SELECT * FROM fruta;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Fruta fruta = new Fruta();
            fruta.setIdFruta(rs.getInt("idfruta"));
            fruta.setNomeFruta(rs.getString("nome"));
            fruta.setCorFruta(rs.getString("cor"));
            
            lista.add(fruta);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Fruta obterPorId(int id) throws SQLException {
        Fruta fruta = null;
        String sql = "SELECT * FROM fruta WHERE idfruta = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
          fruta = new Fruta();
          fruta.setIdFruta(rs.getInt("idfruta"));
          fruta.setNomeFruta(rs.getString("nome"));
          fruta.setCorFruta(rs.getString("cor"));
        }
        
        rs.close();
        stmt.close();
        
        return fruta;
    }    
}
