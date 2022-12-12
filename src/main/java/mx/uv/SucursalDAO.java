package mx.uv;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SucursalDAO {
    public static Conexion c = new Conexion();
    
    public static List<Sucursal> dameSucursal() {
        Statement stm = null;
        ResultSet rs = null;
        List<Sucursal> resultado = new ArrayList<>();
        Connection cc = null;
        cc = c.getConnection();
        try {
            String sql = "select * from sucursal";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Sucursal e = new Sucursal(
                        rs.getInt("idSucursal"),
                        rs.getString("nombreSucursal"),
                        rs.getString("ciudad"));
                resultado.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                rs = null;
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Conexion terminada :D");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return resultado;
    }

    public static String crearSucursal(Sucursal u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";
        cc = c.getConnection();
        try {
            String sql = "INSERT INTO sucursal (nombreSucursal, ciudad) VALUES (?,?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombreSucursal());
            stm.setString(2, u.getCiudad());

            if (stm.executeUpdate() > 0)
                msj = "Agregado correctamente";
            else
                msj = "Algo salio mal, no agregado";
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return msj;
    }

    public static String actualizaSucursal(Sucursal u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";
        cc = c.getConnection();
        try {
            String sql = "UPDATE sucursal SET  nombreSucursal = ?, ciudad = ? WHERE (idSucursal = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombreSucursal());
            stm.setString(3, u.getCiudad());
        
            if (stm.executeUpdate() > 0)
                msj = "Datos del proveedor modificados correctamente";
            else
                msj = "Algo salio mal. No se pueden modificar los datos";
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return msj;
    }

}
