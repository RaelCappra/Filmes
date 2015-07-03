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
        /*try {
            if(conexaoDefault.getConnection() == null || conexaoDefault.getConnection().isClosed()){
                this.conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "cinema");
            } else{
                this.conexao = conexaoDefault;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.conexao = conexaoDefault;
        this.conexao.setDefault();
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
        conexao.fechar();
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
        conexao.fechar();
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
                genero.setNome(rs.getString("descricao"));
                result.add(genero);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
        return result;
    }

    @Override
    public Genero getById(Long pk) {
        String query = "select * from genero where id = ?";
        Connection connection = conexao.getConnection();
        Genero result = new Genero();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, pk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result.setId(rs.getLong("id"));
                result.setNome(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
        return result;
    }
}
