/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classificacao;
import model.Filme;
import model.Genero;

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
                + " direcao, elenco, sinopse, link_trailer, duracao_min) "
                + "values (?,?,?,?,?,?,?,?)";
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getTitulo());
            ps.setLong(2, entity.getGenero().getId());
            ps.setLong(3, entity.getClassificacao().getId());
            ps.setString(4, entity.getDirecao());
            ps.setString(5, entity.getElenco());
            ps.setString(6, entity.getSinopse());
            ps.setString(7, entity.getLinkTrailer());
            ps.setInt(8, entity.getDuracaoMinutos());
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "delete from filme where id = ?";
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Filme> listAll() {
        String query = "select * from filme";
        List<Filme> result = new ArrayList<>();
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GeneroDao generoDao = new GeneroDao();
                ClassificacaoDao classificacaoDao = new ClassificacaoDao();

                Genero genero = generoDao.getById(rs.getLong("genero"));
                Classificacao classificacao = classificacaoDao.getById(rs.getLong("classificacao"));

                Filme filme = new Filme();
                filme.setId(rs.getLong("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(genero);
                filme.setClassificacao(classificacao);
                filme.setDirecao(rs.getString("direcao"));
                filme.setElenco(rs.getString("elenco"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setLinkTrailer(rs.getString("link_trailer"));
                filme.setDuracaoMinutos(rs.getInt("duracao_min"));
                result.add(filme);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Filme getById(Long pk) {
        String query = "select * from filme where id = ?";
        Filme result = new Filme();
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, pk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                GeneroDao generoDao = new GeneroDao();
                ClassificacaoDao classificacaoDao = new ClassificacaoDao();

                Genero genero = generoDao.getById(rs.getLong("genero"));
                Classificacao classificacao = classificacaoDao.getById(rs.getLong("classificacao"));

                result.setId(rs.getLong("id"));
                result.setTitulo(rs.getString("titulo"));
                result.setGenero(genero);
                result.setClassificacao(classificacao);
                result.setDirecao(rs.getString("direcao"));
                result.setElenco(rs.getString("elenco"));
                result.setSinopse(rs.getString("sinopse"));
                result.setLinkTrailer(rs.getString("link_trailer"));
                result.setDuracaoMinutos(rs.getInt("duracao_min"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Long saveReturningId(Filme filme){
        String query = "insert into filme (titulo, genero, classificacao,"
                + " direcao, elenco, sinopse, link_trailer, duracao_min) "
                + "values (?,?,?,?,?,?,?,?) returning id";
        Connection connection = conexao.getConnection();
        Long result = -1L;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, filme.getTitulo());
            ps.setLong(2, filme.getGenero().getId());
            ps.setLong(3, filme.getClassificacao().getId());
            ps.setString(4, filme.getDirecao());
            ps.setString(5, filme.getElenco());
            ps.setString(6, filme.getSinopse());
            ps.setString(7, filme.getLinkTrailer());
            ps.setInt(8, filme.getDuracaoMinutos());
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getLong(1);
            
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
