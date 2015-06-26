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
import model.Genero;

/**
 *
 * @author aluno
 */
public class GeneroDao implements Dao<Genero,Long> {
    private ConexaoPostgreSQL conexao;
    public GeneroDao(){
        try {
            this.conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "cinema");
        } catch (Exception ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Genero entity) {
        String query = "insert into genero (descricao) values (?)";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getNome());
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long pk) {
        String query = "delete from genero where id = ?";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, pk);
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Genero> listAll() {
        String query = "select * from genero";
        List<Genero> result = new ArrayList<>();
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Genero genero = new Genero();
                genero.setId(rs.getLong("id"));
                genero.setNome(rs.getString("nome"));
                result.add(genero);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Genero getById(Long pk) {
        String query = "select * from genero where id = ?";
        Connection connection = conexao.getConnection();
        Genero result = new Genero();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Genero admin = new Genero();
                admin.setId(rs.getLong("id"));
                admin.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
