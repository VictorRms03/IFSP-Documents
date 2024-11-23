<%-- 
    Document   : index
    Created on : 26 de out. de 2024, 22:07:54
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
                <h1>Locadora de DVD's</h1>
                <p>A Locadora com o melhor atendimento!</p>
            </div>

            <div class="home-item-row">

                <div class="home-item-box">

                    <h3>Conheça os DVD's</h3>

                    <img src="${cp}/images/dvd.png" alt="">

                    <a href="${cp}/entidades/dvds/listagem.jsp" class="home-item-btn button">Clique Aqui!</a>

                </div>
                    
                <div class="home-item-box">

                    <h3>Conheça os Atores</h3>

                    <img src="${cp}/images/silhueta.png" alt="">

                    <a href="${cp}/entidades/atores/listagem.jsp" class="home-item-btn button" >Clique Aqui!</a>

                </div>

            </div>

            <div class="home-item-row">

                <div class="home-item-box">

                    <h3>Entenda as Classificações Etárias</h3>

                    <img src="${cp}/images/classificacaoEtaria.jpg" alt="">

                    <a href="${cp}/entidades/classificacoesEtarias/listagem.jsp" class="home-item-btn button">Clique Aqui!</a>

                </div>

                <div class="home-item-box">

                    <h3>Explore os Gêneros</h3>

                    <img src="${cp}/images/generos.png" alt="">

                    <a href="${cp}/entidades/generos/listagem.jsp" class="home-item-btn button">Clique Aqui!</a>

                </div>

            </div>

        </main>

        <footer class="footer">
            <p class="footer-copyright">Victor Ramos - Instituto Federal de São Paulo @ 2024</p>
        </footer>

    </body>

</html>
