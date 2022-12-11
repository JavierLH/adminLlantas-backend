package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    public static Conexion c = new Conexion();
    
    public static List<Empleado> dameEmpleados() {
        Statement stm = null;
        ResultSet rs = null;
        List<Empleado> resultado = new ArrayList<>();
        Connection cc = null;
        // falto conectarme
        cc = c.getConnection();
        try {
            String sql = "SELECT * FROM usuario WHERE idRol =1 AND estatus =1";
            stm = (Statement) cc.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado(rs.getInt("ID"),
                        rs.getString("nombre"), rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),rs.getString("correoElectronico"),
                        rs.getString("direccion"), rs.getString("telefono"),
                        rs.getString("password"), rs.getString("estatus"),
                        rs.getString("idRol"));
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


    public static String actualizaEmpleado(Empleado u) {
        PreparedStatement stm = null;
        //UPDATE `ejemplo80640`.`usuario` SET `id` = '4', `username` = 'alexis', `password` = '123456' WHERE (`id` = '3');
        Connection cc = null;
        String msj = "";
        cc = c.getConnection();
        try {
            String sql = "UPDATE usuario SET  nombre = ?, apellidoPaterno = ?,apellidoMaterno = ?,correoElectronico = ?, direccion = ?, telefono = ?, password = ? WHERE (ID = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getApellidoPaterno());
            stm.setString(3, u.getApellidoMaterno());
            stm.setString(4, u.getCorreoElectronico());
            stm.setString(5, u.getDireccion());
            stm.setString(6, u.getTelefono());
            stm.setString(7, u.getPassword());
            stm.setString(8, u.getEstatus());
            //stm.setString(9, u.getEstatus());
        
            if (stm.executeUpdate() > 0)
                msj = "Datos del empleado modificados correctamente";
            else
                msj = "Algo salio mal. No se pueden modificar los datos del empleado";
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

    public static String crearEmpleado(Empleado u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "INSERT INTO usuario (nombre, apellidoPaterno,apellidoMaterno,correoElectronico,direccion,telefono,password,estatus,idRol) VALUES (?,?,?,?,?,?,?,?,1)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getApellidoPaterno());
            stm.setString(3, u.getApellidoMaterno());
            stm.setString(4, u.getCorreoElectronico());
            stm.setString(5, u.getDireccion());
            stm.setString(6, u.getTelefono());
            stm.setString(7, u.getPassword());
            stm.setString(8, u.getEstatus());
            //stm.setString(9, u.getIdRol());

            if (stm.executeUpdate() > 0)
                msj = "Empleado agregado correctamente";
            else
                msj = "Algo salio mal, empleado no agregado";
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
    
    
    public static String eliminaEmpleado(Empleado u) {
        PreparedStatement stm = null;
        //UPDATE `ejemplo80640`.`usuario` SET `id` = '4', `username` = 'alexis', `password` = '123456' WHERE (`id` = '3');
        Connection cc = null;
        String msj = "";
        cc = c.getConnection();
        try {
            String sql = "DELETE FROM usuario WHERE (ID = ?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setInt(1, u.getIdEmpleado());
            
            if (stm.executeUpdate() > 0)
                msj = "Datos del empleado eliminados correctamente";
            else
                msj = "Algo salio mal. No se pueden eliminar el empleado";
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
