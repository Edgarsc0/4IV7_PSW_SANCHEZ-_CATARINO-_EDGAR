/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
public class ValidarLogin extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    public void init(ServletConfig cfg)throws ServletException{
        String URL="jdbc:mysql:3306//localhost/prueba10";
        String userName="root";
        String password="n0m3l0";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            URL="jdbc:mysql://localhost/prueba10";
            con=DriverManager.getConnection(URL,userName, password);
            set=con.createStatement();
            System.out.println("Se concecto a la BD");
        }catch(Exception e){
            System.out.println("No se logro conectarse a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
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
            out.println("<title>Servlet ValidarLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidarLogin at " + request.getContextPath() + "</h1>");
            String usuario=request.getParameter("usu");
            String password=request.getParameter("psw");
            try{
                String q="select count(*) from usuarios where usuario="+usuario;
                set=con.createStatement();
                rs=set.executeQuery(q);
                int cuenta=0;
                while(rs.next()){
                    cuenta=rs.getInt("count(*)");
                }
                String psw_sql="";
                int rol=0;
                String q2="select psw,rol from usuarios where usuario="+usuario;
                set=con.createStatement();
                rs=set.executeQuery(q2);
                while(rs.next()){
                    psw_sql=rs.getString("psw");
                    rol=rs.getInt("rol");
                }
                if(cuenta>0 && password.equals(psw_sql) && rol==3){
                    out.println("<form method='post' action='inicio_admin'>"
                        + "<input type='hidden' name='usu' value='"+usuario+"'>"
                        + "<input type='hidden' name='psw' value='"+password+"'>"
                        + "<input type='hidden' name='rol' value='"+rol+"'>"
                        + "<input type='submit' style='display:none;' id='sb'>"
                        + "</form>");
                    out.println("<script>"
                        + "document.getElementById('sb').click();"
                        + "</script>");
                }else{
                    if(cuenta>0 && password.equals(psw_sql)){
                        out.println("<form method='post' action='principal'>"
                            + "<input type='hidden' name='usu' value='"+usuario+"'>"
                            + "<input type='hidden' name='psw' value='"+password+"'>"
                            + "<input type='hidden' name='rol' value='"+rol+"'>"
                            + "<input type='submit' style='display:none;' id='sb'>"
                            + "</form>");
                        out.println("<script>"
                            + "document.getElementById('sb').click();"
                            + "</script>");
                    }else{
                        out.println("<script>");
                        out.println("alert('Login fallido');"
                            + "var enlace=document.createElement('A');"
                            + "enlace.setAttribute('href','index.html');"
                            + "enlace.click();"
                            + "</script>");
                    }
                }
            }catch(Exception e){
                
            }
            out.println("<h1>"+usuario+"</h1>");
            out.println("<h1>"+password+"</h1>");
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
