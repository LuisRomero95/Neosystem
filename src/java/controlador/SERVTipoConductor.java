
package controlador;

import dao.TipoConductorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelado.TipoConductor;

public class SERVTipoConductor extends HttpServlet {

    private static String insert= "/InsertarTipoConductor.jsp";
    private static String edit = "/EditarTipoConductor.jsp";
    private static String list_TipoConductor = "/ListarTipoConductor.jsp";
    private TipoConductorDAO tpdao;
    TipoConductor tp = new TipoConductor();
            
     public SERVTipoConductor() {
    	tpdao = new TipoConductorDAO(){};
    }               
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String forward = "";   
            String action = request.getParameter("action");
            
            //ELIMINAR TIPO DE CONDUCTOR
            if (action.equalsIgnoreCase("delete")) {                 
                try {
                    tp.setId(Integer.parseInt(request.getParameter("id")));
                    tpdao.eliminar(tp);                    
                    forward = list_TipoConductor;                 
                    request.setAttribute("tipoconductor", tpdao.consultar());
                } catch (Exception ex) {
                }
            }
            //EDITAR  TIPO DE CONDUCTOR
            else if (action.equalsIgnoreCase("edit")) { 
                try {
                    forward = edit;
                    int id = Integer.parseInt(request.getParameter("id"));
                    TipoConductor tp = tpdao.BuscarPorId(id);             
                    request.setAttribute("tp", tp);
                } catch (Exception ex) {
                }
            }            
            //INSERTAR  TIPO DE CONDUCTOR    
            else if(action.equalsIgnoreCase("insert")) {
            forward = insert;            
            }
            //LISTAR O ACTUALIZAR  TIPO DE CONDUCTOR
            else if(action.equalsIgnoreCase("refresh")){
                try {
                    forward = list_TipoConductor;               
                    List tipoconductor = tpdao.consultar();
                    request.setAttribute("tipoconductor", tipoconductor);
                } catch (Exception ex) {
                }
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);                                
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            TipoConductor tp = new TipoConductor(); 
            request.setCharacterEncoding("UTF-8");
            
            tp.setNom(request.getParameter("txtNom"));
            String id =request.getParameter("txtId");
            
            if (id == null || id.isEmpty()) {
                try {
                    tpdao.insertar(tp);
                } catch (Exception ex) {
                }
             } else {
                try {
                    tp.setId(Integer.parseInt(id));
                    tpdao.modificar(tp);
                } catch (Exception ex) {
                }
            }
                        
        response.sendRedirect(request.getContextPath() + "/SERVTipoConductor?action=refresh");          
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
