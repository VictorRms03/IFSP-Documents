package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;
import edu.citadel.cprl.Type;
import test.cprl.gui.visitor.Visitor;

/**
 * The abstract syntax tree node for an adding expression. An adding expression
 * is a binary expression where the operator is an adding operator, "+" or "-".
 * A simple example would be "x + 5".
 */

/*PRONTO? - NÃO FIZ NADA*/
public class AddingExpr extends BinaryExpr {

    /**
     * Construct an adding expression with the operator ("+" or "-") and the two
     * operands.
     */
    public AddingExpr( Expression leftOperand, Token operator, Expression rightOperand ) {
        
        super( leftOperand, operator, rightOperand );
        setType( Type.Integer );
        
        assert operator.getSymbol().isAddingOperator() : "Operator is not an adding operator.";
        
    }

    @Override
    public void accept( Visitor v ) {
        v.visitConcreteElementAddingExpr( this );
    }
    
    @Override
    public void checkConstraints() {
        
        try {
            
            Expression leftOperand = getLeftOperand();
            Expression rightOperand = getRightOperand();

            leftOperand.checkConstraints();
            rightOperand.checkConstraints();

            // can add/subtract only integers
            if ( leftOperand.getType() != Type.Integer ) {
                String errorMsg = "Left operand for expression should have type Integer.";
                throw error( leftOperand.getPosition(), errorMsg );
            }

            if ( rightOperand.getType() != Type.Integer ) {
                String errorMsg = "Right operand for expression should have type Integer.";
                throw error( rightOperand.getPosition(), errorMsg );
            }
            
        } catch ( ConstraintException e ) {
            ErrorHandler.getInstance().reportError( e );
        }
        
    }

    @Override
    public void emit() throws CodeGenException {
        
        Expression leftOperand = getLeftOperand();
        Expression rightOperand = getRightOperand();
        Symbol operatorSym = getOperator().getSymbol();

        leftOperand.emit();
        rightOperand.emit();

        if ( operatorSym == Symbol.plus ) {
            emit( "ADD" );
        } else if ( operatorSym == Symbol.minus ) {
            emit( "SUB" );
        }
        
    }
    
}
