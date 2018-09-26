<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>JSP Page</title>

    </head>    
    <body>  
        <div class="container">
            <div align="right">
                <br>                
                Bienvenido : <%= sesion.getAttribute("nombre") %>
                <a href="index.jsp?cerrar=true">Cerrar Sesion</a>
            </div>
            <h1>Lista de Vehiculos</h1>
            <hr>
                <a class="btn btn-success btn-lg" href="SERVVehiculo?action=insert">Nuevo Registro</a>
                <a class="btn btn-primary btn-lg" href="SERVVehiculo?action=refresh">Actualizar Lista</a>
                <a class="btn btn-warning btn-lg" href="Admin/admin.jsp">Regresar al menú</a>
            <br>
            <br>
            <form method="POST">
            <table class="table table-bordered" >
                <tr>
                    <th class="text-center">ID</th>                
                    <th class="text-center">PLACA</th>                                    
                    <th class="text-center">CONDUCTOR</th>      
                    <th class="text-center">AYUDANTE</th>      
                    <th class="text-center">MARCA</th>      
                    <th class="text-center">MODELO</th>
                    <th class="text-center">COLOR</th>
                    <th class="text-center">CAPACIDAD MAX</th>
                    <th class="text-center">PASAJEROS MAX</th>
                    <th class="text-center">ACCIONES</th>
                </tr>
               <c:forEach items="${vehiculo}" var="vehiculo">
                    <tr>
                        <td>
                            <c:out value="${vehiculo.id}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.placa}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.id_con}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.id_ayu}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.marca}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.modelo}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.color}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.capmax}"/>
                        </td>
                        <td>
                            <c:out value="${vehiculo.pasmax}"/>
                        </td>
                        <td>
                            <a href="SERVVehiculo?action=edit&id=<c:out value="${vehiculo.id}"/>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="SERVVehiculo?action=delete&id=<c:out value="${vehiculo.id}"/>" onclick="return confirm('¿Estás seguro que deseas eliminar el registro?')"  class="btn btn-danger btn-sm">Eliminar</a>
                        </td>                        
                    </tr>
                </c:forEach>                                    
            </table>                 
            </form>     
    </body>
</html>
