/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.testes;

import padroesempratica.dao.ProdutoDAO;
import padroesempratica.entidades.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class TesteProdutoDAO {
    
    public static void main(String[] args) {
        
        ProdutoDAO dao = null;
        
        try {
            dao = new ProdutoDAO();  
        } catch (SQLException e) { 
            e.printStackTrace();  
        }
        
        //SALVAR
        Produto produtoSalvar = new Produto();
        produtoSalvar.setDescricao("Sabonete 200g");
        produtoSalvar.setQuantidadeEmEstoque(10);

        try {
            dao.salvar(produtoSalvar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //ATUALIZAR
        Produto produtoAtualizar = new Produto();
        produtoAtualizar.setId(1);
        produtoAtualizar.setDescricao("Alvejante 500ml");
        produtoAtualizar.setQuantidadeEmEstoque(20);
        
        try {
            dao.atualizar(produtoAtualizar);
        } catch(SQLException e) {
            e.printStackTrace();
        }  
        
        //OBTER POR ID
        Produto produtoObterPorId = null;
        try {
            produtoObterPorId = dao.obterPorId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(produtoObterPorId);
        
        //LISTAR TODOS
        List<Produto> lista = null;
        try {
            lista = dao.listarTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(Produto produtoListarTodos : lista) {
            System.out.println(produtoListarTodos);
        }
        
        // TESTE DE EXCLUIR
        Produto produtoExcluir = new Produto();
        produtoExcluir.setId(1);

        try {
            dao.excluir(produtoExcluir);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
