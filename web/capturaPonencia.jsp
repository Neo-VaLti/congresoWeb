<%-- 
    Document   : capturaPonencia
    Created on : May 12, 2019, 9:32:30 PM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="objetosNegocio.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Captura ponencia</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencia --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Captura Ponencia</h1>

            <%-- Formulario para capturar los atributos de una ponencia.
                 Los datos se envían al servlet agregaPonencia para
                 guardarlos en la BD --%>
            <form action="AgregarPonencia" method="post" name="capturaPonencia" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet agregaPonencia. --%>
                <table class="centrada">
                    <tr>
                        <td class="derecha">
                            <label for="claveId" >Clave</label>
                        </td>
                        <td>
                            <input type="text" id="claveId" name="clave"
                                   size="7" readonly value="${param.clave}" />
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="tituloId" >Titulo *</label>
                        </td>
                        <td>
                            <input type="text" id="tituloId" name="titulo" 
                                   size="35" maxlength="35" required
                                   placeholder="T&iacute;tulo de la ponencia" />
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="fechaId" >Fecha</label>
                        </td>
                        <td>

                            <input type="text" id="fechaId" name="fecha" 
                                   size="10" title="Formato de Fecha DD/MM/AAAA" required
                                   pattern="^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$" /></td>

                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="HoraId">Hora *</label>
                        </td>
                        <td>
                            <input type="number" id="horaId" name="hora" 
                                   size="5" min="0" max="23"
                                   placeholder="Hora"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            Ponente *
                        </td>
                        <td>
                            <select name="cvePonente" required>
                                <option value="">Selecciona un ponente</option>
                                <%-- La lista de alumnos ponentes se encuentran
                                     en el bean listaPonentes almacenado en el
                                     objeto session por el servlet ObtenPonenciasPonente. --%>
                                <c:forEach items="${consultarAlumnos.lista}" var="alumno" varStatus="opcion" > 
                                    <option value="${alumno.clave}"  >
                                        ${alumno.nombre}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="estadoId" >Estado *</label>
                        </td>
                        <td>
                            <input type="text" id="estadoId" name="estado" 
                                   size="10" maxlength="10" required
                                   placeholder="Estado de la ponencia" />
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
