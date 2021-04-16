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
import objetosNegocio.Alumno;
import objetosNegocio.Ponencia;
import objetosServicio.Fecha;
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class AgregarAlumno extends HttpServlet {

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
        // Si la variable boton recibida de capturaCveAlumno.jsp es igual a "Cancelar"
        if (request.getParameter("boton").equals("Cancelar")) {
            // Redirecciona a la página alumnos.jsp
            rd = request.getRequestDispatcher("alumnos.jsp");
        } else {
            // En este bean de tipo Alumno, se almacenan los atributos de un
            //  alumno enviada por la página capturaAlumno.jsp.
            Alumno alumno = new Alumno();

            // Obten la tarea seleccionada del atributo tareaSel de la
            // variable session que es la que contiene a todas las variables con
            // ámbito de sesion
            HttpSession session = request.getSession();

            // Copia sus atributos al bean alumno
            alumno.setClave((String) request.getParameter("clave"));
            alumno.setNombre((String) request.getParameter("nombre"));
            alumno.setEmail((String) request.getParameter("email"));
            alumno.setCarrera((String) request.getParameter("carrera"));

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

//            String clave = request.getParameter("clave");
//
//            alumno = fachada.obten(new Alumno(clave));

            // Agrega la nueva ponencia al catálogo
            fachada.agregar(alumno);

            // Guarda la opción seleccionada como el atributo tareaSel en la
            // variable sesión que es la que contiene a todas las variables con
            // ámbito de sesión
            session.setAttribute("tareaSel", "consultarAlumnos");

            rd = request.getRequestDispatcher("ObtenAlumnos");
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
