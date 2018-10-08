
package controlador;

import dao.ConductorDAO;
import dao.TipoConductorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelado.Conductor;

public class SERVConductor extends HttpServlet {

    private static String insert= "/InsertarConductor.jsp";
    private static String edit = "/EditarConductor.jsp";
    private static final String list_conductor = "/ListarConductor.jsp";
    private final ConductorDAO conductordao;
    private TipoConductorDAO tpdao;    
    Conductor c = new Conductor();

    public SERVConductor() {
        conductordao = new ConductorDAO(){};
        tpdao = new TipoConductorDAO(){};
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";   
        String action = request.getParameter("action");

        //ELIMINAR AYUDANTE
        if (action.equalsIgnoreCase("delete")) {
            try {
                c.setId(Integer.parseInt(request.getParameter("id")));
                conductordao.eliminar(c);                
                forward = list_conductor;                 
                request.setAttribute("conductor", conductordao.consultar());
            } catch (Exception ex) {
            }
        }
        //EDITAR AYUDANTE
        else if (action.equalsIgnoreCase("edit")) {
            try {
                forward = edit;
                int id = Integer.parseInt(request.getParameter("id"));
                Conductor conductor = conductordao.BuscarPorId(id);
                
                request.setAttribute("conductor", conductor);
                request.setAttribute("tipoconductor", tpdao.consultar());
            } catch (Exception ex) {
            }
        }            
        //INSERTAR AYUDANTE    
        else if(action.equalsIgnoreCase("insert")) {
            try {
                forward = insert;
                List tipoconductor = tpdao.consultar();
                request.setAttribute("tipoconductor", tipoconductor);
            } catch (Exception ex) {
                Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //LISTAR O ACTUALIZAR AYUDANTE
        else if(action.equalsIgnoreCase("refresh")){
            try {
                forward = list_conductor; 
                request.setAttribute("conductor", conductordao.consultar());
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
        String ape = request.getParameter("txtApe");                
        String dni = request.getParameter("txtDni");
        String lic = request.getParameter("txtLic");
        String email = request.getParameter("txtEmail");
        String tel = request.getParameter("txtTel");
        String direc = request.getParameter("txtDirec");
        String tipo = request.getParameter("txtTipo");        
        String id =request.getParameter("txtId");                                                           
        
        try {                              
                Conductor con = new Conductor();
                con.setNom(nombre);
                con.setApe(ape);
                con.setDni(dni);
                con.setLic(lic);        
                con.setEmail(email);     
                con.setTel(tel);        
                con.setDirec(direc);                      
                con.setTipo(tipo);  
                
                if (id == null || id.isEmpty()) {
                     if(conductordao.ConsultarRUCDNI(dni) || conductordao.ConsultarEmail(email)){    

                    }else {
                         try {
                             conductordao.insertar(con);
                         } catch (Exception ex) {
                             Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                } else {                    
                    try {
                        con.setId(Integer.parseInt(id));
                        conductordao.modificar(con);
                    } catch (Exception ex) {
                        Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);                        
                    }
                }             
                   
        }catch (SQLException ex) {
            Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);             
        }                         
        response.sendRedirect(request.getContextPath() + "/SERVConductor?action=refresh");                                       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
