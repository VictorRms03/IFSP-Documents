<%-- 
    Document   : exibeDVD
    Created on : 1 de out. de 2024, 10:07:18
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <ul>
            <li>Numero: ${requestScope.DVD.numero}</li>
            <li>Titulo: ${requestScope.DVD.titulo}</li>
            <li>Ator/Atriz Principal: ${requestScope.DVD.atorPrincipal}</li>
            <li>Ator/Atriz Coadjuvante: ${requestScope.DVD.atorCoadjuvante}</li>
            <li>Diretor/Diretora: ${requestScope.DVD.diretor}</li>
            <li>Ano de Lançamento: ${requestScope.DVD.anoLancamento}</li>
        </ul>
        
    </body>
</html>
