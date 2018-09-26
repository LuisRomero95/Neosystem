           
    function validacion() {
                
        var nombre = document.getElementById("nom_id").value;                
        var contra = document.getElementById("contra_id").value;
        var email = document.getElementById("email_id").value;
        var indice = document.getElementById("select_id").selectedIndex;

        if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
              alert('[ERROR] El campo nombre no puede quedar vacío');
              return false;              
        }else if(!(nombre.length <=25) || /^\s+$/.test(nombre)){
            alert('[ERROR] El nombre no puede exceder los 25 dígitos');
            return false;
        }
        else if (contra ==  null || contra.length ==  0 || /^\s+$/.test(contra) ) {
          // Si no se cumple la condicion...
          alert('[ERROR] La contraseña no puede quedar vacío');
          return false;
        }
        else if ( !(contra.length <=20) || /^\s+$/.test(contra) ) {
          alert('[ERROR] La contraseña debe tener un valor máximo de 20 dígitos');
          return false;
        }
        else if (email ==  null || email.length ==  0 || /^\s+$/.test(email) ) {
          // Si no se cumple la condicion...
          alert('[ERROR] El email no puede quedar vacío');
          return false;
        }        
        else if ( !(email.length <=50) || /^\s+$/.test(email) ) {
          alert('[ERROR] El email debe tener un valor máximo de 50 dígitos');
          return false;
        }        
        else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
          alert('[ERROR] Ingrese un email con formato adecuado');
          return false;
        }
        else if ( indice == null || indice == 0 ){
          alert('[ERROR] Seleccione una opción');
          return false;
        }          
      
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