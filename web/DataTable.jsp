<%-- 
    Document   : DataTable
    Created on : 03/10/2018, 02:31:32 AM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>  
        <script type="text/javascript">
            $(document).ready( function () {
                $('#tableUser').DataTable();
            } );            
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <table id="tableUser" class="display">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
            <script>         
                    require_once "procesos/seleccionar.php";                                              
            </script>

            </tbody>
        </table>
    </body>
</html>