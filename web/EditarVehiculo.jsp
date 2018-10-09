<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <input type="text" class="form-control" id="placa_id" name="txtPlaca" placeholder="PE1324"  value=<c:out value="${vehiculo.placa}" /> >
                            </div>      
                            <div>
                                <label for="con_id" class="control-label">CONDUCTOR</label>
                                <br>
                                <select name="txtCon" id="con_id" class="form-control">
                                    <option value="">--Seleccione Conductor--</option>
                                    <c:forEach var="con" items="${conductor}" >
                                        <option value="${con.id}">
                                            ${con.nom}
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                            </div>
                            <div>
                                <label for="ayu_id" class="control-label">AYUDANTE</label>
                                <br>
                                <select name="txtAyu" id="ayu_id" class="form-control">
                                    <option value="">--Seleccione Ayudante--</option>
                                    <c:forEach var="ayu" items="${ayudante}" >
                                        <option value="${ayu.id}">
                                            ${ayu.nom}
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                            </div>                              
                            <div class="form-group">                                
                                <label for="listarMarca" class="control-label">MARCA</label>       
                                <select id="listarMarca" onchange="seleccionarMarca()" class="form-control">
                                    <option>  Cargando marca...</option>
                                </select>
                                <br>                                                             
                                    <div>
                                        <label for="marca_id" class="control-label">MARCA SELECCIONADA</label>
                                        <input type="text"  class="form-control" id="marca_id" readonly="" name="txtMarca" value=<c:out value="${vehiculo.marca}" /> >                        
                                    </div>                                                                                            
                            </div>
                            <div class="form-group"> 
                                   <label for="listarAño" class="control-label">AÑO</label>       
                                   <select id="listarAño" onchange="seleccionarAño()" class="form-control">
                                       <option>--Seleccione un año--</option>
                                       <option>2000</option>
                                       <option>2001</option>
                                       <option>2002</option>
                                       <option>2003</option>
                                       <option>2004</option>
                                       <option>2005</option>
                                       <option>2006</option>
                                       <option>2007</option>
                                       <option>2008</option>                                       
                                       <option>2009</option>                                       
                                       <option>2010</option>
                                       <option>2011</option>
                                       <option>2012</option>
                                       <option>2013</option>
                                       <option>2014</option>
                                       <option>2015</option>
                                       <option>2016</option>
                                       <option>2017</option>
                                       <option>2018</option>
                                   </select>
                                <br>          
                                <div>
                                    <label for="año_id" class="control-label">AÑO SELECCIONADO</label>       
                                    <input type="text" class="form-control" id="año_id" readonly="" name="txtAño" value=<c:out value="${vehiculo.año}" /> >
                                </div>                                                                
                            </div>                             
                        </div>
                        <div class="col-md-6">                            
                            <div class="form-group">                                                                
                                <label for="listarModelo" class="control-label">MODELO</label> 
                                <select id="listarModelo" onchange="modeloSeleccionada()"  class="form-control">
                                </select>
                                <br>
                                <div>
                                    <label for="modelo_año" class="control-label">MODELO SELECCIONADO</label>        
                                    <input type="text" class="form-control" id="modelo_año" readonly="" name="txtModelo" value=<c:out value="${vehiculo.modelo}" /> >                                    
                                </div>                                                                                                
                            </div>                            
                            <div class="form-group"> 
                                <label for="cap_id" class="control-label">CAPACIDAD MAX</label>
                                <input type="text" class="form-control" id="cap_id" name="txtCapmax" placeholder="5"  value=<c:out value="${vehiculo.capmax}" /> >
                            </div>          
                            <div class="form-group">
                                <label for="pas_id" class="control-label">PASAJEROS MAX</label>
                                <input type="text" class="form-control" id="pas_id" name="txtPasmax" placeholder="2"  value=<c:out value="${vehiculo.pasmax}" /> >
                            </div>  
                        </div>                        
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group"> <!-- Submit Insertar -->
                                <input type="submit" name="btnInsertar" value="Actualizar" class="btn btn-success btn-lg">
                                <a href="SERVVehiculo?action=refresh"  class="btn btn-danger btn-lg" onclick="return confirm('¿Desea salir de la edición?')">Regresar</a>
                            </div>                             
                        </div>                    
                    </div>                        
                </div>
            </form>           
        </div>
        <script type="text/javascript">            
            function llamarMarca() {
                if(window.XMLHttpRequest){
                    xmlhttp = new XMLHttpRequest();
                }else{
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                xmlhttp.onreadystatechange = function (){
                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
                        if(xmlhttp.responseXML !== null){
                            ejecutarMarca(this);
                        }
                    }
                };
                xmlhttp.open("GET","https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=XML", true);
                xmlhttp.send();
            }
            function ejecutarMarca(xmlhttp){
                var resultado = document.getElementById("listarMarca");
                var xmlDoc = xmlhttp.responseXML;
                var marcas = "";
                var vehiculo = xmlDoc.getElementsByTagName("AllVehicleMakes");

                for(var i = 0; i < vehiculo.length; i++){                   
                    marcas += "<option>" +
                            vehiculo[i].getElementsByTagName("Make_Name")[0].childNodes[0].nodeValue +
                            "</option>";                    
                }
                resultado.innerHTML = marcas;
            }
            
            llamarMarca();
            function seleccionarMarca(){
                var e = document.getElementById("listarMarca");
                var marca = e.options[e.selectedIndex].text;                               
                document.getElementById("marca_id").value = marca;                
            } 
            
            document.getElementById("listarMarca").addEventListener("click", seleccionarAño);
            function seleccionarAño(){
                var e = document.getElementById("listarAño");
                var year = e.options[e.selectedIndex].text;                               
                document.getElementById("año_id").value = year;                 
            }           
                
            document.getElementById("listarAño").addEventListener("click", llamarModelo);
            function llamarModelo() {
                var marca = document.getElementById("marca_id").value;
                var año = document.getElementById("año_id").value;
                if(window.XMLHttpRequest){
                    xmlhttp = new XMLHttpRequest();
                }else{
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                xmlhttp.onreadystatechange = function (){
                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
                        if(xmlhttp.responseXML !== null){
                            ejecutarModelo(this);
                        }
                    }
                };
                xmlhttp.open("GET","https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/"+marca+"/modelyear/"+año+"?format=xml", true);
                xmlhttp.send();
            }
            function ejecutarModelo(xmlhttp){
                var resultado = document.getElementById("listarModelo");
                var xmlDoc = xmlhttp.responseXML;
                var marcas = "<option>--Seleccione Modelo</option>";
                var vehiculo = xmlDoc.getElementsByTagName("MakeModels");

                for(var i = 0; i < vehiculo.length; i++){                   
                    marcas += "<option>" +
                            vehiculo[i].getElementsByTagName("Model_Name")[0].childNodes[0].nodeValue +
                            "</option>";                    
                }
                resultado.innerHTML = marcas;
            }
            
            llamarModelo();
            function modeloSeleccionada(){
                var e = document.getElementById("listarModelo");
                var modelo = e.options[e.selectedIndex].text;
                document.getElementById("modelo_año").value = modelo;
            }            
            
        </script>    
    </body>
</html>
