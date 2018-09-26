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

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/validarVehiculo.js" type="text/javascript"></script>
        <title>JSP Page</title>        
    </head>
    <body>       
        <div class="container" >
            <div align="right">
                <br>                
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>
            <h1>Insertar Vehiculo</h1>
            <hr>            
            <form name="frmInsertarVehiculo" method="POST" action="SERVVehiculo" onsubmit="return validacion()" >
                <div class="container">

                    <div class="form-group"> 
                        <label for="id_vehiculo" class="control-label">ID</label>
                        <input type="text" class="form-control" id="id_vehiculo" readonly  name="txtId" placeholder="Id autoincrementable">
                    </div> 
                    <div class="form-group"> 
                        <label for="placa_id" class="control-label">PLACA</label>
                        <input type="text" class="form-control" id="placa_id" name="txtPlaca" placeholder="73095001">
                    </div>      
                    <div class="form-group">
                        <label for="con_id" class="control-label">CONDUCTOR</label>
                        <input type="text" class="form-control" id="con_id" name="txtId_con" placeholder="Luis Alonso Romero Costilla">
                    </div> 
                    <div class="form-group">
                        <label for="ayu_id" class="control-label">AYUDANTE</label>
                        <input type="text" class="form-control" id="ayu_id" name="txtId_ayu" placeholder="larcroco@gmail.com">
                    </div>
                    <div class="form-group">
                        <label for="marca_id" class="control-label">MARCA</label>
                        <input type="text" class="form-control" id="marca_id" name="txtMarca" placeholder="3257618">
                    </div>                  
                    <div class="form-group"> 
                        <label for="modelo_id" class="control-label">MODELO</label>
                        <input type="text" class="form-control" id="modelo_id" name="txtModelo" placeholder="979527707">
                    </div>
                    <div class="form-group"> 
                        <label for="color_id" class="control-label">COLOR</label>
                        <input type="text" class="form-control" id="color_id" name="txtColor" placeholder="Jr. Wacaypata 448, Urb. Tupác Amaru, San Luis, Lima, Perú">
                    </div>          
                    <div class="form-group"> 
                        <label for="cap_id" class="control-label">CAPACIDAD MAX</label>
                        <input type="text" class="form-control" id="cap_id" name="txtCapmax" placeholder="Jr. Wacaypata 448, Urb. Tupác Amaru, San Luis, Lima, Perú">
                    </div>          
                    <div class="form-group">
                        <label for="pas_id" class="control-label">PASAJEROS MAX</label>
                        <input type="text" class="form-control" id="pas_id" name="txtPasmax" placeholder="Jr. Wacaypata 448, Urb. Tupác Amaru, San Luis, Lima, Perú">
                    </div>                         
                    <div class="form-group"> <!-- Submit Insertar -->
                        <input type="submit" name="btnInsertar" value="Insertar" class="btn btn-success btn-lg">
                        <a href="SERVVehiculo?action=refresh"  class="btn btn-danger btn-lg">Atrás</a>
                        <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg">
                    </div>     

                </div>
            </form>           
        </div>
    </body>
</html>
