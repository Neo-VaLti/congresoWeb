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
import objetosNegocio.Alumno;
import objetosTransferencia.Lista;
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class ObtenPonenciasPonente extends HttpServlet {

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

        // En este bean de tipo Lista, se almacena la lista de alumnos de las
        // ponencias leídas de la tabla ponencias de la base de datos congreso
        Lista listaPonenciasPonente = new Lista();

        // Obten la tarea seleccionada del atributo tareaSel de la
        // variable session que es la que contiene a todas las variables con
        // ámbito de sesion
        HttpSession session = request.getSession();

        // Obten la tarea seleccionada en index.jsp
        String tareaSel = (String) session.getAttribute("tareaSel");

        // Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene el vector con la lista de ponencias
        String clave = request.getParameter("cvePonente");

        //ponencia = fachada.obten(new Ponencia(clave));
        Alumno alumno = fachada.obten(new Alumno(clave));
        List lista = fachada.consultarPonencias(alumno);

        // Almacena la lista de ponencias en el bean listaPonencias
        listaPonenciasPonente.setLista(lista);

        // Almacena el título de la tabla de canciones en el bean
        // listaPonencias
        listaPonenciasPonente.setTituloTabla("Lista de ponencias por ponente");

        session.setAttribute("listaPonencias", listaPonenciasPonente);

        if (tareaSel.equals("listarPonenciasAlumno")) {
            siguiente = "despliegaPonencias.jsp";
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
