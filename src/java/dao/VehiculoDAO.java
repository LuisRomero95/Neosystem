
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelado.Vehiculo;

public class VehiculoDAO extends Conexion implements DAO{    

    @Override
    public void insertar(Object obj) throws Exception{
        Vehiculo veh = (Vehiculo) obj;
        PreparedStatement pst;
        String sql="INSERT INTO vehiculos (placa, id_con, id_ayu, marca, año, modelo, cap_max, pas_max) VALUES(?,?,?,?,?,?,?,?)";
        try {
            this.conectar();           
            pst = conexion.prepareStatement(sql);
            pst.setString(1, veh.getPlaca());
            pst.setString(2, veh.getConductor());
            pst.setString(3, veh.getAyudante());
            pst.setString(4, veh.getMarca());
            pst.setString(5, veh.getAño());
            pst.setString(6, veh.getModelo());
            pst.setInt(7, veh.getCapmax());
            pst.setInt(8, veh.getPasmax());
            pst.executeUpdate();            
                               
        } catch ( SQLException e) {
            throw e;
        }
        finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Object obj) throws Exception{
        Vehiculo v = (Vehiculo) obj;
        PreparedStatement pst;
        String sql="UPDATE vehiculos set estado = 0 WHERE id = ?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, v.getId());
            pst.executeUpdate();            
            
        } catch ( SQLException e) {
        }
        finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(Object obj) throws Exception{
        Vehiculo veh = (Vehiculo) obj;
        PreparedStatement pst;
        String sql="UPDATE vehiculos SET placa=?, id_con=?, id_ayu=?, marca=?, año=?, modelo=?, cap_max=?, pas_max=? WHERE id=?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, veh.getPlaca());
            pst.setString(2, veh.getConductor());
            pst.setString(3, veh.getAyudante());
            pst.setString(4, veh.getMarca());
            pst.setString(5, veh.getAño());
            pst.setString(6, veh.getModelo());
            pst.setInt(7, veh.getCapmax());
            pst.setInt(8, veh.getPasmax());
            pst.setInt(9, veh.getId());
            pst.executeUpdate(); 
            
        } catch ( SQLException e) {
        }
        finally{
            this.cerrar();
        }
    }

    @Override
    public Vehiculo BuscarPorId(int id) throws Exception{
          Vehiculo c = new Vehiculo();
           PreparedStatement pst;
           ResultSet res;           
           String sql = "SELECT * FROM vehiculos WHERE id =?";
           try {
               this.conectar();
               pst = conexion.prepareStatement(sql);
               pst.setInt(1,id);                 
               
               res = pst.executeQuery();                                    
                if (res.next()) {
                    c.setPlaca(res.getString("placa"));
                    c.setConductor(res.getString("id_con"));            
                    c.setAyudante(res.getString("id_ayu"));
                    c.setMarca(res.getString("marca"));
                    c.setAño(res.getString("año"));
                    c.setModelo(res.getString("modelo"));                    
                    c.setCapmax(res.getInt("cap_max"));
                    c.setPasmax(res.getInt("pas_max"));
                    c.setId(res.getInt("id"));
                }                   
     
                } catch ( SQLException e) {
                }
                finally{
                    this.cerrar();
                }
           return c;
    }

    @Override
    public List<Vehiculo> consultar() throws Exception{
        List<Vehiculo> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT v.id, v.placa, c.nom, a.nom, v.marca, v.año, v.modelo, v.cap_max, v.pas_max FROM vehiculos v, conductores c, ayudantes a WHERE v.id_con = c.id && v.id_ayu =a.id AND v.estado = 1";
        //String sql = "SELECT * FROM vehiculos WHERE estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Vehiculo(
                        rs.getInt("v.id"),
                        rs.getString("v.placa"),
                        rs.getString("c.nom"),
                        rs.getString("a.nom"),
                        rs.getString("v.marca"),
                        rs.getString("v.año"),
                        rs.getString("v.modelo"),
                        rs.getInt("v.cap_max"),
                        rs.getInt("v.pas_max"))
                );
            }
            } catch ( SQLException e) {
            }
            finally{
                this.cerrar();
            }
        return datos;
    }

    @Override
    public boolean ConsultarNombre(String nom) throws Exception {
        PreparedStatement pst;
        ResultSet res = null;
        String sql = "SELECT * FROM vehiculos WHERE placa='"+nom+"'";

        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            res = pst.executeQuery();
        } catch (Exception e) {
        }
         return res.next();       
    }
    
}
