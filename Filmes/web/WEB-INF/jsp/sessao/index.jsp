﻿﻿﻿﻿﻿﻿﻿<%-- 
    Document   : index
    Created on : 02/07/2015, 01:29:00
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-16"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de cinema</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <tr colspan="10">
                    <th>
                        Sessões de cinema futuras
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
                    <th>
                        3d
                    </th>
                    <th>
                        Legendado
                    </th>
                    <th>
                        Sala
                    </th>
                    <th>
                        Ingresso Adulto
                    </th>
                    <th>
                        Ingresso Estudante
                    </th>
                    <th>
                        Ingresso Idoso
                    </th>
                </tr>

                <c:if test="${inicio == null}">
                    <c:set var="inicio" value="0"/>
                </c:if>
                <c:if test="${fim == null}">
                    <c:set var="fim" value="6"/>
                </c:if>
                <c:forEach var="sessao" items="${sessoes}" begin="${inicio}" end="${fim}">
                    <tr>
                        <td>
                            <a href="Servlet?controller=filme&method=descricao&id=${sessao.filme.id}">
                                <img src="assets/${sessao.filme.urlCartaz}">
                            </a>
                        </td>
                        <td>
                            ${sessao.filme.titulo}
                        </td>
                        <td>
                            <fmt:formatDate value="${sessao.horario.time}" pattern="dd/MM/yyyy - HH:mm"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sessao.duracaoEmDate}" pattern="HH:mm"/>
                        </td>
                        <td>
                            ${sessao.is3d ? "sim" : "não"}
                        </td>
                        <td>
                            ${sessao.isLegendado? "sim" : "não"}
                        </td>
                        <td>
                            ${sessao.sala}
                        </td>
                        <td>
                            R$ ${sessao.valorAdulto}
                        </td>
                        <td>
                            R$ ${sessao.valorEstudante}
                        </td>
                        <td>
                            R$ ${sessao.valorIdoso}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${inicio > 0}">
                <a href="Servlet?controller=sessao&method=index&inicio=${inicio - 6}&fim=${fim - 6}"><<</a>
            </c:if>
            <c:if test="${fim < sessoesSize}">
                <a href="Servlet?controller=sessao&method=index&inicio=${inicio + 6}&fim=${fim + 6}">>></a>
            </c:if>
        </div>
    </body>
</html>
