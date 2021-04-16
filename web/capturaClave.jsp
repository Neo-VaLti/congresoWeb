<%-- 
    Document   : capturaClave
    Created on : May 12, 2019, 9:29:02 PM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Captura clave ponencia</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>
        
        <main>
            
             <h1>Agrega una ponencia</h1>
            <%-- Formulario para capturar la clave de una ponencia.
                 La clave se envía al servlet ObtenPonencia para
                 obtener la ponencia de la BD --%>
            <form action="ObtenPonencia" method="post" name="capturaClave" >
                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet obtenPonencia. --%>
                <table class="centrada">
                    <tr>
                        <td><label for="claveId" >Clave *</label></td>
                        <td>
                            <input type="text" id="claveId" name="clave" 
                                   size="7" pattern="^[A-Z]{3}[0-9]{4}$" 
                                   title="Tres letras may&uacute;sculas seguidas de 4 d&iacute;gitos"
                                   placeholder="ABC1234" required />
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
                        <%-- Botón limpiar --%>
                        <td>
                            <input type="reset" value="Limpiar" />
                        </td>
                    </tr>
                </table>
            </form>
            
        </main>
    </body>
</html>
