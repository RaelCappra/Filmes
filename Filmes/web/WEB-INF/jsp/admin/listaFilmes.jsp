<%-- 
    Document   : adminFilmes
    Created on : 02/07/2015, 11:05:56
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filmes cadastrados</title>
    </head>
    <body>
        
        <table>
            <tr colspan="100">
                <th>
                    Filme
                </th>
            </tr>
            <tr>
                <th>
                    Cartaz
                </th>
                <th>
                    Título
                </th>
                <th>
                    Duração
                </th>
                <th>
                    Direção
                </th>
                <th>
                    Elenco
                </th>
                <th>
                    Sinopse
                </th>
                <th>
                    Link do trailer (yt)
                </th>
                <th>
                    Gênero
                </th>
                <th>
                    Classificação
                </th>
            </tr>

            <c:if test="${inicio == null}">
                <c:set var="inicio" value="0"/>
            </c:if>
            <c:if test="${fim == null}">
                <c:set var="fim" value="6"/>
            </c:if>
            <c:forEach var="filme" items="${filmes}">
                <tr>
                    <td>
                        <a href="Servlet?controller=Filme&method=descricao&id=${sessao.filme.id}">
                            PLACEHOLDER
                        </a>
                    </td>
                    <td>
                        ${filme.titulo}
                    </td>
                    <td>
                </td>
                <td>
                ${filme.duracaoMinutos} minutos
                </td>
                <td>
                ${filme.direcao}
                </td>
                <td>
                ${filme.elenco}
                </td>
                <td>
                ${filme.sinopse}
                </td>
                <td>
                ${filme.linkTrailer}
                </td>
                <td>
                ${filme.genero.nome}
                </td>
                <td>
                ${filme.classificacao.descricao}
                </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
