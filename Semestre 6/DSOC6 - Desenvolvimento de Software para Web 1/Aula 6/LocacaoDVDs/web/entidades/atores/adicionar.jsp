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
                <h1>Adicionar Ator</h1>
            </div>

            <div class="alterar-div-form">

                <form method="POST" action="${cp}/processaAtores" class="alterar-form">

                    <input type="hidden" name="acao" value="adicionar">

                    <table>

                        <thead>

                            <th colspan="3">Adicionar Ator</th>

                        </thead>

                        <tbody>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Adição">
                                </td>
                            </tr>
                            
                            <tr>
                                <td> 
                                    <label for="nome">Nome: </label>
                                </td>

                                <td>
                                    <input type="text" name="nome" id="nome" placeholder="Nome">
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="sobrenome">Sobrenome: </label>
                                </td>

                                <td>
                                    <input type="text" name="sobrenome" id="sobrenome" placeholder="Sobrenome">
                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <label for="dataEstreia">Data de Estreia: </label>
                                </td>

                                <td>
                                    <input type="date" name="dataEstreia" id="dataEstreia">
                                </td>
                            </tr>
                            
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Confirmar Adição">
                                </td>
                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

            <div class="alterar-div-options">

                
                <a href="${cp}/entidades/atores/listagem.jsp">Voltar</a>

            </div>

        </main>

        <footer>
            <span>Victor Ramos - Instituto Federal de São Paulo @ 2024</span>
        </footer>

    </body>

</html>
