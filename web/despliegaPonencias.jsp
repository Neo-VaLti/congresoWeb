<%-- 
    Document   : despliegaPonencias
    Created on : May 13, 2019, 12:26:50 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="objetosNegocio.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Despliega Ponencias</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <%-- Despliega los datos de todas las ponencias. Los datos
                 se encuentran en el bean listaPonencias guardados en
                 el objeto request por los servlets ObtenPonencias
                 ObtenPonenciasPonente u ObtenPonenciasPeriodo. --%>
            <table class="bicolor" >

                <%-- Título de la tabla --%>
                <caption>
                    ${listaPonencias.tituloTabla}
                </caption>

                <tr>
                    <%-- Títulos de las columnas --%>
                    <th>Clave</th>
                    <th>Título</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Ponente</th>
                    <th>Estado</th>
                </tr>

                <c:forEach items="${listaPonencias.lista}" var="ponencia"
                           varStatus="fila">
                    <tr>
                        <td>${ponencia.clave}</td>
                        <td>${ponencia.titulo}</td>
                        <td>${ponencia.fecha}</td>
                        <td>${ponencia.hora}</td>
                        <td>${ponencia.ponente}</td>
                        <td>${ponencia.estado}</td>
                    </tr>
                </c:forEach>
            </table>
        </main>
    </body>
</html>
