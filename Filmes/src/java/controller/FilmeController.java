/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.FilmeDao;
import java.util.List;
import model.Filme;

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
}
