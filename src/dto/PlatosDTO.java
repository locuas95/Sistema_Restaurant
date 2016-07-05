
package dto;

public class PlatosDTO {
    private int idplatos;
    private int idmenu;
    private double precio;
    private String nombre;
    private String descripcion;

    public PlatosDTO() {
    }

    public PlatosDTO(int idmenu, double precio, String nombre, String descripcion) {
        this.idmenu = idmenu;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdplatos() {
        return idplatos;
    }

    public void setIdplatos(int idplatos) {
        this.idplatos = idplatos;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
