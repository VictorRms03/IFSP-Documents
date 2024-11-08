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
                <h1>Alterar Ator</h1>
            </div>

            <div class="alterar-div-form">

                <form action="" style="display: flex; flex-direction: column;">

                    <div>
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" id="nome" placeholder="NOME">
                    </div>
                    
                    <div>
                        <label for="sobrenome">Sobrenome: </label>
                        <input type="text" name="sobrenome" id="sobrenome" placeholder="SOBRENOME">
                    </div>
                    
                    <div>
                        <label for="dataEstreia">Data de Estréia: </label>
                        <input type="date" name="dataEstreia" id="dataEstreia" placeholder="DATA-ESTREIA">
                    </div>
                    

                    <input type="submit" value="Confirmar Alteração">

                </form>

            </div>

            <div class="alterar-div-options">

                <a href="">Voltar</a>

            </div>




        </main>

        <footer>
            <span>Victor Ramos - Instituto Federal de São Paulo @ 2024</span>
        </footer>

    </body>

</html>
