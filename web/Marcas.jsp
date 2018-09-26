<%-- 
    Document   : Marcas
    Created on : 17/09/2018, 09:06:28 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
        
$.ajax({
	url: "https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeId/440?format=json",
	type: "GET",
	dataType: "json",
	success: function(result)
	{
		console.log(result);
	},
	error: function(xhr, ajaxOptions, thrownError)
	{
		console.log(xhr.status);
		console.log(thrownError);
	}
});        
        
    </script>

%>    
    <body>
        <h1>Hello World!</h1>
        ID: <input type="text" name="txtId" >
        MARCA: <input type="text" name="txtMarca" >
    </body>
</html>
