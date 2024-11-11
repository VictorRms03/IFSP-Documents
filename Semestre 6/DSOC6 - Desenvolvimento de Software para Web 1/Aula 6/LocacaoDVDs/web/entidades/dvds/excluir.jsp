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
            
            <jsp:useBean id="servicosAtores" scope="page" class="locacaodvds.servicos.AtoresServices"/>
            <jsp:useBean id="servicosClassificacoesEtarias" scope="page" class="locacaodvds.servicos.ClassificacaoEtariaServices"/>
            <jsp:useBean id="servicosGeneros" scope="page" class="locacaodvds.servicos.GenerosServices"/>

            <div class="page-title">
                <h1>Excluir DVD</h1>
            </div>

            <div class="alterar-div-form">

                <form method="POST" action="${cp}/processaDvds" class="alterar-form">

                    <input type="hidden" name="id" value="${requestScope.dvd.id}">
                    <input type="hidden" name="acao" value="excluir">

                    <table>

                        <thead>

                            <th colspan="3">Excluir "${requestScope.dvd.titulo}" - ID: ${requestScope.dvd.id} </th>

                        </thead>

                        <tbody>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Exclusão">
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="titulo">Título: </label>
                                </td>

                                <td>
                                    <input type="text" name="titulo" id="titulo" value="${requestScope.dvd.titulo}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="anoLancamento">Ano de Lançamento: </label>
                                </td>

                                <td>
                                    <input type="text" name="anoLancamento" id="anoLancamento" value="${requestScope.dvd.anoLancamento}" disabled>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="dataLancamento">Data de Lançamento: </label>
                                </td>

                                <td>
                                    <input type="date" name="dataLancamento" id="dataLancamento" value="${requestScope.dvd.dataLancamento}" disabled>
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="duracaoMinutos">Duração (Min): </label>
                                </td>

                                <td>
                                    <input type="number" name="duracaoMinutos" id="duracaoMinutos" value="${requestScope.dvd.duracaoMinutos}" disabled>
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="idAtorPrincipal">Ator Principal: </label>
                                </td>

                                <td>
                                    <select name="idAtorPrincipal" disabled>
                                        
                                        <option value="${requestScope.dvd.atorPrincipal.id}" selected>
                                            ${requestScope.dvd.atorPrincipal.nome} ${requestScope.dvd.atorPrincipal.sobrenome}
                                        </option>
                                        
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idAtorCoadjuvante">Ator Coadjuvante: </label>
                                </td>
                                
                                <td>
                                    <select name="idAtorCoadjuvante" disabled>
                                        
                                        <option value="${requestScope.dvd.atorCoadjuvante.id}" selected>
                                            ${requestScope.dvd.atorCoadjuvante.nome} ${requestScope.dvd.atorCoadjuvante.sobrenome}
                                        </option>
                                        
                                    </select>
                                </td>
                              
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idClassificacaoEtaria">Classificação Etária: </label>
                                </td>

                                <td>

                                    <select name="idClassificacaoEtaria" disabled>
                                        
                                        <option value="${requestScope.dvd.classificacaoEtaria.id}" selected>
                                            ${requestScope.dvd.classificacaoEtaria.descricao}
                                        </option>
                                        
                                    </select>

                                </td>
                              
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idGenero">Gênero: </label>
                                </td>

                                <td>

                                    <select name="idGenero" disabled>
                                        
                                        <option value="${requestScope.dvd.genero.id}" selected>
                                            ${requestScope.dvd.genero.descricao}
                                        </option>
                                        
                                    </select>

                                </td>
                              
                            </tr>
                            
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Exclusão">
                                </td>
                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

            <div class="alterar-div-options">

                
                <a href="${cp}/entidades/dvds/listagem.jsp">Voltar</a>

            </div>

        </main>

        <footer class="footer">
            <p class="footer-copyright">Victor Ramos - Instituto Federal de São Paulo @ 2024</p>
        </footer>

    </body>

</html>
