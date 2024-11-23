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
import java.time.format.DateTimeParseException;
import java.lang.NullPointerException;
import locacaodvds.dao.AtorDAO;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.dao.DvdDAO;
import locacaodvds.dao.GeneroDAO;
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
                
                if ( !isAtorExistente( atorPrincipal ) ) {
                    
                    String errorMsg = "ID de Ator Principal inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isAtorExistente( atorCoadjuvante ) ) {
                    
                    String errorMsg = "ID de Ator Coadjuvante inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isClassificacaoEtariaExistente( classificacaoEtaria ) ) {
                    
                    String errorMsg = "ID de Classificação Etária inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isGeneroExistente( genero ) ) {
                    
                    String errorMsg = "ID de Gênero inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isTituloValido( request.getParameter( "titulo" ) ) ) {
                   
                    String errorMsg = "Título inserido invalido, insira um título de tamanho entre 1 e 99 caracteres";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isAnoLancamentoValido( request.getParameter( "anoLancamento" ) ) ) {
                    
                    String errorMsg = "Ano de Lançamento inserido invalido, insira um número entre 0 e 2099";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isDataValida( request.getParameter( "dataLancamento" ) ) ) {
                    
                    String errorMsg = "Data de Lançamento inserido invalido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                
                } else if ( !isDuracaoMinutosValido ( request.getParameter( "duracaoMinutos" ) ) ) {
                    
                    String errorMsg = "Duração em Minutos inserido invalido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else {
                    
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
                    
                }
                
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
                
                if ( !isAtorExistente( atorPrincipal ) ) {
                    
                    String errorMsg = "ID de Ator Principal inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isAtorExistente( atorCoadjuvante ) ) {
                    
                    String errorMsg = "ID de Ator Coadjuvante inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isClassificacaoEtariaExistente( classificacaoEtaria ) ) {
                    
                    String errorMsg = "ID de Classificação Etária inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isGeneroExistente( genero ) ) {
                    
                    String errorMsg = "ID de Gênero inserido não existe";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isTituloValido( request.getParameter( "titulo" ) ) ) {
                   
                    String errorMsg = "Título inserido invalido, insira um título de tamanho entre 1 e 99 caracteres";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isAnoLancamentoValido( request.getParameter( "anoLancamento" ) ) ) {
                    
                    String errorMsg = "Ano de Lançamento inserido invalido, insira um número entre 0 e 2099";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else if ( !isDataValida( request.getParameter( "dataLancamento" ) ) ) {
                    
                    String errorMsg = "Data de Lançamento inserido invalido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                
                } else if ( !isDuracaoMinutosValido ( request.getParameter( "duracaoMinutos" ) ) ) {
                    
                    String errorMsg = "Duração em Minutos inserido invalido";
                    request.setAttribute("errorMsg", errorMsg);
                    dispatcher = request.getRequestDispatcher( "/entidades/dvds/erro.jsp" );
                    
                } else {
                    
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
     * @param ator Ator a ser verificado se é existente no Banco de Dados
     * @return TRUE se o Ator existir no Banco da Dados
     * @throws SQLException 
     */
    private boolean isAtorExistente(Ator ator) throws SQLException {
        
        AtorDAO atorDao = new AtorDAO();     
        for( Ator atorBanco : atorDao.listarTodos() ) {

            if ( ator.getId() == atorBanco.getId() ) {
                return true;
            }
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param classificacaoEtaria Classificação Etária a ser verificado se é existente no Banco de Dados
     * @return TRUE se a Classificação Etária existir no Banco da Dados
     * @throws SQLException 
     */
    private boolean isClassificacaoEtariaExistente( ClassificacaoEtaria classificacaoEtaria ) throws SQLException {
        
        ClassificacaoEtariaDAO classificacaoEtariaDAO = new ClassificacaoEtariaDAO();
                
        for( ClassificacaoEtaria classificacaoEtariaBanco : classificacaoEtariaDAO.listarTodos() ) {
            if ( classificacaoEtaria.getId() == classificacaoEtariaBanco.getId() ) {
                return true;
            }
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param genero Genero a ser verificado se é existente no Banco de Dados
     * @return TRUE se o Gênero existir no Banco da Dados
     * @throws SQLException 
     */
    private boolean isGeneroExistente( Genero genero ) throws SQLException {
        
        GeneroDAO generoDAO = new GeneroDAO();
                
        for( Genero generoBanco : generoDAO.listarTodos() ) {
            if ( genero.getId() == generoBanco.getId() ) {
                return true;
            }
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param titulo Titulo a ser Validado
     * @return TRUE se o título for válido ( Uma string de tamanho entre 1 e 100 )
     */
    private boolean isTituloValido( String titulo ) {
        
        if ( titulo.length() <= 100 && titulo.length() > 0 ) {
            return true;
        } 
        
        return false;
        
    }
    
    /**
     * 
     * @param anoLancamento Ano de Lançamento a ser Validado
     * @return TRUE se o Ano de Lançamento for válido ( Um número entre 0 e 2099 )
     */
    private boolean isAnoLancamentoValido( String anoLancamento ) {
        
        try {
            
            int anoLancamentoInt = Integer.parseInt( anoLancamento );
            
            if ( anoLancamentoInt >= 0 && anoLancamentoInt < 2100 ) {
                return true;
            }
            
        } catch ( NumberFormatException e ) {
            return false;
        }
        
        return false;
        
    }
    
    /**
     * 
     * @param data Data a ser Validada
     * @return TRUE se a Data for válida ( For uma string que pode ser transformada em um número que pode ser transformada em uma Data )
     */
    private boolean isDataValida( String data ) {
        
        try {
            
            Date dataDate = Date.valueOf( LocalDate.parse( data , DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) );
            
        } catch ( DateTimeParseException | NullPointerException e ) {
            return false;
        }
        
        return true;
        
    }
    
    /**
     * 
     * @param duracaoMinutos Duração em Minutos a ser Validada
     * @return TRUE se a Duração em minutos for valida ( Um número entre 1 e 10000 )
     */
    private boolean isDuracaoMinutosValido( String duracaoMinutos ) {
        
        try {
            
            int duracaoMinutosInt = Integer.parseInt( duracaoMinutos );
            
            if ( duracaoMinutosInt > 0 && duracaoMinutosInt <= 10000 ) {
                return true;
            }

        } catch ( NumberFormatException e ) {
            return false;
        }
        
        return false;
        
    }

}
