
package modelado;


public class Precio {
    private int id;
    private String tipo;
    private int cantidad;
    private double peso;    
    private double resultado;
    private String Cliente;

    public Precio() {
    }

    public Precio(int id, String tipo, int cantidad, double peso, double resultado, String Cliente) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.peso = peso;
        this.resultado = resultado;
        this.Cliente = Cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

   
    
}
