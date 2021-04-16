package acciones;

import dao.Conexion;
import utils.Validaciones;
import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Alumno;
import objetosNegocio.Ponencia;
import objetosServicio.Fecha;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import excepciones.*;
import java.sql.Connection;

/**
 *
 * @author José/Oswaldo
 */
public class ActualizarPonencia extends HttpServlet {

    public void actualizaPonencia1(Ponencia ponencia) throws PersistenciaException {

        Conexion conexion = null;
        try {
            conexion = new Conexion("jdbc:mysql://localhost/congreso", "root", "sesamo");
            Connection conn = conexion.getConexion();
            dao.Ponencias registroPonencias = new dao.Ponencias("Ponencias");
            registroPonencias.setConexion(conn);

            String sql = "";
            sql = sql + "UPDATE congreso.ponencias";
            sql = sql + " SET clave = '" + ponencia.getClave() + "'";
            sql = sql + ", titulo = '" + ponencia.getTitulo() + "'";
            sql = sql + ", fecha = '" + ponencia.getFecha().toDateString() + "'";
            sql = sql + ", hora = '" + ponencia.getHora() + "'";
            sql = sql + ", cvePonente = '" + ponencia.getPonente().getClave() + "'";
            sql = sql + ", estado = '" + ponencia.getEstado() + "'";
            sql = sql + " WHERE clave = '" + ponencia.getClave() + "';";

            registroPonencias.actualiza(sql);
        } catch (DAOException daoe) {
            throw new PersistenciaException("No se puede actualizar la ponencia", daoe);
        } finally {

            try {
                if (conexion != null) {
                    conexion.close();
                }

            } catch (DAOException daoe) {
                throw new PersistenciaException("No se puede actualizar la ponencia", daoe);
            }
        }
    }

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
            // valida los datos de la ponencia
            Map<String, Mensaje> mensajes = validaciones.validaPonencia(request);

            // Si la validación falla
            if (!mensajes.isEmpty()) {
                request.setAttribute("mensajes", mensajes);

                // Redirecciona a la pagina JSP editaPonencia.jsp
                rd = request.getRequestDispatcher("editaPonencia.jsp");
            } else {
                // En este bean de tipo Ponencia, se almacenan los atributos de una
                //  ponencia enviada por la página editaPonencia.jsp.
                Ponencia ponencia = new Ponencia();

                // Obten la tarea seleccionada del atributo tareaSel de la
                // variable session que es la que contiene a todas las variables con
                // ámbito de sesion
                HttpSession session = request.getSession();

                // Copia sus atributos al bean ponencia
                ponencia.setClave((String) request.getParameter("clave"));
                ponencia.setTitulo((String) request.getParameter("titulo"));
                ponencia.setFecha(new Fecha((String) request.getParameter("fecha")));
                ponencia.setHora(Integer.parseInt((String) request.getParameter("hora")));
                ponencia.setEstado((String) request.getParameter("estado"));

                // Crea el objeto para acceder a la base de datos
                IPersistencia fachada = new PersistenciaBD();

                String cvePonente = request.getParameter("cvePonente");

                Alumno alumno = fachada.obten(new Alumno(cvePonente));
                ponencia.setPonente(alumno);

                // Agrega la nueva ponencia al catálogo
                actualizaPonencia1(ponencia);

                // Guarda la opción seleccionada como el atributo tareaSel en la
                // variable sesión que es la que contiene a todas las variables con
                // ámbito de sesión
                session.setAttribute("tareaSel", "listaPonencias");

                rd = request.getRequestDispatcher("ObtenPonencias");
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
