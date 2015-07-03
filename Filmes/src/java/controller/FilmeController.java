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
    
    public void adicionar(){
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
    public void telaAdicionar(){
        GeneroDao generoDao = new GeneroDao();
        ClassificacaoDao classificacaoDao = new ClassificacaoDao();
        
        List<Genero> generos = generoDao.listAll();
        List<Classificacao> classificacoes = classificacaoDao.listAll();
        
        request.setAttribute("generos", generos);
        request.setAttribute("classificacoes", classificacoes);
    }
}
