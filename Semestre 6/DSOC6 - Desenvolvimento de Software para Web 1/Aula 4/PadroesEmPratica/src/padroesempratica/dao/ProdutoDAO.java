/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.dao;

import java.sql.SQLException;
import java.util.List;
import padroesempratica.entidades.Produto;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author victo
 */
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() throws SQLException {
        super();
    }
    
    @Override
    public void salvar(Produto obj) throws SQLException {
        String sql = "INSERT INTO produto( descricao, quantidadeEmEstoque ) " + "VALUES( ?, ? );";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getDescricao() );
        stmt.setInt( 2, obj.getQuantidadeEmEstoque() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Produto obj) throws SQLException {
        String sql = "UPDATE produto " + "SET" + " descricao = ?, " + " quantidadeEmEstoque = ? " +
            "WHERE" + " id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getDescricao());
        stmt.setInt( 2, obj.getQuantidadeEmEstoque());
        stmt.setInt( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Produto obj) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Produto produto = new Produto();
            produto.setId( rs.getInt( "id" ) );
            produto.setDescricao(rs.getString( "descricao" ) );
            produto.setQuantidadeEmEstoque(rs.getInt( "quantidadeEmEstoque" ) );

            lista.add( produto );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Produto obterPorId(int id) throws SQLException {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

        produto = new Produto();
        produto.setId( rs.getInt( "id" ) );
        produto.setDescricao( rs.getString( "descricao" ) );
        produto.setQuantidadeEmEstoque( rs.getInt( "quantidadeEmEstoque" ) );

        }

        rs.close();
        stmt.close();

        return produto;
    }
    
}
