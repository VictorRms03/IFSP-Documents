/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package formularioMaior.servlets;

import entidades.Formulario;
import jakarta.servlet.RequestDispatcher;
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
        String temFilhos = request.getParameter( "filhos" );
        
        Formulario formulario = new Formulario();
        
        formulario.setNome(nome);
        formulario.setSobrenome(sobrenome);
        formulario.setCpf(cpf);
        formulario.setDataNasc(dataNascimento);
        formulario.setSexo(sexo);
        formulario.setObservacoes(observacoes);
        formulario.setEmail(email);
        formulario.setLogradouro(logradouro);
        formulario.setNumero(numero);
        formulario.setComplemento(complemento);
        formulario.setCidade(cidade);
        formulario.setEstado(estado);
        formulario.setCep(cep);
        formulario.setFilhos(temFilhos);
        
        request.setAttribute("formularioObtido", formulario);
        
        RequestDispatcher disp = request.getRequestDispatcher( "exibeFormulario.jsp" );
        
        disp.forward( request, response );
        
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
