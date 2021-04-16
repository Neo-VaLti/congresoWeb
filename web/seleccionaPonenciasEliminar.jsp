<%-- 
    Document   : seleccionaPonenciasEliminar
    Created on : May 13, 2019, 12:42:49 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Selecciona ponencias a eliminar</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <%-- Formulario para capturar las ponencias a eliminar.
                 Ls claves de las ponencias se envían al servlet
                 EliminarPonencias para eliminarlas de la BD --%>
            <form action="EliminarPonencias" method="post">
                <%-- Tabla donde se muestran los datos de todas las ponencias --%>
                <table class="bicolor">

                    <%-- Título de la tabla --%>
                    <caption><h1>Selecciona las ponencias a eliminar</h1></caption>

                    <%-- Títulos de las columnas --%>
                    <tr>
                        <th>&nbsp;</th>
                        <th>Clave</th>
                        <th>Título</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Ponente</th>
                        <th>Estado</th>
                    </tr>

                    <%-- Despliega los datos de todas las ponencias. Los datos
                         se encuentran en el bean listaPonencias guardados en
                         el objeto request por el servlet ObtenPonencias. --%>
                    <c:forEach items="${listaPonencias.lista}" var="ponencia"
                               varStatus="fila">
                        <%-- Inserta en cada celda de una fila de la tabla
                             uno de los atributos de la ponencia --%>
                        <tr>
                            <td><input type="checkbox" name="claves" value="${ponencia.clave}" ></td>
                            <td>${ponencia.clave}</td>
                            <td>${ponencia.titulo}</td>
                            <td>${ponencia.fecha}</td>
                            <td>${ponencia.hora}</td>
                            <td>${ponencia.ponente.nombre}</td>
                            <td>${ponencia.estado}</td>
                        </tr>
                    </c:forEach>
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
