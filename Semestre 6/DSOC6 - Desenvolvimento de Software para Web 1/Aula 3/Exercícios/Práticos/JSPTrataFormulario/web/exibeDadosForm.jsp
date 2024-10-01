<%-- 
    Document   : exibeDadosForm
    Created on : 1 de out. de 2024, 10:16:06
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
            <li>Nome: ${param.nome}</li>
            <li>Idade: ${param.idade}</li>
        </ul>

    </body>
</html>
