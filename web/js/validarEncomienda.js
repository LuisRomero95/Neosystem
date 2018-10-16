$(document).ready(function (){
    
    $('#insertar').click(function (){      
        
  
        var cliente = $('#cli_id').val().trim();
        var usuario = $('#usuario_id').val().trim();
        var vehiculo = $('#vehiculo_id').val().trim();
        var precio = $('#precio_id').val().trim();
;
          
        if ( cliente === '' ){
          alert('[ERROR] Seleccione un cliente');
          return false;
        }     
        else if ( usuario === '' ){
          alert('[ERROR] Seleccione un usuario');
          return false;
        }        
        else if ( vehiculo === '' ){
          alert('[ERROR] Seleccione un vehiculo');
          return false;
        }    
        else if ( precio === '' ){
          alert('[ERROR] Seleccione un precio');
          return false;
        }            
          
     });
});      