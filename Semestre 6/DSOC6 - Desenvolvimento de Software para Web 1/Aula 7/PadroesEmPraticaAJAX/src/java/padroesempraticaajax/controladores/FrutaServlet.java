/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package padroesempraticaajax.controladores;

import padroesempraticaajax.dao.FrutaDAO;
import padroesempraticaajax.entidades.Fruta;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "FrutaServlet", urlPatterns = {"/processaFruta"})
public class FrutaServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        String acao = request.getParameter("acao");
        FrutaDAO dao = null;
        List<Fruta> lista = new ArrayList<>();
        Jsonb jb = JsonbBuilder.create();
        
        try {
            
            dao = new FrutaDAO();
            
            if ( acao.equals("inserir") ) {
                
                String nome = request.getParameter("nome");
                String cor = request.getParameter("cor");
                
                if ( nome.isBlank() || cor.isBlank() ) {
                    
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    PrintWriter pw = response.getWriter();
                    pw.print("{\"status\": \"falha\", \"mensagem\": \"Campos em branco!\"}");
                } else {
                    Fruta fruta = new Fruta();
                
                    fruta.setNomeFruta(nome);
                    fruta.setCorFruta(cor);

                    dao.salvar(fruta);
                    PrintWriter pw = response.getWriter();
                    pw.print("{\"status\": \"sucesso\", \"mensagem\": \"Fruta inserida com sucesso!\"}");
                }
            } else if ( acao.equals("listar") ) {
                lista = dao.listarTodos();
                PrintWriter pw = response.getWriter();
                pw.print(jb.toJson(lista));
            }
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            PrintWriter pw = response.getWriter();
            pw.print("{\"status\": \"erro\", \"mensagem\": \"Erro no servidor.\"}");
        } finally{
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
