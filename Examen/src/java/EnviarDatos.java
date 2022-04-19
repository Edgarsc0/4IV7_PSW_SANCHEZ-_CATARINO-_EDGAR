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
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/EnviarDatos"})
public class EnviarDatos extends HttpServlet {

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
            String nom,appat,apmat,grp;
            int bol;
            nom=request.getParameter("nom");
            appat=request.getParameter("appat");
            apmat=request.getParameter("apmat");
            bol=Integer.parseInt(request.getParameter("bol"));
            grp=request.getParameter("grp");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
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
);
                    out.println("</style>");
            out.println("<title>Servlet EnviarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet EnviarDatos at " + request.getContextPath() + "</h1>");
            try{
                String agregarAlumno="insert into alumno values ("+bol+",'"+nom+"','"+appat+"','"+apmat+"');";
                set.executeUpdate(agregarAlumno);
                out.println("<h1>Se registro el alumno</h1>");
                try{
                    String agregarGrupo="insert into grupo(grupo,boleta) values('"+grp+"',"+bol+");";
                    set.executeUpdate(agregarGrupo);
                    out.println("<h1>Se agrego el grupo</h1>");
                    try{
                        ArrayList <String> labs=new ArrayList<>();
                        ArrayList <Integer> noSerie=new ArrayList<>();
                        String q;
                        switch(grp.split("")[0]){
                            case "3": 
                                for(int i=0;i<3;i++){
                                    labs.add(request.getParameter("lab-"+i));
                                    noSerie.add(Integer.parseInt(request.getParameter("ns-"+i)));
                                }//out.println("<h1>"+noSerie+"</h1>");
                                for(int i=0;i<3;i++){
                                    switch(labs.get(i)){
                                        case "LBD":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",1)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LNV":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",2)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LDS":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",3)";
                                            set.executeUpdate(q);
                                            break;
                                        case "4.0":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",4)";
                                            set.executeUpdate(q);
                                            break;
                                    }
                                }
                                out.println("<h1>Se enviaron los numeros de serie</h1>");
                                break;
                            case "4":
                                for(int i=0;i<4;i++){
                                    labs.add(request.getParameter("lab-"+i));
                                    noSerie.add(Integer.parseInt(request.getParameter("ns-"+i)));
                                }//out.println("<h1>"+noSerie+"</h1>");
                                for(int i=0;i<4;i++){
                                    switch(labs.get(i)){
                                        case "LBD":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",1)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LNV":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",2)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LDS":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",3)";
                                            set.executeUpdate(q);
                                            break;
                                        case "4.0":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",4)";
                                            set.executeUpdate(q);
                                            break;
                                    }
                                }
                                out.println("<h1>Se enviaron los numeros de serie</h1>");
                                break;
                            case "5":
                                for(int i=0;i<5;i++){
                                    labs.add(request.getParameter("lab-"+i));
                                    noSerie.add(Integer.parseInt(request.getParameter("ns-"+i)));
                                }//out.println("<h1>"+noSerie+"</h1>");
                                for(int i=0;i<5;i++){
                                    switch(labs.get(i)){
                                        case "LBD":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",1)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LNV":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",2)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LDS":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",3)";
                                            set.executeUpdate(q);
                                            break;
                                        case "4.0":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",4)";
                                            set.executeUpdate(q);
                                            break;
                                    }
                                }
                                out.println("<h1>Se enviaron los numeros de serie</h1>");
                                break;
                            case "6":
                                for(int i=0;i<5;i++){
                                    labs.add(request.getParameter("lab-"+i));
                                    noSerie.add(Integer.parseInt(request.getParameter("ns-"+i)));
                                }//out.println("<h1>"+noSerie+"</h1>");
                                for(int i=0;i<5;i++){
                                    switch(labs.get(i)){
                                        case "LBD":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",1)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LNV":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",2)";
                                            set.executeUpdate(q);
                                            break;
                                        case "LDS":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",3)";
                                            set.executeUpdate(q);
                                            break;
                                        case "4.0":
                                            q="insert into computadora(noSerie,boleta,id_lab) values("+noSerie.get(i)+","+bol+",4)";
                                            set.executeUpdate(q);
                                            break;
                                    }
                                }
                                out.println("<h1>Se enviaron los numeros de serie</h1>");
                                break;
                        }
                        out.println("<a href='index.html'>Regresar a principal</a>");
                    }catch(Exception e){
                       out.println("<h1>Error al enviar los numeros de serie</h1>");
                       out.println("<h1>"+e.getMessage()+"</h1>");
                       out.println("<h1>"+e.getStackTrace()+"</h1>"); 
                    }
                }catch(Exception e){
                    out.println("<h1>Error al enviar el grupo</h1>");
                    out.println("<h1>"+e.getMessage()+"</h1>");
                    out.println("<h1>"+e.getStackTrace()+"</h1>");
                }
            }catch(Exception e){
                out.println("<h1>Error al enviar los datos del alumno</h1>");
                out.println("<h1>Es posible que hayas registrado una boleta que ya lleno el formulario</h1>");
                out.println("<a href='index.html'>Regresar a principal</a>");
                /*out.println("<h1>"+e.getMessage()+"</h1>");
                out.println("<h1>"+e.getStackTrace()+"</h1>");*/
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
