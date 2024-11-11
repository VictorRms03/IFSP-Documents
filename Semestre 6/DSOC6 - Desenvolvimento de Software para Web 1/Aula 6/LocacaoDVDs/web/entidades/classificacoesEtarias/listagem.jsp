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
                <h1>Classificações Etárias</h1>
                <p>Entenda as Classificações Etárias</p>
            </div>

            <div class="div-form">

                <table>

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Descrição</th>
                            <th>Alterar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>

                    <tbody>

                        <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.ClassificacaoEtariaServices"/>
                
                        <c:forEach items="${servicos.todos}" var="classificacaoEtaria">

                            <tr>

                                <td>${classificacaoEtaria.id}</td>
                                <td>${classificacaoEtaria.descricao}</td>

                                <td>
                                    <a href="${cp}/processaClassificacoesEtarias?acao=prepararAlteracao&id=${classificacaoEtaria.id}">
                                        Alterar
                                    </a>
                                </td>

                                <td>
                                    <a href="${cp}/processaClassificacoesEtarias?acao=prepararExclusao&id=${classificacaoEtaria.id}">
                                        Excluir
                                    </a>
                                </td>

                            </tr>

                        </c:forEach>
                      </tbody>

                </table>

            </div>

            <div class="div-form-options">
                <a href="${cp}/entidades/classificacoesEtarias/adicionar.jsp" class="button">Adicionar</a>
            </div>

        </main>

        <footer class="footer">
            <p class="footer-copyright">Victor Ramos - Instituto Federal de São Paulo @ 2024</p>
        </footer>

    </body>

</html>
