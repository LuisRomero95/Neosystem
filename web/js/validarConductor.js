          
    function validacion() {
                               
        var dni = document.getElementById("dni_id").value;
        var licencia = document.getElementById("lic_id").value;
        var nombre = document.getElementById("nom_id").value;             
        var apellido = document.getElementById("ape_id").value; 
        var email = document.getElementById("email_id").value; 
        var telefono = document.getElementById("tel_id").value; 
        var direcion = document.getElementById("direc_id").value;
        var indice = document.getElementById("select_id").selectedIndex;
        

        if( dni == null || dni.length == 0 || /^\s+$/.test(dni) ) {
              alert('[ERROR] El dni no puede quedar vacio.');
              return false;
        }
        else if(  !(dni.length == 8) || /^\s+$/.test(dni) ) {
              alert('[ERROR] El dni debe tener un valor máximo de 8 dígitos.');
              return false;
        }         
        else if( licencia == null || licencia.length == 0 || /^\s+$/.test(licencia) ) {
              alert('[ERROR] La licencia no puede quedar vacío.');
              return false;              
        }          
        else if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
              alert('[ERROR] El nombre no puede quedar vacío.');
              return false;              
        }
        else if(!(nombre.length <=25) || /^\s+$/.test(nombre)){
            alert('[ERROR] El nombre no puede exceder los 25 dígitos.');
            return false;
        }   
        else if (!isNaN(nombre) || /^\s+$/.test(nombre) ) {
            alert('[ERROR] El nombre no puede tener números');
            return false;
        }        
        else if (apellido == null || apellido.length == 0 || /^\s+$/.test(apellido) ) {
          alert('[ERROR] El apellido no puede quedar vacio.');
          return false;
        }
        else if (!(apellido.length <=60) || /^\s+$/.test(apellido) ) {
          alert('[ERROR] El apellido debe tener un valor máximo de 60 dígitos.');
          return false;
        } 
        else if (!isNaN(apellido) || /^\s+$/.test(apellido) ) {
        alert('[ERROR] El apellido no puede tener números');
        return false;
        }             
        else if (email == null || email.length == 0 || /^\s+$/.test(email) ) {
          alert('[ERROR] El email no puede quedar vacio.');
          return false;
        }        
        else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
          alert('[ERROR] Ingrese un email con formato adecuado');
          return false;
        }
        else if (telefono == null || telefono.length == 0 || /^\s+$/.test(telefono) ) {
          alert('[ERROR] El telefono no puede quedar vacio.');
          return false;
        }        
        else if (!(/^\d{9}$/.test(telefono)) ) {
          alert('[ERROR] El telefono celular debe tener 9 digitos');
          return false;
        }            
        else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
          alert('[ERROR] La direccion no puede quedar vacia.');
          return false;
        }
        else if (!(direcion.length <=100) || /^\s+$/.test(direcion)) {
          alert('[ERROR] La direccion debe tener un valor de máximo de 100 dígitos');
          return false;
        }
        else if ( indice == null || indice == 0 ){
          alert('[ERROR] Seleccione una opcion');
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