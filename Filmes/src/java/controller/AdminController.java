/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AdminDao;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author Rael
 */
public class AdminController extends Controller{
    public void telaLogin(){
        //this.hasPageJsp = true;
        //HttpSession session = request.getSession();
    }
    
    public void login(){
        this.hasPageJsp = false;
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.autentica(login, senha);
        if(admin == null){
            session.invalidate();
            request.setAttribute("mensagem", "login/senha incorretos");
            this.redirect("telaLogin");
        } else{
            session.setAttribute("admin", admin);
            this.redirect("menuAdmin");
        }
    }
    
    public void menuAdmin(){
    }
}