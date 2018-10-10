
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<%
HttpSession sesion = request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("index.jsp");
    }
    else{
        String nivel = sesion.getAttribute("nivel").toString();
        if(!(nivel.equals("1") || nivel.equals("2"))){
            response.sendRedirect("navbar.jsp");
        }
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/validarAyudante.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>  
    <body>
        <div class="container">
            <div align="right">
                <br>
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>                
            <h1>Editar Ayudante</h1>
            <hr>     
            <form  method="POST" action="SERVAyudante" name="frmEditarAyudante" onsubmit="return validacion()" >
               <div class="container">
                    <div class="col-md-6">
                        <div class="form-group"> <!-- Identificación-->
                            <label for="ayudante_id" class="control-label">ID</label>
                            <input type="text" class="form-control" id="ayudante_id" readonly  name="txtId"   value="<c:out value="${ayudante.id}" />" >
                        </div>

                        <div class="form-group"> <!-- Dni -->
                            <label for="dni_id" class="control-label">DNI</label>
                            <input type="text" class="form-control" id="dni_id" name="txtDni" value="<c:out value="${ayudante.dni}" />"   onkeypress="return soloNumeros(event)" onblur="limpiaDni()"  >
                        </div>                

                        <div class="form-group"> <!-- Nombres -->
                            <label for="nom_id" class="control-label">NOMBRE</label>
                            <input type="text" class="form-control" id="nom_id" name="txtNombre" value="<c:out value="${ayudante.nom}" />" onkeypress="return soloLetras(event)">
                        </div>

                        <div class="form-group"> <!-- Apellidos -->
                            <label for="ape_id" class="control-label">APELLIDOS</label>
                            <input type="text" class="form-control" id="ape_id" name="txtApe" value="<c:out value="${ayudante.ape}" />"  onkeypress="return soloLetras(event)">
                        </div>                         
                    </div> 
                        
                    <div class="col-md-6">
                        <div class="form-group"> <!-- Correo Electrónico-->
                            <label for="email_id" class="control-label">Email</label>
                            <input type="text" class="form-control" id="email_id" name="txtEmail" value="<c:out value="${ayudante.email}" />" onkeyup="minus(this);" >
                        </div> 
                        <div class="form-group"> <!-- Teléfono corporativo-->
                            <label for="tel_id" class="control-label">TELÉFONO CELULAR</label>
                            <input type="text" class="form-control" id="tel_id" name="txtTel" value="<c:out value="${ayudante.tel}" />" onkeypress="return soloNumeros(event)" onblur="limpiaTC()" >
                        </div>   
                       <div class="form-group"> <!-- Dirección-->
                            <label for="direc_id" class="control-label">DIRECCIÓN</label>
                            <input type="text" class="form-control" id="direc_id" name="txtDirec" value="<c:out value="${ayudante.direc}" />" >
                        </div>                        
                    </div>                            
                        
                    <div class="col-md-12">
                        <div class="form-group"> <!-- Submit Insertar -->
                            <input type="submit" name="btnInsertar" value="Actualizar" class="btn btn-success btn-lg">
                            <a href="SERVAyudante?action=refresh" class="btn btn-danger btn-lg" onclick="return confirm('¿Desea salir de la edición?')">Regresar</a>
                        </div>   
                    </div>                        
            </form>
        </div>             
    </body>
</html>
