<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/> 
    </head>
    <body>
        <div class="container-fluid">
            <a href="Servlet?controller=admin&method=listaFilmes">Voltar</a>
            <form method="post" action="Servlet?controller=admin&method=adicionarFilme" role="form" id="form">
                <div class="form-group"> 
                  <label for="titulo">Título:</label>
                  <input type="text" name="titulo" id="titulo" required><br>
                </div>
                <div class="form-group"> 
                  <label for="genero">Genero:</label>
                  <select name="genero" id="genero">
                      <c:forEach items="${generos}" var="genero" >
                          <option value=${genero.id}>
                              ${genero.nome}
                          </option>
                      </c:forEach>
                  </select><br>
                </div>
                <div class="form-group"> 
                  <label for="link">Link do trailer (após /watch?v=):</label>
                  <input type="text" name="link" id="link" required><br>
                </div>
                <div class="form-group"> 
                  <label for="classificacao">Classificação etária:</label>
                  <select name="classificacao" id="classificacao">
                      <c:forEach items="${classificacoes}" var="classificacao">
                          <option value=${classificacao.id}>
                              ${classificacao.descricao}
                          </option>
                      </c:forEach>
                  </select><br>
                </div>
                <div class="form-group"> 
                  <label for="diretor">Diretor:</label>
                  <input type="text" name="diretor" id="diretor" required><br>
                </div>
                <div class="form-group"> 
                  <label for="duracao">Duracao(minutos):</label>
                  <input type="number" name="duracao" min="0" id="duracao" required><br>
                </div>
                <div class="form-group"> 
                  <label for="sinopse">Sinopse:</label>
                  <input type="textarea" name="sinopse" id="sinopse" required><br>
                </div>
                <div class="form-group"> 
                  <label for="elenco">Elenco:</label>
                  <input type="text" name="elenco" id="elenco" required>
                </div>
                <div class="form-group"> 
                  <input type="submit">
                </div>
              </form> 
        </div>
    </body>
</html>