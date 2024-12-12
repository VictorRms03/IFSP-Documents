/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package padroesempraticaajax.controladores;

import padroesempraticaajax.dao.CarroDAO;
import padroesempraticaajax.entidades.Carro;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "CarroServlet", urlPatterns = {"/processaCarro"})
public class CarroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        
        String acao = request.getParameter("acao");
        CarroDAO dao = null;
        List<Carro> lista = new ArrayList<>();
        Jsonb jb = JsonbBuilder.create();
        
        try {
            
            dao = new CarroDAO();
            
            if ( acao.equals("inserir") ) {
                
                String nome = request.getParameter("nome");
                String modelo = request.getParameter("modelo");
                String anoFabricacaoString = request.getParameter("anoFabricacao");

                    
                try {
                   int anoFabricacao = Integer.parseInt(request.getParameter("anoFabricacao"));

                   if ( anoFabricacao > 0 ) {
                       Carro carro = new Carro();

                       carro.setNome(nome);
                       carro.setModelo(modelo);
                       carro.setAnoFabricacao(anoFabricacao);

                       dao.salvar(carro);

                   } else {
                       response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                       PrintWriter pw = response.getWriter();
                       pw.print("{\"status\": \"falha\", \"mensagem\": \"Ano de fabricação deve ser um inteiro positivo!\"}");
                   }   
                } catch ( NumberFormatException e ) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    PrintWriter pw = response.getWriter();
                    pw.print("{\"status\": \"falha\", \"mensagem\": \"Somentos números são aceitos no Ano de Fabricação!\"}");
                }
                
                
            } else if (acao.equals("listar")) {
                lista = dao.listarTodos();
                PrintWriter pw = response.getWriter();
                pw.print(jb.toJson(lista));
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            PrintWriter pw = response.getWriter();
            pw.print("{\"status\": \"erro\", \"mensagem\": \"Erro no servidor.\"}");
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
