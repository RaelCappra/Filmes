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
import model.Admin;

/**
 *
 * @author aluno
 */
public class AdminDao implements Dao<Admin, String>{
    private ConexaoPostgreSQL conexao;
    public AdminDao(){
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
    public void save(Admin entity) {
        String query = "insert into admin (login, senha_md5) values (?, ?)";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getMd5senha());
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
    }

    @Override
    public void delete(String pk) {
        String query = "delete from admin where login = ?";
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, pk);
            ps.execute();
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
    }

    @Override
    public List<Admin> listAll() {
        String query = "select * from admin";
        List<Admin> result = new ArrayList<>();
        Connection connection = conexao.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin();
                admin.setLogin(rs.getString("login"));
                admin.setMd5senha(rs.getString("md5_senha"));
                result.add(admin);
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
        return result;
    }

    @Override
    public Admin getById(String pk) {
        String query = "select * from admin where login = ?";
        Connection connection = conexao.getConnection();
        Admin result = null;
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, pk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = new Admin();
                result.setLogin(rs.getString("login"));
                result.setMd5senha(rs.getString("md5_senha"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
        return result;
    }

    public Admin autentica(String login, String senha) {
        String query = "select * from admin where login = ? and senha_md5 = md5(?)";
        Connection connection = conexao.getConnection();
        Admin result = null;
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = new Admin();
                result.setLogin(rs.getString("login"));
                result.setMd5senha(rs.getString("senha_md5"));
            }
        } catch (SQLException ex) {
            //TODO: tratar
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.fechar();
        return result;
    }
    
    
    
}
