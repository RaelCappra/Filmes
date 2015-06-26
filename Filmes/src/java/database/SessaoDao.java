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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessao> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sessao getById(Long pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
