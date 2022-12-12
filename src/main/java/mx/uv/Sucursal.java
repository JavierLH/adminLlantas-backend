package mx.uv;

public class Sucursal {
    private Integer idSucursal;
    private String nombreSucursal;
    private String ciudad;

    public Sucursal() {
    }


    public Sucursal(Integer idSucursal, String nombreSucursal, String ciudad) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.ciudad = ciudad;
    }



    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
