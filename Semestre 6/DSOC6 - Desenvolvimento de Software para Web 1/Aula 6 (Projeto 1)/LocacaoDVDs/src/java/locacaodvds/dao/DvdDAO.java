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
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

/**
 *
 * @author victo
 */
public class DvdDAO extends DAO<Dvd> {
    
    public DvdDAO() throws SQLException {
    }


    @Override
    public void salvar( Dvd obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " +
                "dvd( titulo, ano_lancamento, ator_principal_id, "
                        + "ator_coadjuvante_id, data_lancamento, "
                        + "duracao_minutos, classificacao_etaria_id, "
                        + "genero_id ) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ? );" );
        
        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        stmt.setDate( 5, obj.getDataLancamento() );
        stmt.setInt( 6, obj.getDuracaoMinutos() );
        stmt.setInt( 7, obj.getClassificacaoEtaria().getId() );
        stmt.setInt( 8, obj.getGenero().getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar( Dvd obj ) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE dvd " +
                "SET titulo = ?, ano_lancamento = ?, ator_principal_id = ?, "
                        + "ator_coadjuvante_id = ?, data_lancamento = ?, "
                        + "duracao_minutos = ?, classificacao_etaria_id = ?, "
                        + "genero_id = ? " +
                "WHERE id = ?;" );
        
        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        stmt.setDate( 5, obj.getDataLancamento() );
        stmt.setInt( 6, obj.getDuracaoMinutos() );
        stmt.setInt( 7, obj.getClassificacaoEtaria().getId() );
        stmt.setInt( 8, obj.getGenero().getId() );
        stmt.setInt( 9, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(Dvd obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM dvd " +
                "WHERE id = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<Dvd> listarTodos() throws SQLException {
        
        List<Dvd> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT d.id idDvd, "
                        + "d.titulo tituloDvd, "
                        + "d.ano_lancamento anoLancamentoDvd, "
                        + "d.data_lancamento dataLancamentoDvd, "
                        + "d.duracao_minutos duracaoMinutosDvd, "
                        + "ap.id idAtorPrincipal, "
                        + "ap.nome nomeAtorPrincipal, "
                        + "ap.sobrenome sobrenomeAtorPrincipal, "
                        + "ap.data_estreia dataEstreiaAtorPrincipal, "
                        + "ac.id idAtorCoadjuvante, "
                        + "ac.nome nomeAtorCoadjuvante, "
                        + "ac.sobrenome sobrenomeAtorCoadjuvante, "
                        + "ac.data_estreia dataEstreiaAtorCoadjuvante, "
                        + "ce.id idClassificacaoEtaria, "
                        + "ce.descricao descricaoClassificacaoEtaria, "
                        + "g.id idGenero, "
                        + "g.descricao descricaoGenero " +
                "FROM dvd d, "
                        + "ator ap, "
                        + "ator ac, "
                        + "classificacao_etaria ce, "
                        + "genero g " + 
                "WHERE d.ator_principal_id = ap.id AND "
                        + "d.ator_coadjuvante_id = ac.id AND "
                        + "d.classificacao_etaria_id = ce.id AND "
                        + "d.genero_id = g.id " +
                "ORDER BY d.titulo, "
                        + "d.ano_lancamento, "
                        + "g.id, "
                        + "d.duracao_minutos ;" );
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            Genero genero = new Genero();
            genero.setId( rs.getInt( "idGenero" ) );
            genero.setDescricao( rs.getString( "descricaoGenero" ) );
            
            ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
            classificacaoEtaria.setId( rs.getInt( "idClassificacaoEtaria" ) );
            classificacaoEtaria.setDescricao( rs.getString( "descricaoClassificacaoEtaria" ) );
            
            Ator atorPrincipal = new Ator();
            atorPrincipal.setId( rs.getInt( "idAtorPrincipal" ) );
            atorPrincipal.setNome( rs.getString( "nomeAtorPrincipal" ) );
            atorPrincipal.setSobrenome( rs.getString( "sobrenomeAtorPrincipal" ));
            atorPrincipal.setDataEstreia( rs.getDate( "dataEstreiaAtorPrincipal" ) );
            
            Ator atorCoadjuvante = new Ator();
            atorCoadjuvante.setId( rs.getInt( "idAtorCoadjuvante" ) );
            atorCoadjuvante.setNome( rs.getString( "nomeAtorCoadjuvante" ) );
            atorCoadjuvante.setSobrenome( rs.getString( "sobrenomeAtorCoadjuvante" ));
            atorCoadjuvante.setDataEstreia( rs.getDate( "dataEstreiaAtorCoadjuvante" ) );
            
            Dvd dvd = new Dvd();
            dvd.setId( rs.getInt( "idDvd" ) );
            dvd.setTitulo( rs.getString( "tituloDvd" ) );
            dvd.setAnoLancamento( rs.getInt( "anoLancamentoDvd" ) );
            dvd.setDataLancamento( rs.getDate( "dataLancamentoDvd" ) );
            dvd.setDuracaoMinutos( rs.getInt( "duracaoMinutosDvd" ) );
            dvd.setAtorPrincipal( atorPrincipal );
            dvd.setAtorCoadjuvante( atorCoadjuvante );
            dvd.setClassificacaoEtaria( classificacaoEtaria );
            dvd.setGenero( genero );
            
            
            lista.add( dvd );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public Dvd obterPorId( int id ) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT d.id idDvd, "
                        + "d.titulo tituloDvd, "
                        + "d.ano_lancamento anoLancamentoDvd, "
                        + "d.data_lancamento dataLancamentoDvd, "
                        + "d.duracao_minutos duracaoMinutosDvd, "
                        + "ap.id idAtorPrincipal, "
                        + "ap.nome nomeAtorPrincipal, "
                        + "ap.sobrenome sobrenomeAtorPrincipal, "
                        + "ap.data_estreia dataEstreiaAtorPrincipal, "
                        + "ac.id idAtorCoadjuvante, "
                        + "ac.nome nomeAtorCoadjuvante, "
                        + "ac.sobrenome sobrenomeAtorCoadjuvante, "
                        + "ac.data_estreia dataEstreiaAtorCoadjuvante, "
                        + "ce.id idClassificacaoEtaria, "
                        + "ce.descricao descricaoClassificacaoEtaria, "
                        + "g.id idGenero, "
                        + "g.descricao descricaoGenero " +
                "FROM dvd d, "
                        + "ator ap, "
                        + "ator ac, "
                        + "classificacao_etaria ce, "
                        + "genero g " + 
                "WHERE d.id = ? AND "
                        + "d.ator_principal_id = ap.id AND "
                        + "d.ator_coadjuvante_id = ac.id AND "
                        + "d.classificacao_etaria_id = ce.id AND "
                        + "d.genero_id = g.id" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        Dvd dvd = null;
        
        if ( rs.next() ) {
            
            Genero genero = new Genero();
            genero.setId( rs.getInt( "idGenero" ) );
            genero.setDescricao( rs.getString( "descricaoGenero" ) );
            
            ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
            classificacaoEtaria.setId( rs.getInt( "idClassificacaoEtaria" ) );
            classificacaoEtaria.setDescricao( rs.getString( "descricaoClassificacaoEtaria" ) );
            
            Ator atorPrincipal = new Ator();
            atorPrincipal.setId( rs.getInt( "idAtorPrincipal" ) );
            atorPrincipal.setNome( rs.getString( "nomeAtorPrincipal" ) );
            atorPrincipal.setSobrenome( rs.getString( "sobrenomeAtorPrincipal" ));
            atorPrincipal.setDataEstreia( rs.getDate( "dataEstreiaAtorPrincipal" ) );
            
            Ator atorCoadjuvante = new Ator();
            atorCoadjuvante.setId( rs.getInt( "idAtorCoadjuvante" ) );
            atorCoadjuvante.setNome( rs.getString( "nomeAtorCoadjuvante" ) );
            atorCoadjuvante.setSobrenome( rs.getString( "sobrenomeAtorCoadjuvante" ));
            atorCoadjuvante.setDataEstreia( rs.getDate( "dataEstreiaAtorCoadjuvante" ) );
            
            dvd = new Dvd();
            dvd.setId( rs.getInt( "idDvd" ) );
            dvd.setTitulo( rs.getString( "tituloDvd" ) );
            dvd.setAnoLancamento( rs.getInt( "anoLancamentoDvd" ) );
            dvd.setDataLancamento( rs.getDate( "dataLancamentoDvd" ) );
            dvd.setDuracaoMinutos( rs.getInt( "duracaoMinutosDvd" ) );
            dvd.setAtorPrincipal( atorPrincipal );
            dvd.setAtorCoadjuvante( atorCoadjuvante );
            dvd.setClassificacaoEtaria( classificacaoEtaria );
            dvd.setGenero( genero );
            
        }
        
        rs.close();
        stmt.close();
        
        return dvd;
        
    }
    
}
