<%-- 
    Document   : despliegaAlumno
    Created on : May 13, 2019, 1:10:59 AM
    Author     : OswaldoAbimael
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Despliega alumno</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu alumnos --%>
        <%@include file="jspf/menuAlumnos.jspf"%>

        <main>
            <h1>Alumno Existente</h1>

            <%-- Despliega los datos del alumno. Los datos se encuentran
                 en el bean alumno guardados en el objeto sesion por el
                 servlet ObtenAlumno. --%>
            <table class="centrada">
                <tr>
                    <td class="derecha">Clave</td>
                    <td class="gris">${alumno.clave}</td>
                <tr>
                    <td class="derecha">Nombre</td>
                    <td class="gris">${alumno.nombre}</td>
                </tr>
                <tr>
                    <td class="derecha">Email</td>
                    <td class="gris">${alumno.email}</td>
                </tr>
                <tr>
                    <td class="derecha">Carrera</td>
                    <td class="gris">${alumno.carrera}</td>
                </tr>
            </table>
        </main>
    </body>
</html>
