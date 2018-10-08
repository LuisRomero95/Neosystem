
    function validacion() {

        var opciones = document.getElementsByName("optradio"); 
        var ruc_dni = document.getElementById("ruc_dni_id").value;
        var nombre = document.getElementById("nom_id").value;           
        var email = document.getElementById("email_id").value;            
        var fijo = document.getElementById("tel_fij_id").value;                     
        var celular = document.getElementById("tel_cel_id").value;
        var direcion = document.getElementById("direc_id").value;
        
        var seleccionado = false;
        for(var i=0; i<opciones.length; i++) {    
          if(opciones[i].checked) {
              
            seleccionado = true;     

            break;
          }
        }

        if(!seleccionado) {
          alert('[ERROR] Eliga entre RUC o DNI ');
          return false;
        }
        
        for(x = 0; x < opciones.length; x++){
            if(opciones[x].checked){
                if( opciones[x].value =='1' ){
                    if(  ruc_dni == null || ruc_dni.length == 0 || /^\s+$/.test(ruc_dni)  ){
                        alert('[ERROR] El RUC no puede quedar vacío ');
                                return false;
                    }             
                    else if(  !(ruc_dni.length == 11)|| /^\s+$/.test(ruc_dni) ){
                        alert('[ERROR] El RUC debe tener 11 digitos ');
                        return false;
                    }  
                }  
                else if( opciones[x].value =='2'){
                    if(  ruc_dni == null || ruc_dni.length == 0 || /^\s+$/.test(ruc_dni)  ){
                        alert('[ERROR] El DNI no puede quedar vacío ');
                        return false;
                    }             
                    else if(  !(ruc_dni.length == 8)|| /^\s+$/.test(ruc_dni) ){
                        alert('[ERROR] El DNI debe tener 8 digitos ');   
                                return false;
                    }  
                }                
            } 
        }
              
        if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
        alert('[ERROR] El nombre no puede quedar vacio');
        return false;
        }
        else if (!isNaN(nombre) || /^\s+$/.test(nombre) ) {
        alert('[ERROR] El nombre no puede tener números');
        return false;
        }
        else if(!(nombre.length <=50) || /^\s+$/.test(nombre)){
            alert('[ERROR] El nombre no puede exceder los 50 caracteres');
            return false;
        }        
        else if (email ==  null || email.length ==  0 || /^\s+$/.test(email) ) {
          // Si no se cumple la condicion...
          alert('[ERROR] El email no puede quedar vacío');
          return false;
        }               
        else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
        alert('[ERROR] Ingrese un email con formato adecuado');
        return false;
        }
        else if(!(email.length <=25) || /^\s+$/.test(email)){
            alert('[ERROR] El email no puede exceder los 50 caracteres');
            return false;
        }
        else if (fijo ==  null || fijo.length ==  0 || /^\s+$/.test(fijo) ) {
          alert('[ERROR] El teléfono fijo no puede quedar vacío');
          return false;
        }         
        else if (!(/^\d{7}$/.test(fijo)) ) {
        alert('[ERROR] El teléfono fijo tiene 7 digitos');
        return false;
        }
        else if (celular ==  null || celular.length ==  0 || /^\s+$/.test(celular) ) {
          alert('[ERROR] El teléfono celular no puede quedar vacío');
          return false;
        }           
        else if (!(/^\d{9}$/.test(celular)) ) {
        // Si no se cumple la condicion...
        alert('[ERROR] El telefono celular debe tener 9 digitos');
        return false;
        }      
        else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
        // Si no se cumple la condicion...
        alert('[ERROR] La dirección no puede quedar vacío');
        return false;
        }  
        else if (!(direcion.length <=50)|| /^\s+$/.test(direcion) ) {
        // Si no se cumple la condicion...
        alert('[ERROR] La dirección no puede tener más de 50 caracteres');
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
                
    function limpiaRuc_Dni() {
    var val = document.getElementById("ruc_dni_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(isNaN(val[i]))
                document.getElementById("ruc_dni_id").value = '';
        }
    }                 
    
    function limpiaNombre() {        
    var val = document.getElementById("nom_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(!isNaN(val[i]))
                document.getElementById("nom_id").value = '';
        }
    }    
    
    function limpiaTF() {
    var val = document.getElementById("tel_fij_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(isNaN(val[i]))
                document.getElementById("tel_fij_id").value = '';
        }
    }     

    function limpiaTC() {
    var val = document.getElementById("tel_cel_id").value;
    var tam = val.length;
        for(i = 0; i < tam; i++) {
            if(isNaN(val[i]))
                document.getElementById("tel_cel_id").value = '';
        }
    }  