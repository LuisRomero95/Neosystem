           
            function validacion() {
                
           var placa = document.getElementById("placa_id").value;                
           var conductor = document.getElementById("con_id").value;           
           var ayudante = document.getElementById("ayu_id").value;            
           var marca = document.getElementById("marca_id").value;                     
           var modelo = document.getElementById("modelo_id").value;
           var color = document.getElementById("color_id").value;
           var capacidad = document.getElementById("cap_id").value;
           var pasajeros = document.getElementById("pas_id").value;

              if( conductor == null || conductor.length == 0 || /^\s+$/.test(ruc_dni) ) {
                    alert('[ERROR] El identificador del conductor no puede quedar vacío.');
                    return false;
              }  
              else if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo ruc_dni debe tener un valor de...');
                return false;
              }
              else if (!(/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(email))) {
                // Si no se cumple la condicion...
                alert('[ERROR] Ingrese un email con formato adecuado');
                return false;
              }
              else if (!(/^\d{7}$/.test(fijo)) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo telefono fijo debe tener un valor de...');
                return false;
              }
              else if (!(/^\d{9}$/.test(celular)) ) {
                // Si no se cumple la condicion...
                alert('[ERROR] El telefono celular debe tener 9 digitos');
                return false;
              }      
              else if (direcion == null || direcion.length == 0 || /^\s+$/.test(direcion)) {
                // Si no se cumple la condicion...
                alert('[ERROR] El campo direccion debe tener un valor de...');
                return false;
              }              

              // Si el script ha llegado a este punto, todas las condiciones
              // se han cumplido, por lo que se devuelve el valor true
              return true;
            }         