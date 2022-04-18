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
import java.sql.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author esanc
 */
public class ConsultarAlumnos extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection con;
    private Statement set;
    private ResultSet rs;
    public void init(ServletConfig cfg)throws ServletException{
        String URL="jdbc:mysql:3306//localhost/alumnos";
        String userName="root";
        String password="n0m3l0";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            URL="jdbc:mysql://localhost/alumnos";
            con=DriverManager.getConnection(URL,userName, password);
            set=con.createStatement();
            System.out.println("Se concecto a la BD");
        }catch(Exception e){
            System.out.println("No se logro conectarse a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
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
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Lista alumnos batiz</title>");
                    out.println("<style>"
                            +"*{"
                                +"background-color:#121212;color:white;font-family:monospace;font-size:25px;text-align:center;"
                            + "}"
                            +"h1{"
                                +"color:white;background-color:#3700B3;font-size:40px;"
                            + "}"
                            +"input{"
                                +"border:1px solid white;border-radius:5px;margin-top:10px;"
                            + "}"
                            + "a{"
                                +"color:white;margin-top:10px;"
                            + "}");
                    out.println("</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Tabla de la lista de alumnos</h1>"
                                +"<table align='center' border=1>"
                                    +"<tr>"
                                        +"<th>Boleta</th>"
                                        +"<th>Nombre del alumno</th>"
                                        +"<th>Telefono</h1>"
                                    +"</tr>");
                    try{
                        int boleta;
                        String nombre, appat, apmat, telefono;
                        String q="select * from alumnobatiz";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            boleta=rs.getInt("boleta");
                            nombre=rs.getString("nombre");
                            appat=rs.getString("appat");
                            apmat=rs.getString("apmat");
                            telefono=rs.getString("telefono");
                            out.println("<tr>"
                                        +"<td>"+boleta+"</td>"
                                        +"<td>"+nombre+" "+appat+" "+apmat+"</td>"
                                        +"<td>"+telefono+"</td>"
                                      + "</tr>");
                        }
                        rs.close();
                        set.close();
                    }catch(Exception e){
                        System.out.println("Error al conectar a la tabla");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                    }
                    out.println("<a href=index.html>Regresar a principal</a>");
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
        }
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
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
}
