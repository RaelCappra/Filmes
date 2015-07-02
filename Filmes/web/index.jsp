﻿<%-- 
    Document   : index
    Created on : 02/07/2015, 01:29:00
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-16"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            window.location = "Servlet?controller=Sessao&method=index";
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arquivo de filmes</title>
    </head>
    <body>
        <table>
            <tr colspan="10">
                <th>
                    Sessões de cinema em breve
                </th>
            </tr>
            <tr>
                <th>
                    Cartaz
                </th>
                <th>
                    Filme
                </th>
                <th>
                    Horário
                </th>
                <th>
                    Duração
                </th>
            </tr>
            <c:forEach var="sessao" items="${sessoes}">
                <tr>
                    <td>
                        PLACEHOLDER
                    </td>
                    <td>
                        ${sessao.filme.titulo}
                    </td>
                    <td>
                        ${sessao.horario.date}
                    </td>
                    <td>
                        ${sessao.filme.duracaoMinutos}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
