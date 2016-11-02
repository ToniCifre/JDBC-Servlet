<%-- 
    Document   : index
    Created on : 26-oct-2016, 19:56:40
    Author     : tonix
--%>
<%@page import="javax.swing.text.Document"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script></script>
    </head>
    <body style="font-family: arial;">
        <h1 style="padding-left: 80px;">ALUMNES</h1>
        <br/>

        <form action="index.jsp">
            <select name="alumnos" style="font-size: 25px; margin-left: 80px;">
                <option value="0">Selecciona un alumne per veure la seva informació</option>
                <option value="1">Rafel Mateu</option>
                <option value="2">Antoni Cifre</option>
                <option value="3">Angel Martorell</option>
                <option value="4">Dolores Pons</option>
                <option value="5">Antonia Sanç</option>
                <option value="6">Alberto Perez</option>
                <option value="7">Jaume Frau</option>
                <option value="8">Pere Pons</option>
            </select>
            <input type="submit" value="Enviar"/>
        </form>

        <%            Manejador m = new Manejador();
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
        %> 

<%-- 
        <a href="hello">MyServlet Page</a>
--%>
    </body>
</html>
