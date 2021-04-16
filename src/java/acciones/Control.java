package acciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José/Oswaldo
 */
public class Control extends HttpServlet {

    /**
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Obtén de la solicitud, la tarea seleccionada del menú de canciones
        String tareaSel = request.getParameter("tarea");
        String siguiente = null;

        // Guarda la tarea seleccionada como el atributo tareaSel en la
        // variable session que es la que contiene a todas las variables con
        // ámbito de sesion
        HttpSession session = request.getSession();
        session.setAttribute("tareaSel", tareaSel);

        // establece la pagina JSP o servlet que inicia
        // el caso de uso seleccionado
        switch (tareaSel) {
            case "AgregarPonencia":
                siguiente = "capturaClave.jsp";
                break;
            case "ActualizarPonencia":
                siguiente = "ObtenPonencias";
                break;
            case "EliminarPonencias":
                siguiente = "ObtenPonencias";
                break;
            case "listaPonencias":
                siguiente = "ObtenPonencias";
                break;
            case "listarPonenciasAlumno":
                siguiente = "ObtenAlumnos";
                break;
            case "listarPonenciasEstado":
                siguiente = "ObtenPonencias";
                break;
            case "listarPonenciasPeriodo":
                siguiente = "ObtenPonencias";
                break;
            case "AgregarAlumno":
                siguiente = "capturaCveAlumno.jsp";
                break;
            case "consultarAlumnos":
                siguiente = "ObtenAlumnos";
                break;
            default:
                break;
        }

        // Redirecciona a la página JSP o servlet
        request.getRequestDispatcher(siguiente).forward(request, response);
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
