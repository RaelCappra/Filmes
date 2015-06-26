/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import database.FilmeDao;
import model.Classificacao;
import model.Filme;
import model.Genero;

/**
 *
 * @author aluno
 */
public class Test {
    public static void main(String... args){
        /*Filme filme = new Filme();
        filme.setTitulo("test");
        filme.setDirecao("asd");
        filme.setElenco("asd");
        filme.setLinkTrailer("asd");
        filme.setSinopse("asd");
        filme.setClassificacao(new Classificacao(1, "q"));
        filme.setGenero(new Genero(1, "w"));
        filme.setDuracaoMinutos(61);*/
        FilmeDao filmeDao = new FilmeDao();
        //filmeDao.save(filme);*/
        System.out.println(filmeDao.listAll());
    }
}
