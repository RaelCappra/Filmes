<%-- 
    Document   : menuAdmin
    Created on : 02/07/2015, 05:39:40
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
        <title>Página do administrador</title>
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
        <link href="css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/> 
    </head>
    <body>
        <div class="container-fluid">
            <div class="well">
                ${mensagem}<br>
                <a href="Servlet?controller=admin&method=listaFilmes">Filmes</a><br>
                <a href="Servlet?controller=admin&method=sessoes">Sessões</a><br>
                <a href="Servlet?controller=admin&method=logout">Logout</a>
             </div>
        </div>
    </body>
</html>
