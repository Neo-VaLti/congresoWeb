/* 
 * Esta funcion valida un periodo.
 */
var cancelar = false;

function validaPeriodo() {
    var errores=0;

    if (cancelar) {
        location.href="ponencias.jsp";
        return true;
    }
    else{
        // Ejecuta las validaciones en orden inverso para que el elemento
        //  con el enfoque sea el primero con error
        if(!validaFecha(document.forms.capturaPeriodo.hasta, 'msjHasta', true))   errores += 1;
        if(!validaFecha(document.forms.capturaPeriodo.desde, 'msjDesde', true))   errores += 1;

        return (errores==0);
    }
}


