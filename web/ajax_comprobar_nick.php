<?php   
// Que no se nos olvide incluir nuestro fichero con la conexion a la base de datos.  
include("conexion.php");  
$nick=$_REQUEST['txtNombre'];  
$sql="SELECT nom FROM usuarios WHERE nom='$nick'";  
$res=mysql_query($sql);  
$total=mysql_num_rows($res);  
if($total >0)  
{   

  echo "Este nick está ocupado";  
}  
else  
{  

  echo "Nick libre";  
}  
