package mx.uv;

public class Proveedor {
    private Integer idProvedor;
    private String nombreEmpresa;
    private String categoria;
    private String estatus; 

    public Proveedor() {
    }

    public Proveedor(Integer idProvedor, String nombreEmpresa, String categoria, String estatus) {
        this.idProvedor = idProvedor; 
        this.nombreEmpresa = nombreEmpresa;
        this.categoria = categoria;
        this.estatus = estatus; 
    }

    public Integer getIdProvedor() {
        return idProvedor;
    }
    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    } 

    public String getEstatus(){
        return estatus;
    }
    public void setEstatus(String estatus){
        this.estatus = estatus;
    }

    
}
