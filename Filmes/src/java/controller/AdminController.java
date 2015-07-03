/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AdminDao;
import database.ClassificacaoDao;
import database.FilmeDao;
import database.GeneroDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Classificacao;
import model.Filme;
import model.Genero;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import servlet.Servlet;

/**
 *
 * @author Rael
 */
public class AdminController extends Controller {

    private final FilmeDao filmeDao = new FilmeDao();

    public void editarCartaz() throws FileNotFoundException, IOException, Exception {
        if (checkIsAdmin()) {
            long id = Long.parseLong(request.getParameter("id"));
            Filme filme = filmeDao.getById(id);
            boolean isMultiPart = FileUpload.isMultipartContent(request);
            if (isMultiPart) {

                FileItemFactory factory = new DiskFileItemFactory();

                ServletFileUpload upload = new ServletFileUpload(factory);

                String formulario = "";

                try {

                    List<FileItem> items = upload.parseRequest(request);

                    Iterator<FileItem> iter = items.iterator();

                    while (iter.hasNext()) {

                        FileItem item = iter.next();

                        if (item.getFieldName().equals("tipoForm")) {

                            formulario = item.getString();

                        }
                        if (!item.isFormField()) {

                            if (item.getName().length() > 0) {
                                String caminho = (Servlet.realPath + "/assets/");
                                File diretorio = new File(caminho);

                                if (!diretorio.exists()) {
                                    diretorio.mkdir();
                                }

                                String nome = item.getName();

                                String arq[] = nome.split("\\\\");

                                for (int i = 0; i < arq.length; i++) {

                                    nome = arq[i];

                                }

                                File file = new File(diretorio, nome);
                                //item.write(file);
                                try (FileOutputStream output = new FileOutputStream(file)) {
                                    InputStream is = item.getInputStream();
                                    byte[] buffer = new byte[4096];

                                    int nLidos;

                                    while ((nLidos = is.read(buffer)) >= 0) {

                                        output.write(buffer, 0, nLidos);

                                    }

                                    output.flush();
                                }
                                filme.setUrlCartaz(nome);
                                filmeDao.update(filme);
                            }

                        }

                    }

                } catch (FileUploadException ex) {
                    System.out.println(ex.getMessage());
                }

            }

            this.redirect("listaFilmes");
        }
    }

    public void listaFilmes() {
        if (checkIsAdmin()) {
            List<Filme> filmes = filmeDao.listAll();
            this.request.setAttribute("filmes", filmes);
        }
    }
    
    private boolean checkIsAdmin(){
        return checkIsAdmin(this);
    }
    
    static boolean checkIsAdmin(Controller controller) {
        HttpSession session = controller.request.getSession();
        if (session.getAttribute("admin") == null) {
            session.invalidate();
            controller.redirect(AdminController.class, "telaLogin");
            return false;
        }
        return true;
    }

    public void telaLogin() {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") != null) {
            this.redirect("menuAdmin");
        }
    }

    public void login() {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") != null) {
            this.redirect("menuAdmin");
        } else {
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
    }

    public void menuAdmin() {
        checkIsAdmin();
    }

    public void adicionar() {
        if(checkIsAdmin()){
            GeneroDao generoDao = new GeneroDao();
            ClassificacaoDao classificacaoDao = new ClassificacaoDao();

            long idGenero = Long.parseLong(request.getParameter("genero"));
            long idClassificacao = Long.parseLong(request.getParameter("classificacao"));
            String titulo = request.getParameter("titulo");
            String linkTrailer = request.getParameter("link");
            String diretor = request.getParameter("diretor");
            String sinopse = request.getParameter("sinopse");
            String elenco = request.getParameter("elenco");
            int duracaoMinutos = Integer.parseInt(request.getParameter("duracao"));

            Genero genero = generoDao.getById(idGenero);
            Classificacao classificacao = classificacaoDao.getById(idClassificacao);

            Filme filme = new Filme();
            filme.setGenero(genero);
            filme.setClassificacao(classificacao);
            filme.setTitulo(titulo);
            filme.setLinkTrailer(linkTrailer);
            filme.setDirecao(diretor);
            filme.setElenco(elenco);
            filme.setDuracaoMinutos(duracaoMinutos);
            filme.setSinopse(sinopse);

            filmeDao.save(filme);
            this.redirect(AdminController.class, "listaFilmes");
        }
    }
}
