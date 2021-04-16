<%-- 
    Document   : capturaAlumno
    Created on : May 13, 2019, 12:55:55 AM
    Author     : OswaldoAbimael
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Captura alumno</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu alumno --%>
        <%@include file="jspf/menuAlumnos.jspf"%>

        <main>
            <h1>Captura Alumno</h1>

            <%-- Formulario para capturar los atributos de un alumno.
                 Los datos se envían al servlet agregaAlumno para
                 guardarlos en la BD --%>
            <form action="AgregarAlumno" method="post" name="capturaAlumno" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet agregaAlumno. --%>
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
                            <label for="nombreId" >Nombre *</label>
                        </td>
                        <td>
                            <input type="text" id="nombreId" name="nombre" 
                                   size="35" maxlength="35" required
                                   placeholder="Nombre del alumno" />
                        </td>

                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="emailId" >Email *</label>
                        </td>
                        <td>
                            <input type="email" id="emailId" name="email" 
                                   size="35" maxlength="35" required
                                   placeholder="Ingrese su email"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="derecha">
                            <label for="carreraId" >Carrera *</label>
                        </td>
                        <td>
                            <input type="text" id="carreraId" name="carrera" 
                                   size="20" maxlength="20" required
                                   placeholder="Ingresa tu carrera" />
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
