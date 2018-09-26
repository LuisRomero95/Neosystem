function validacion() {
    // Expresion regular que representa un Email válido
    
    var nombre = document.getElementById("nom_id").value;
    cadena = "^[a-zA-Z][0-9]"; 
    re = new RegExp(cadena);

    if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
        alert('[ERROR] El tipo de conductor no puede quedar vacío');
        return false;              
    }else if(!(nombre.length <=2) || /^\s+$/.test(nombre)){
        alert('[ERROR] El tipo de conductor no puede exceder de los 2 dígitos');
        return false;
    }
    else if (!(document.getElementById("nom_id").value.match(re))){
        alert("Sólo se permite una letra seguido de un número");
        return false;
    } 
    return true
}