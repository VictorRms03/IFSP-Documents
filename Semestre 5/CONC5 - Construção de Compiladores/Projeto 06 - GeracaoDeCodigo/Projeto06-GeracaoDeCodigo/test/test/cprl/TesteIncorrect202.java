/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static test.cprl.TestUtils.testar;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class TesteIncorrect202 {
    
    @Test
    public void testeIncorrect202() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect_202",
                "../examples/Incorrect/Subprograms/Incorrect_202.cprl",
                "../examples/Incorrect/Subprograms/Incorrect_202-Projeto05-AnaliseDeRestricoes-Results.txt" );
        
    }
    
}
