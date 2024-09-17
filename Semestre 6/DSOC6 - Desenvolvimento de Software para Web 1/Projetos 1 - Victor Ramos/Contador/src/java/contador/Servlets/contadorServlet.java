/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contador.Servlets;

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
@WebServlet( name = "contadorServlet", urlPatterns = { "/contador"} )
public class contadorServlet extends HttpServlet{

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
            System.out.println(i);
        }
        
    }
    
    
    
    
}
