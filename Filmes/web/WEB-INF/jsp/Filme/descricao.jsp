<%-- 
    Document   : descricao
    Created on : 02/07/2015, 05:14:20
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${filme.titulo}</title>
    </head>
    <body>
        <table>
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
                <td>PLACEHOLDER</td>
                <td>${filme.titulo}</td>
                <td>${filme.genero.nome}</td>
                <td>${filme.classificacao.descricao}</td>
                <td>${filme.elenco}</td>
                <td>${filme.sinopse}</td>
                <td><iframe width="300" height="300" src="${filme.linkTrailer}" frameborder="0" allowfullscreen></iframe></td>
            </tr>
        </table>
    </body>
</html>
