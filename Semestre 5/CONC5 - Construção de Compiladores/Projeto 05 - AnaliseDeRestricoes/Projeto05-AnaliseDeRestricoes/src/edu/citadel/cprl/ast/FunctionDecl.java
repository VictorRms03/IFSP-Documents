package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;

import java.util.List;

/**
 * The abstract syntax tree node for a function declaration.
 */
public class FunctionDecl extends SubprogramDecl {

    /**
     * Construct a function declaration with its name (an identifier).
     */
    public FunctionDecl( Token funcId ) {
        super( funcId );
    }

    /**
     * Computes the relative address of the function return value. <br>
     * Note: This method assumes that the relative addresses of all formal
     * parameters have been set.
     */
    public int getRelAddr() {
        
        int firstParamAddr = 0;

        List<ParameterDecl> params = getFormalParams();
        if ( params.size() > 0 ) {
            ParameterDecl firstParamDecl = params.get( 0 );
            firstParamAddr = firstParamDecl.getRelAddr();
        }

        // the location for the return value is above the first parameter
        return firstParamAddr - getType().getSize();
        
    }

    /**
     * Returns true if the specified list of statements contains at least one
     * return statement.
     *
     * @param statements the list of statements to check for a return statement.
     * If any of the statements in the list contains nested statements (e.g., an
     * if statement or a loop statement), then the nested statements are also
     * checked for a return statement.
     */
    private boolean hasReturnStmt( List<Statement> statements ) {
        
        for ( Statement stmt : statements ) {
            
            if ( stmt instanceof ReturnStmt ) {
                return true;
            } else if ( stmt instanceof IfStmt ) {
                
                IfStmt ifStmt = (IfStmt) stmt;
                if ( hasReturnStmt( ifStmt.getThenStmts() ) ) {
                    return true;
                }

                for ( ElsifPart elsifPart : ifStmt.getElsifParts() ) {
                    if ( hasReturnStmt( elsifPart.getThenStmts() ) ) {
                        return true;
                    }
                }

                if ( hasReturnStmt( ifStmt.getElseStmts() ) ) {
                    return true;
                }
                
            } else if ( stmt instanceof LoopStmt ) {
                
                LoopStmt loopStmt = (LoopStmt) stmt;
                if ( hasReturnStmt( loopStmt.getStatements() ) ) {
                    return true;
                }
                
            }
            
        }

        return false;
        
    }
    
    @Override
    public void checkConstraints() {
        
        // Regra Variada: não pode haver nenhuma var nos parâmetros.
        
        // Regra Variada: é necessário que haja pelo menos uma instrução de 
        // retorno.
        
        // Dica: veja a implementação de SubprogramDecl
        
        // <editor-fold defaultstate="collapsed" desc="Implementação">
                    
        try {
            
            if ( this.getStatementPart() != null ){
                this.getStatementPart().checkConstraints();
            }
            
            for( ParameterDecl param : this.getFormalParams() ) {
                if ( param.isVarParam() ) {
                    throw error( param.getPosition(), "ALGUM ERRO" ); //MENSAGEM ERRADA
                }    
            }
            
            //VERIFICAR REGRA 2
            
        } catch ( ConstraintException e ){
            ErrorHandler.getInstance().reportError( e );
        }

        // </editor-fold>
        
    }
    
    @Override
    public void emit() throws CodeGenException {
        // ...
    }
    
}
