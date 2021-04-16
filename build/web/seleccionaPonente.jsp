<%-- 
    Document   : seleccionaPonente
    Created on : May 13, 2019, 1:15:28 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Selecciona ponente</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Consultar ponencias por ponente</h1>
            <%-- Formulario para capturar la ponencia de un alumno.
                 La clave del ponente se envia al servlet ObtenPonenciasPonente
                 para obtener la lista de ponencias de ese alumno de la BD --%>
            <form  action="ObtenPonenciasPonente" method="post">
                <table class="centrada">
                    <tr>
                        <td class="derecha">
                            Ponente *
                        </td>
                        <td>
                            <select name="cvePonente" required>
                                <option value="">Selecciona un ponente</option>
                                <%-- La lista de alumnos de ponencias se encuentran
                                     en el bean listaPonencias almacenado en el
                                     objeto session por el servlet ObtenPonenciasPonente. --%>
                                <c:forEach items="${consultarAlumnos.lista}"
                                           var="ponente" varStatus="opcion" >
                                    <option value="${ponente.clave}"  >
                                        ${ponente.nombre}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td id="msjAlumno">
                            &nbsp;
                        </td>
                    </tr>
                </table>
                <br />
                <table class="centrada">
                    <tr>
                        <%-- Botones enviar --%>
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
