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
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <link href="css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/> 
    </head>
    <body>
        <a href="Servlet?controller=admin&method=menuAdmin">Voltar</a>
        <table class="table table-bordered">
            <tr colspan="100">
                <th colspan="100">
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
                    Editar
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
                <form id="formEditar${filme.id}" name="formEditar${filme.id}" method="post" role="form" action="Servlet?controller=admin&method=editarFilme&id=${filme.id}">
                    <td>
                        <input type="text" name="titulo" id="titulo" required value=" ${filme.titulo}">
                    </td>
                    <td>
                        <input type="number" name="duracao" min="0" id="duracao" value="${filme.duracaoMinutos}" required> minutos
                    </td>
                    <td>
                        <input type="text" name="diretor" id="diretor" required value=" ${filme.direcao}">
                    </td>
                    <td>
                        <input type="text" name="elenco" id="elenco" required value=" ${filme.elenco}">
                    </td>
                    <td>
                        <input type="text" name="sinopse" id="sinopse" required value=" ${filme.sinopse}">
                    </td>
                    <td>
                        <a href="http://youtube.com/watch?v=${filme.linkTrailer}">
                            http://youtube.com/watch?v=</a>
                        <input type="text" name="link" id="link" required value=" ${filme.linkTrailer}">
                    </td>
                    <td>
                        <select name="genero" id="genero">
                            <c:forEach items="${generos}" var="genero" >
                                <option value=${genero.id} 
                                        ${genero.id eq filme.genero.id ? "selected" : ""}>
                                    ${genero.nome}
                                </option>
                            </c:forEach>
                        </select>

                    </td>
                    <td>
                        <select name="classificacao" id="classificacao">
                            <c:forEach items="${classificacoes}" var="classificacao">
                                <option value=${classificacao.id}
                                        ${classificacao.id eq filme.classificacao.id ? "selected" : ""}>
                                    ${classificacao.descricao}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="submit">
                    </td>
                    
                </form>
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
