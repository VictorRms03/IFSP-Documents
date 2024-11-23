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
                <h1>Alterar DVD</h1>
            </div>

            <div class="div-form">

                <form method="POST" action="${cp}/processaDvds" class="form-personalizado">

                    <input type="hidden" name="id" value="${requestScope.dvd.id}">
                    <input type="hidden" name="acao" value="alterar">

                    <table>

                        <thead>

                            <th colspan="3">Alterar "${requestScope.dvd.titulo}" - ID: ${requestScope.dvd.id} </th>

                        </thead>

                        <tbody>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Alteração">
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="titulo">Título: </label>
                                </td>

                                <td>
                                    <input type="text" 
                                            size="20" 
                                            maxlength="100" 
                                            name="titulo" 
                                            id="titulo" 
                                            value="${requestScope.dvd.titulo}"
                                            required>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="anoLancamento">Ano de Lançamento: </label>
                                </td>

                                <td>
                                    <input type="number" 
                                            size="8" 
                                            name="anoLancamento" 
                                            id="anoLancamento" 
                                            value="${requestScope.dvd.anoLancamento}" 
                                            required>
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="dataLancamento">Data de Lançamento: </label>
                                </td>

                                <td>
                                    <input type="date" 
                                            size="8" 
                                            name="dataLancamento" 
                                            id="dataLancamento" 
                                            value="${requestScope.dvd.dataLancamento}" 
                                            required>
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="duracaoMinutos">Duração (Min): </label>
                                </td>

                                <td>
                                    <input type="number" 
                                            size="8" 
                                            name="duracaoMinutos" 
                                            id="duracaoMinutos" 
                                            value="${requestScope.dvd.duracaoMinutos}" 
                                            required>
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="idAtorPrincipal">Ator Principal: </label>
                                </td>

                                <td>
                                    <select name="idAtorPrincipal" required>
                                        
                                        <c:forEach items="${servicosAtores.todos}" var="ator">
                                          
                                            <c:choose>
                                                
                                                <c:when test="${ requestScope.dvd.atorPrincipal.id eq ator.id }">
                                                    <option value="${ator.id}" selected>
                                                        ${ator.nome} ${ator.sobrenome}
                                                    </option>
                                                </c:when>    
                                                
                                                <c:otherwise>
                                                    <option value="${ator.id}">
                                                        ${ator.nome} ${ator.sobrenome}
                                                    </option>
                                                </c:otherwise>
                                                
                                            </c:choose>
                                                    
                                        </c:forEach>
                                        
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idAtorCoadjuvante">Ator Coadjuvante: </label>
                                </td>
                                
                                <td>
                                    <select name="idAtorCoadjuvante" required>
                                        
                                        <c:forEach items="${servicosAtores.todos}" var="ator">
                                          
                                            <c:choose>
                                                
                                                <c:when test="${ requestScope.dvd.atorCoadjuvante.id eq ator.id }">
                                                    <option value="${ator.id}" selected>
                                                        ${ator.nome} ${ator.sobrenome}
                                                    </option>
                                                </c:when>    
                                                
                                                <c:otherwise>
                                                    <option value="${ator.id}">
                                                        ${ator.nome} ${ator.sobrenome}
                                                    </option>
                                                </c:otherwise>
                                                
                                            </c:choose>
                                                    
                                        </c:forEach>
                                        
                                    </select>
                                </td>
                              
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idClassificacaoEtaria">Classificação Etária: </label>
                                </td>

                                <td>

                                    <select name="idClassificacaoEtaria" required>
                                        
                                        <c:forEach items="${servicosClassificacoesEtarias.todos}" var="classificacaoEtaria">
                                            
                                            <c:choose>
                                                
                                                <c:when test="${ requestScope.dvd.classificacaoEtaria.id eq classificacaoEtaria.id }">
                                                    <option value="${classificacaoEtaria.id}" selected>
                                                        ${classificacaoEtaria.descricao}
                                                    </option>
                                                </c:when>    
                                                
                                                <c:otherwise>
                                                    <option value="${classificacaoEtaria.id}">
                                                        ${classificacaoEtaria.descricao}
                                                    </option>
                                                </c:otherwise>
                                                
                                            </c:choose>
                                        
                                        </c:forEach>
                                        
                                    </select>

                                </td>
                              
                            </tr>
                            
                            <tr>
                                
                                <td> 
                                    <label for="idGenero">Gênero: </label>
                                </td>

                                <td>

                                    <select name="idGenero" required>
                                        
                                        <c:forEach items="${servicosGeneros.todos}" var="genero">

                                            <c:choose>
                                                
                                                <c:when test="${ requestScope.dvd.genero.id eq genero.id }">
                                                    <option value="${genero.id}" selected>
                                                        ${genero.descricao}
                                                    </option>
                                                </c:when>    
                                                
                                                <c:otherwise>
                                                    <option value="${genero.id}">
                                                        ${genero.descricao}
                                                    </option>
                                                </c:otherwise>
                                                
                                            </c:choose>

                                        </c:forEach>
                                        
                                    </select>

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
                <a href="${cp}/entidades/dvds/listagem.jsp" class="button">Voltar</a>
            </div>

        </main>

    </body>

</html>
