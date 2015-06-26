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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classificacao;
import model.Filme;
import model.Genero;
import model.Sessao;

/**
 *
 * @author aluno
 */
public class SessaoDao implements Dao<Sessao, Long> {

    private ConexaoPostgreSQL conexao;

    public SessaoDao() {
        try {
            this.conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "cinema");
        } catch (Exception ex) {
            //TODO: tratar
            Logger.getLogger(FilmeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Sessao entity) {
        String query = "insert into sessao (filme, horario, valor_adulto,"
                + " valor_estudante, valor_idoso, is3d, is_legendado, sala) "
                + "values (?,?,?,?,?,?,?,?)";
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, entity.getFilme().getId());

            java.sql.Timestamp ts = new java.sql.Timestamp(entity.getHorario()
                    .getTimeInMillis());

            ps.setTimestamp(2, ts);
            ps.setDouble(3, entity.getValorAdulto());
            ps.setDouble(4, entity.getValorEstudante());
            ps.setDouble(5, entity.getValorIdoso());
            ps.setBoolean(6, entity.isIs3d());
            ps.setBoolean(7, entity.isIsLegendado());
            ps.setInt(8, entity.getSala());
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "delete from sessao where id = ?";
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
    public List<Sessao> listAll() {
        String query = "select * from sessao";
        List<Sessao> result = new ArrayList<>();
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FilmeDao filmeDao = new FilmeDao();
                Filme filme = filmeDao.getById(rs.getLong("filme"));
                
                Sessao sessao = new Sessao();
                
                sessao.setId(rs.getLong("id"));
                sessao.setFilme(filme);
                sessao.setValorAdulto(rs.getDouble("valor_adulto"));
                sessao.setValorEstudante(rs.getDouble("valor_estudante"));
                sessao.setValorEstudante(rs.getDouble("valor_idoso"));
                sessao.setSala(rs.getInt("sala"));
                sessao.setIsLegendado(rs.getBoolean("is_legendado"));
                sessao.setIs3d(rs.getBoolean("is3d"));
                
                Calendar horario = Calendar.getInstance();
                java.sql.Timestamp ts = rs.getTimestamp("horario");
                horario.setTimeInMillis(ts.getTime());
                sessao.setHorario(horario);
                result.add(sessao);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Sessao getById(Long pk) {
        String query = "select * from sessao where id = ?";
        Sessao sessao = new Sessao();
        Connection connection = conexao.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, pk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                FilmeDao filmeDao = new FilmeDao();
                Filme filme = filmeDao.getById(rs.getLong("filme"));
                
                sessao.setId(rs.getLong("id"));
                sessao.setFilme(filme);
                sessao.setValorAdulto(rs.getDouble("valor_adulto"));
                sessao.setValorEstudante(rs.getDouble("valor_estudante"));
                sessao.setValorEstudante(rs.getDouble("valor_idoso"));
                sessao.setSala(rs.getInt("sala"));
                sessao.setIsLegendado(rs.getBoolean("is_legendado"));
                sessao.setIs3d(rs.getBoolean("is3d"));
                
                Calendar horario = Calendar.getInstance();
                java.sql.Timestamp ts = rs.getTimestamp("horario");
                horario.setTimeInMillis(ts.getTime());
                sessao.setHorario(horario);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessao;
    }

}
