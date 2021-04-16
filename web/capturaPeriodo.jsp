<%-- 
    Document   : capturaPeriodo
    Created on : May 13, 2019, 1:25:01 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Captura periodo</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Periodo de las ponencias a listar</h1>
            <%-- Formulario para capturar un periodo y enviarlo al servlet
                 obtenPonenciasPeriodo para obtener la lista de ponencias
                 de ese periodo de la BD --%>
            <form action="ObtenPonenciasPeriodo" method="post" name="capturaPeriodo" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet ObtenPonenciasPeriodo. --%>
                <table class="centrada">
                    <tr>
                        <td>
                            <label for="fechaDesdeId" >Fecha inicial (dd/mm/aaaa) *</label>                                
                        </td>
                        <td>
                            <input type="date" id="fechaDesdeId" name="desde"
                                   size="20" required />
                        </td>
                        <td id="msjDesde" class="${mensajes.desde.claseMensaje}">
                            ${mensajes.desde.mensaje}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="fechaHastaId" >Fecha final (dd/mm/aaaa) *</label>                                
                        </td>
                        <td>
                            <input type="date" id="fechaHastaId" name="hasta"
                                   size="20" required />
                        </td>
                        <td id="msjHasta" class="${mensajes.hasta.claseMensaje}">
                            ${mensajes.hasta.mensaje}
                        </td>
                    </tr>
                </table>
                <br />
                <table class="centrada" >
                    <tr>
                        <%-- Boton enviar --%>
                        <td>
                            <input type="submit" name="boton" value="Continuar" />
                        </td>
                        <%-- Boton limpiar --%>
                        <td>
                            <input type="reset" value="Limpiar" />
                        </td>
                    </tr>
                </table>
            </form>
        </main>
    </body>
</html>
