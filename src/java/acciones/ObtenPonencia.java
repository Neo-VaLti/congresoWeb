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
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class ObtenPonencia extends HttpServlet {

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
        String siguiente = "";
        //Validaciones validaciones = new Validaciones();

        // Si la variable boton recibida de capturaClave.jsp es igual a "Cancelar"
        if (request.getParameter("boton").equals("Cancelar")) {
            // Redirecciona a la página ponencias.jsp
            rd = request.getRequestDispatcher("ponencias.jsp");
        } else {

            // En este bean de tipo Ponencia, se almacenan los atributos de una
            //  ponencia leída de la tabla ponencias de la base de datos congreso.
            Ponencia ponencia = new Ponencia();

            // Obten la tarea seleccionada del atributo tareaSel de la
            // variable session que es la que contiene a todas las variables con
            // ámbito de sesion
            HttpSession session = request.getSession();

            // Obten la tarea seleccionada en index.jsp
            String tareaSel = (String) session.getAttribute("tareaSel");

            // Obten la clave de la ponencia enviada por la página capturaClave.jsp
            // o por la página seleccionaPonenciaActualizar.jsp
            String clave = (String) request.getParameter("clave");

            // Objeto para recibir la ponencia obtenida
            Ponencia ponenciaObtenida;

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Obtiene el vector con la lista de ponencias
            ponenciaObtenida = fachada.obten(new Ponencia(clave));

            // Si la ponencia existe en la base de datos
            if (ponenciaObtenida != null) {
                // Copia sus atributos al bean ponencia
                ponencia.setClave(ponenciaObtenida.getClave());
                ponencia.setTitulo(ponenciaObtenida.getTitulo());
                ponencia.setFecha(ponenciaObtenida.getFecha());
                ponencia.setHora(ponenciaObtenida.getHora());
                ponencia.setPonente(ponenciaObtenida.getPonente());
                ponencia.setEstado(ponenciaObtenida.getEstado());

                session.setAttribute("ponencia", ponencia);

                if (tareaSel.equals("AgregarPonencia")) {
                    siguiente = "despliegaPonencia.jsp";
                } else if (tareaSel.equals("ActualizarPonencia")) {
                    siguiente = "ObtenAlumnos";
                }
            } else {
                if (tareaSel.equals("AgregarPonencia")) {
                    siguiente = "ObtenAlumnos";
                }
            }
            rd = request.getRequestDispatcher(siguiente);
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
