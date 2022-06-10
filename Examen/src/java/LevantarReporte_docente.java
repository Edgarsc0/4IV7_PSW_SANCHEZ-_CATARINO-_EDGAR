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
public class LevantarReporte_docente extends HttpServlet {

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
            out.println("<title>Servlet LevantarReporte_docente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Levantamiento de reporte</h1>");
            out.println("<form action='SubirReporte_docente' method='post'>");
            out.println("<label>Numero de serie: </label><input type='number' name='noSerie'><br>");
            out.println("<label>Laboratorio al que pertenece: </label><select name='lab'>"
                    + "<option value='1'>LBD</option>"
                    + "<option value='2'>LNT</option>"
                    + "<option value='3'>LDS</option>"
                    + "<option value='4'>4.0</option>"
                    + "</select><br>");
            out.println("<label>Falla: </label><select name='falla'>"
                    + "<option value='1'>Monitor</option>"
                    + "<option value='2'>Mouse</option>"
                    + "<option value='3'>CPU</option>"
                    + "<option value='4'>Teclado</option>"
                    + "<option value='5'>Camara</option>"
                    + "<option value='6'>Software</option>"
                    + "</select><br>");
            out.println("<label>Descripcion: </label><br>"
                    + "<textarea name='des'></textarea>");
            out.println("<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"
                    + "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'><br>"
                    + "<input type='submit' value='Subir reporte'>");
            out.println("</form>");
            out.println("<form method='post' action='principal'>"
                                + "<input type='submit' value='Regresar a principal'>"
                                + "<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"
                                + "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"
                                + "</form>");
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
