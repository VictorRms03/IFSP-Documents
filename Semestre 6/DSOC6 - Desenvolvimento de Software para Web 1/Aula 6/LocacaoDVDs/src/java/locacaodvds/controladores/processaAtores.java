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
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Dvd;

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
                
                if ( !isNomeValido( request.getParameter( "nome" ) ) ) {
                    
                    String errorMsg = "Nome inserido Inválido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else if ( !isNomeValido( request.getParameter( "sobrenome" ) ) ) {
                    
                    String errorMsg = "Sobrenome inserido Inválido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else if ( !isDataValida( request.getParameter( "dataEstreia" ) ) ) {
                    
                    String errorMsg = "Data inserida Inválida";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else {
                    
                    Ator ator = new Ator();
                
                    ator.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                    ator.setNome( request.getParameter( "nome" ) );
                    ator.setSobrenome( request.getParameter( "sobrenome" ) );
                    ator.setDataEstreia( Date.valueOf( LocalDate.parse( request.getParameter( "dataEstreia" ) , 
                            DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );

                    dao.atualizar( ator );

                    dispatcher = request.getRequestDispatcher( "/entidades/atores/listagem.jsp" );
                    
                }
                
            } else if ( acao.equals( "excluir" ) ) {
                
                Ator ator = new Ator();
                
                ator.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                
                if( isAtorUtilizado( ator ) ) {
                    
                    String errorMsg = "Ator sendo utilizado no Cadastro de algum DVD";
                    request.setAttribute( "errorMsg", errorMsg );
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else {
                    
                    dao.excluir( ator );
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/listagem.jsp" );
                    
                }
            
            } else if ( acao.equals( "adicionar" ) ) {
                
                if ( !isNomeValido( request.getParameter( "nome" ) ) ) {
                    
                    String errorMsg = "Nome inserido Inválido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else if ( !isNomeValido( request.getParameter( "sobrenome" ) ) ) {
                    
                    String errorMsg = "Sobrenome inserido Inválido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else if ( !isDataValida( request.getParameter( "dataEstreia" ) ) ) {
                    
                    String errorMsg = "Data inserida Inválida";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/atores/erro.jsp" );
                    
                } else {
                    
                    Ator ator = new Ator();
                
                    ator.setNome( request.getParameter( "nome" ) );
                    ator.setSobrenome( request.getParameter( "sobrenome" ) );
                    ator.setDataEstreia( Date.valueOf( LocalDate.parse( request.getParameter( "dataEstreia" ) , 
                            DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) ) );

                    dao.salvar( ator );

                    dispatcher = request.getRequestDispatcher("/entidades/atores/listagem.jsp");
                    
                }
                
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

    /**
     * 
     * @param ator Ator a ser comparado
     * @return TRUE se o ator está sendo utilizado em algum DVD
     * @throws SQLException
     */
    private boolean isAtorUtilizado( Ator ator ) throws SQLException {
        
        DvdDAO dvdDAO = new DvdDAO();

        for ( Dvd dvd : dvdDAO.listarTodos() ) {

            if ( dvd.getAtorPrincipal().getId() == ator.getId() || 
                dvd.getAtorCoadjuvante().getId() == ator.getId() ) 
            { return true; }

        }
        
        return false;
        
    }
    
    /**
     * 
     * @param nome Nome ou Sobrenome a ser validado
     * @return TRUE se o nome/sobrenome for válido
     * @throws SQLException 
     */
    private boolean isNomeValido( String nome ) {
        
        if ( nome.length() < 46 && nome.length() > 0 ) {
            return true;
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param data é a data a ser validada
     * @return TRUE se a data é válida
     */
    private boolean isDataValida( String data ) {
        
        //Verificando se a String segue o tamanho certo
        if ( data.length() != 10 ) { return false; }
        
        //Verificando se os Caracteres que deveriam ser '-' realmente são
        if ( data.charAt(4) != '-' || data.charAt(7) != '-' ) { return false; }
        
        //Verificando se os Caracteres que deveriam ser digitos realmente são
        if ( !Character.isDigit( data.charAt(0) ) || 
                !Character.isDigit( data.charAt(1) ) || 
                !Character.isDigit( data.charAt(2) ) ||
                !Character.isDigit( data.charAt(3) ) || 
                !Character.isDigit( data.charAt(5) ) || 
                !Character.isDigit( data.charAt(6) ) || 
                !Character.isDigit( data.charAt(8) ) || 
                !Character.isDigit( data.charAt(9) ) )
        { return false; }
        
        //Verificando se o mês é valido
        int mes = Integer.parseInt( data.substring(5, 7) );
        
        if ( mes > 12 || mes < 1 ) { return false; }
        
        //Verificando se o dia é valido
        int dia = Integer.parseInt( data.substring(8, 10) );
        
        if (dia < 1){ return false; }
        
        if ( mes == 1 || mes == 3 || mes == 5 || mes == 7 
                || mes == 8 || mes == 10 || mes == 12 ) 
        {
            if ( dia > 31 ) { return false;}
        }
        
        if ( mes == 4 || mes == 6 || mes == 9 || mes == 11 ){
            if ( dia > 30 ) { return false;}
        }
        
        if ( mes == 2 ) {
            if (dia > 29) { return false;}
        }
        
        return true;
        
    }
    
}
