﻿﻿﻿<%-- 
    Document   : descricao
    Created on : 02/07/2015, 05:14:20
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"> 
        <title>${filme.titulo}</title>
    </head>
    <body>
        <div class="container-fluid">
            <a href="Servlet?controller=sessao&method=index">Voltar</a>
            <table class="table">
            <tr>
                <th>
                    Cartaz
                </th>
                <th>
                    Título
                </th>
                <th>
                    Gênero
                </th>
                <th>
                    Classificação
                </th>
                <th>
                    Elenco
                </th>
                <th>
                    Sinopse
                </th>
                <th>
                    Trailer
                </th>
            </tr>
            <tr>
                <td><img src="assets/${filme.urlCartaz}"></td>
                <td>${filme.titulo}</td>
                <td>${filme.genero.nome}</td>
                <td>${filme.classificacao.descricao}</td>
                <td>${filme.elenco}</td>
                <td>${filme.sinopse}</td>
                <td><iframe width="300" height="300" src="https://youtube.com/embed/${filme.linkTrailer}" frameborder="0" allowfullscreen></iframe></td>
            </tr>
        </table></div>
    </body>
</html>
