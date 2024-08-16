package modelo;
/*@author Nelson*/
public class Usuario {
    private String contrasena;
    private String cargo;
    private String fechaCreacion;
    private String fechaModificacion;

    public Usuario(String contrasena, String cargo, String fechaCreacion, String fechaModificacion) {
        this.contrasena = contrasena;
        this.cargo = cargo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }
    
    public String getContraseña() {
        return contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }
}
