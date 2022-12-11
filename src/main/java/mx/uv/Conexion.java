package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://db4free.net:3306/adminllantas";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "javier";
    private static String password = "taNMMcx4xVW.qM7";
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("listo conectado");
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("no encontro el driver");
        }
        return connection;
    }   
}