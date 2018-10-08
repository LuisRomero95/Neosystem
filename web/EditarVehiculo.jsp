
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
        <script src="js/validarVehiculo.js" type="text/javascript"></script>
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
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group"> <!-- Identificación-->
                                <label for="vehiculo_id" class="control-label">ID</label>
                                <input type="text" class="form-control" id="vehiculo_id" readonly  name="txtId"  value=<c:out value="${vehiculo.id}" /> >
                            </div>                            
                            <div class="form-group"> 
                                <label for="placa_id" class="control-label">PLACA</label>
                                <input type="text" class="form-control" id="placa_id" name="txtPlaca" placeholder="PE1324" value=<c:out value="${vehiculo.placa}"/> >
                            </div>      
                            <div>
                                <label for="con_id" class="control-label">CONDUCTOR</label>
                                <br>
                                <select name="txtCon" id="con_id">
                                    <option value="">--Seleccionar--</option>
                                    <c:forEach var="con" items="${conductor}" >
                                        <option value="${con.id}">
                                            ${con.nom}
                                        </option>
                                    </c:forEach>
                                </select>                                                
                            </div>
                            <div>
                                <label for="ayu_id" class="control-label">AYUDANTE</label>
                                <br>
                                <select name="txtAyu" id="ayu_id">
                                    <option value="">--Seleccionar--</option>
                                    <c:forEach var="ayu" items="${ayudante}" >
                                        <option value="${ayu.id}">
                                            ${ayu.nom}
                                        </option>
                                    </c:forEach>
                                </select>                                                
                            </div>                              
                        </div>
                        <div class="col-md-6">
                            <div class="form-group"> 
                                <label for="cap_id" class="control-label">CAPACIDAD MAX</label>
                                <input type="text" class="form-control" id="cap_id" name="txtCapmax" placeholder="5" value=<c:out value="${vehiculo.capmax}"/> >
                            </div>          
                            <div class="form-group">
                                <label for="pas_id" class="control-label">PASAJEROS MAX</label>
                                <input type="text" class="form-control" id="pas_id" name="txtPasmax" placeholder="2" value=<c:out value="${vehiculo.pasmax}"/> >
                            </div>  
                        </div>                        
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="marca_id" class="control-label">MARCA</label>
                                <input type="text" class="form-control" id="marca_id" name="txtMarca" placeholder="3257618" value=<c:out value="${vehiculo.marca}"/> >
                            </div>           
                            <div class="form-group"> 
                                <label for="año_id" class="control-label">AÑO</label>
                                <input type="text" class="form-control" id="año_id" name="txtAño" placeholder="2018" value=<c:out value="${vehiculo.año}"/> >
                            </div>                             
                            <div class="form-group"> 
                                <label for="modelo_id" class="control-label">MODELO</label>
                                <input type="text" class="form-control" id="modelo_id" name="txtModelo" placeholder="979527707" value=<c:out value="${vehiculo.modelo}"/> >
                            </div>   
                        </div>
                        <div class="col-md-6">

                        </div>                                                
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group"> <!-- Submit Insertar -->
                                <input type="submit" name="btnInsertar" value="Insertar" class="btn btn-success btn-lg">
                                <a href="SERVVehiculo?action=refresh"  class="btn btn-danger btn-lg">Atrás</a>
                                <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg">
                            </div>                             
                        </div>                    
                    </div>      
                </div>
            </form>
        </div>
    </body>
</html>
