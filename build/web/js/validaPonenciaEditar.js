/* 
 * Valida los campos de una cancion.
 */
var cancelar = false;

function validaPonenciaEditar() {
    var errores=0;

    if (cancelar) {
        location.href="ponencias.jsp";
        return true;
    }
    else {
        // Ejecuta las validaciones en orden inverso para que el elemento con el enfoque
        // sea el primero con error
        if(!validaFecha(document.forms.editaCancion.fecha, 'msjFecha', false))   errores += 1;
        if(!validaEnteroMaxDigitos(2, document.forms.editaCancion.hora, 'msjHora', true))   errores += 1;
        if(!validaCadena(35, document.forms.editaCancion.estado, 'msjEstado', true))   errores += 1;
        if(!validaCadena(35, document.forms.editaCancion.ponente, 'msjPonente', true))   errores += 1;
        if(!validaCadena(35, document.forms.editaCancion.titulo, 'msjTitulo', true))   errores += 1;

        return (errores==0);
    }
}


