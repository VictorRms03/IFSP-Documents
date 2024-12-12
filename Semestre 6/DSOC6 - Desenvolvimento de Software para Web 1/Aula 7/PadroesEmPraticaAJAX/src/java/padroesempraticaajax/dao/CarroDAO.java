/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempraticaajax.dao;

import padroesempraticaajax.entidades.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CarroDAO extends DAO<Carro>{
    
    public CarroDAO() throws SQLException{
        super();
    }

    @Override
    public void salvar(Carro obj) throws SQLException {
        String sql = "INSERT INTO carro(nome, modelo, anoFabricacao) " +
                "VALUES(?, ?, ?);";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getModelo());
        stmt.setInt(3, obj.getAnoFabricacao());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Carro obj) throws SQLException {
        String sql = "UPDATE carro " +
                "SET" +
                "   nome = ?, " +
                "   modelo = ?," +
                "   anoFabricacao = ? " +
                "WHERE" +
                "   idcarro = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getModelo());
        stmt.setInt(3, obj.getAnoFabricacao());
        stmt.setInt(4, obj.getIdCarro());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Carro obj) throws SQLException {
        String sql = "DELETE FROM carro WHERE idcarro = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, obj.getIdCarro());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Carro> listarTodos() throws SQLException {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM carro;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Carro carro = new Carro();
            carro.setIdCarro(rs.getInt("idcarro"));
            carro.setNome(rs.getString("nome"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAnoFabricacao(rs.getInt("anoFabricacao"));
            
            lista.add(carro);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Carro obterPorId(int id) throws SQLException {
        Carro carro = null;
        String sql = "SELECT * FROM carro WHERE idcarro = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
          carro = new Carro();
          carro.setIdCarro(rs.getInt("idcarro"));
          carro.setNome(rs.getString("nome"));
          carro.setModelo(rs.getString("modelo"));
          carro.setAnoFabricacao(rs.getInt("anoFabricacao"));
        }
        
        rs.close();
        stmt.close();
        
        return carro;
    }    
}
