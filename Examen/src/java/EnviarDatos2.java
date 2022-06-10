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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
@WebServlet(urlPatterns = {"/EnviarDatos2"})
public class EnviarDatos2 extends HttpServlet {
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
            int noSerie=Integer.parseInt(request.getParameter("ns"));
            Calendar calendario = new GregorianCalendar();
            int hora, minutos;
            hora =calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dateYear = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH)+1;
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            int bol=Integer.parseInt(request.getParameter("bol"));
            int id_comp=Integer.parseInt(request.getParameter("select"));
            String descripcion=request.getParameter("des");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnviarDatos2</title>");
            out.println("<style>h1{ font-size:35px;color:#FFCB74;}*{background-color:#111111;color:white;font-family: monospace;text-align: center;}</style>");
            out.println("</head>");
            out.println("<body>");
            try{
                /*String q="insert into reporte 
                (dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) "
                + "values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"',
                '"+descripcion+"',"+noSerie+","+bol+","+id_comp+")";*/
                String q;
                switch(id_comp){
                    case 1:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",1)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                    case 2:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",2)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                    case 3:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",3)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                    case 4:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",4)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                    case 5:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",5)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                    case 6:
                        q="insert into reporte(dia,mes,anno,hora,descripcion,noSerie,usuario_reportante,id_componente) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+descripcion+"',"+noSerie+","+bol+",6)";                        
                        set.executeUpdate(q);
                        out.println("<h1>Se subio el reporte</h1>");
                        break;
                }
                //out.println("<h1>Se subio el reporte</h1>");
                out.println("<form method='post' action='principal'>"
                                + "<input type='submit' value='Regresar a principal'>"
                                + "<input type='hidden' name='usu' value='"+bol+"'>"
                                +"<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"
                                + "</form>");
            }catch(Exception e){
                out.println("<h1>No se logro subir el reporte</h1>");
                out.println("<h1>"+e.getMessage()+"</h1>");
                out.println("<h1>"+e.getStackTrace()+"</h1>");
            }
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
