
package modelado;

public class Vehiculo {
    
    private int id;
    private String placa;
    private String conductor;
    private String ayudante;
    private String marca;
    private String año;
    private String modelo;
    private int capmax;
    private int pasmax;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String conductor, String ayudante, String marca, String año, String modelo, int capmax, int pasmax) {
        this.id = id;
        this.placa = placa;
        this.conductor = conductor;
        this.ayudante = ayudante;
        this.marca = marca;
        this.año = año;
        this.modelo = modelo;
        this.capmax = capmax;
        this.pasmax = pasmax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getAyudante() {
        return ayudante;
    }

    public void setAyudante(String ayudante) {
        this.ayudante = ayudante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapmax() {
        return capmax;
    }

    public void setCapmax(int capmax) {
        this.capmax = capmax;
    }

    public int getPasmax() {
        return pasmax;
    }

    public void setPasmax(int pasmax) {
        this.pasmax = pasmax;
    }
    
}

