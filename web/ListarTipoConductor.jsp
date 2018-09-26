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
                <h1>Lista de Tipos de Conductores</h1>
                <hr>
                <a class="btn btn-success btn-lg" href="SERVTipoConductor?action=insert">Nuevo Registro</a>
                <a class="btn btn-info btn-lg" href="SERVTipoConductor?action=refresh">Actualizar Lista</a>
                <a class="btn btn-primary btn-lg" href="SERVConductor?action=refresh">Regresar a Lista de Conductores</a>                
                <a class="btn btn-primary btn-lg" href="Admin/admin.jsp">Regresar al menú</a>
                <br>
                <br>
            <form method="POST">
            <table class="table table-bordered" >
                <tr>
                    <th class="text-center">ID</th>                
                    <th class="text-center">TIPO</th>
                    <th class="text-center">ACCIONES</th>
                </tr>
                <c:forEach items="${tipoconductor}" var="tp">
                    <tr>
                        <td>
                            <c:out value="${tp.id}"/>
                        </td>
                        <td>
                            <c:out value="${tp.nom}"/>
                        </td>                        
                        <td>
                            <a href="SERVTipoConductor?action=edit&id=<c:out value="${tp.id}" />" class="btn btn-warning btn-sm">Editar</a>                         
                            <a href="SERVTipoConductor?action=delete&id=<c:out value="${tp.id}"/>" onclick="return confirm('¿Estás seguro que deseas eliminar el registro?')"  class="btn btn-danger btn-sm">Eliminar</a>                            
                        </td>
                    </tr>
                </c:forEach>                               
            </table>                 
            </form>
     
    </body>
</html>
