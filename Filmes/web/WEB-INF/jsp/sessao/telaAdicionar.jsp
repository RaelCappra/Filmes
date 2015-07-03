<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        
        <form method="post" action="Servlet?controller=admin&method=adicionarSessao">
              Hora inicio:<input type="date" name="data" required><input type="time" name="hora" required> <br>
              
              Filme:<select name ="filme" required>
                <c:forEach items="${filmes}" var="filme">
                    <option value="${filme.id}">${filme.titulo}</option> 
                </c:forEach>
              </select><br>
              Preço para adulto:<input type="number" name="valorAdulto" step="0.01" min="0" required><br>
              Preço para estudante:<input type="number" name="valorEstudante" step="0.01" min="0" required><br>
              Preço para idoso:<input type="number" name="valorIdoso" step="0.01" min="0" required><br>
              Sala:<input type="number" name="sala" min="1"><br>
              3D <input type="checkbox" name="3d" value="3d"><br>
              Legendado <input type="checkbox" name="legendado" value="legendado"><br>
              <input type="submit">
        </form>  
            
        </div>
    </body>
</html>
