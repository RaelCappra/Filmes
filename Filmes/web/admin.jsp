<%-- 
    Document   : admin
    Created on : 02/07/2015, 01:29:13
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Cinema</title>
    </head>
    <body>
        <form method="post" action="Servlet?controller=Admin&method=login">
            <table>
                <tr>
                    <td><label for="login">Login</label></td>
                <a href="admin.jsp"></a>
                    <td><input type="text" name="login" id="login" /></td>
                </tr>
                <tr>
                    <td><label for="senha">Senha</label></td>
                    <td><input type="password" name="senha" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
