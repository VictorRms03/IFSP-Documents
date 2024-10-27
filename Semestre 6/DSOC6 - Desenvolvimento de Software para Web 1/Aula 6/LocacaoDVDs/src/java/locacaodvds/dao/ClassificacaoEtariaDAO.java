/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author victo
 */
public class ClassificacaoEtariaDAO extends DAO<ClassificacaoEtaria> {
    
    public ClassificacaoEtariaDAO() throws SQLException {
    }


    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " +
                "classificacao_etaria( descricao ) " +
                "VALUES (?);" );
        
        stmt.setString( 1, obj.getDescricao() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE classificacao_etaria " +
                "SET descricao = ? " +
                "WHERE id = ?;" );
        
        stmt.setString( 1, obj.getDescricao() );
        stmt.setInt( 2, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM classificacao_etaria " +
                "WHERE id = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<ClassificacaoEtaria> listarTodos() throws SQLException {
        
        List<ClassificacaoEtaria> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * " +
                "FROM classificacao_etaria " +
                "ORDER BY descricao " );
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
            
            classificacaoEtaria.setId( rs.getInt( "id" ) );
            classificacaoEtaria.setDescricao( rs.getString( "descricao" ) );
            
            lista.add(classificacaoEtaria);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public ClassificacaoEtaria obterPorId( int id ) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT * " +
                "FROM classificacao_etaria " +
                "WHERE id = ?;" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        ClassificacaoEtaria classificacaoEtaria = null;
        
        if ( rs.next() ) {
            
            classificacaoEtaria = new ClassificacaoEtaria();
            
            classificacaoEtaria.setId( rs.getInt("id") );
            classificacaoEtaria.setDescricao(rs.getString("descricao") ); 
            
        }
        
        rs.close();
        stmt.close();
        
        return classificacaoEtaria;
        
    }
    
}
