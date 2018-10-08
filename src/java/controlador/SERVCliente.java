
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                   
            
        request.setCharacterEncoding("UTF-8");

        String identificador = request.getParameter("txtRuc_Dni");
        String nombre = request.getParameter("txtNombre");
        String email = request.getParameter("txtEmail");
        String fijo = request.getParameter("txtTel_fij");
        String celular = request.getParameter("txtTel_cel");
        String direccion = request.getParameter("txtDirec");
        String id =request.getParameter("txtId");
                                                      
        try {                              
            Cliente cli = new Cliente();
            cli.setRuc_dni(identificador);
            cli.setNom(nombre);
            cli.setEmail(email);
            cli.setTel_fij(fijo);
            cli.setTel_cel(celular);
            cli.setDirec(direccion); 
                
                if (id == null || id.isEmpty()) {
                     if(clientedao.ConsultarEmail(email) || clientedao.ConsultarRUCDNI(identificador)){    

                    }else {
                         try {
                             clientedao.insertar(cli);
                         } catch (Exception ex) {
                             Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                } else {                    
                    try {
                        cli.setId(Integer.parseInt(id));
                        clientedao.modificar(cli);
                    } catch (Exception ex) {
                        Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);                        
                    }
                }             
                   
        }catch (SQLException ex) {
            Logger.getLogger(SERVConductor.class.getName()).log(Level.SEVERE, null, ex);             
        }                             
        response.sendRedirect(request.getContextPath() + "/SERVCliente?action=refresh");        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
