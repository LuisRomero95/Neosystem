<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
HttpSession sesion = request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("index.jsp");
    }
    else{
        String nivel = sesion.getAttribute("nivel").toString();
        if(!nivel.equals("1")){
            response.sendRedirect("../index.jsp");
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/validarTipoConductor.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div align="right">
                <br>
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>                
                <h1>Ingresar Tipo de Conductor</h1>
                <hr>     
            <form name="frmInsertarTipoConductor" method="POST" action="SERVTipoConductor" onsubmit="return validacion()">
            <div class="container">
                <div class="col-md-6"> 
                    
                   <div class="form-group"> <!-- Nombre -->
                       <label for="nom_id" class="control-label">TIPO</label>
                       <input type="text" class="form-control" id="nom_id" name="txtNom" placeholder="A1">
                   </div>                    
                </div>
                
                <div class="col-md-12">
                    <div class="form-group"> <!-- Submit Insertar -->
                        <input type="submit" name="btnInsertar" value="Insertar" class="btn btn-success btn-lg">
                        <a href="SERVTipoConductor?action=refresh"  class="btn btn-danger btn-lg">Atrás</a>
                        <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg">
                    </div>                    
                </div>
            </div>        
            </form>          
        </div>                
    </body>
</html>
