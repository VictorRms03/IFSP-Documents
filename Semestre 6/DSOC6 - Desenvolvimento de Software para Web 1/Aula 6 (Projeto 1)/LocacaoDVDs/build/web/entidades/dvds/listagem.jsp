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
                <h1>DVD's</h1>
                <p>Veja os melhores DVD's para você alugar!</p>
            </div>

            <div class="div-form">

                <table>

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Titulo</th>
                            <th>Ano de Lançamento</th>
                            <th>Data de Lançamento</th>
                            <th>Duração (Min)</th>
                            <th>Ator Principal</th>
                            <th>Ator Coadjuvante</th>
                            <th>Classificação Etária</th>
                            <th>Gênero</th>
                            <th>Alterar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>

                    <tbody>

                        <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.DvdsServices"/>
                
                        <c:forEach items="${servicos.todos}" var="dvd">

                            <tr>

                                <td>${dvd.id}</td>
                                <td>${dvd.titulo}</td>
                                <td>${dvd.anoLancamento}</td>
                                <td>${dvd.dataLancamento}</td>
                                <td>${dvd.duracaoMinutos}</td>
                                <td>${dvd.atorPrincipal.nome} ${dvd.atorPrincipal.sobrenome}</td>
                                <td>${dvd.atorCoadjuvante.nome} ${dvd.atorCoadjuvante.sobrenome}</td>
                                <td>${dvd.classificacaoEtaria.descricao}</td>
                                <td>${dvd.genero.descricao}</td>

                                <td>
                                    <a href="${cp}/processaDvds?acao=prepararAlteracao&id=${dvd.id}" class="table-options">
                                        Alterar
                                    </a>
                                </td>

                                <td>
                                    <a href="${cp}/processaDvds?acao=prepararExclusao&id=${dvd.id}" class="table-options">
                                        Excluir
                                    </a>
                                </td>

                            </tr>

                        </c:forEach>
                      </tbody>

                </table>

            </div>

            <div class="div-form-options">
                <a href="${cp}/entidades/dvds/adicionar.jsp" class="button">Adicionar</a>
            </div>

        </main>

    </body>

</html>
