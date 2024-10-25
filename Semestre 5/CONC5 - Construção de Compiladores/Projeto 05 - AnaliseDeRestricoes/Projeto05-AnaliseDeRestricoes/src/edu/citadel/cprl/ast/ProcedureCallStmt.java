package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Token;

import java.util.List;

/**
 * The abstract syntax tree node for a procedure call statement.
 */
public class ProcedureCallStmt extends Statement {

    private Token procId;
    private List<Expression> actualParams;
    private ProcedureDecl procDecl;

    /*
     * Construct a procedure call statement with its name token, the
     * list of actual parameters being passed as part of the call,
     * and a reference to the declaration of the procedure being called.
     */
    public ProcedureCallStmt( Token procId,
            List<Expression> actualParams,
            ProcedureDecl procDecl ) {
        
        this.procId = procId;
        this.actualParams = actualParams;
        this.procDecl = procDecl;
        
    }

    public Token getProcId() {
        return procId;
    }

    public List<Expression> getActualParams() {
        return actualParams;
    }

    public ProcedureDecl getProcDecl() {
        return procDecl;
    }
    
    @Override
    public void checkConstraints() {
        
        // Regra de Tipo: a quantidade de argumentos (actual parameters)
        // precisa ser a mesma da quantidade de parâmetros formais e cada par
        // deve ter o mesmo tipo.
        
        // Regra Variada: se um parâmetro formal é um parâmetro var, então o
        // argumento deve ser um valor nomeado, não uma expressão arbitrária.
        
        // <editor-fold defaultstate="collapsed" desc="Implementação">
                    
        try {
            
            for( Expression param : this.actualParams ){
                param.checkConstraints();
            }
            
            if ( this.actualParams.size() != this.procDecl.getFormalParams().size() ) {
                throw error( this.procId.getPosition(), "Number of actual parameters doesn't match with formal parameters." ); //x
            }

            for ( int i=0; i<this.actualParams.size(); i++ ) {
                
                if ( !matchTypes( this.actualParams.get(i).getType(), this.procDecl.getFormalParams().get(i).getType() ) ) {
                    throw error( this.actualParams.get(i).getPosition(), "Parameter type mismatch." );
                }
                
                if ( this.procDecl.getFormalParams().get(i).isVarParam() ) {
                    
                    if ( this.actualParams.get(i) instanceof NamedValue ) {
                        this.actualParams.set(i, new Variable( (NamedValue) this.actualParams.get(i) ) );
                    } else {
                        throw error( this.actualParams.get(i).getPosition(), "Expression for a var parameter must be a variable." );
                    }
                    
                }
                
            }
            
        } catch ( ConstraintException e ) {
            ErrorHandler.getInstance().reportError( e );
        }

        // </editor-fold>
        
    }

    @Override
    public void emit() throws CodeGenException {
        // ...
    }
    
}
