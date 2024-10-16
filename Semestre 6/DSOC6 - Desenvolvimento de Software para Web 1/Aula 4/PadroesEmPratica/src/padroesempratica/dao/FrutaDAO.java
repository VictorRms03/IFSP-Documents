/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.dao;

import java.sql.SQLException;
import java.util.List;
import padroesempratica.entidades.Fruta;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

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
        String sql = "INSERT INTO fruta( nome, corPredominante ) " + "VALUES( ?, ? );";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getCorPredominante() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Fruta obj) throws SQLException {
        String sql = "UPDATE fruta " + "SET" + " nome = ?, " + " corPredominante = ? " +
            "WHERE" + " id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getCorPredominante());
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Fruta obj) throws SQLException {
        String sql = "DELETE FROM fruta WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Fruta> listarTodos() throws SQLException {
        List<Fruta> lista = new ArrayList<>();
        String sql = "SELECT * FROM fruta;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Fruta fruta = new Fruta();
            fruta.setId( rs.getInt( "id" ) );
            fruta.setNome( rs.getString( "nome" ) );
            fruta.setCorPredominante(rs.getString( "corPredominante" ) );

            lista.add( fruta );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Fruta obterPorId(int id) throws SQLException {
        Fruta fruta = null;
        String sql = "SELECT * FROM fruta WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            fruta = new Fruta();
            fruta.setId( rs.getInt( "id" ) );
            fruta.setNome( rs.getString( "nome" ) );
            fruta.setCorPredominante(rs.getString( "corPredominante" ) );

        }

        rs.close();
        stmt.close();

        return fruta;
    }
    
}
