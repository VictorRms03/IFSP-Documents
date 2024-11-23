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
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.Dvd;

/**
 *
 * @author victo
 */
@WebServlet(name = "processaClassificacoesEtarias", urlPatterns = {"/processaClassificacoesEtarias"})
public class processaClassificacoesEtarias extends HttpServlet {

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
        
        ClassificacaoEtariaDAO dao = null;
        
        RequestDispatcher dispatcher = null;
        
        try {
            
            dao = new ClassificacaoEtariaDAO();
            
            if ( acao.equals( "prepararAlteracao" ) ) {
            
                int id = Integer.parseInt( request.getParameter( "id" ) );
                ClassificacaoEtaria classificacaoEtaria = dao.obterPorId( id );

                request.setAttribute( "classificacaoEtaria", classificacaoEtaria );

                dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/alterar.jsp" );
            
            } else if ( acao.equals( "prepararExclusao" ) ) {
                
                int id = Integer.parseInt( request.getParameter( "id" ) );
                ClassificacaoEtaria classificacaoEtaria = dao.obterPorId( id );

                request.setAttribute( "classificacaoEtaria", classificacaoEtaria );

                dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/excluir.jsp" );
                
            } else if ( acao.equals( "alterar" ) ) {
                
                if ( !isDescricaoValida( request.getParameter( "descricao" ) ) ) {
                    
                    String errorMsg = "Descrição inserida invalida";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/erro.jsp" );
                    
                } else {
                
                    ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();

                    classificacaoEtaria.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                    classificacaoEtaria.setDescricao(request.getParameter( "descricao" ) );

                    dao.atualizar( classificacaoEtaria );

                    dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/listagem.jsp" );
                    
                }
                
            } else if ( acao.equals( "excluir" ) ) {
                
                ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
                
                classificacaoEtaria.setId( Integer.parseInt( request.getParameter( "id" ) ) );
                
                if( isClassificacaoEtariaUtilizada( classificacaoEtaria ) ) {
                    
                    String errorMsg = "Classificação Etaria sendo utilizada no Cadastro de algum DVD";
                    request.setAttribute( "errorMsg", errorMsg );
                    dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/erro.jsp" );
                    
                } else {
                    
                    dao.excluir( classificacaoEtaria );
                    
                    dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/listagem.jsp" );
                    
                }
                
            } else if ( acao.equals( "adicionar" ) ) {
                
                if ( !isDescricaoValida( request.getParameter( "descricao" ) ) ) {
                    
                    String errorMsg = "Descrição inserida invalida";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/classificacoesEtarias/erro.jsp" );
                    
                } else {
                    
                    ClassificacaoEtaria classificacaoEtaria = new ClassificacaoEtaria();
                
                    classificacaoEtaria.setDescricao( request.getParameter( "descricao" ) );

                    dao.salvar( classificacaoEtaria );

                    dispatcher = request.getRequestDispatcher("/entidades/classificacoesEtarias/listagem.jsp");
                    
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
     * @param descricao Descrição a ser validada
     * @return TRUE se a Descrição for válida ( Uma String de tamanho entre 1 e 40 )
     */
    private boolean isDescricaoValida( String descricao ) {
        
        if ( descricao.length() > 0 && descricao.length() < 41 ) {
            return true;
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param classificacaoEtaria Classificação a ser verificada
     * @return TRUE se a classificaçãoEtaria estiver sendo utilizada por algum DVD
     * @throws SQLException 
     */
    private boolean isClassificacaoEtariaUtilizada( ClassificacaoEtaria classificacaoEtaria ) throws SQLException {
        
        DvdDAO dvdDAO = new DvdDAO();

        for ( Dvd dvd : dvdDAO.listarTodos() ) {

            if ( dvd.getClassificacaoEtaria().getId() == classificacaoEtaria.getId() ) { 
                return true; 
            }

        }
        
        return false;
        
    }
    
}
