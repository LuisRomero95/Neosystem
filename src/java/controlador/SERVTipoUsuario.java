
package controlador;

import dao.TipoUsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelado.TipoUsuario;

public class SERVTipoUsuario extends HttpServlet {

private static String insert= "/InsertarTipoUsuario.jsp";
    private static String edit = "/EditarTipoUsuario.jsp";
    private static String list_tipo_usuario = "/ListarTipoUsuario.jsp";
    private TipoUsuarioDAO tudao;
    TipoUsuario tu = new TipoUsuario();
            
        public SERVTipoUsuario() {
           tudao = new TipoUsuarioDAO(){};
       }              

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String forward = "";   
        String action = request.getParameter("action");

        //ELIMINAR TIPO DE USUARIO
        if (action.equalsIgnoreCase("delete")) {                 
            try {
                tu.setId(Integer.parseInt(request.getParameter("id")));
                tudao.eliminar(tu);
                forward = list_tipo_usuario;
                request.setAttribute("tu", tudao.consultar());                          
            } catch (Exception ex) {
            }               
        }
        //EDITAR TIPO DE USUARIO
        else if (action.equalsIgnoreCase("edit")) {
            try {
                forward = edit;
                int id = Integer.parseInt(request.getParameter("id"));
                TipoUsuario tu = tudao.BuscarPorId(id);             
                request.setAttribute("tu", tu);
            } catch (Exception ex) {
            }
        }            
        //INSERTAR TIPO USUARIO    
        else if(action.equalsIgnoreCase("insert")) {
        forward = insert;            
        }            
        //LISTAR O ACTUALIZAR LISTA
        else if(action.equalsIgnoreCase("refresh")){
            try {
            forward = list_tipo_usuario;
            request.setAttribute("tu", tudao.consultar());                  
            } catch (Exception e) {
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        request.setCharacterEncoding("UTF-8");
                
        TipoUsuario tu = new TipoUsuario();
        
        String nombre = request.getParameter("txtNombre");
        tu.setNom(nombre);                                                        
        String id =request.getParameter("txtId");

        try {
            if(tudao.ConsultarNombre(nombre)){    

            }else                 
                if (id == null || id.isEmpty()) {
                    try {
                        tudao.insertar(tu);
                    } catch (Exception ex) {
                    }
                }else {
                    try {
                        tu.setId(Integer.parseInt(id));
                        tudao.modificar(tu);
                    } catch (Exception ex){ 
                    }
                }  
        }                   
        catch (SQLException ex) {
            Logger.getLogger(SERVUsuario.class.getName()).log(Level.SEVERE, null, ex);             
        }            
                
        response.sendRedirect(request.getContextPath() + "/SERVTipoUsuario?action=refresh");           
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}