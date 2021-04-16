/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import persistencia.PersistenciaBD;

/**
 *
 * @author José/Oswaldo
 */
public class ObtenAlumno extends HttpServlet {

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

        // Si la variable boton recibida de capturaCveAlumno.jsp es igual a "Cancelar"
        if (request.getParameter("boton").equals("Cancelar")) {
            // Redirecciona a la página alumnos.jsp
            rd = request.getRequestDispatcher("alumnos.jsp");
        } else {

            // En este bean de tipo Alumnos, se almacenan los atributos de un
            //  alumno leída de la tabla alumnos de la base de datos congreso.
            Alumno alumno = new Alumno();

            // Obten la tarea seleccionada del atributo tareaSel de la
            // variable session que es la que contiene a todas las variables con
            // ámbito de sesion
            HttpSession session = request.getSession();

            // Obten la tarea seleccionada en index.jsp
            String tareaSel = (String) session.getAttribute("tareaSel");

            // Obten la clave del alumno enviada por la página capturaCveAlumno.jsp
            String cvePonente = (String) request.getParameter("clave");

            // Objeto para recibir al alumno obtenido
            Alumno alumnoObtenido;

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Obtiene el vector con la lista de alumnos
            alumnoObtenido = fachada.obten(new Alumno(cvePonente));

            // Si el alumno existe en la base de datos
            if (alumnoObtenido != null) {
                // Copia sus atributos al bean alumno
                alumno.setClave(alumnoObtenido.getClave());
                alumno.setNombre(alumnoObtenido.getNombre());
                alumno.setEmail(alumnoObtenido.getEmail());
                alumno.setCarrera(alumnoObtenido.getCarrera());

                session.setAttribute("alumno", alumno);

                if (tareaSel.equals("AgregarAlumno")) {
                    siguiente = "despliegaAlumno.jsp";
                }
            } 
            else {
                if (tareaSel.equals("AgregarAlumno")) {
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
