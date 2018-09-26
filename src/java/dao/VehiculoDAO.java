
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
        String sql="INSERT INTO vehiculos (placa, id_con, id_ayu, marca, modelo, color, capmax, pasmax) VALUES(?,?,?,?,?,?,?,?)";
        try {
            this.conectar();           
            pst = conexion.prepareStatement(sql);
            pst.setString(1, veh.getPlaca());
            pst.setInt(2, veh.getId_con());
            pst.setInt(3, veh.getId_ayu());
            pst.setString(4, veh.getMarca());
            pst.setString(5, veh.getModelo());
            pst.setString(6, veh.getColor());
            pst.setInt(7, veh.getCapmax());
            pst.setInt(8, veh.getPasmax());
            pst.executeUpdate();            
                               
        } catch ( SQLException e) {
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
        String sql="UPDATE vehiculos SET placa=?, id_con=?, id_ayu=?, marca=?, modelo=?, color=?, capmax=?, pasmax=? WHERE id=?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, veh.getPlaca());
            pst.setInt(2, veh.getId_con());
            pst.setInt(3, veh.getId_ayu());
            pst.setString(4, veh.getMarca());
            pst.setString(5, veh.getModelo());
            pst.setString(6, veh.getColor());
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
                    c.setId_con(res.getInt("id_con"));            
                    c.setId_ayu(res.getInt("id_ayu"));
                    c.setMarca(res.getString("marca"));
                    c.setModelo(res.getString("modelo"));
                    c.setColor(res.getString("Color"));
                    c.setCapmax(res.getInt("capmax"));
                    c.setPasmax(res.getInt("pasmax"));
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
        String sql = "SELECT * FROM vehiculos WHERE estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getInt("id_con"),
                        rs.getInt("id_ayu"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getInt("capmax"),
                        rs.getInt("pasmax"))
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
    public List filtrar(String campo, String criterio) throws Exception{
        List<Vehiculo> datos = new ArrayList<>();
        ResultSet rs;
        PreparedStatement pst;
        String sql = "SELECT * FROM clientes WHERE "+campo+" like '%"+criterio+"%'";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);            
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getInt("id_con"),
                        rs.getInt("id_ayu"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getInt("capmax"),
                        rs.getInt("pasmax"))
                );
            }
            } catch ( SQLException e) {
            }
            finally{
                this.cerrar();
            }
        return datos;
    }    
    
}
