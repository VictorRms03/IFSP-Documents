/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.testes;

import padroesempratica.dao.FrutaDAO;
import padroesempratica.entidades.Fruta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class TesteFrutaDAO {
    
    public static void main(String[] args) {
        
        FrutaDAO dao = null;
        
        try {
            dao = new FrutaDAO();  
        } catch (SQLException e) { 
            e.printStackTrace();  
        }
        
        //SALVAR
        Fruta frutaSalvar = new Fruta();
        frutaSalvar.setNome("Maca");
        frutaSalvar.setCorPredominante("Vermelho");

        try {
            dao.salvar(frutaSalvar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //ATUALIZAR
        Fruta frutaAtualizar = new Fruta();
        frutaAtualizar.setId(1);
        frutaAtualizar.setNome("Maca");
        frutaAtualizar.setCorPredominante("Verde");
        
        try {
            dao.atualizar(frutaAtualizar);
        } catch(SQLException e) {
            e.printStackTrace();
        }  
        
        //OBTER POR ID
        Fruta frutaObterPorId = null;
        try {
            frutaObterPorId = dao.obterPorId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(frutaObterPorId);
        
        //LISTAR TODOS
        List<Fruta> lista = null;
        try {
            lista = dao.listarTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(Fruta frutaListarTodos : lista) {
            System.out.println(frutaListarTodos);
        }
        
        // TESTE DE EXCLUIR
        Fruta frutaExcluir = new Fruta();
        frutaExcluir.setId(1);

        try {
            dao.excluir(frutaExcluir);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
