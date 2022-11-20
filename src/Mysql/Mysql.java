package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "admin";
    Connection conn = null;

    public Connection conn(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
             throwables.printStackTrace();
        }
        return conn;
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
