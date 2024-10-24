package cadastroclientes.controladores;

import cadastroclientes.dao.CidadeDAO;
import cadastroclientes.dao.ClienteDAO;
import cadastroclientes.entidades.Cidade;
import cadastroclientes.entidades.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Clientes.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "ClientesServlet", 
             urlPatterns = { "/processaClientes" } )
public class ClientesServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        ClienteDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {

            dao = new ClienteDAO();

            if ( acao.equals( "inserir" ) ) {

                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt( request.getParameter( "idCidade" ) );
                
                /*VALIDAÇÕES*/
                if ( nome.length() < 1 || nome.length() > 45 ) {
                    
                    request.setAttribute("err", "Tamanho de Nome invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( sobrenome.length() < 1 || sobrenome.length() > 45 ) {
                    
                    request.setAttribute("err", "Tamanho de Sobrenome invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( !verificaData( dataNascimento ) ) {
                    
                    request.setAttribute("err", "Formato de Data enviado invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( !verificaCpf( cpf ) ) {
                    
                    request.setAttribute("err", "Formato de CPF enviado invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( !verificaEmail( email ) ) {
                    
                    request.setAttribute("err", "Formato de E-mail enviado invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( logradouro.length() < 1 || logradouro.length() > 50 ) {
                    
                    request.setAttribute("err", "Tamanho de Logradouro invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( numero.length() < 1 || numero.length() > 6 ) {
                    
                    request.setAttribute("err", "Tamanho de Numero invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( bairro.length() <  1 || bairro.length() > 30 ) {
                    
                    request.setAttribute("err", "Tamanho de Bairro invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( !verificaCep( cep ) ) {
                    
                    request.setAttribute("err", "Formato de CEP enviado invalido");
                    disp = request.getRequestDispatcher("/formularios/clientes/erro.jsp");
                    
                } else if ( new CidadeDAO().obterPorId( idCidade ) == null ) {
                    
                    request.setAttribute("err", "Id de Estado enviado invalido");
                    disp = request.getRequestDispatcher("/formularios/cidades/erro.jsp");
                    
                } else {
                    
                    Cidade ci = new Cidade();
                    ci.setId( idCidade );

                    Cliente c = new Cliente();
                    c.setNome( nome );
                    c.setSobrenome( sobrenome );
                    c.setDataNascimento( Date.valueOf( 
                            LocalDate.parse( dataNascimento, dtf ) ) );
                    c.setCpf( cpf );
                    c.setEmail( email );
                    c.setLogradouro( logradouro );
                    c.setNumero( numero );
                    c.setBairro( bairro );
                    c.setCep( cep );
                    c.setCidade( ci );

                    dao.salvar( c );

                    disp = request.getRequestDispatcher(
                            "/formularios/clientes/listagem.jsp" );
                    
                }
                
            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));
                String nome = request.getParameter( "nome" );
                String sobrenome = request.getParameter( "sobrenome" );
                String dataNascimento = request.getParameter( "dataNascimento" );
                String cpf = request.getParameter( "cpf" );
                String email = request.getParameter( "email" );
                String logradouro = request.getParameter( "logradouro" );
                String numero = request.getParameter( "numero" );
                String bairro = request.getParameter( "bairro" );
                String cep = request.getParameter( "cep" );
                int idCidade = Integer.parseInt( 
                        request.getParameter( "idCidade" ) );

                Cidade ci = new Cidade();
                ci.setId( idCidade );

                Cliente c = new Cliente();
                c.setId( id );
                c.setNome( nome );
                c.setSobrenome( sobrenome );
                c.setDataNascimento( Date.valueOf( 
                        LocalDate.parse( dataNascimento, dtf ) ) );
                c.setCpf( cpf );
                c.setEmail( email );
                c.setLogradouro( logradouro );
                c.setNumero( numero );
                c.setBairro( bairro );
                c.setCep( cep );
                c.setCidade( ci );

                dao.atualizar( c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp" );

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter( "id" ));

                Cliente c = new Cliente();
                c.setId( id );

                dao.excluir( c );

                disp = request.getRequestDispatcher(
                        "/formularios/clientes/listagem.jsp" );

            } else {
                
                int id = Integer.parseInt(request.getParameter( "id" ));
                Cliente c = dao.obterPorId( id );
                request.setAttribute( "cliente", c );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/clientes/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/clientes/excluir.jsp" );
                }
                
            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        if ( disp != null ) {
            disp.forward( request, response );
        }
        
    }

    @Override
    protected void doGet( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    protected void doPost( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "ClientesServlet";
    }
    
    /**
     * 
     * @param data é a data a ser verificada
     * @return verifica se a data é valida
     */
    private boolean verificaData( String data ) {
        
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
    
    /**
     * 
     * @param cpf é o cpf a ser verificado
     * @return verifica se o cpf é valido
     */
    private boolean verificaCpf( String cpf ) {
        
        if ( cpf.length() != 14 ) { return false; }
        
        if ( cpf.charAt(3) != '.' || cpf.charAt(7) != '.' || cpf.charAt(11) != '-' ) {
            return false;
        }
        
        if ( !Character.isDigit( cpf.charAt(0) ) || 
                !Character.isDigit( cpf.charAt(1) ) || 
                !Character.isDigit( cpf.charAt(2) ) ||
                !Character.isDigit( cpf.charAt(4) ) || 
                !Character.isDigit( cpf.charAt(5) ) || 
                !Character.isDigit( cpf.charAt(6) ) || 
                !Character.isDigit( cpf.charAt(8) ) || 
                !Character.isDigit( cpf.charAt(9) ) || 
                !Character.isDigit( cpf.charAt(10) ) || 
                !Character.isDigit( cpf.charAt(12) ) || 
                !Character.isDigit( cpf.charAt(13) ))
        { return false; }
            
            return true;
    }
    
    /**
     * 
     * @param email é o email a ser verificado
     * @return verifica se o email é valido
     */
    private boolean verificaEmail( String email ) {
        
        if ( !email.contains("@") && 
                email.charAt(0) != '@' && 
                email.charAt( email.length()-1 ) != '@' )
        { return false; }
        
        return true;
    }
    
    /**
     * 
     * @param cep é o cep a ser verificado
     * @return verifica se o cep é valido
     */
    private boolean verificaCep( String cep ) {
        
        if ( cep.length() != 9 ) { return false; }
        
        if ( cep.charAt(5) != '-' ) { return false; }
        
        if ( !Character.isDigit( cep.charAt(0) ) || 
                !Character.isDigit( cep.charAt(1) ) || 
                !Character.isDigit( cep.charAt(2) ) ||
                !Character.isDigit( cep.charAt(3) ) || 
                !Character.isDigit( cep.charAt(4) ) || 
                !Character.isDigit( cep.charAt(6) ) || 
                !Character.isDigit( cep.charAt(7) ) || 
                !Character.isDigit( cep.charAt(8) ) )
        { return false; }
        
        return true;
    }

}
