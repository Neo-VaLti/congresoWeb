<%-- 
    Document   : error
    Created on : May 13, 2019, 1:39:27 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Pagina de error</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>
        
          <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu alumnos --%>
        <%@include file="jspf/menuAlumnos.jspf"%>

        <main>
            <h1>Página de Error</h1>
            <br />
            <table class="centrada">
                <tr>
                    <th class="error">Error:</th>
                    <td class="msjError">
                        ${pageContext.exception.message}
                    </td>
                </tr>
                <tr>
                    <th class="error">Causa:</th>
                    <td class="msjError">
                        ${pageContext.exception.cause.message}
                    </td>
                </tr>
            </table>
        </main>
    </body>
</html>
