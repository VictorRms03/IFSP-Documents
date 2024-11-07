<%-- 
    Document   : listagem
    Created on : 6 de nov. de 2024, 22:18:42
    Author     : Victor Ramos - BV3026191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora DVD's - Listagem de Atores</title>
        <link rel="stylesheet" href="${cp}/css/style.css">

    </head>

    <body>
        
        <header>
            
            <a href="index.jsp"> 
                <img src="/images/dvdLogo.png" alt="" class="logo-img"> 
            </a>


            <div class="header-options">
                <div>
                    <a href="/index.jsp"> Início </a>
                </div>

                <hr>

                <div>
                    <a href="/entidades/dvds/listagem.jsp"> DVD's </a>
                </div>

                <hr>

                <div>
                    <a href="/entidades/atores/listagem.jsp"> Atores </a>
                </div>

                <hr>

                <div>
                    <a href="/entidades/classificacoesEtarias/listagem.jsp"> Classificações Etárias </a>
                </div>

                <hr>

                <div>
                    <a href="/entidades/generos/listagem.jsp"> Gêneros </a>
                </div>
            </div>


        </header>

        <main>

            <div class="home-title">
                <h1>Locadora de DVD's</h1>
                <p>A Locadora com o melhor atendimento!</p>
            </div>

            <div class="home-item-row">

                <div class="home-item-box">
                    
                    <h3>Conheça os Atores</h3>

                    <img src="/images/silhueta.png" alt="">

                    <a href="/entidades/atores/listagem.jsp" class="home-item-btn" >Clique Aqui!</a>
                    
                </div>

                <div class="home-item-box">
                    
                    <h3>Conheça os DVD's</h3>

                    <img src="/images/dvd.png" alt="">

                    <a href="/entidades/dvds/listagem.jsp" class="home-item-btn">Clique Aqui!</a>
                    
                </div>

            </div>

            <div class="home-item-row">

                <div class="home-item-box">
                    
                    <h3>Entenda as Classificações Etarias</h3>

                    <img src="/images/classificacaoEtaria.jpg" alt="">

                    <a href="/entidades/classificacoesEtarias/listagem.jsp" class="home-item-btn">Clique Aqui!</a>
                    
                </div>

                <div class="home-item-box">
                    
                    <h3>Explore os Gêneros</h3>

                    <img src="/images/generos2.png" alt="">

                    <a href="/entidades/generos/listagem.jsp" class="home-item-btn">Clique Aqui!</a>
                    
                </div>

            </div>

        </main>

        <footer>
            <span>Victor Ramos - Instituto Federal de São Paulo @ 2024</span>
        </footer>

    </body>

</html>
