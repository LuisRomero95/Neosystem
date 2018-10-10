           
    function validacion() {                
        var placa = document.getElementById("placa_id").value;
        var conductor = document.getElementById("con_id").selectedIndex;    
        var ayudante = document.getElementById("ayu_id").selectedIndex;   
        var año = document.getElementById("añoSelecionado").value;
        var marca = document.getElementById("marcaSelecionado").value;
        var modelo = document.getElementById("modeloSelecionado").value;
        var serie = document.getElementById("serieSelecionada").value;
        var capacidad = document.getElementById("cap_id").value;
        var pasajeros = document.getElementById("pas_id").value;

        if( placa === null || placa.length === 0 || /^\s+$/.test(placa) ) {
              alert('[ERROR] La placa del vehículo no puede quedar vacío.');
              return false;
        }  
        else if ( conductor == null || conductor == 0 ){
          alert('[ERROR] Seleccione un conductor');
          return false;
        }      
        else if ( ayudante == null || ayudante == 0 ){
          alert('[ERROR] Seleccione un ayudante');
          return false;
        }      
        else if ( año === null || año.length === 0 || /^\s+$/.test(año)){
          alert('[ERROR] Seleccione año');
          return false;
        }      
        else if ( marca === null || marca.length === 0 || /^\s+$/.test(marca)){
          alert('[ERROR] Seleccione marca');
          return false;
        }              
        else if ( modelo === null || modelo.length === 0 || /^\s+$/.test(modelo)){
          alert('[ERROR] Seleccione modelo');
          return false;
        }  
        else if ( serie === null || serie.length === 0 || /^\s+$/.test(serie)){
          alert('[ERROR] Seleccione serie');
          return false;
        }   
        else if ( capacidad === null || capacidad.length === 0 || /^\s+$/.test(capacidad)){
          alert('[ERROR] Seleccione cantidad máxima de capacidad');
          return false;
        }  
        else if ( pasajeros === null || pasajeros.length === 0 || /^\s+$/.test(pasajeros)){
          alert('[ERROR] Seleccione cantidad máxima de pasajeros');
          return false;
        }          
        return true;        
    }    
    
    

