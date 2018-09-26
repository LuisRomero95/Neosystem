package modelado;

public class Ayudante {
    private int id;
    private String dni;
    private String nom;
    private String ape;
    private String direc;
    private String tel;
    private String email;

    public Ayudante() {
    }

    public Ayudante(int id, String dni, String nom, String ape, String direc, String tel, String email) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.ape = ape;
        this.direc = direc;
        this.tel = tel;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
