package database;

import java.sql.*;

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
    public ConexaoPostgreSQL() throws Exception {
        this(ConexaoPostgreSQL.HOST, ConexaoPostgreSQL.USER, ConexaoPostgreSQL.PASSWORD, ConexaoPostgreSQL.DATABASE);
    }

    public ConexaoPostgreSQL(String host, String user, String password, String database) throws Exception {
        super(host, user, password, database);
        if ((host != null) && (host.length() > 0)) {
            con = DriverManager.getConnection("jdbc:postgresql://" + host + ":"+PORT+"/" + database, this.user, this.password);
        } else {
            con = DriverManager.getConnection("jdbc:postgresql:" + database, this.user, this.password);
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
}
