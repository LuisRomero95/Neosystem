           
            function validacion() {
                
           var placa = document.getElementById("placa_id").value;                       

              if( placa === null || placa.length === 0 || /^\s+$/.test(placa) ) {
                    alert('[ERROR] La placa del vehículo no puede quedar vacío.');
                    return false;
              }  


         

              // Si el script ha llegado a este punto, todas las condiciones
              // se han cumplido, por lo que se devuelve el valor true
              return true;
            }         