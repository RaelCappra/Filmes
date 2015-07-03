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
        <a href="Servlet?controller=admin&method=menuAdmin">Voltar</a>
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
            <c:forEach var="filme" items="${filmes}">
                <tr>
                    <td>
                        <a href="Servlet?controller=filme&method=descricao&id=${filme.id}">
                            <img src="assets/${filme.urlCartaz}" width="170" height="240">
                        </a>
                        <form id="formImagem${filme.id}" name="formImagem${filme.id}" method="post" action="Servlet?controller=admin&method=editarCartaz&id=${filme.id}" enctype="multipart/form-data">
                            <input type="hidden" id="tipoForm" name="tipoForm" value="imagem">
                            <%--<input type="hidden" id="controller" name="controller" value="admin">
                            <input type="hidden" id="method" name="method" value="editarCartaz">
                            <input type="hidden" id="id" name="id" value="${filme.id}">--%>
                            <input name="imagem" type="file" accept="image/jpeg; image/gif; image/bmp; image/png" id="imagem" class="dados" maxlength="60" value="c:/">
                            <input type="submit" id="upload" name="upload">
                        </form>

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
                        <a href="http://youtube.com/watch?v=${filme.linkTrailer}">
                            youtube.com/watch?v=${filme.linkTrailer}</a>
                    </td>
                    <td>
                        ${filme.genero.nome}
                    </td>
                    <td>
                        ${filme.classificacao.descricao}
                    </td>
                    <td>
                        <a href="Servlet?controller=admin&method=excluirFilme&id=${filme.id}">
                            X
                        </a>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td><a href="Servlet?controller=filme&method=telaAdicionar">Adicionar Filme</a></td>
                </tr>
        </table>
        
    </body>
</html>
