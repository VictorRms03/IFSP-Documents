/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fibonacci.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author bv3026191
 */
@WebServlet( name = "fibonacciServlet", urlPatterns = { "/fibonacci" } )
public class fibonacciServlet extends HttpServlet {
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    private void processRequest( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
    
        for( int i=1; i<=30; i++ ) {
            System.out.println( fibonacci(i) );
        }
        
    }
    
    private int fibonacci( int n ) {
        
        int previous = 0;
        int actual = 0;
        
        for( int i=0; i<n; i++ ) {
            
            if ( actual == 0 ) {
                actual = 1;
            } else {
                int next = previous + actual;
            
                previous = actual;
                actual = next;
            }
            
        }
        
        return actual;
    }
    
}
