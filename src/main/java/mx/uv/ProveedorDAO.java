package mx.uv;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProveedorDAO {
    public static Conexion c = new Conexion();
    
    public static List<Proveedor> dameProveedores() {
        Statement stm = null;
        ResultSet rs = null;
        List<Proveedor> resultado = new ArrayList<>();
        Connection cc = null;
        // falto conectarme
        cc = c.getConnection();
        try {
            String sql = "select * from provedor";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor e = new Proveedor(
                        rs.getInt("idProveedor"),
                        rs.getString("nombreEmpresa"),
                        rs.getString("categoria"),
                        rs.getString("estatus"));
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

    public static String crearProveedor(Proveedor u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "INSERT INTO adminLlantas.provedor (nombreEmpresa, categoria, estatus) VALUES (?,?,?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombreEmpresa());
            stm.setString(2, u.getCategoria());
            stm.setString(3, u.getEstatus());

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

    public static String actualizaProveedor(Proveedor u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";
        cc = c.getConnection();
        try {
            String sql = "UPDATE provedor SET  nombreEmpresa = ?, categoria = ?, estatus = ?, WHERE (idProveedor = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombreEmpresa());
            stm.setString(3, u.getCategoria());
            stm.setString(4, u.getEstatus());
        
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
