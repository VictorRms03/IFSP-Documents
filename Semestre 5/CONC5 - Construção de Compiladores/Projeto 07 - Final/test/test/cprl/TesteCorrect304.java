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
public class TesteCorrect304 {
    
    @Test
    public void testeCorrect304() throws IOException, FileNotFoundException {
        
        testar( "TesteCorrect_304",
                "../examples/Correct/Arrays/Correct_304.cprl",
                "../examples/Correct/Arrays/Correct_304-Projeto07-Results.txt" );
        
    }
    
}
