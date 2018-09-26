
package controlador;

import dao.AyudanteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelado.Ayudante;

public class SERVAyudante extends HttpServlet {

    private static String insert= "/InsertarAyudante.jsp";
    private static String edit = "/EditarAyudante.jsp";
    private static String list_ayudante = "/ListarAyudante.jsp";
    private final AyudanteDAO ayudantedao;
    Ayudante ayudante = new Ayudante();
    
    public SERVAyudante() {
        ayudantedao = new AyudanteDAO();
    }    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String forward = "";   
            String action = request.getParameter("action");
            
            //ELIMINAR AYUDANTE
            if (action.equalsIgnoreCase("delete")) {                 
                try {
                    ayudante.setId(Integer.parseInt(request.getParameter("id")));
                    ayudantedao.eliminar(ayudante);
                    forward = list_ayudante; 
                    request.setAttribute("ayudante", ayudantedao.consultar());
                } catch (Exception ex) {
                }                 
            }
            //EDITAR AYUDANTE
            else if (action.equalsIgnoreCase("edit")) {
                try {
                    forward = edit;
                    int id = Integer.parseInt(request.getParameter("id"));
                    Ayudante ayudante = ayudantedao.BuscarPorId(id);             
                    request.setAttribute("ayudante", ayudante);
                } catch (Exception ex) {
                }
            }            
            //INSERTAR AYUDANTE    
            else if(action.equalsIgnoreCase("insert")) {
            forward = insert;            
            }
            //ACTUALIZAR AYUDANTE
            else if(action.equalsIgnoreCase("refresh")){
                try {
                    forward = list_ayudante; 
                    request.setAttribute("ayudante", ayudantedao.consultar());
                } catch (Exception ex) {
                }                
            } 
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Ayudante ayudante = new Ayudante();
            ayudante.setDni(request.getParameter("txtDni"));
            ayudante.setNom(request.getParameter("txtNombre"));
            ayudante.setApe(request.getParameter("txtApe"));
            ayudante.setDirec(request.getParameter("txtDirec"));             
            ayudante.setTel(request.getParameter("txtTel"));
            ayudante.setEmail(request.getParameter("txtEmail"));                                
            String id =request.getParameter("txtId");
            
            if (id == null || id.isEmpty()) {
                try {
                    ayudantedao.insertar(ayudante);
                } catch (Exception ex) {
                }
             } else {
                try {
                    ayudante.setId(Integer.parseInt(id));
                    ayudantedao.modificar(ayudante);
                } catch (Exception ex) {
                }
            }
                        
        response.sendRedirect(request.getContextPath() + "/SERVAyudante?action=refresh");         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
