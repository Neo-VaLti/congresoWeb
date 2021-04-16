package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosTransferencia.Lista;
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class ObtenAlumnos extends HttpServlet {

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
        RequestDispatcher rd;
        String siguiente = null;

        // En este bean de tipo Lista, se almacena la lista de
        // alumnos leídas de la tabla alumnos de la base de datos congreso
        Lista consultarAlumnos = new Lista();

        // Obten la tarea seleccionada del atributo tareaSel de la
        // variable session que es la que contiene a todas las variables con
        // ámbito de sesion
        HttpSession session = request.getSession();

        // Obten la tarea seleccionada en index.jsp
        String tareaSel = (String) session.getAttribute("tareaSel");

        // Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene el vector con la lista de alumnos
        List lista = fachada.consultarAlumnos();

        // Almacena la lista de alumnos en el bean listaAlumnos
        consultarAlumnos.setLista(lista);

        // Almacena el título de la tabla de alumnos en el bean
        // listaAlumnos
        consultarAlumnos.setTituloTabla("Lista de todos los Alumnos");

        request.setAttribute("consultarAlumnos", consultarAlumnos);

        if (tareaSel.equals("AgregarAlumno")) {
            siguiente = "capturaAlumno.jsp";
        } else if (tareaSel.equals("AgregarPonencia")) {
            siguiente = "capturaPonencia.jsp";
        } else if (tareaSel.equals("ActualizarPonencia")) {
            siguiente = "editaPonencia.jsp";
        }else if(tareaSel.equals("listarPonenciasAlumno")){
            siguiente = "seleccionaPonente.jsp";
        }
        else {
            siguiente = "despliegaAlumnos.jsp";
        }

        rd = request.getRequestDispatcher(siguiente);
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
