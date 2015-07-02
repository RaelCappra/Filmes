package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoPostgreSQL extends Conexao {
    public static final String HOST = "localhost";
    public static final String PORT = "5432";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DATABASE = "prova";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver postgreSQL nao foi carregado.");
        }
    }

    // Construtores
    public ConexaoPostgreSQL()/* throws Exception */{
        this(ConexaoPostgreSQL.HOST, ConexaoPostgreSQL.USER, ConexaoPostgreSQL.PASSWORD, ConexaoPostgreSQL.DATABASE);
    }

    public ConexaoPostgreSQL(String host, String user, String password, String database) /*throws Exception*/ {
        super(host, user, password, database);
        try {
            if ((host != null) && (host.length() > 0)) {
                con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + PORT + "/" + database, this.user, this.password);
            } else {
                con = DriverManager.getConnection("jdbc:postgresql:" + database, this.user, this.password);
            }
        } catch (SQLException sQLException) {
            System.exit(1);
        }
    }
   
    @Override
    public void fechar() {
        if (con != null) {
            try {
                con.close();
                conexaoDefault = null;
            } catch (Exception ex) {
                System.err.println("Houve um erro ao tentar fechar a conexao com o banco.");
            }
        }
    }
    
    @Override
    public Connection getConnection(){
        try {
            if (con == null || con.isClosed()){
                if ((host != null) && (host.length() > 0)) {
                    con = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + PORT + "/" + dbname, this.user, this.password);
                } else {
                    con = DriverManager.getConnection("jdbc:postgresql:" + dbname, this.user, this.password);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
