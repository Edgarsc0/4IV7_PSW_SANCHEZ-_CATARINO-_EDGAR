/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
public class inicio_admin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inicio_admin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inicio_admin at " + request.getContextPath() + "</h1>");
            out.println("<a href='index.html'>Cerrar sesion</a>");
            out.println("<h1>Dar de alta profesores</h1>");
            out.println("<form method='post' action='DarDeAltaP'>");
            out.println("<table>"
                    + "<tr>"
                    + "<td><label>Nombre</label></td>"
                    + "<td><input type='text' name='nombre'>"
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td><label>Appat</label></td>"
                    + "<td><input type='text' name='appat'>"
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td><label>Apmat</label>"
                    + "</td><td><input type='text' name='apmat'>"
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td><label>Numero de identifiacion</label></td>"
                    + "<td><input type='number' name='id'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td><label>Password</label></td>"
                    + "<td><input type='text' name='psw'></td>"
                    + "</tr>"
                    + "</table>");
            out.println("<input type='submit' value='Registrar Profesor'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
