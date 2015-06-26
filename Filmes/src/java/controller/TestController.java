package controller;

import java.io.IOException;

public class TestController extends Controller {

    public void test() {
        this.redirect(PessoaController.class, "tela_adicionar");
    }

    public void test_ajax() throws IOException {
        String name;
        name = "Hello " + request.getParameter("user");
        if (request.getParameter("user").equals("")) {
            name = "Hello Usuário: ";
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        // essa será a string retornada
        response.getWriter().write(name);
        // como é uma requisicao ajax (não haverá redirecionamento)
        this.hasPageJsp = false;
    }
    
    
}
