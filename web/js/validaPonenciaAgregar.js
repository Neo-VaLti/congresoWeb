/* 
 * Valida los campos de una ponencia
 */
var cancelar = false;

function validaPonenciaAgregar() {
    var errores = 0;

    if (cancelar) {
        location.href = "ponencias.jsp";
        return true;
    } else {
        // Ejecuta las validaciones en orden inverso para que el elemento con el enfoque
        // sea el primero con error
        if (!validaFecha(document.forms.capturaPonencia.fecha, 'msjFecha', false))
            errores += 1;
        if (!validaEnteroMaxDigitos(2, document.forms.capturaPonencia.hora, 'msjHora', true))
            errores += 1;
        if (!validaCadena(35, document.forms.capturaPonencia.estado, 'msjEstado', true))
            errores += 1;
        if (!validaCadena(35, document.forms.capturaPonencia.ponente, 'msjPonente', true))
            errores += 1;
        if (!validaCadena(35, document.forms.capturaPonencia.titulo, 'msjTitulo', true))
            errores += 1;


        return (errores == 0);
    }
}


