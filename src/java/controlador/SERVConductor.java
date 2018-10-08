
package controlador;

import dao.ConductorDAO;
import dao.TipoConductorDAO;
import java.io.IOException;
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
        Conductor a = new Conductor();
        request.setCharacterEncoding("UTF-8");
        
        a.setNom(request.getParameter("txtNombre"));
        a.setApe(request.getParameter("txtApe"));
        a.setDni(request.getParameter("txtDni"));
        a.setLic(request.getParameter("txtLic"));        
        a.setEmail(request.getParameter("txtEmail"));     
        a.setTel(request.getParameter("txtTel"));        
        a.setDirec(request.getParameter("txtDirec"));                      
        a.setTipo((request.getParameter("txtTipo")));

        String id =request.getParameter("txtId");

        if (id == null || id.isEmpty()) {
            try {
                conductordao.insertar(a);
            } catch (Exception ex) {
            }
         } else {
            try {
                a.setId(Integer.parseInt(id));
                conductordao.modificar(a);
            } catch (Exception ex) {
            }
            }
                        
        response.sendRedirect(request.getContextPath() + "/SERVConductor?action=refresh");                                       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
