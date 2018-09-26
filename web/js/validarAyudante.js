
    function validacion() {

        var dni = document.getElementById("dni_id").value;   
        var nombre = document.getElementById("nom_id").value;           
        var ape = document.getElementById("ape_id").value;
        var email = document.getElementById("email_id").value;            
        var celular = document.getElementById("tel_id").value;                     
        var direcion = document.getElementById("direc_id").value;
        
        if( dni == null || dni.length == 0 || /^\s+$/.test(dni) ) {
            alert('[ERROR] El dni no puede quedar vacio.');
            return false;
        }
        else if(  !(dni.length == 8) || /^\s+$/.test(dni) ) {
            alert('[ERROR] El dni debe tener un valor máximo de 8 dígitos.');
            return false;
        }                       
        else if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
        alert('[ERROR] El nombre no puede quedar vacio');
        return false;
        }
        else if (!isNaN(nombre) || /^\s+$/.test(nombre) ) {
        alert('[ERROR] El nombre no puede tener números');
        return false;
        }
        else if (ape == null || ape.length == 0 || /^\s+$/.test(ape) ) {
        alert('[ERROR] El apellido no puede quedar vacio');
        return false;
        }
        else if (!isNaN(ape) || /^\s+$/.test(ape) ) {
        alert('[ERROR] El apellido no puede tener números');
        return false;
        }       
        else if (email ==  null || email.length ==  0 || /^\s+$/.test(email) ) {
          // Si no se cumple la condicion...
          alert('[ERROR] El email no puede quedar vacío');
          return false;
        }               
        else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
        // Si no se cumple la condicion...
        alert('[ERROR] Ingrese un email con formato adecuado');
        return false;
        }
        else if (!(/^\d{9}$/.test(celular)) ) {
        // Si no se cumple la condicion...
        alert('[ERROR] El celular debe tener 9 digitos');
        return false;
        }      
        else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
        // Si no se cumple la condicion...
        alert('[ERROR] El campo direccion no puede quedar vacío');
        return false;
        }  
        else if (!(direcion.length <=50)|| /^\s+$/.test(direcion) ) {
        // Si no se cumple la condicion...
        alert('[ERROR] La dirección no puede tener más de 50 dígitos');
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
    

    function soloNumeros(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = "0123456789";
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
                
    function limpiaDni() {
    var val = document.getElementById("dni_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(isNaN(val[i]))
                document.getElementById("dni_id").value = '';
        }
    }                  

    function limpiaTC() {
    var val = document.getElementById("tel_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(isNaN(val[i]))
                document.getElementById("tel_id").value = '';
        }
    }  