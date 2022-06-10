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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
public class EnviarDatos extends HttpServlet {
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
            out.println("<style>"
                            +"*{"
                                +"background-color:#121212;color:white;font-family:monospace;font-size:25px;text-align:center;"
                            + "}"
                            +"h1{"
                                +"color:white;background-color:#3700B3;font-size:40px;"
                            + "}"
                            + "a{"
                                +"color:white;margin-top:10px;"
                            + "}");
            out.println("</style>");
            out.println("<title>Servlet EnviarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            ArrayList <Integer> arrBol=new ArrayList<>();
            ArrayList <String> arrNom=new ArrayList<>();
            ArrayList <String> arrAp=new ArrayList<>();
            ArrayList <String> arrAm=new ArrayList<>();
            ArrayList <String> arrTel=new ArrayList<>();
            try{
                int currentBol;
                String currentNom, currentAp, currentAm, currentTel;
                String q="select * from alumnobatiz";
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    currentBol=rs.getInt("boleta");
                    currentNom=rs.getString("nombre");
                    currentAp=rs.getString("appat");
                    currentAm=rs.getString("apmat");
                    currentTel=rs.getString("telefono");
                    arrBol.add(currentBol);
                    arrNom.add(currentNom);                                        
                    arrAp.add(currentAp);
                    arrAm.add(currentAm);
                    arrTel.add(currentTel);
                }
                /*out.println("<h1>Se obtuvieron los datos</h1>");
                out.println("<h1>"+arrBol+"</h1>");
                out.println("<h1>"+arrNom+"</h1>");
                out.println("<h1>"+arrAp+"</h1>");
                out.println("<h1>"+arrAm+"</h1>");
                out.println("<h1>"+arrTel+"</h1>");*/
                try{
                    ArrayList <Integer> newarrBol=new ArrayList<>();
                    ArrayList <String> newarrNom=new ArrayList<>();
                    ArrayList <String> newarrAp=new ArrayList<>();
                    ArrayList <String> newarrAm=new ArrayList<>();
                    ArrayList <String> newarrTel=new ArrayList<>();
                    int noReg=arrBol.size();
                    int[] id=new int[1];
                    for(int i=0;i<noReg;i++){
                        newarrBol.add(Integer.parseInt(request.getParameter("bol-"+i)));
                        newarrNom.add(request.getParameter("nom-"+i));
                        newarrAp.add(request.getParameter("ap-"+i));
                        newarrAm.add(request.getParameter("am-"+i));
                        newarrTel.add(request.getParameter("tel-"+i));
                    }
                    /*out.println("<hr>");
                    out.println("<h1>"+newarrBol+"</h1>");
                    out.println("<h1>"+newarrNom+"</h1>");
                    out.println("<h1>"+newarrAp+"</h1>");
                    out.println("<h1>"+newarrAm+"</h1>");
                    out.println("<h1>"+newarrTel+"</h1>");*/
                    
                    for(int i=0;i<noReg;i++){
                        /*boolean g=arrNom.get(i).equals((String)newarrNom.get(i));
                        out.println("<h1>"+g+"</h1>");*/
                        if(arrBol.get(i)-newarrBol.get(i)==0 && arrNom.get(i).equals((String)newarrNom.get(i))
                                && arrAp.get(i).equals((String)newarrAp.get(i))
                                && arrAm.get(i).equals((String)newarrAm.get(i))
                                && arrTel.get(i).equals((String)newarrTel.get(i))){
                            id[0]=-4;
                        }else{
                            id[0]=i;
                            break;
                        }
                    }
                    int idb;
                    idb=id[0];
                    //out.println("<h1>"+idb+"</h1>");
                    int newBol;
                    String newNom,newAp,newAm,newTel;
                    newBol=Integer.parseInt(request.getParameter("bol-"+idb));
                    newNom=request.getParameter("nom-"+idb);
                    newAp=request.getParameter("ap-"+idb);
                    newAm=request.getParameter("am-"+idb);
                    newTel=request.getParameter("tel-"+idb);
                    String newq="update alumnobatiz set boleta="+newBol+", nombre='"+newNom+"', appat='"+newAp+"', apmat='"+newAm+"', telefono='"+newTel+"' where boleta="+arrBol.get(idb)+";";
                    set.executeUpdate(newq);
                    out.println("<h1>Se actuailizo el dato</h1>");
                    out.println("<h1></h1>");
                    out.println("<a href='ConsultarAlumnos'>Consultar alumnos</a>");
                    rs.close();
                    set.close();
                }catch(Exception e){
                    out.println("<h1>No Se actuailizo el dato</h1>");
                    out.println("<p>Es posible que hayas exedido el numero de caracteres permitidos para la boleta o el telefono."
                            + " O no hayas hecho ninguna modificacion."
                            + " Ten en cuenta que ambos permiten un maximo de 10 digitos</p>");
                    out.println("<a href='ConsultarAlumnos'>Consultar alumnos</a>");
                    /*out.println("<h1>"+e.getMessage()+"</h1>");
                    out.println("<h1>"+e.getStackTrace()+"</h1>");*/
                }
            }catch(Exception e){
                out.println("<h1>No Se obtuvieron los datos");
                out.println("<h1>"+e.getMessage()+"</h1>");
                out.println("<h1>"+e.getStackTrace()+"</h1>");
            }
            //out.println("<h1>Servlet EnviarDatos at " + request.getContextPath() + "</h1>");
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
