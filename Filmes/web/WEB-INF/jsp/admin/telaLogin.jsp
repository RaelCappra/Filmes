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
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/> 
    </head>
    <body>
        <div class="container-fluid">
            ${mensagem}


            <form method="post" action="Servlet?controller=admin&method=login" role="form">

                <div class="form-control">
                    <label for="login">Login</label>
                    <input type="text" name="login" id="login" required/>
                </div>

                <div class="form-control">


                    <label for="senha">Senha</label>
                    <input type="password" name="senha" required/>
                </div>
                <div class="form-control">
                    <input type="submit" value="Login" />
                </div>
            </form>
            <br><br>
            <a href="Servlet?controller=sessao&method=index">Home</a>
        </div>
    </body>
</html>
