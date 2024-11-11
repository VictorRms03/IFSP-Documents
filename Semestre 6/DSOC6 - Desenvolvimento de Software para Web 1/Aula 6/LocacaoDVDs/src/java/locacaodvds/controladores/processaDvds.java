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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

/**
 *
 * @author victo
 */
@WebServlet(name = "processaDvds", urlPatterns = {"/processaDvds"})
public class processaDvds extends HttpServlet {

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
        
        DvdDAO dao = null;
        
        RequestDispatcher dispatcher = null;
        
        try {
            
            dao = new DvdDAO();
            
            if ( acao.equals( "prepararAlteracao" ) ) {
            
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Dvd dvd = dao.obterPorId( id );

                request.setAttribute( "dvd", dvd );

                dispatcher = request.getRequestDispatcher( "/entidades/dvds/alterar.jsp" );
            
            } else if ( acao.equals( "prepararExclusao" ) ) {
                
                int id = Integer.parseInt( request.getParameter( "id" ) );
                Dvd dvd = dao.obterPorId( id );

                request.setAttribute( "dvd", dvd );

                dispatcher = request.getRequestDispatcher( "/entidades/dvds/excluir.jsp" );
                
            } else if ( acao.equals( "alterar" ) ) {
                
                Ator atorPrincipal = new Ator();
                atorPrincipal.setId( Integer.parseInt( request.getParameter( "idAtorPrincipal" ) ) );
                
                Ator atorCoadjuvante = new Ator();
                atorCoadjuvante.setId( Integer.parseInt( request.getParameter( "idAtorCoadjuvante" ) ) );
                
                ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
                classificacaoEtaria.setId( Integer.parseInt( request.getParameter( "idClassificacaoEtaria" ) ) );
                
                Genero genero = new Genero();
                genero.setId( Integer.parseInt( request.getParameter( "idGenero" ) ) );
                
                
                Dvd dvd = new Dvd();
                
                dvd.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                dvd.setTitulo( request.getParameter( "titulo" ) );
                dvd.setAnoLancamento( Integer.parseInt( request.getParameter("anoLancamento") ) );
                dvd.setDataLancamento( Date.valueOf( LocalDate.parse( request.getParameter( "dataLancamento" ) , 
                        DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );
                dvd.setDuracaoMinutos( Integer.parseInt( request.getParameter( "duracaoMinutos" ) ) );
                dvd.setAtorPrincipal( atorPrincipal );
                dvd.setAtorCoadjuvante( atorCoadjuvante );
                dvd.setClassificacaoEtaria( classificacaoEtaria );
                dvd.setGenero( genero );
                
                dao.atualizar( dvd );
                
                dispatcher = request.getRequestDispatcher( "/entidades/dvds/listagem.jsp" );
                
            } else if ( acao.equals( "excluir" ) ) {
                
                Dvd dvd = new Dvd();
                dvd.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                
                dao.excluir( dvd );
                
                dispatcher = request.getRequestDispatcher( "/entidades/dvds/listagem.jsp" );
            
            } else if ( acao.equals( "adicionar" ) ) {
                
                Ator atorPrincipal = new Ator();
                atorPrincipal.setId( Integer.parseInt( request.getParameter( "idAtorPrincipal" ) ) );
                
                Ator atorCoadjuvante = new Ator();
                atorCoadjuvante.setId( Integer.parseInt( request.getParameter( "idAtorCoadjuvante" ) ) );
                
                ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
                classificacaoEtaria.setId( Integer.parseInt( request.getParameter( "idClassificacaoEtaria" ) ) );
                
                Genero genero = new Genero();
                genero.setId( Integer.parseInt( request.getParameter( "idGenero" ) ) );
                
                
                Dvd dvd = new Dvd();
                
                dvd.setTitulo( request.getParameter( "titulo" ) );
                dvd.setAnoLancamento( Integer.parseInt( request.getParameter("anoLancamento") ) );
                dvd.setDataLancamento( Date.valueOf( LocalDate.parse( request.getParameter( "dataLancamento" ) , 
                        DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );
                dvd.setDuracaoMinutos( Integer.parseInt( request.getParameter( "duracaoMinutos" ) ) );
                dvd.setAtorPrincipal( atorPrincipal );
                dvd.setAtorCoadjuvante( atorCoadjuvante );
                dvd.setClassificacaoEtaria( classificacaoEtaria );
                dvd.setGenero( genero );
                
                dao.salvar( dvd );
                
                dispatcher = request.getRequestDispatcher("/entidades/dvds/listagem.jsp");
                
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
