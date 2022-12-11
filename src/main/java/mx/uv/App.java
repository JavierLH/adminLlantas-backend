package mx.uv;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * Hello world!
 *
 */
public class App 
{
    public static Gson gson = new Gson();
    public static void main( String[] args ){
        Empleado empleado = new Empleado();
        port(getHerokuAssignedPort());
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        System.out.println("Hello World!");
        before((req, res) -> res.type("application/json"));
        
        get("/empleados", (req, res) -> gson.toJson(EmpleadoDAO.dameEmpleados()));
        get("/proveedores", (req, res) -> gson.toJson(ProveedorDAO.dameProveedores()));

        post("/", (req, res) -> {
            String datosFormulario = req.body();
            Empleado u = gson.fromJson(datosFormulario, Empleado.class);
            return EmpleadoDAO.crearEmpleado(u);
        });

        post("/crearProveedor", (req, res) -> {
            String datosFormulario = req.body();
            Proveedor u = gson.fromJson(datosFormulario, Proveedor.class);
            return ProveedorDAO.crearProveedor(u);
        });

        post("/actualiza", (req, res) -> {
            String datosFormulario = req.body();
            Empleado u = gson.fromJson(datosFormulario, Empleado.class);
            return EmpleadoDAO.actualizaEmpleado(u);
        });

        post("/actualizaProveedor", (req, res) -> {
            String datosFormulario = req.body();
            Proveedor u = gson.fromJson(datosFormulario, Proveedor.class);
            return ProveedorDAO.actualizaProveedor(u);
        });


        post("/elimina" ,(req,res)-> {
            String datosFormulario = req.body();
            Empleado u = gson.fromJson(datosFormulario, Empleado.class);
            //System.out.println(u.getIdEmpleado());
            
            return EmpleadoDAO.eliminaEmpleado(u.getIdEmpleado());

        });

        post("/login", (req, res) -> {
            String datosFormulario = req.body();
            Empleado u=gson.fromJson(datosFormulario, Empleado.class);
            if (EmpleadoDAO.iniciarSesion(u)==true ){
                
                empleado.setNombre(u.getNombre());
                empleado.setPassword(u.getPassword());
                return true;
            }else{
                return false;
            }
        });
        
    }
    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
        return 4567;
    }


}
