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
            
            <a href="${cp}/index.jsp"> 
                <img src="${cp}/images/dvdLogo.png" alt="" class="logo-img"> 
            </a>


            <div class="header-options">
                <div>
                    <a href="${cp}/index.jsp"> Início </a>
                </div>

                <hr>

                <div>
                    <a href="${cp}/entidades/dvds/listagem.jsp"> DVD's </a>
                </div>

                <hr>

                <div>
                    <a href="${cp}/entidades/atores/listagem.jsp"> Atores </a>
                </div>

                <hr>

                <div>
                    <a href="${cp}/entidades/classificacoesEtarias/listagem.jsp"> Classificações Etárias </a>
                </div>

                <hr>

                <div>
                    <a href="${cp}/entidades/generos/listagem.jsp"> Gêneros </a>
                </div>
            </div>


        </header>

        <main>

            <div class="page-title">
                <h1>Atores</h1>
                <p>Conheça os atores mais famosos para se ver na telinha!</p>
            </div>

            <div class="listagem-div-table">

                <table>

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Sobrenome</th>
                            <th>Data de Estreia</th>
                            <th>Alterar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>

                    <tbody>

                        <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.AtoresServices"/>
                
                        <c:forEach items="${servicos.todos}" var="ator">

                            <tr>

                                <td>${ator.id}</td>
                                <td>${ator.nome}</td>
                                <td>${ator.sobrenome}</td>
                                <td>${ator.dataEstreia}</td>

                                <td>
                                    <a href="${cp}/processaAtores?acao=prepararAlteracao&id=${ator.id}">
                                        Alterar
                                    </a>
                                </td>

                                <td>
                                    <a href="${cp}/processaAtores?acao=prepararExclusao&id=${ator.id}">
                                        Excluir
                                    </a>
                                </td>

                            </tr>

                        </c:forEach>
                      </tbody>

                </table>

            </div>

            <div class="listagem-div-options">

                <a href="${cp}/entidades/atores/adicionar.jsp">Adicionar</a>

            </div>




        </main>

        <footer>
            <span>Victor Ramos - Instituto Federal de São Paulo @ 2024</span>
        </footer>

    </body>

</html>
