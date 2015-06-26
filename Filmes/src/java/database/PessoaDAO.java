package database;

import java.sql.*;
import java.util.ArrayList;
import model.Pessoa;

public class PessoaDAO {    
    // SQLs
    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;    
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public PessoaDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from pessoa where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from pessoa where nome ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from pessoa order by nome;");
            this.excluir = con.getConnection().prepareStatement("delete from pessoa where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update pessoa set nome = ?, sobrenome = ? where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into pessoa (nome, sobrenome) values (?,?) returning id;");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Pessoa obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Pessoa pessoa = new Pessoa();
        if (rs.next()) {
            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSobrenome(rs.getString("sobrenome"));
        }
        this.obter.close();
        return pessoa;
    }

    public ArrayList<Pessoa> listar() throws SQLException {
        ArrayList<Pessoa> todos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                todos.add(new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome")));
            }
            this.listar.close();
        } catch (SQLException e) {
            return todos;
        }
        return todos;
    }

    public boolean adicionar(Pessoa pessoa) {
        try {
            this.adicionar.setString(1, pessoa.getNome());
            this.adicionar.setString(2, pessoa.getSobrenome());
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert pessoa 2");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Pessoa pessoa) {
        try {
            this.atualizar.setString(1, pessoa.getNome());
            this.atualizar.setString(2, pessoa.getSobrenome());
            this.atualizar.setInt(3, pessoa.getId());
            this.atualizar.execute();
            this.atualizar.close();
            return true;
        } catch (Exception erro) {
            return false;
        }
    }

    public boolean autenticar(String login, String senha) {
        return login.equals("admin") && senha.equals("123");
    }

    public Pessoa buscar(String nome) throws SQLException {
        this.buscar.setString(1, "%"+nome.trim()+"%");
        ResultSet rs = this.buscar.executeQuery();
        Pessoa pessoa = new Pessoa();
        if (rs.next()) {
            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSobrenome(rs.getString("sobrenome"));
        }
        this.buscar.close();
        return pessoa;
    }
}
