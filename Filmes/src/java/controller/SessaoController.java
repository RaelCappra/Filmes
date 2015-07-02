/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.SessaoDao;

/**
 *
 * @author Rael
 */
public class SessaoController extends Controller{
    private final SessaoDao sessaoDao = new SessaoDao();
    public void index(){
        this.request.setAttribute("sessoes", sessaoDao.listAll());
    }
}
