<?php
  $usuario= $_REQUEST['usuario'];
  $db = new mysqli ("localhost","root","","bdmudanza4");
  $query = "SELECT nom FROM usuarios WHERE usuario='$usuario'";
  $db ->query($query);
  if($db->affected_rows==0){
      echo "Usuario disponible";
  }
  else{
      echo "Usuario no disponible";
  }