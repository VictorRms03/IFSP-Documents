/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package formularioDvd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author victo
 */
@WebServlet(name = "formularioDVDServlet", urlPatterns = {"/formularioDVD"})
public class formularioDVDServlet extends HttpServlet {

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
       
        request.setCharacterEncoding( "UTF-8" );
        
        String numero = request.getParameter( "numero" );
        String titulo = request.getParameter( "titulo" );
        String atorPrincipal = request.getParameter( "atorPrincipal" );
        String atorCoadjuvante = request.getParameter( "atorCoadjuvante" );
        String diretor = request.getParameter( "diretor" );
        String anoLancamento = request.getParameter( "anoLancamento" );
        
        System.out.println( " -- INFOS DVD -- " );
        System.out.println( "Número: " + numero );
        System.out.println( "Titulo: " + titulo );
        System.out.println( "Ator Principal: " + atorPrincipal );
        System.out.println( "Ator Coadjuvante: " + atorCoadjuvante );
        System.out.println( "diretor: " + diretor );
        System.out.println( "Ano de Lançamento: " + anoLancamento );
        System.out.println( "Número: " + numero );
        
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
