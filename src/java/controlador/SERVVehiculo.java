
package controlador;

import dao.VehiculoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelado.Vehiculo;

public class SERVVehiculo extends HttpServlet {

    private static String insert= "/InsertarVehiculo.jsp";
    private static String edit = "/EditarVehiculo.jsp";
    private static String list_cliente = "/ListarVehiculo.jsp";
    private VehiculoDAO vehiculodao;
    Vehiculo c = new Vehiculo();
            
     public SERVVehiculo() {
    	vehiculodao = new VehiculoDAO(){};
    }         
                
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String forward = "";   
            String action = request.getParameter("action");
            
            //ELIMINAR CLIENTE
            if (action.equalsIgnoreCase("delete")) {
                 
                try {
                    c.setId(Integer.parseInt(request.getParameter("id")));
                    vehiculodao.eliminar(c);                    
                    forward = list_cliente;                 
                    request.setAttribute("vehiculo", vehiculodao.consultar());
                } catch (Exception ex) {
                }
            }
            //EDITAR CLIENTE
            else if (action.equalsIgnoreCase("edit")) {
                try {
                    forward = edit;
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vehiculo vehiculo = vehiculodao.BuscarPorId(id);             
                    request.setAttribute("vehiculo", vehiculo);
                } catch (Exception ex) {
                }
            }            
            //INSERTAR CLIENTE    
            else if(action.equalsIgnoreCase("insert")) {        
                    forward = insert;            
            }
            //ACTUALIZAR CLIENTE
            else if(action.equalsIgnoreCase("refresh")){
                try {
                    forward = list_cliente;                  
                    request.setAttribute("vehiculo", vehiculodao.consultar());
                } catch (Exception ex) {
                }
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);                    
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
                   
            Vehiculo v = new Vehiculo();
            v.setPlaca(request.getParameter("txtPlaca"));
            v.setId_con(Integer.parseInt(request.getParameter("txtId_con")));
            v.setId_ayu(Integer.parseInt(request.getParameter("txtId_ayu")));
            v.setMarca(request.getParameter("txtMarca"));
            v.setModelo(request.getParameter("txtModelo"));
            v.setColor(request.getParameter("txtColor"));
            v.setCapmax(Integer.parseInt(request.getParameter("txtCapmax")));
            v.setPasmax(Integer.parseInt(request.getParameter("txtPasmax")));
            String id =request.getParameter("txtId");
            
            if (id == null || id.isEmpty()) {
                try {
                    vehiculodao.insertar(v);
                } catch (Exception ex) {
                }
             } else {
                try {
                    v.setId(Integer.parseInt(id));
                    vehiculodao.modificar(v);
                } catch (Exception ex) {
                }
            }
                        
        response.sendRedirect(request.getContextPath() + "/SERVVehiculo?action=refresh");          
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
