
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelado.Cliente;

public class SERVCliente extends HttpServlet {
    
    private static String insert= "/InsertarCliente.jsp";
    private static String edit = "/EditarCliente.jsp";
    private static String list_cliente = "/ListarCliente.jsp";
    private ClienteDAO clientedao;
    Cliente c = new Cliente();
            
     public SERVCliente() {
    	clientedao = new ClienteDAO(){};
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
                    clientedao.eliminar(c);
                    forward = list_cliente;
                    request.setAttribute("cliente", clientedao.consultar());                      
                } catch (Exception ex) {
                }              
            }
            //EDITAR CLIENTE
            else if (action.equalsIgnoreCase("edit")) {
                try {
                    forward = edit;
                    int id = Integer.parseInt(request.getParameter("id"));
                    Cliente cliente = clientedao.BuscarPorId(id);             
                    request.setAttribute("cliente", cliente);
                } catch (Exception ex) {
                }
            }            
            //INSERTAR CLIENTE    
            else if(action.equalsIgnoreCase("insert")) {        
                    forward = insert;
            
            }
            //LISTAR O ACTUALIZAR CLIENTE
            else if(action.equalsIgnoreCase("refresh")){
                try {
                    forward = list_cliente;
                    request.setAttribute("cliente", clientedao.consultar()); 
                } catch (Exception e) {
                }
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
             
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                   
            Cliente c = new Cliente();
            request.setCharacterEncoding("UTF-8");
            
            c.setRuc_dni(request.getParameter("txtRuc_Dni"));
            c.setNom(request.getParameter("txtNombre"));
            c.setEmail(request.getParameter("txtEmail"));
            c.setTel_fij(request.getParameter("txtTel_fij"));
            c.setTel_cel(request.getParameter("txtTel_cel"));
            c.setDirec(request.getParameter("txtDirec"));                                 
            String id =request.getParameter("txtId");
            
            if (id == null || id.isEmpty()) {
                try {
                    clientedao.insertar(c);
                } catch (Exception ex) {
 
                }
             } else {
                try {
                    c.setId(Integer.parseInt(id));
                    clientedao.modificar(c);
                } catch (Exception ex) {

                }
            }
                        
        response.sendRedirect(request.getContextPath() + "/SERVCliente?action=refresh");        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
