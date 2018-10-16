
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelado.Precio;

public class PrecioDAO extends Conexion implements DAO{    

    @Override
    public void insertar(Object obj) throws Exception {
        Precio u = (Precio) obj;
        PreparedStatement pst;
        String sql="INSERT INTO precios (tipo, cantidad, peso, resultado, id_cliente) VALUES(?,?,?,?,?)";
        //conectarse a la bd
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, u.getTipo());
            pst.setInt(2, u.getCantidad());
            pst.setDouble(3, u.getPeso());
            pst.setDouble(4, u.getResultado());
            pst.setString(5, u.getCliente());
            //ejecutar la consulta sql antes definida
            // asi la bd sabe la consulta que voy a ejecutar
            pst.executeUpdate();            
            //cerrar conexion para no tener conexiones abiertas
            
        }
        catch ( SQLException e) {
            throw e;
        }
        finally{
            this.cerrar();
        }        
    }

    @Override
    public void eliminar(Object obj) throws Exception {
        Precio u = (Precio) obj;
        PreparedStatement pst;
        String sql="UPDATE precios SET estado = 0 WHERE id = ?";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, u.getId());
            pst.executeUpdate();            
                 
        } catch (SQLException e) {
            throw e;            
        }
        finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(Object obj) throws Exception {
        Precio u = (Precio) obj;
        PreparedStatement pst;        
        String sql = "UPDATE precios SET tipo=?, cantidad=?, peso=?, resultado=?, id_cliente=? WHERE id=? AND estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, u.getTipo());
            pst.setInt(2, u.getCantidad());
            pst.setDouble(3, u.getPeso());
            pst.setDouble(4, u.getResultado());         
            pst.setString(5, u.getCliente());         
            pst.setInt(6, u.getId()); 
            pst.executeUpdate();            
        } catch ( SQLException e) {                     
        }
        finally{
            this.cerrar();            
        }        
    }

    @Override
    public List consultar() throws Exception {
        List<Precio> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT p.id, p.tipo, p.cantidad, p.peso, p.resultado, c.nom FROM precios p, clientes c WHERE p.id_cliente = c.id AND p.estado = 1";
        try {
            this.conectar();
            pst = conexion.prepareStatement(sql);
            //ejecutar mi consulta y recuperar los resultados en rs
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new Precio(
                        rs.getInt("p.id"),
                        rs.getString("p.tipo"),
                        rs.getInt("p.cantidad"),
                        rs.getDouble("p.peso"),
                        rs.getDouble("p.resultado"),
                        rs.getString("c.nom")
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
    public Precio BuscarPorId(int id) throws Exception {
        Precio usuario = new Precio();
        PreparedStatement pst;
        ResultSet res;
        String sql = "SELECT p.id, p.tipo, p.cantidad, p.peso, p.resultado, c.nom FROM precios p, clientes c WHERE p.id_cliente = c.id AND p.id=? AND p.estado = 1";
        try {
           this.conectar();
           pst = conexion.prepareStatement(sql);
           pst.setInt(1,id);  

           res = pst.executeQuery();                                    
            if (res.next()) {
                usuario.setTipo(res.getString("p.tipo"));
                usuario.setCantidad(res.getInt("p.cantidad"));
                usuario.setPeso(res.getDouble("p.peso"));                
                usuario.setResultado(res.getDouble("p.resultado"));
                usuario.setCliente(res.getString("c.nom"));
                usuario.setId(res.getInt("p.id"));
            }                       

        } catch ( SQLException e ) {
        }
        finally{
           this.cerrar();
        }
        return usuario;        
    }

    @Override
    public boolean ConsultarNombre(String nom) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
