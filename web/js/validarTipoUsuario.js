           
    function validacion() {
                
        var tipo = document.getElementById("nom_id").value;                          

        if( tipo == null || tipo.length == 0 || /^\s+$/.test(tipo) ) {
              alert('[ERROR] El tipo de usuario no puede quedar vacío.');
              return false;
        }
        if( !(tipo.length <=50) || /^\s+$/.test(tipo) ) {
              alert('[ERROR] El tipo de usuario debe tener máximo 6 dígitos.');
              return false;
        }           
        
          // Si el script ha llegado a este punto, todas las condiciones
          // se han cumplido, por lo que se devuelve el valor true
          return true;
        } 
        
    function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
    }
        
    function limpia() {
    var val = document.getElementById("nom_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(!isNaN(val[i]))
                document.getElementById("nom_id").value = '';
        }
    }