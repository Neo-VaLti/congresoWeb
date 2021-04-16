<%-- 
    Document   : index
    Created on : May 12, 2019, 4:06:22 PM
    Author     : OswaldoAbimael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Congreso Web: Pagina principal</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <script type="text/javascript" src="js/galeria.js"></script>
  <link rel="stylesheet" type="text/css" href="css/galeria.css" media="screen" /> 
   <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" /> 
    </head>
    <body onLoad="primera()">
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/encabezado.jspf"%>

        <%-- Incluye el menu ponencias --%>
        <%@include file="jspf/menuPpal.jspf"%>
<div id="Contenido">
  <div id="fotos">
			<img src="" id="uno" />
		</div>
		<div id="boton">
			<form action="" method="post" name="f1">
				<input class="boto1" type="button" name="bntAnterior" value="<<" onclick="anterior()" />
				<input class="boto2" type="button" name="bntSiguiente" value=">>" onclick="siguiente()"/>
			</form>
		</div>
	</div>

    </body>
</html>
