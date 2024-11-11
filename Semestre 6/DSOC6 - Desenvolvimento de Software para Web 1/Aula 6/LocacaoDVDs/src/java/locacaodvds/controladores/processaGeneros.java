/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author victo
 */
@WebServlet(name = "processaGeneros", urlPatterns = {"/processaGeneros"})
public class processaGeneros extends HttpServlet {

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
        
        GeneroDAO dao = null;
        
        RequestDispatcher dispatcher = null;
        
        try {
            
            dao = new GeneroDAO();
            
            if ( acao.equals( "prepararAlteracao" ) ) {
            
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Genero genero = dao.obterPorId( id );

                request.setAttribute( "genero", genero );

                dispatcher = request.getRequestDispatcher( "/entidades/generos/alterar.jsp" );
            
            } else if ( acao.equals( "prepararExclusao" ) ) {
                
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Genero genero = dao.obterPorId( id );

                request.setAttribute( "genero", genero );

                dispatcher = request.getRequestDispatcher( "/entidades/generos/excluir.jsp" );
                
            } else if ( acao.equals( "alterar" ) ) {
                
                Genero genero = new Genero();
                
                genero.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                genero.setDescricao(request.getParameter( "descricao" ) );
                
                dao.atualizar( genero );
                
                dispatcher = request.getRequestDispatcher( "/entidades/generos/listagem.jsp" );
                
            } else if ( acao.equals( "excluir" ) ) {
                
                Genero genero = new Genero();
                
                genero.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                
                dao.excluir( genero );
                
                dispatcher = request.getRequestDispatcher( "/entidades/generos/listagem.jsp" );
            
            } else if ( acao.equals( "adicionar" ) ) {
                
                Genero genero = new Genero();
                
                genero.setDescricao(request.getParameter( "descricao" ) );
                
                dao.salvar( genero );
                
                dispatcher = request.getRequestDispatcher("/entidades/generos/listagem.jsp");
                
                
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
