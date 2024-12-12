<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Padroes em Pratica Ajax</title>
    </head>
    <body>
        <div class="titulo-botoes">
            <h1>Atividades</h1>
            <a href="${cp}/listagemFruta.jsp"><button>Frutas</button></a>
            <a href="${cp}/listagemCarro.jsp"><button>Carros</button></a>
            <a href="${cp}/listagemProduto.jsp"><button>Produtos</button></a>
        </div>
    </body>
</html>