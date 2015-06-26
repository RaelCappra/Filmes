/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Filme;

/**
 *
 * @author aluno
 */
public class FilmeDao implements Dao<Filme, Long> {

    private ConexaoPostgreSQL conexao;

    public FilmeDao() {
        try {
            this.conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "cinema");
        } catch (Exception ex) {
            //TODO: tratar
            Logger.getLogger(FilmeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Filme entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Filme> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filme getById(Long pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
