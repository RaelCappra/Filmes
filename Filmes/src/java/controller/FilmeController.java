/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ClassificacaoDao;
import database.FilmeDao;
import database.GeneroDao;
import java.util.List;
import model.Classificacao;
import model.Filme;
import model.Genero;

/**
 *
 * @author Rael
 */
public class FilmeController extends Controller{
    FilmeDao filmeDao = new FilmeDao();
    
    
    public void descricao(){
        long id = Long.parseLong(request.getParameter("id"));
        Filme filme = filmeDao.getById(id);
        request.setAttribute("filme", filme);
    }
    
    
    public void telaAdicionar(){
        if(AdminController.checkIsAdmin(this)){
            GeneroDao generoDao = new GeneroDao();
            ClassificacaoDao classificacaoDao = new ClassificacaoDao();

            List<Genero> generos = generoDao.listAll();
            List<Classificacao> classificacoes = classificacaoDao.listAll();

            request.setAttribute("generos", generos);
            request.setAttribute("classificacoes", classificacoes);
        }
    }
}
