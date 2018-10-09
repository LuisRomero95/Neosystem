
package controlador;

import dao.TipoUsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.Usuario;

public class SERVUsuario extends HttpServlet {

    private static String insert= "/InsertarUsuario.jsp";
    private static String edit = "/EditarUsuario.jsp";
    private static String list_usuario = "/ListarUsuario.jsp";
    private UsuarioDAO usuariodao;
    private TipoUsuarioDAO tudao;    
    Usuario u = new Usuario();

            
     public SERVUsuario() {
    	usuariodao = new UsuarioDAO(){};
        tudao = new TipoUsuarioDAO(){};
    }         
            
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";           
        String action = request.getParameter("action");                
           
            //ELIMINAR USUARIO
            if (action.equalsIgnoreCase("delete")) {                 
                try {
                    u.setId(Integer.parseInt(request.getParameter("id")));
                    usuariodao.eliminar(u);                    
                    forward = list_usuario;                 
                    request.setAttribute("usuario", usuariodao.consultar());
                } catch (Exception ex) {
                    
                }
            }
            //EDITAR USUARIO
            else if (action.equalsIgnoreCase("edit")) {
                try {
                    forward = edit;
                    int id = Integer.parseInt(request.getParameter("id"));
                    Usuario usuario = usuariodao.BuscarPorId(id);
                    List  tipousuario = tudao.consultar();
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("tipousuario", tipousuario);
                } catch (Exception ex) {
                }
            }            
            //INSERTAR USUARIO    
            else if(action.equalsIgnoreCase("insert")) {
                try {
                    forward = insert;
                    List  usuario = tudao.consultar();
                    request.setAttribute("usuario", usuario);     
                } catch (Exception ex) {
                    Logger.getLogger(SERVUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
            //LISTAR O ACTUALIZAR USUARIO
            else if(action.equalsIgnoreCase("refresh")){
                try {
                    forward = list_usuario;
                    List  usuario = usuariodao.consultar();
                    request.setAttribute("usuario", usuario);                  
                } catch (Exception ex) {
                }
            }           
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
             
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                              
        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("txtNombre");
        String contra = request.getParameter("txtContra");
        String email = request.getParameter("txtEmail");
        String nivel = request.getParameter("txtNivel");
        String id =request.getParameter("txtId"); 

        try {                              
                Usuario u = new Usuario();    
                u.setNom(nombre);
                u.setPassword(contra);                       
                u.setEmail(email);
                u.setNivel(nivel);   
                
                if (id == null || id.isEmpty()) {
                     if(usuariodao.ConsultarEmail(email) || usuariodao.ConsultarNombre(nombre)){    

                    }else {
                         try {
                             usuariodao.insertar(u);
                         } catch (Exception ex) {
                             Logger.getLogger(SERVUsuario.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                } else {                    
                    try {
                        u.setId(Integer.parseInt(id));
                        usuariodao.modificar(u);
                    } catch (Exception ex) {
                        Logger.getLogger(SERVUsuario.class.getName()).log(Level.SEVERE, null, ex);                        
                    }
                }             
                   
        }catch (SQLException ex) {
            Logger.getLogger(SERVUsuario.class.getName()).log(Level.SEVERE, null, ex);             
        }                           
        response.sendRedirect(request.getContextPath() + "/SERVUsuario?action=refresh");        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
