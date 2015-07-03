/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import database.FilmeDao;
import database.SessaoDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import model.Classificacao;
import model.Filme;
import model.Genero;
import model.Sessao;

/**
 *
 * @author aluno
 */
public class Test {

    public static void main(String... args) throws FileNotFoundException {
        /*Filme filme = new Filme();
         filme.setTitulo("ultimo");
         filme.setDirecao("biaud");
         filme.setElenco("biaud");
         filme.setLinkTrailer("biaud");
         filme.setSinopse("biaud");
         filme.setClassificacao(new Classificacao(1, "e"));
         filme.setGenero(new Genero(1, "r"));
         filme.setDuracaoMinutos(61);
         FilmeDao filmeDao = new FilmeDao();
         filme.setId(filmeDao.saveReturningId(filme));
         SessaoDao sessaoDao = new SessaoDao();
         for(int i = 0; i < 1; i++){
         Sessao sessao = new Sessao();
         sessao.setFilme(filme);
         sessao.setHorario(Calendar.getInstance());
         sessao.setIs3d(false);
         sessao.setIsLegendado(true);
         sessao.setSala(i);
         sessao.setValorAdulto(1500);

            
         sessaoDao.save(sessao);

         //System.out.println(sessaoDao.listAll());
         }*/
        System.out.println(System.getProperty("user.dir"));
        String caminho = "../Filmes/web/assets/";
        File diretorio = new File(caminho);
        if(!diretorio.exists()){
            diretorio.mkdir();
        }
        File file = new File(diretorio, "dank.png");
        
        File copiado = new File(diretorio, "sem_cartaz.png");
        try (FileOutputStream output = new FileOutputStream(file)) {
            //byte[] data = item.get();

            InputStream is = new FileInputStream(copiado);
            byte[] buffer = new byte[4096];

            int nLidos;

            while ((nLidos = is.read(buffer)) >= 0) {

                output.write(buffer, 0, nLidos);

            }

            output.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
