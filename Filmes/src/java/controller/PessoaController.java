package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import database.PessoaDAO;

public class PessoaController extends Controller {

    public void listar() throws SQLException {
        this.request.setAttribute("vetPessoa", new PessoaDAO().listar());
        // logo após será enviado (automaticamente) para /WEB-INF/jsp/pessoa/listar.jsp
    }

    public void autenticar() throws SQLException, IOException {
        PrintWriter out;
        out = this.response.getWriter();
        HttpSession session = this.request.getSession(true);
        session.setAttribute("login", this.request.getParameter("login"));
        session.setAttribute("senha", this.request.getParameter("senha"));
        out.println("Login:" + this.request.getParameter("login"));
        out.println("Senha:" + this.request.getParameter("senha"));
        out.println("Autenticou?:" + new PessoaDAO().autenticar(this.request.getParameter("login"), this.request.getParameter("senha")));
        // caso eu determine que não ha nem redirecionamento nem pagina jsp
        this.hasPageJsp = false;
    }

    public void tela_adicionar() throws ServletException, IOException {
        // irá cair para a tela_adicionar.jsp
    }

    public void listarPOG() throws ServletException, IOException {
        // somente por teste redirecionei para outro controller
        this.redirect(TestController.class, "test");
    }

    public void tela_editar() throws ServletException, IOException, SQLException {
        this.request.setAttribute("pessoa", new PessoaDAO().obter(Integer.parseInt(this.request.getParameter("id"))));
    }

    public void adicionar() throws ServletException, IOException, SQLException {
        // depois de executar a função de adicionar - redireciono para a função de listar (que está no mesmo controller)
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.request.getParameter("nome"));
        pessoa.setSobrenome(this.request.getParameter("sobrenome"));
        new PessoaDAO().adicionar(pessoa);
        // momento do redirecionamento
        this.redirect("listar");
    }

    public void excluir() throws ServletException, IOException, SQLException {
        new PessoaDAO().excluir(Integer.parseInt(this.request.getParameter("id")));
        this.redirect(PessoaController.class, "listar");
    }

    public void editar() throws ServletException, IOException, SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(Integer.parseInt(this.request.getParameter("id")));
        pessoa.setNome(this.request.getParameter("nome"));
        pessoa.setSobrenome(this.request.getParameter("sobrenome"));
        new PessoaDAO().editar(pessoa);
        // a função do redirecionamento recebe Controller.class (neste caso PessoaController) e o method (como String)
        this.redirect(PessoaController.class, "listar");
    }
    
     public void search() throws IOException, SQLException {        
        // como é uma requisicao ajax (não haverá redirecionamento)      
        this.hasPageJsp = false;        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (!request.getParameter("user").isEmpty()) {
            PessoaDAO pessoaDAO = new PessoaDAO();           
            System.out.println("=================================");
            System.out.println("=================================");
            System.out.println("User:"+request.getParameter("user"));
            System.out.println("=================================");
            System.out.println("=================================");
            Pessoa pessoa = pessoaDAO.buscar(request.getParameter("user"));
            // essa será a string retornada
            if (pessoa.getId()>0) {
                response.getWriter().write("Pessoa encontrada:"+pessoa.getNome()+" "+pessoa.getSobrenome());
            } else {
                response.getWriter().write("Nenhuma pessoa encontrada");
            }
        } else {
           response.getWriter().write("User em branco...");
        }
    }
}
