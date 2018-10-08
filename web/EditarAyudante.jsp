
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
                            <input type="text" class="form-control" id="email_id" name="txtEmail" style="text-transform:lowercase;" value="<c:out value="${ayudante.email}" />" >
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
                            <a href="SERVAyudante?action=refresh" class="btn btn-danger btn-lg">Atrás</a>
                            <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg">
                        </div>   
                    </div>                        
            </form>
        </div>
<script type="text/javascript">
           
        function validacion() {
                
           var dni = document.getElementById("dni_id").value;                
           var nombre = document.getElementById("nom_id").value;
           var apellido = document.getElementById("ape_id").value;
           var direcion = document.getElementById("direc_id").value;           
           var email = document.getElementById("email_id").value;            
           var telefono = document.getElementById("tel_id").value;                     


              if( dni == null || dni.length == 0 || /^\s+$/.test(dni) ) {
                    alert('[ERROR] El dni no puede quedar vacio.');
                    return false;
              }
              else if(  !(dni.length == 8) || /^\s+$/.test(dni) ) {
                    alert('[ERROR] El dni debe tener un valor máximo de 8 dígitos.');
                    return false;
              }                
              else if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El nombre no puede quedar vacio.');
                return false;
              }
              else if (!(nombre.length <=60) || /^\s+$/.test(nombre) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El nombre debe tener un valor máximo de 60 dígitos.');
                return false;
              }              
              else if (apellido == null || apellido.length == 0 || /^\s+$/.test(apellido) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El apellido no puede quedar vacio.');
                return false;
              }
              else if (!(apellido.length <=80) || /^\s+$/.test(apellido) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El apellido debe tener un valor máximo de 80 dígitos');
                return false;
              }                
              else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
                // Si no se cumple la condicion...
                alert('[ERROR] La direccion no puede quedar vacia.');
                return false;
              }
              else if (!(direcion.length <=100) || /^\s+$/.test(direcion)) {
                // Si no se cumple la condicion...
                alert('[ERROR] La direccion debe tener un valor de máximo de 100 dígitos');
                return false;
              }              
              else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
                // Si no se cumple la condicion...
                alert('[ERROR] Ingrese un email con formato adecuado');
                return false;
              }
              else if (!(/^\d{9}$/.test(telefono)) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El telefono celular debe tener 9 digitos');
                return false;
              }      
             

              // Si el script ha llegado a este punto, todas las condiciones
              // se han cumplido, por lo que se devuelve el valor true
              return true;
        }                        
        </script>                 
    </body>
</html>
