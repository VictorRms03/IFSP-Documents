/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;
import jakarta.servlet.RequestDispatcher;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author victo
 */
@WebServlet(name = "processaAtores", urlPatterns = {"/processaAtores"})
public class processaAtores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        AtorDAO dao = null;
        
        RequestDispatcher dispatcher = null;
        
        try {
            
            dao = new AtorDAO();
            
            if ( acao.equals( "prepararAlteracao" ) ) {
            
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Ator ator = dao.obterPorId( id );

                request.setAttribute( "ator", ator );

                dispatcher = request.getRequestDispatcher( "/entidades/atores/alterar.jsp" );
            
            } else if ( acao.equals( "prepararExclusao" ) ) {
                
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Ator ator = dao.obterPorId( id );

                request.setAttribute( "ator", ator );

                dispatcher = request.getRequestDispatcher( "/entidades/atores/excluir.jsp" );
                
            } else if ( acao.equals( "alterar" ) ) {
                
                Ator ator = new Ator();
                
                ator.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                ator.setNome( request.getParameter( "nome" ) );
                ator.setSobrenome( request.getParameter( "sobrenome" ) );
                ator.setDataEstreia( Date.valueOf( LocalDate.parse( request.getParameter( "dataEstreia" ) , 
                        DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );
                
                dao.atualizar( ator );
                
                dispatcher = request.getRequestDispatcher( "/entidades/atores/listagem.jsp" );
                
            } else if ( acao.equals( "excluir" ) ) {
                
                Ator ator = new Ator();
                
                ator.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                
                dao.excluir( ator );
                
                dispatcher = request.getRequestDispatcher( "/entidades/atores/listagem.jsp" );
            
            } else if ( acao.equals( "adicionar" ) ) {
                
                Ator ator = new Ator();
                
                ator.setNome( request.getParameter( "nome" ) );
                ator.setSobrenome( request.getParameter( "sobrenome" ) );
                ator.setDataEstreia( Date.valueOf( LocalDate.parse( request.getParameter( "dataEstreia" ) , 
                        DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );
                
                dao.salvar( ator );
                
                dispatcher = request.getRequestDispatcher("/entidades/atores/listagem.jsp");
                
            }
            
        } catch ( SQLException exc ) {
            
            exc.printStackTrace();
            
        } finally {
            
            if ( dao != null ) {
                try {
                    dao.closeConnection();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
            
        }
        
        if ( dispatcher != null ) {
            dispatcher.forward( request, response );
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
