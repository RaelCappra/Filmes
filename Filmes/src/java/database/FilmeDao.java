/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String query = "insert into filme (titulo, genero, classificacao,"
                + " direcao, elenco, sinopse, link_trailer, duracao) "
                + "values (?,?,?,?,?,?,?,?)";
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getTitulo());
            ps.setLong(2, entity.getGenero().getId());
            ps.setLong(3, entity.getClassificacao().getId());
            ps.setString(4, entity.getDirecao());
            ps.setString(5, entity.getSinopse());
            ps.setString(6, entity.getLinkTrailer());
            ps.setString(7, entity.getDuracaoMinutos() + " minutes"); //TODO:Check this
            ps.executeQuery();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
