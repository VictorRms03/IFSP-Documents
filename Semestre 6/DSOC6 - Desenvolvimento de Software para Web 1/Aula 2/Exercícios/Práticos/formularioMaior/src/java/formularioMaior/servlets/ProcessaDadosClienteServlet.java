/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package formularioMaior.servlets;

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
@WebServlet(name = "ProcessaDadosClienteServlet", urlPatterns = {"/ProcessaDadosCliente"})
public class ProcessaDadosClienteServlet extends HttpServlet {

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
        
        String nome = request.getParameter( "nome" );
        String sobrenome = request.getParameter( "sobrenome" );
        String cpf = request.getParameter( "cpf" );
        String dataNascimento = request.getParameter( "dataNasc" );
        String sexo = request.getParameter( "sexo" );
        String observacoes = request.getParameter( "observacoes" );
        String email = request.getParameter( "email" );
        String logradouro = request.getParameter( "logradouro" );
        String numero = request.getParameter( "numero" );
        String complemento = request.getParameter( "complemento" );
        String cidade = request.getParameter( "cidade" );
        String estado = request.getParameter( "estado" );
        String cep = request.getParameter( "cep" );
        
        boolean temFilhos = false;
        if ( request.getParameter( "filhos" ).equals("S") ) {
            temFilhos = true;
        }
        
        
        System.out.println( "Seu nome: " + nome );
        System.out.println( "Seu sobrenome: " + sobrenome );
        System.out.println( "Seu CPF: " + cpf );
        System.out.println( "Sua Data de Nascimento: " + dataNascimento );
        System.out.println( "Seu sexo: " + sexo );
        System.out.println( "Observações: " + observacoes );
        System.out.println( "Seu email: " + email );
        
        System.out.println( "Seu endereço: ");
        System.out.println( "Logradouro: " + logradouro );
        System.out.println( "Numero: " + numero );
        System.out.println( "Complemento: " + complemento );
        System.out.println( "Cidade: " + cidade );
        System.out.println( "Estado: " + estado );
        System.out.println( "Cep: " + cep );
        
        if ( temFilhos ) {
            System.out.println( "Você tem filhos! Parabéns!" );
        } else {
            System.out.println( "Você não tem filhos... Ainda..." );
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
