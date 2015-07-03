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
        ${mensagem}
        <form method="post" action="Servlet?controller=admin&method=login">
            <table>
                <tr>
                    <td><label for="login">Login</label></td>
                <a href="admin.jsp"></a>
                    <td><input type="text" name="login" id="login" required/></td>
                </tr>
                <tr>
                    <td><label for="senha">Senha</label></td>
                    <td><input type="password" name="senha" required/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
