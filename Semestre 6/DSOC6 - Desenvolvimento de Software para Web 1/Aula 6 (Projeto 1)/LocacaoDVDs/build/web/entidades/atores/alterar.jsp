<%-- 
    Document   : index
    Created on : 06 de nov. de 2024, 22:19:01
    Author     : Victor Ramos - BV3026191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora DVD's</title>
        <link rel="stylesheet" href="${cp}/css/style.css">

    </head>

    <body>
        
        <header>
            
            <nav class="navbar">
                
                <a href="${cp}/index.jsp" class="navbar-logo">
                    <img src="${cp}/images/dvdLogo.png" alt="" class="logo-img">
                </a>
                
                <ul class="navbar-links">
                    
                    <li> <a href="${cp}/index.jsp">Início</a> </li>
                    <li> <a href="${cp}/entidades/dvds/listagem.jsp">DVD's</a> </li>
                    <li> <a href="${cp}/entidades/atores/listagem.jsp">Atores</a> </li>
                    <li> <a href="${cp}/entidades/classificacoesEtarias/listagem.jsp">Classificações Etárias</a> </li>
                    <li> <a href="${cp}/entidades/generos/listagem.jsp">Gêneros</a> </li>
                    
                </ul>
                
            </nav>

        </header>

        <main>
            
            <div class="page-title">
                <h1>Alterar Ator</h1>
            </div>

            <div class="div-form">

                <form method="POST" action="${cp}/processaAtores" class="form-personalizado">

                    <input type="hidden" name="id" value="${requestScope.ator.id}">
                    <input type="hidden" name="acao" value="alterar">

                    <table>

                        <thead>

                            <th colspan="3">Alterar "${requestScope.ator.nome} ${requestScope.ator.sobrenome}" - ID: ${requestScope.ator.id} </th>

                        </thead>

                        <tbody>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Alteração">
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="nome">Nome: </label>
                                </td>

                                <td>
                                    <input type="text"
                                            size="20"
                                            maxlength="45"
                                            name="nome"
                                            id="nome"
                                            value="${requestScope.ator.nome}"
                                            required>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="sobrenome">Sobrenome: </label>
                                </td>

                                <td>
                                    <input type="text"
                                            size="20"
                                            maxlength="45"
                                            name="sobrenome"
                                            id="sobrenome"
                                            value="${requestScope.ator.sobrenome}"
                                            required>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="dataEstreia">Data de Estreia: </label>
                                </td>

                                <td>
                                    <input type="date"
                                            size="8"
                                            placeholder="dd/mm/yyyy" 
                                            name="dataEstreia" 
                                            id="dataEstreia" 
                                            value="${requestScope.ator.dataEstreia}"
                                            required>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Alteração">
                                </td>
                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

            <div class="div-form-options">
                <a href="${cp}/entidades/atores/listagem.jsp" class="button">Voltar</a>
            </div>
            
        </main>

    </body>

</html>
