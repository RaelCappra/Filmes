﻿﻿<%-- 
    Document   : index
    Created on : 02/07/2015, 01:29:00
    Author     : Rael
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
        <title>Arquivo de filmes</title>
    </head>
    <body>
        <a href="Servlet?controller=admin&method=menuAdmin">Voltar</a>
        <table>
            <tr colspan="10">
                <th>
                    Todas as sessões
                </th>
            </tr>
            <tr>
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
                <th>
                    Excluir
                </th>
            </tr>
            
            <c:if test="${inicio == null}">
                <c:set var="inicio" value="0"/>
            </c:if>
            <c:if test="${fim == null}">
                <c:set var="fim" value="6"/>
            </c:if>
            <c:forEach var="sessao" items="${sessoes}">
                <tr>
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
                        <input type="checkbox" ${sessao.is3d ? "checked" : ""}>
                    </td>
                    <td>
                        <input type="checkbox" ${sessao.isLegendado ? "checked" : ""}>
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
                    <td>
                        <a href="Servlet?controller=admin&method=excluirSessao&id=${sessao.id}">
                            X
                        </a>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td><a href="Servlet?controller=sessao&method=telaAdicionar">Adicionar Sessão</a></td>
                </tr>
        </table>
        
        </body>
</html>
