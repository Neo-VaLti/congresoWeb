package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import objetosTransferencia.Mensaje;

/**
 *
 * @author José/Oswaldo
 */
public class Validaciones {

    /**
     * Este método permite validar una clave de una ponencia del formulario de
     * la página capturaClave.jsp. La validacion se hace en el servlet
     * ObtenPonencia
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaClavePonencia(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<String, Mensaje>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String clave = request.getParameter("clave");

        // Si no hay clave
        if (valida.cadenaVacia(clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave", mensaje);
        } // Si la clave no es valida
        else if (!valida.validaClave(clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Clave no valida", "msjError");

            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave", mensaje);
        }
        return mensajes;
    }

    /**
     * Este método permite validar una ponencia de los formularios de las
     * páginas capturaCancion.jsp y editaPonencia.jsp. Las validaciones se hacen
     * en los servlets AgregaPonencia y actualizaPonencia, respectivamente.
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaPonencia(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<String, Mensaje>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String titulo = request.getParameter("titulo");

        // Si no hay titulo
        if (valida.cadenaVacia(titulo)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("titulo", mensaje);
        } // Si el titulo es muy largo
        else if (!valida.validaCadena(35, titulo)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("titulo", mensaje);
        }

        String fecha = request.getParameter("fecha");

        // Si hay fecha
        if (!valida.cadenaVacia(fecha)) {
            // Si la fecha no es valida
            if (!valida.validaFecha(fecha)) {
                // crea mensaje de error
                mensaje = new Mensaje("Error!: Fecha invalida", "msjError");
                // Agrega el mensaje de error a la lista de errores
                mensajes.put("fecha", mensaje);
            }
            return mensajes;
        }

        String hora = request.getParameter("hora");

        // Si no hay hora
        if (valida.cadenaVacia(hora)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("hora", mensaje);
        } // Si la duracion no es entero
        else if (!valida.validaEntero(hora)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: No es un entero", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("hora", mensaje);
        } // Si la duracion es muy larga
        else if (!valida.validaEnteroMaxDigitos(2, hora)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Entero muy grande", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("hora", mensaje);
        }

        String ponente = request.getParameter("ponente");

        // Si no hay ponente
        if (valida.cadenaVacia(ponente)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("ponente", mensaje);
        } // Si el interprete es muy largo
        else if (!valida.validaCadena(35, ponente)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("ponente", mensaje);
        }

        String estado = request.getParameter("estado");

        // Si hay estado
        if (!valida.cadenaVacia(estado)) {
            // Si la fecha no es valida
            if (!valida.validaFecha(estado)) {
                // crea mensaje de error
                mensaje = new Mensaje("Error!: Fecha invalida", "msjError");
                // Agrega el mensaje de error a la lista de errores
                mensajes.put("estado", mensaje);
            }
        }

        return mensajes;
    }

    /**
     * Este método permite validar una clave de una ponencia del formulario de
     * la página capturaClave.jsp. La validacion se hace en el servlet
     * ObtenPonencia
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaPeriodo(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<String, Mensaje>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String desde = request.getParameter("desde");

        // Si no hay fecha inicial
        if (valida.cadenaVacia(desde)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("desde", mensaje);
        } // Si la fecha no es valida
        else if (!valida.validaFecha(desde)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Fecha invalida", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("desde", mensaje);
        }

        String hasta = request.getParameter("hasta");

        // Si no hay fecha final
        if (valida.cadenaVacia(hasta)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("hasta", mensaje);
        } // Si la fecha no es valida
        else if (!valida.validaFecha(hasta)) {
            // crea mensaje de error
            mensaje = new Mensaje("!Error: Fecha invalida", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("hasta", mensaje);
        }
        return mensajes;
    }
}
