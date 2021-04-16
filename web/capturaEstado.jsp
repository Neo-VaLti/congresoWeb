<%-- 
    Document   : capturaEstado
    Created on : May 13, 2019, 1:22:19 AM
    Author     : OswaldoAbimael
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Captura estado</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPonencias.jspf"%>

        <main>
            <h1>Lista de ponencias por estado</h1>
            <%-- Formulario para capturar un estado y enviarlo al servlet
                 obtenPonenciasEstado para obtener la lista de ponencias
                 de ese estado de la BD --%>
            <form action="ObtenPonenciaEstado" method="post" name="capturaEstado" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet ObtenPonenciasEstado. --%>
               <table class="centrada">
                    <tr>
                        <td class="derecha">
                            Estado *
                        </td>
                        <td>
                            <select name="estado" required>
                                <option value="">Selecciona un estado</option>
                                <%-- La lista de alumnos de ponencias se encuentran
                                     en el bean listaPonencias almacenado en el
                                     objeto session por el servlet ObtenPonenciasPonente. --%>
                                <c:forEach items="${listaPonencias.lista}"
                                           var="ponencia" varStatus="opcion" >
                                    <option value="${ponencia.estado}"  >
                                        ${ponencia.estado}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td id="msjEstado">
                            &nbsp;
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
