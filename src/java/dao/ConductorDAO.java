
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelado.Conductor;

public class ConductorDAO extends Conexion implements DAO{    

    @Override
    public void insertar(Object obj) throws Exception{
        Conductor c = (Conductor) obj;
        PreparedStatement pst;
        String sql="INSERT INTO conductores ( nom, ape, dni, lic, direc, tel, email, id_tipo) VALUES(?,?,?,?,?,?,?,?)";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getApe());
            pst.setString(3, c.getDni());
            pst.setString(4, c.getLic());
            pst.setString(5, c.getDirec());
            pst.setString(6, c.getTel());
            pst.setString(7, c.getEmail());
            pst.setString(8, c.getTipo());
            pst.executeUpdate();            

        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }   
    }

    @Override
    public void eliminar(Object obj) throws Exception{
        Conductor c = (Conductor) obj;
        PreparedStatement pst;
        String sql="UPDATE conductores set estado = 0 WHERE id = ?";
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
    public void modificar(Object obj) throws Exception{
        Conductor c = (Conductor) obj;
        PreparedStatement pst;
        String sql="UPDATE conductores SET nom=?, ape=?, dni=?, lic=?, direc=?, tel=?, email=?, id_tipo=? WHERE id=?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getApe());
            pst.setString(3, c.getDni());
            pst.setString(4, c.getLic());
            pst.setString(5, c.getDirec());
            pst.setString(6, c.getTel());
            pst.setString(7, c.getEmail());            
            pst.setString(8, c.getTipo());            
            pst.setInt(9, c.getId());
            pst.executeUpdate();      
            
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }   
    }

    @Override
    public Conductor BuscarPorId(int id) throws Exception{
           Conductor c = new Conductor();
           PreparedStatement pst;
           ResultSet res;
           String sql = "SELECT * FROM conductores WHERE id = ?";
           try {
            this.conectar();
               pst = conexion.prepareStatement(sql);
               pst.setInt(1,id);                 
               res = pst.executeQuery();                                    
                if (res.next()) {                                     
                    c.setNom(res.getString("nom"));            
                    c.setApe(res.getString("ape"));      
                    c.setDni(res.getString("dni"));
                    c.setLic(res.getString("lic"));                       
                    c.setDirec(res.getString("direc"));
                    c.setTel(res.getString("tel"));                    
                    c.setEmail(res.getString("email"));                   
                    c.setTipo(res.getString("id_tipo"));
                    c.setId(res.getInt("id"));
                }                   
     
        } catch (SQLException e) {
        }
        finally{
            this.cerrar();
        }   
           return c;
    }

    @Override
    public List<Conductor> consultar() throws Exception{
        List<Conductor> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT c.id, c.dni, c.lic, c.nom, c.ape, c.direc, c.tel, c.email, tc.nom FROM conductores c, tiposconductores tc WHERE c.id_tipo = tc.id AND c.estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Conductor(
                        rs.getInt("c.id"),
                        rs.getString("c.nom"),
                        rs.getString("c.ape"),
                        rs.getString("c.dni"),
                        rs.getString("c.lic"),                        
                        rs.getString("c.direc"),
                        rs.getString("c.tel"),
                        rs.getString("c.email"),
                        rs.getString("tc.nom"))
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
    public boolean ConsultarNombre(String nom) throws SQLException{
        PreparedStatement pst;
        ResultSet res = null;
        String sql = "SELECT * FROM usuarios WHERE nom='"+nom+"'";

        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            res = pst.executeQuery();
        } catch (Exception e) {
        }
         return res.next();
    }

    
}