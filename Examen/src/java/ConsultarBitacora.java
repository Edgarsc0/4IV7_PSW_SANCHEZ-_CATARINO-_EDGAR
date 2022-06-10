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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
@WebServlet(urlPatterns = {"/ConsultarBitacora"})
public class ConsultarBitacora extends HttpServlet {
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
            out.println("<title>Servlet ConsultarBitacora</title>");  
            out.println("<style>"
                                + "*{"
                                + "text-align:justify;"
                                + "}"
                                + ".btn{"
                                + "margin-top:10px;}"
                            + "*{"
                            + "background-color:#111111;\n" +
"                color:white;\n" +
"                font-family: monospace;\n" +
"                text-align: center;}"
                            + ".txt{"
                            + "width:100%;}"
                            + ".formato{"
                            + "display: grid;\n" +
"                place-items:center;}"
                            + "p{"
                            + "font-size: 35px;}"
                            + "table{"
                            + "font-size:25px;}"
                            + "h1{"
                            + "                font-size: 35px;\n" +
"                animation: espaciado 10s alternate infinite;\n" +
"                color:#FFCB74;}"
                            + ".table{border: 1px solid lightblue;}"
                            + "input,a{font-size:25px;}"
                            );
                    out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ConsultarBitacora at " + request.getContextPath() + "</h1>");
            out.println("<div class='table'>");
            out.println("<h1>Consulta de bitacora</h1>");
            out.println("<table border='1' align='center'>"
                    + "<tr>"
                    + "<th>ID Reporte</th>"
                    + "<th>Dia</th>"
                    + "<th>Mes</th>"
                    + "<th>Año</th>"
                    + "<th>Hora</th>"
                    + "<th>Descripcion</th>"
                    + "<th>Numero de serie</th>"
                    + "<th>Boleta reportante</th>"
                    + "<th>Falla</th></tr>");
            try{
                int id,dia,mes,año,boleta_r,ns,id_comp;
                String descripcion,hora;
                String q="select * from reporte;";
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    id=rs.getInt("id_reporte");
                    dia=rs.getInt("dia");
                    mes=rs.getInt("mes");
                    año=rs.getInt("anno");
                    boleta_r=rs.getInt("usuario_reportante");
                    ns=rs.getInt("noSerie");
                    hora=rs.getString("hora");
                    descripcion=rs.getString("descripcion");
                    id_comp=rs.getInt("id_componente");
                    /*out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>"+id_comp+"</td></tr>");*/
                    switch(id_comp){
                        case 1:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>MONITOR</td></tr>");
                            break;
                        case 2:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>MOUSE</td></tr>");
                            break;
                        case 3:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>CPU</td></tr>");
                            break;
                        case 4:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>TECLADO</td></tr>");
                            break;
                        case 5:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>CAMARA</td></tr>");
                            break;
                        case 6:
                            out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+dia+"</td>"
                            + "<td>"+mes+"</td>"
                            + "<td>"+año+"</td>"
                            + "<td>"+hora+"</td>"
                            + "<td>"+descripcion+"</td>"
                            + "<td>"+ns+"</td>"
                            + "<td>"+boleta_r+"</td>"
                            + "<td>SOFTWARE</td></tr>");
                            break;
                    }
                }
                out.println("</table>");
                out.println("</div>");
                
            }catch(Exception e){
                out.println("<h1>Error1</h1>");
                out.println("<h1>"+e.getMessage()+"</h1>");
            }
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
