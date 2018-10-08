<?php
require('conexion.php');
 
$colname_rs_user = "-1";
if (isset($_POST['username'])) {
  $colname_rs_user = $_POST['username'];
}
//mysql_select_db($database_conn, $conn);
$query_rs_user = sprintf("SELECT * FROM usuarios WHERE nom = '%s'",$colname_rs_user);
$rs_user = mysql_query($query_rs_user, $con) or die(mysql_error());
$row_rs_user = mysql_fetch_assoc($rs_user);
$totalRows_rs_user = mysql_num_rows($rs_user);
if($totalRows_rs_user == 0)
{
    echo '<div align="center" class="ok">Nombre de usuario disponible';
}
else{
    echo '<div align="center" class="error">Nombre de usuario Ocupado';
}


mysql_free_result($rs_user);
