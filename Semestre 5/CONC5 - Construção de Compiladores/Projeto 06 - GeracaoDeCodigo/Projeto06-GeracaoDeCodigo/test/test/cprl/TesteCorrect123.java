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
public class TesteCorrect123 {
    
    @Test
    public void testeCorrect123() throws IOException, FileNotFoundException {
        
        testar( "TesteCorrect_123",
                "../examples/Correct/CPRL0/Correct_123.cprl",
                "../examples/Correct/CPRL0/Correct_123-Projeto06-Results.txt" );
        
    }
    
}
