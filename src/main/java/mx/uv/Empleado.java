package mx.uv;

public class Empleado {
    private Integer idEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String direccion;
    private String telefono;
    private String password;
    private String estatus;
    private String idRol;

    
    public Empleado(){

    }
    public Empleado(Integer idEmpleado,String estatus){
        this.idEmpleado=idEmpleado;
        this.estatus = estatus;
    }
    public Empleado(Integer idEmpleado, String nombre, String password, String idRol){
        this.idEmpleado=idEmpleado;
        this.nombre =nombre;
        this.password=password;
        this.idRol=idRol;

    }
    public Empleado(Integer idEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno,
            String correoElectronico, String direccion, String telefono, String password, String estatus,String idRol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.telefono = telefono;
        this.password = password;
        this.estatus = estatus;
        this.idRol = idRol;

    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getIdRol() {
        return idRol;
    }
    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
}
