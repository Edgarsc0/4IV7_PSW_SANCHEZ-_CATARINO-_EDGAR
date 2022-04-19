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
@WebServlet(urlPatterns = {"/EnviarDatos3"})
public class EnviarDatos3 extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    public void init(ServletConfig cfg)throws ServletException{
        String URL="jdbc:mysql:3306//localhost/prueba7";
        String userName="root";
        String password="Hal02012()";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            URL="jdbc:mysql://localhost/prueba7";
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
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dateYear = calendar.get(Calendar.YEAR);
            int mes = calendar.get(Calendar.MONTH)+1;
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            int hora, minutos;
            hora =calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);
            /* TODO output your page here. You may use following sample code. */
            int bol=Integer.parseInt(request.getParameter("bolsol"));
            String asunto=request.getParameter("sol");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("*{\n" +
"                background-color:#111111;\n" +
"                color:white;\n" +
"                font-family: monospace;\n" +
"                text-align: center;\n" +
"            }"
                    + "h1{\n" +
"                color: #FFCB74;\n" +
"            } #er{font-size:35px;}");
            out.println("</style>");
            out.println("<title>Servlet EnviarDatos3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Asunto" +asunto+ "</h1>");
            String nombre;
            String appat;
            String apmat;
            out.println("<div id='er'>");
            out.println("<table align='center' id='tb' border='1'>"
                    + "<tr>"
                    + "<th>Nombre</th>"
                    + "<th>Boleta</th>"
                    + "</tr>");
            try{
                String q="select * from alumno where boleta="+bol;
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    nombre=rs.getString("nombre");
                    appat=rs.getString("appat");
                    apmat=rs.getString("apmat");
                    out.println("<tr>"
                            + "<td>"+nombre+" "+appat+" "+apmat+"</td>"
                                    + "<td>"+bol+"</td>");
                }
                try{
                    String newq="insert into solicitud(dia,mes,anno,hora,asunto,boleta_solicitante) values("+dia+","+mes+","+dateYear+",'"+hora+":"+minutos+"','"+asunto+"',"+bol+")";
                    set.executeUpdate(newq);
                    out.println("<h1>Se ha enviado la solicitud. Pronto un administrador lo atendera.</h1>");
                }catch(Exception e){
                    out.println("<h1>No se ha podido enviar la solicitud</h1>");
                    out.println("<h1>"+e.getMessage()+"</h1>");
                }
            }catch(Exception e){
                out.println("<h1>No se pudo obtener el reg</h1>");
                out.println("<h1>"+e.getMessage()+"</h1>");
            }
            out.println("<script>"
                    //s+"alert(document.getElementById('tb').rows.length);"
                    + "if(document.getElementById('tb').rows.length==1){"
                    + "document.getElementById('er').innerHTML='<h1>No tienes registro en nuestra base de datos. Llena el formulario primero para emitir una solicitud.</h1>';"
                    + "}");
            out.println("</script>");
            out.println("</div>");
            out.println("</table>");
            //out.println("<input type='button' onclick='contarRows()'>");
            out.println("<a href='index.html'>Regresar a principal</a>");
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
