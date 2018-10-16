<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>

<%
HttpSession sesion = request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/validarEncomienda.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div align="right">
                <br>                
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>
            <h1>Insertar Encomienda</h1>
            <hr>                 
            <form name="frmInsertarVehiculo" method="POST" action="SERVEncomienda"  autocomplete="off">
                <div class="container">
                    
                    <div class="row">
                        
                        <div class="col-md-6">                             
                            
                            <div class="form-group">
                                <label for="cli_id" class="control-label">Cliente</label>
                                <br>
                                <select name="txtCliente" id="cli_id" class="form-control">
                                    <option value="" selected>Seleccione un cliente...</option>
                                    <c:forEach var="cliente" items="${cliente}" >
                                        <option value="${cliente.id}">
                                            ${cliente.nom}
                                        </option>
                                    </c:forEach>
                                </select>                                
                            </div>
                                        
                            <div class="form-group">
                                <label for="usuario_id" class="control-label">Usuario</label>
                                <br>
                                <select name="txtUsuario" id="usuario_id" class="form-control">
                                    <option value="" selected="selected">Seleccione un usuario...</option>
                                    <c:forEach var="usuario" items="${usuario}" >
                                        <option value="${usuario.id}">
                                            ${usuario.nom}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>                              
                           
                        </div>                        
                                                
                        <div class="col-md-6">
                                                                    
                            <div class="form-group">
                                <label for="vehiculo_id" class="control-label">Vehiculo</label>
                                <br>
                                <select name="txtVechiculo" id="vehiculo_id" class="form-control">
                                    <option value="" selected="selected">Seleccione un vehiculo...</option>
                                    <c:forEach var="vehiculo" items="${vehiculo}" >
                                        <option value="${vehiculo.id}">
                                            ${vehiculo.placa}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>  

                            <div class="form-group">
                                <label for="precio_id" class="control-label">Precio</label>
                                <br>
                                <select name="txtPrecio" id="precio_id" class="form-control">
                                    <option value="" selected="selected">Seleccione un precio...</option>
                                    <c:forEach var="precio" items="${precio}" >
                                        <option value="${precio.id}">
                                            ${precio.id}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>                              
                            
                        </div>
                        
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group"> <!-- Submit Insertar -->
                                <input type="submit" id="insertar" name="btnInsertar" value="Insertar" id="insertar" class="btn btn-success btn-lg">
                                <a href="SERVEncomienda?action=refresh"  class="btn btn-danger btn-lg" onclick="return confirm('¿Desea salir del registro?')">Regresar</a>
                                <input type="reset" name="btnLimpiar" value="Limpiar" class="btn btn-warning btn-lg" onclick="return confirm('¿Desea limpiar los datos a registrar?')">
                            </div>                             
                        </div>                          
                    </div>
                    
                </div>
            </form>
        </div>

    </body>
</html>
