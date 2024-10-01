<%-- 
    Document   : montadorTabela
    Created on : 1 de out. de 2024, 10:24:02
    Author     : victo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            table, tr, td {
                border: 1px solid black;
            }
        </style>
        
    </head>
    <body>
        
        <c:if test="${param.linhas>0 && param.colunas>0}">
            
        </c:if>
        
        <c:choose>
            
            <c:when test="${ (param.linhas <= 0) && (param.colunas <= 0) }">
                Linhas ou Colunas Invalidas.
            </c:when>   
                
            <c:otherwise>
                
                <table>
                
                    <c:forEach begin="1" end="${param.linhas}" varStatus="i">

                        <tr>

                        <c:forEach begin="1" end="${param.colunas}" varStatus="j">

                            <td> ${i.count} ${j.count} </td>

                        </c:forEach>

                        </tr>

                    </c:forEach>

                </table>
               
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
