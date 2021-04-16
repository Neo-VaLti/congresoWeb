package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Ponencia;
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class EliminarPonencias extends HttpServlet {

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

        // Si la variable boton recibida de capturaClave.jsp es igual a "Cancelar"
        if (request.getParameter("boton").equals("Cancelar")) {
            // Redirecciona a la página ponencias.jsp
            rd = request.getRequestDispatcher("ponencias.jsp");
        } else {
            // Obten la tarea seleccionada del atributo tareaSel de la
            // variable session que es la que contiene a todas las variables con
            // ámbito de sesion
            HttpSession session = request.getSession();

            // Obten la lista de los indices de las ponencias a eliminar
            String claves[] = (String[]) request.getParameterValues("claves");

            // Obten el número de ponencias a eliminar
            int nPonencias = claves.length;

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            for (int i = 0; i < nPonencias; i++) {
                // Elimina la ponencia del catálogo
                fachada.eliminar(new Ponencia(claves[i]));
            }

            // Guarda la opción seleccionada como el atributo tareaSel en la
            // variable sesión que es la que contiene a todas las variables con
            // ámbito de sesión
            session.setAttribute("tareaSel", "listaPonencias");

            rd = request.getRequestDispatcher("ObtenPonencias");

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
