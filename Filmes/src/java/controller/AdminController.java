/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AdminDao;
import database.FilmeDao;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Filme;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Rael
 */
public class AdminController extends Controller {

    FilmeDao filmeDao = new FilmeDao();

    public void editarCartaz() {
        long id = Long.parseLong(request.getParameter("id"));
        System.out.println("chamou de boa");
        boolean isMultiPart = FileUpload.isMultipartContent(request);
        if (isMultiPart) {

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            String formulario = "";

            try {

                List items = upload.parseRequest(request);

                Iterator iter = items.iterator();

                while (iter.hasNext()) {

                    FileItem item = (FileItem) iter.next();

                    if (item.getFieldName().equals("tipoForm")) {

                        formulario = item.getString();

                    }

                    if (!item.isFormField()) {

                        if (item.getName().length() > 0) {
                            
                            //this.inserirImagem(item);

                        }

                    }

                }

            } catch (FileUploadException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public void listaFilmes() {
        List<Filme> filmes = filmeDao.listAll();
        this.request.setAttribute("filmes", filmes);
    }

    public void telaLogin() {

    }

    public void login() {
        this.hasPageJsp = true;
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.autentica(login, senha);
        if (admin == null) {
            session.invalidate();
            request.setAttribute("mensagem", "login/senha incorretos");

            this.redirect(AdminController.class, "telaLogin");
        } else {
            session.setAttribute("admin", admin);
            this.redirect("menuAdmin");
        }
    }

    public void menuAdmin() {
    }
}
