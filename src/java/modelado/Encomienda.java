
package modelado;

public class Encomienda {
    private int id;
    private String cliente;
    private String usuario;
    private String vehiculo;
    private int precio;

    public Encomienda() {
    }

    public Encomienda(int id, String cliente, String usuario, String vehiculo, int precio) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

   
    
    
    
   
}
