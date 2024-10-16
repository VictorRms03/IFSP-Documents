/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.testes;

import padroesempratica.dao.CarroDAO;
import padroesempratica.entidades.Carro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class TesteCarroDAO {
    
    public static void main(String[] args) {
        
        CarroDAO dao = null;
        
        try {
            dao = new CarroDAO();  
        } catch (SQLException e) { 
            e.printStackTrace();  
        }
        
        //SALVAR
        Carro carroSalvar = new Carro();
        carroSalvar.setNome("Volkswagen");
        carroSalvar.setModelo("Fox 1.6");
        carroSalvar.setAno(2012);

        try {
            dao.salvar(carroSalvar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //ATUALIZAR
        Carro carroAtualizar = new Carro();
        carroAtualizar.setId(1);
        carroAtualizar.setNome("Ford");
        carroAtualizar.setModelo("Fiesta 1.0");
        carroAtualizar.setAno(2008);
        
        try {
            dao.atualizar(carroAtualizar);
        } catch(SQLException e) {
            e.printStackTrace();
        }  
        
        //OBTER POR ID
        Carro carroObterPorId = null;
        try {
            carroObterPorId = dao.obterPorId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(carroObterPorId);
        
        //LISTAR TODOS
        List<Carro> lista = null;
        try {
            lista = dao.listarTodos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(Carro carroListarTodos : lista) {
            System.out.println(carroListarTodos);
        }
        
        // TESTE DE EXCLUIR
        Carro carroExcluir = new Carro();
        carroExcluir.setId(1);

        try {
            dao.excluir(carroExcluir);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
