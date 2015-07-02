/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AdminDao;
import database.FilmeDao;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Filme;

/**
 *
 * @author Rael
 */
public class AdminController extends Controller{
    FilmeDao filmeDao = new FilmeDao();
    
    public void listaFilmes(){
        List<Filme> filmes = filmeDao.listAll();
        this.request.setAttribute("filmes", filmes);
    }
    
    public void telaLogin(){
        
    }
    
    public void login(){
        this.hasPageJsp = true;
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.autentica(login, senha);
        if(admin == null){
            session.invalidate();
            request.setAttribute("mensagem", "login/senha incorretos");
            this.redirect(AdminController.class, "telaLogin");
        } else{
            session.setAttribute("admin", admin);
            this.redirect("menuAdmin");
        }
    }
    
    public void menuAdmin(){
    }
}