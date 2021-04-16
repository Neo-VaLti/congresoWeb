package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/jspf/encabezado.jspf");
    _jspx_dependants.add("/jspf/menuPpal.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Congreso Web: Pagina principal</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/galeria.js\"></script>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/galeria.css\" media=\"screen\" /> \n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"css/nav.css\" media=\"screen\" /> \n");
      out.write("    </head>\n");
      out.write("    <body onLoad=\"primera()\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <img alt=\"titulo\" src=\"IMG/titulo.PNG\" width=\"800\" height=\"150\">\n");
      out.write("</header>");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<nav>\n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"ponencias.jsp\">Registro de ponencias</a></li>\n");
      out.write("        <li><a href=\"alumnos.jsp\">Registro de alumnos</a></li>\n");
      out.write("    </ul>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("<div id=\"Contenido\">\n");
      out.write("  <div id=\"fotos\">\n");
      out.write("\t\t\t<img src=\"\" id=\"uno\" />\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"boton\">\n");
      out.write("\t\t\t<form action=\"\" method=\"post\" name=\"f1\">\n");
      out.write("\t\t\t\t<input class=\"boto1\" type=\"button\" name=\"bntAnterior\" value=\"<<\" onclick=\"anterior()\" />\n");
      out.write("\t\t\t\t<input class=\"boto2\" type=\"button\" name=\"bntSiguiente\" value=\">>\" onclick=\"siguiente()\"/>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
