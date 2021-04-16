<%-- 
    Document   : despliegaPonencia
    Created on : May 12, 2019, 10:48:43 PM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Despliega ponencia</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Ponencia Existente</h1>

            <%-- Despliega los datos de la ponencia. Los datos se encuentran
                 en el bean cancion guardados en el objeto sesion por el
                 servlet ObtenPonencia. --%>
            <table class="centrada">
                <tr>
                    <td class="derecha">Clave</td>
                    <td class="gris">${ponencia.clave}</td>
                <tr>
                    <td class="derecha">Título</td>
                    <td class="gris">${ponencia.titulo}</td>
                </tr>
                <tr>
                    <td class="derecha">Fecha</td>
                    <td class="gris">${ponencia.fecha}</td>
                </tr>
                <tr>
                    <td class="derecha">Hora</td>
                    <td class="gris">${ponencia.hora}</td>
                </tr>
                <tr>
                    <td class="derecha">Ponente</td>
                    <td class="gris">${ponencia.ponente}</td>
                </tr>
                <tr>
                    <td class="derecha">Estado</td>
                    <td class="gris">${ponencia.estado}</td>
                </tr>
            </table>
        </main>
    </body>
</html>
