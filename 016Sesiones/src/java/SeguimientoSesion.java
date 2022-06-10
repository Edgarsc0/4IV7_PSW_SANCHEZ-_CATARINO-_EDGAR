/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class SeguimientoSesion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesionCliente=request.getSession(true);
            String idSesion=sesionCliente.getId();
            long fechaCreacion=sesionCliente.getCreationTime();
            long fechaAcceso=sesionCliente.getLastAccessedTime();
            Integer cuenta=(Integer) sesionCliente.getAttribute("sesion.ss");
            if(cuenta==null){
                cuenta=new Integer(1);
            }else{
                cuenta=new Integer(cuenta.intValue()+1);
            }
            sesionCliente.setAttribute("sesion.ss",cuenta);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Has visitado esta pagina: "+cuenta+((cuenta.intValue()==1)?"Vez":"Veces")+"</h1>");
            out.println("<br><p>Datos de la sesion</p>"
                    + "<br><h2>Sesion: </h2>"+idSesion
                    + "<br><h2>Fue creada: </h2>");
            out.println(new Date(fechaCreacion).toString());
            out.println("<br><h2>Fue ultima vez que entro:</h2>");
            out.println(new Date(fechaAcceso).toString());
            out.println("<br>Atributos:<br>");
            Enumeration parametrosNombres=sesionCliente.getAttributeNames();
            while(parametrosNombres.hasMoreElements()){
                String parametros=(String)parametrosNombres.nextElement();
                Object valor=sesionCliente.getAttribute(parametros);
                out.println(parametros+" : "+valor.toString()+"<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
