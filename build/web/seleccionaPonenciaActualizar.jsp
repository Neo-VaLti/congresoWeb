<%-- 
    Document   : seleccionaPonenciaActualizar
    Created on : May 13, 2019, 12:33:33 AM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Selecciona cancion a actualizar</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <%-- Formulario para capturar una ponencia a actualizar.
                 La clave de la ponencia se envía al servlet ObtenPonencia para
                 obtener la ponencia de la BD --%>
            <form action="ObtenPonencia" method="post">
                <%-- Tabla donde se muestran los datos de todas las ponencias --%>
                <table class="bicolor">

                    <%-- Título de la tabla --%>
                    <caption>
                        <h1>Selecciona la ponencia a actualizar</h1>
                    </caption>

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
                            <td><input type="radio" name="clave" value="${ponencia.clave}" /></td>
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
