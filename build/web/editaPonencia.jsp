<%-- 
    Document   : editaPonencia
    Created on : May 12, 2019, 10:02:58 PM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Edita ponencia</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Edita Ponencia</h1>

            <%-- Formulario para modificar los atributos de una ponencia.
                 Los datos se envían al servlet ActualizarPonencia
                 para actualizar la ponencia en la BD --%>
            <form action="ActualizarPonencia" method="post" name="editaPonencia" >

                <%-- Despliega los datos de la ponencia para editarlos. Los datos
                     se encuentran en el bean ponencia guardados en el objeto
                     sesion por el servlet ObtenPonencia.
                     Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet ActualizarPonencia. --%>
                <table class="centrada">
                    <tr>
                        <td class="derecha">
                            <label for="claveId" >Clave</label>
                        </td>
                        <td>
                            <input type="text" id="claveId" name="clave" 
                                   size="35" readonly value="${ponencia.clave}" />
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="tituloId" >Titulo *</label>
                        </td>
                        <td>
                            <input type="text" id="tituloId" name="titulo" 
                                   value="${ponencia.titulo}" size="35" 
                                   maxlength="35" required  />
                        </td>
                        <td id="msjTitulo" class="${mensajes.titulo.claseMensaje}">
                            ${mensajes.titulo.mensaje}
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">Fecha</td>
                        <td>
                            <input name="fecha" size="10" value="${ponencia.fecha}"
                                   onchange="validaFecha(this, 'msjFecha', false);" /></td>
                        <td id="msjFecha" class="${mensajes.fecha.claseMensaje}">
                            ${mensajes.fecha.mensaje}
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">Hora</td>
                        <td>
                            <input name="hora" size="5" value="${ponencia.hora}"
                                   onchange="validaEnteroMaxDigitos(2, this, 'msjHora', true);" /></td>
                        <td id="msjHora" class="${mensajes.hora.claseMensaje}">
                            ${mensajes.hora.mensaje}
                        </td>
                    </tr>
                     <tr>
                        <td class="derecha">
                            Ponente *
                        </td>
                        <td>
                            <select name="cvePonente" required="">
                                <option value="">Selecciona un ponente</option>
                                <%-- La lista de alumnos ponentes se encuentran
                                     en el bean listaPonencias almacenado en el
                                     objeto session por el servlet ObtenAlumnos. --%>
                                <c:forEach items="${consultarAlumnos.lista}" var="ponente" 
                                           varStatus="opcion" >
                                    <c:choose>
                                        <c:when test="${ponencia.ponente.clave == ponente.clave}" >
                                            <option selected value="${ponente.clave}" >${ponente.nombre}</option>
                                        </c:when>
                                        <c:when test="${ponencia.ponente.clave != ponente.clave}" >
                                            <option value="${ponente.clave}" >${ponente.nombre}</option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td id="msjAlumno">&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="estadoId" >Estado *</label>
                        </td>
                        <td>
                            <input type="text" id="estadoId" name="estado" 
                                   value="${ponencia.estado}" size="35" 
                                   maxlength="35" required  />
                        </td>
                        <td id="msjEstado" class="${mensajes.estado.claseMensaje}">
                            ${mensajes.estado.mensaje}
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
