package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.swing.text.Document;
import java.io.PrintWriter;
import java.sql.ResultSet;
import servlet.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("        <script></script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"font-family: arial;\">\n");
      out.write("        <h1 style=\"padding-left: 80px;\">ALUMNES</h1>\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("        <form action=\"index.jsp\">\n");
      out.write("            <select name=\"alumnos\" style=\"font-size: 25px; margin-left: 80px;\">\n");
      out.write("                <option value=\"0\">Selecciona un alumne per veure la seva informació</option>\n");
      out.write("                <option value=\"1\">Rafel Mateu</option>\n");
      out.write("                <option value=\"2\">Antoni Cifre</option>\n");
      out.write("                <option value=\"3\">Angel Martorell</option>\n");
      out.write("                <option value=\"4\">Dolores Pons</option>\n");
      out.write("                <option value=\"5\">Antonia Sanç</option>\n");
      out.write("                <option value=\"6\">Alberto Perez</option>\n");
      out.write("                <option value=\"7\">Jaume Frau</option>\n");
      out.write("                <option value=\"8\">Pere Pons</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"Enviar\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");
            Manejador m = new Manejador();
            PrintWriter pw = response.getWriter();
            String cod = request.getParameter("alumnos");
            ResultSet r = m.getAlumne(cod);
            while (r.next()) {
                pw.println("<h1>"+r.getString(1)+"</h1>");
            }
            r = m.getTutories(cod);
            pw.println("<h3>Tutories</h3>");
            while (r.next()) {
                pw.println(r.getString(1) + "<br/>");
            }
            pw.println("<h3>Asignatures</h3>");
            r = m.getAsignatures(cod);
            while (r.next()) {
                pw.println(r.getString(1) + "<br/>");
            }
        
      out.write(" \n");
      out.write("\n");
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
