<%-- 
    Document   : despliegaAlumno
    Created on : May 13, 2019, 1:11:59 AM
    Author     : OswaldoAbimael
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="objetosNegocio.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Despliega alumnos</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu alumnos --%>
        <%@include file="jspf/menuAlumnos.jspf"%>

        <main>
            <%-- Despliega los datos de todos los alumnos. Los datos
                 se encuentran en el bean listaAlumnos guardados en
                 el objeto request por los servlets obtenAlumnos --%>
            <table class="bicolor" >

                <%-- Título de la tabla --%>
                <caption>
                    ${listaAlumnos.tituloTabla}
                </caption>

                <tr>
                    <%-- Títulos de las columnas --%>
                    <th>Clave</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Carrera</th>
                </tr>

                <c:forEach items="${consultarAlumnos.lista}" var="alumno" varStatus="fila">
                    <tr>
                        <td>${alumno.clave}</td>
                        <td>${alumno.nombre}</td>
                        <td>${alumno.email}</td>
                        <td>${alumno.carrera}</td>
                    </tr>
                </c:forEach>
            </table>
        </main>
    </body>
</html>
