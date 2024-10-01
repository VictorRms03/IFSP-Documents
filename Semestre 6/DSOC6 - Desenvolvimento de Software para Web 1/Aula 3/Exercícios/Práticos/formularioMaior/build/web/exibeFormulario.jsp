<%-- 
    Document   : exibeFormulario
    Created on : 1 de out. de 2024, 09:44:53
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
        <li>Nome: ${requestScope.formularioObtido.nome}</li>
        <li>Sobrenome: ${requestScope.formularioObtido.sobrenome}</li>
        <li>CPF: ${requestScope.formularioObtido.cpf}</li>
        <li>Data de Nascimento: ${requestScope.formularioObtido.dataNasc}</li>
        <li>Sexo: ${requestScope.formularioObtido.sexo}</li>
        <li>Observações: ${requestScope.formularioObtido.observacoes}</li>
        <li>Email: ${requestScope.formularioObtido.email}</li>
        <li>Logradouro: ${requestScope.formularioObtido.logradouro}</li>
        <li>Numero: ${requestScope.formularioObtido.numero}</li>
        <li>Complemento: ${requestScope.formularioObtido.complemento}</li>
        <li>Cidade: ${requestScope.formularioObtido.cidade}</li>
        <li>Estado: ${requestScope.formularioObtido.estado}</li>
        <li>CEP: ${requestScope.formularioObtido.cep}</li>
        <li>Tem Filhos: ${requestScope.formularioObtido.filhos}</li>
    </ul>
        
        
        
    </body>
</html>
