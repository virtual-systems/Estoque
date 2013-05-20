package br.com.bs.estoque.model.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String connString = "jdbc:mysql://localhost/estoque";
    private static String user = "root";
    private static String passwd = "123";
    private static Connection conn = null;

    public static Connection getConn() {
        if (conn == null) {
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                conn = DriverManager.getConnection(connString, user, passwd);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
    
    public static void log(String msg) {
        System.out.println(msg);
    }
}
