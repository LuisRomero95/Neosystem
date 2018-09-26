
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

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>        
    </head>
    <body>       
        <div class="container" >
            <div align="right">
                <br>                
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>
            <h1>Editar Vehiculo</h1>
            <hr>            
            <form name="frmInsertarVehiculo" method="POST" action="SERVVehiculo" onsubmit="return validacion()" >
                <div class="container">

                    <div class="form-group"> 
                        <label for="id_vehiculo" class="control-label">ID</label>
                        <input type="text" class="form-control" id="id_vehiculo" readonly  name="txtId" value=<c:out value="${vehiculo.id}"/> >
                    </div> 
                    <div class="form-group"> 
                        <label for="placa_id" class="control-label">PLACA</label>
                        <input type="text" class="form-control" id="placa_id" name="txtPlaca" value=<c:out value="${vehiculo.placa}"/> >
                    </div>      
                    <div class="form-group">
                        <label for="con_id" class="control-label">CONDUCTOR</label>
                        <input type="text" class="form-control" id="con_id" name="txtId_con" value=<c:out value="${vehiculo.id_con}"/> >
                    </div> 
                    <div class="form-group">
                        <label for="ayu_id" class="control-label">AYUDANTE</label>
                        <input type="text" class="form-control" id="ayu_id" name="txtId_ayu" value=<c:out value="${vehiculo.id_ayu}"/> >
                    </div>
                    <div class="form-group">
                        <label for="marca_id" class="control-label">MARCA</label>
                        <input type="text" class="form-control" id="marca_id" name="txtMarca" value=<c:out value="${vehiculo.marca}"/> >
                    </div>                  
                    <div class="form-group"> 
                        <label for="modelo_id" class="control-label">MODELO</label>
                        <input type="text" class="form-control" id="modelo_id" name="txtModelo" value=<c:out value="${vehiculo.modelo}"/> >
                    </div>
                    <div class="form-group"> 
                        <label for="color_id" class="control-label">COLOR</label>
                        <input type="text" class="form-control" id="color_id" name="txtColor" value=<c:out value="${vehiculo.color}"/> >
                    </div>          
                    <div class="form-group"> 
                        <label for="cap_id" class="control-label">CAPACIDAD MAX</label>
                        <input type="text" class="form-control" id="cap_id" name="txtCapmax" value=<c:out value="${vehiculo.capmax}"/> >
                    </div>          
                    <div class="form-group">
                        <label for="pas_id" class="control-label">PASAJEROS MAX</label>
                        <input type="text" class="form-control" id="pas_id" name="txtPasmax" value=<c:out value="${vehiculo.pasmax}"/> >
                    </div>                         
                    <div class="form-group"> <!-- Submit Insertar -->
                        <input type="submit" name="btnInsertar" value="Editar" class="btn btn-success btn-lg">
                        <a href="SERVVehiculo?action=refresh"  class="btn btn-danger btn-lg">Atrás</a>
                        <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg">
                    </div>     
                </div>
            </form>
<script type="text/javascript">
           
            function validacion() {
                
           var placa = document.getElementById("placa_id").value;                
           var conductor = document.getElementById("con_id").value;           
           var ayudante = document.getElementById("ayu_id").value;            
           var marca = document.getElementById("marca_id").value;                     
           var modelo = document.getElementById("modelo_id").value;
           var color = document.getElementById("color_id").value;
           var capacidad = document.getElementById("cap_id").value;
           var pasajeros = document.getElementById("pas_id").value;

              if( conductor == null || conductor.length == 0 || /^\s+$/.test(ruc_dni) ) {
                    alert('[ERROR] El identificador del conductor no puede quedar vacío.');
                    return false;
              }  
              else if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo ruc_dni debe tener un valor de...');
                return false;
              }
              else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
                // Si no se cumple la condicion...
                alert('[ERROR] Ingrese un email con formato adecuado');
                return false;
              }
              else if (!(/^\d{7}$/.test(fijo)) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo telefono fijo debe tener un valor de...');
                return false;
              }
              else if (!(/^\d{9}$/.test(celular)) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El telefono celular debe tener 9 digitos');
                return false;
              }      
              else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo direccion debe tener un valor de...');
                return false;
              }              

              // Si el script ha llegado a este punto, todas las condiciones
              // se han cumplido, por lo que se devuelve el valor true
              return true;
            }                        
        </script>
        </div>
    </body>
</html>
