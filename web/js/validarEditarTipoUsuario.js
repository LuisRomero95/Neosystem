
$(document).ready(function (){
    
    $('#nom_id').keypress(function (e) {
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = "áéíóúabcdefghijklmnñopqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false;
       for(var i in especiales){
            if(key === especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)===-1 && !tecla_especial){
            return false;
        }
    });
    
        //Limpia el input si ingresa digitos
    $( "#nom_id" ).blur(function() {
        var val = $('#nom_id').val();
        var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(!isNaN(val[i]))
                document.getElementById("nom_id").value = '';
        }
    });
    
    $("#nom_id").keyup(function() {
       $(this).val($(this).val().toLowerCase());
    });    
    
    $('#editar').click(function (){
        var nombre = $('#nom_id').val();
        var listanombre = $('#listaNombre').val();
        
        if( nombre === null || nombre.length === 0 || /^\s+$/.test(nombre) ) {
              alert('[ERROR] El tipo de usuario no puede quedar vacío.');
              return false;
        }
        else if( !(nombre.length <=50) || /^\s+$/.test(nombre) ) {
              alert('[ERROR] El tipo de usuario debe tener máximo 6 dígitos.');
              return false;
        }
        else if(nombre === listanombre){
            alert('[ERROR] El nuevo nombre no esta disponible');
            return false;
        }              
        
          // Si el script ha llegado a este punto, todas las condiciones
          // se han cumplido, por lo que se devuelve el valor true
          return true;
         
        
    });
    
});