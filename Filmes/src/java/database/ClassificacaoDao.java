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

/**
 *
 * @author aluno
 */
public class ClassificacaoDao implements Dao<Classificacao,Long> {
    private ConexaoPostgreSQL conexao;
    public ClassificacaoDao(){
        try {
            this.conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "cinema");
        } catch (Exception ex) {
            //TODO: tratar
            Logger.getLogger(ClassificacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Classificacao entity) {
        String query = "insert into classificacao (descricao) values (?)";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getDescricao());
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(ClassificacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long pk) {
        String query = "delete from classificacao where id = ?";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, pk);
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(ClassificacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Classificacao> listAll() {
        String query = "select * from classificacao";
        List<Classificacao> result = new ArrayList<>();
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classificacao genero = new Classificacao();
                genero.setId(rs.getLong("id"));
                genero.setDescricao(rs.getString("nome"));
                result.add(genero);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(ClassificacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Classificacao getById(Long pk) {
        String query = "select * from classificacao where id = ?";
        Connection connection = conexao.getConnection();
        Classificacao result = new Classificacao();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, pk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result.setId(rs.getLong("id"));
                result.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(ClassificacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
