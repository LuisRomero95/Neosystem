
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelado.Encomienda;


public class EncomiendaDAO extends Conexion implements DAO{ 

    @Override
    public void insertar(Object obj) throws Exception {
        Encomienda c = (Encomienda) obj;
        PreparedStatement pst;
        String sql="INSERT INTO encomiendas ( id_cli, id_usu, id_veh, id_precio) VALUES(?,?,?,?)";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, c.getCliente());
            pst.setString(2, c.getUsuario());            
            pst.setString(3, c.getVehiculo());
            pst.setInt(4, c.getPrecio());
            pst.executeUpdate();            

        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }          
    }

    @Override
    public void eliminar(Object obj) throws Exception {
        Encomienda c = (Encomienda) obj;
        PreparedStatement pst;
        String sql="UPDATE encomiendas SET estado = 0 WHERE id = ?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, c.getId());
            pst.executeUpdate();            
          
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }           
    }

    @Override
    public void modificar(Object obj) throws Exception {
        Encomienda c = (Encomienda) obj;
        PreparedStatement pst;
        String sql="UPDATE encomiendas SET id_cli=?, id_usu=?, id_veh=?, id_precio=? WHERE id=?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, c.getCliente());
            pst.setString(2, c.getUsuario());
            pst.setString(3, c.getVehiculo());
            pst.setInt(7, c.getPrecio());            
            pst.setInt(8, c.getId());
            pst.executeUpdate();      
            
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }           
    }

    @Override
    public List consultar() throws Exception {
       List<Encomienda> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT e.id, c.nom, u.nom, v.placa, pe.resultado FROM clientes c, usuarios u, vehiculos v, precios pe, encomiendas e WHERE e.id_cli = c.id AND e.id_usu = u.id AND e.id_veh = v.id AND e.id_precio = pe.id AND e.estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Encomienda(
                        rs.getInt("e.id"),
                        rs.getString("c.nom"),
                        rs.getString("u.nom"),
                        rs.getString("v.placa"),
                        rs.getInt("pe.resultado")
                )
                );
            }
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }   
        return datos;
    }

    @Override
    public Encomienda BuscarPorId(int id) throws Exception {
           Encomienda c = new Encomienda();
           PreparedStatement pst;
           ResultSet res;
           String sql = "SELECT e.id, c.nom, u.nom, v.placa, pe.resultado FROM clientes c, usuarios u, vehiculos v, precios pe, encomiendas e WHERE e.id_cli = c.id AND e.id_usu = u.id AND e.id_veh = v.id AND e.id_precio = pe.id AND e.id=? AND e.estado = 1";
           try {
            this.conectar();
               pst = conexion.prepareStatement(sql);
               pst.setInt(1,id);                 
               res = pst.executeQuery();                                    
                if (res.next()) {                                     
                    c.setCliente(res.getString("c.nom"));            
                    c.setUsuario(res.getString("u.nom"));      
                    c.setVehiculo(res.getString("v.placa"));                 
                    c.setPrecio(res.getInt("pe.resultado"));                                       
                    c.setId(res.getInt("c.id"));
                }                   
     
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }   
           return c;        
    }

    @Override
    public boolean ConsultarNombre(String nom) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
