<?php
//Configuracion de la conexion a base de datos
$bd_host = "localhost";// definir host 
$bd_usuario = "root";  // definir usuario
$bd_password = ""; // definir password
$bd_base = "bdmudanza4";  // definir base de datos
$con = mysql_connect($bd_host, $bd_usuario, $bd_password); 
mysql_select_db($bd_base, $con); 

