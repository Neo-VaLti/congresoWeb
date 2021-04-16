package acciones;

import utils.Validaciones;
import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosServicio.Fecha;
import objetosServicio.Periodo;
import objetosTransferencia.Lista;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class ObtenPonenciasPeriodo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        Validaciones validaciones = new Validaciones();

        // Si la variable boton recibida de capturaClave.jsp es igual a "Cancelar"
        if (request.getParameter("boton").equals("Cancelar")) {
            // Redirecciona a la página ponencias.jsp
            rd = request.getRequestDispatcher("ponencias.jsp");
        } else {
            // valida los datos de la ponencias
            Map<String, Mensaje> mensajes = validaciones.validaPeriodo(request);

            // Si la validación falla
            if (!mensajes.isEmpty()) {
                request.setAttribute("mensajes", mensajes);

                // Redirecciona a la pagina JSP capturaPeriodo.jsp
                rd = request.getRequestDispatcher("capturaPeriodo.jsp");
            } else {
                // En este bean de tipo Lista, se almacena la lista de
                // ponencias leídas de la tabla ponencias de la base de datos congreso
                Lista listaPonencias = new Lista();

                // Obten la tarea seleccionada del atributo tareaSel de la
                // variable session que es la que contiene a todas las variables con
                // ámbito de sesion
                HttpSession session = request.getSession();

                // Obten el periodo de la ponencias enviada por la página capturaPeriodo.jsp
                Periodo periodo = new Periodo(new Fecha(request.getParameter("desde")),
                        new Fecha(request.getParameter("hasta")));

                // Crea el objeto para acceder a la base de datos
                IPersistencia fachada = new PersistenciaBD();

                // Obtiene el vector con la lista de ponencias
                List lista = fachada.consultarPonencias(periodo);

                // Almacena la lista de canciones en el bean listaPonencias
                listaPonencias.setLista(lista);

                // Almacena el título de la tabla de ponencias en el bean
                // listaPonencias
                listaPonencias.setTituloTabla("Lista de las Ponencias del periodo " + periodo);

                request.setAttribute("listaPonencias", listaPonencias);

                rd = request.getRequestDispatcher("despliegaPonencias.jsp");
            }
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
