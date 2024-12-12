<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${cp}/js/lib/jquery/jquery.min.js"></script>
        <script src="${cp}/js/fruta.js"></script>
        <title>Fruta</title>
    </head>
    <body>
        <div>
            <h1>Listagem Fruta</h1>
            <button onclick="cadastrar(event)">Cadastrar uma fruta</button>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Cor</th>
                </tr>
            </thead>
            <tbody id="tabela">
            </tbody>
        </table>
        <div>
            <a href="${cp}/index.jsp"><button>Voltar</button></a>
        </div>
    </body>
</html>
