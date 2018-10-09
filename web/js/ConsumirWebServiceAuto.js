            function llamarMarca() {
                if(window.XMLHttpRequest){
                    xmlhttp = new XMLHttpRequest();
                }else{
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                xmlhttp.onreadystatechange = function (){
                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
                        if(xmlhttp.responseXML !== null){
                            ejecutarMarca(this);
                        }
                    }
                };
                xmlhttp.open("GET","https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=XML", true);
                xmlhttp.send();
            }
            function ejecutarMarca(xmlhttp){
                var resultado = document.getElementById("listarMarca");
                var xmlDoc = xmlhttp.responseXML;
                var marcas = "";
                var vehiculo = xmlDoc.getElementsByTagName("AllVehicleMakes");

                for(var i = 0; i < vehiculo.length; i++){                   
                    marcas += "<option>" +
                            vehiculo[i].getElementsByTagName("Make_Name")[0].childNodes[0].nodeValue +
                            "</option>";                    
                }
                resultado.innerHTML = marcas;
            }
            
            llamarMarca();
            function seleccionarMarca(){
                var e = document.getElementById("listarMarca");
                var marca = e.options[e.selectedIndex].text;                               
                document.getElementById("text1").value = marca;                
            } 
            
            document.getElementById("listarMarca").addEventListener("click", seleccionarAño);
            function seleccionarAño(){
                var e = document.getElementById("listarAño");
                var year = e.options[e.selectedIndex].text;                               
                document.getElementById("text2").value = year;                 
            }           
                
            document.getElementById("listarAño").addEventListener("click", llamarModelo);
            function llamarModelo() {
                var marca = document.getElementById("text1").value;
                var año = document.getElementById("text2").value;
                if(window.XMLHttpRequest){
                    xmlhttp = new XMLHttpRequest();
                }else{
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                xmlhttp.onreadystatechange = function (){
                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
                        if(xmlhttp.responseXML !== null){
                            ejecutarModelo(this);
                        }
                    }
                };
                xmlhttp.open("GET","https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/"+marca+"/modelyear/"+año+"?format=xml", true);
                xmlhttp.send();
            }
            function ejecutarModelo(xmlhttp){
                var resultado = document.getElementById("listarModelo");
                var xmlDoc = xmlhttp.responseXML;
                var marcas = "<option>--Seleccione Modelo</option>";
                var vehiculo = xmlDoc.getElementsByTagName("MakeModels");

                for(var i = 0; i < vehiculo.length; i++){                   
                    marcas += "<option>" +
                            vehiculo[i].getElementsByTagName("Model_Name")[0].childNodes[0].nodeValue +
                            "</option>";                    
                }
                resultado.innerHTML = marcas;
            }
            
            llamarModelo();
            function modeloSeleccionada(){
                var e = document.getElementById("listarModelo");
                var marca = e.options[e.selectedIndex].text;
                document.getElementById("text3").value = marca;
            }            
            