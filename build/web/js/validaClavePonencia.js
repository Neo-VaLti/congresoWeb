/* 
 * Valida la clave de una cancion
 */
var cancelar = false;

function validaClavePonencia() {
    var errores=0;

    if (cancelar) {
        location.href="ponencias.jsp";
        return true;
    }
    else{
        // Ejecuta las validaciones en orden inverso para que el elemento
        //  con el enfoque sea el primero con error
        if(!validaClave(document.forms.capturaClave.clave, 'msjClave'))
            errores += 1;

        return (errores==0);
    }
}


