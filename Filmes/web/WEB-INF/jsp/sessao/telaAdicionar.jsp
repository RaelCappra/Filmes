<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <link href="css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/> 
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <a href="Servlet?controller=admin&method=sessoes">Voltar</a>
            <form method="post" action="Servlet?controller=admin&method=adicionarSessao" role="form">
                <div class="form-group"> 
                    Hora inicio:<input type="date" name="data" required><input type="time" name="hora" required> <br>

                    <div class="form-group"> 
                        Filme:<select name ="filme" required>
                            <c:forEach items="${filmes}" var="filme">
                                <option value="${filme.id}">${filme.titulo}</option> 
                            </c:forEach>
                        </select><br>
                    </div>
                    <div class="form-group"> 
                        Preço para adulto:
                        <input type="number" name="valorAdulto" step="0.01" min="0" required><br>
                    </div>
                    <div class="form-group"> 
                        Preço para estudante:<input type="number" name="valorEstudante" step="0.01" min="0" required><br>
                    </div>
                    <div class="form-group"> 
                        Preço para idoso:<input type="number" name="valorIdoso" step="0.01" min="0" required><br>
                    </div>
                    <div class="form-group"> 
                        Sala:<input type="number" name="sala" min="1"><br>
                    </div>
                    <div class="form-group"> 
                        3D <input type="checkbox" name="3d" value="3d"><br>
                    </div>
                    <div class="form-group"> 
                        Legendado <input type="checkbox" name="legendado" value="legendado"><br>
                    </div>
                    <div class="form-group"> 
                        <input type="submit">
                    </div>
            </form>  

        </div>
    </body>
</html>
