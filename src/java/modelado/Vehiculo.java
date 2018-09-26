
package modelado;

public class Vehiculo {
    
    private int id;
    private String placa;
    private int id_con;
    private int id_ayu;
    private String marca;
    private String modelo;
    private String color;
    private int capmax;
    private int pasmax;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, int id_con, int id_ayu, String marca, String modelo, String color, int capmax, int pasmax) {
        this.id = id;
        this.placa = placa;
        this.id_con = id_con;
        this.id_ayu = id_ayu;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.capmax = capmax;
        this.pasmax = pasmax;
    }

    public int getPasmax() {
        return pasmax;
    }

    public void setPasmax(int pasmax) {
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

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

    public int getId_ayu() {
        return id_ayu;
    }

    public void setId_ayu(int id_ayu) {
        this.id_ayu = id_ayu;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapmax() {
        return capmax;
    }

    public void setCapmax(int capmax) {
        this.capmax = capmax;
    }
    
    
    
}

