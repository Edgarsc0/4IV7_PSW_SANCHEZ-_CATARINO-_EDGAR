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
@WebServlet(urlPatterns = {"/LevantarReporte"})
public class LevantarReporte extends HttpServlet {
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LevantarReporte</title>");
            out.println("<style>"
                    + "textarea{"
                    + "resize: none;width:300px;"
                    + "}"
                    + "*{"
                    + "background-color:#111111;color:white;\n" +
"                font-family: monospace;\n" +
"                text-align: center;}"
                     + "table{"
                            + "font-size:25px;}"
                     + "p{"
                            + "font-size: 35px;}"
                            + "table{"
                            + "font-size:25px;}"
                     + ".table{border: 1px solid lightblue;}"
                            + "input,a,label,textarea{font-size:25px;}"
                    + "h1{"
                            + "                font-size: 35px;\n" +
"                animation: espaciado 10s alternate infinite;\n" +
"                color:#FFCB74;}"
                    + "");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form method='post' action='EnviarDatos2'>");
            //out.println("<h1>Servlet LevantarReporte at " + request.getContextPath() + "</h1>");
            int boleta=Integer.parseInt(request.getParameter("bol"));
            out.println("<div class='table'>");
            out.println("<table align='center' id='table'>"
                    + "<tr>"
                    + "<th>Numero de Serie</th>"
                    + "<th>Laboratorio</th>"
                    + "</tr>");
            try{
                out.println("<h1>Estas son las computadoras que registraste:</h1>");
                out.println("<p>Si la tabla esta vacia es posible que aun no"
                        + " hayas llenado el formulario de registro de computadoras o ingresaste"
                        + " erroneamente tu boleta: <input type='number' readonly='' name='bol' value='"+boleta+"'></p>");
                String lab;
                int noSerie;
                String q="select computadora.noSerie, laboratorio.nombre "
                        + "from computadora inner join laboratorio on "
                        + "computadora.id_lab=laboratorio.id_lab "
                        + "where boleta="+boleta;
                set=con.createStatement();
                rs=set.executeQuery(q);
                ArrayList <Integer> arrnoSerie=new ArrayList<>();
                int i=0;
                while(rs.next()){
                    lab=rs.getString("nombre");
                    noSerie=rs.getInt("noSerie");
                    if(arrnoSerie.contains(noSerie)){                        
                    }else{
                        arrnoSerie.add(noSerie);
                        out.println("<tr>"
                            + "<td><input type='number' id='ns-"+i+"'readonly='' value='"+noSerie+"'></td>"
                            + "<td>"+lab+"</td>"
                            + "<td><input type='button' onclick='mostrarForm(id)' id='"+i+"' value='Realizar reporte'></td>"
                            + "</tr>");
                    i++;}
                };
            }catch(Exception e){
                out.println("</h1>Error al acceder a la base de datos</h1>");
                out.println("<h1>"+e.getMessage()+"</h1>");
                out.println("<h1>"+e.getStackTrace()+"</h1>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("<div style='margin-top:10px' class='frm' id='frm'>"
                    + "</div>");
            out.println("</form>");
            out.println("<a href='index.html'>Regresar a principal</a>");
            out.println("<script>"
                    + "function error(){"
                    + "alert('Solo puedes realizar un reporte a la vez.');}"
                    + "function mostrarForm(id){"
                    + "var div=document.getElementById('frm');"
                    + "var label0=document.createElement('H3');"
                    + "var txtLabel0=document.createTextNode('Realizar reporte para: ');"
                    + "label0.appendChild(txtLabel0);"
                    + "var inpt=document.createElement('INPUT');"
                    + "inpt.setAttribute('readonly','');"
                    + "inpt.setAttribute('value',document.getElementById('ns-'+id).value);"
                    + "inpt.setAttribute('type','text');"
                    + "inpt.setAttribute('name','ns');"
                    + "div.appendChild(label0);"
                    + "div.appendChild(inpt);"
                    + "var br4=document.createElement('BR');"
                    + "div.appendChild(br4);"
                    + "globalThis.numeroReg=document.getElementById('table').rows.length-1;"
                    + "for(i=0;i<numeroReg;i++){"
                    + "document.getElementById(i).setAttribute('onclick','error()');}"
                    + "var label1=document.createElement('LABEL');"
                    + "var txtLabel1=document.createTextNode('Selecciona la falla que presenta el equipo: ');"
                    + "label1.appendChild(txtLabel1);"
                    + "div.appendChild(label1);"
                    + "var s=document.createElement('SELECT');"
                    + "s.setAttribute('name','select');"
                    + "s.innerHTML='<option value=1>Monitor</option>"
                    + "<option value=2>Mouse</option>"
                    + "<option value=3>CPU</option>"
                    + "<option value=4>Teclado</option>"
                    + "<option value=5>Camara</option>"
                    + "<option value=6>Software</option>';"
                    + "div.appendChild(s);"
                    + "var br=document.createElement('BR');"
                    + "div.appendChild(br);"
                    + "var label2=document.createElement('LABEL');"
                    + "var txtLabel2=document.createTextNode('Describe el problema, ten en cuenta que solo se permiten 150 caracteres : ');"
                    + "label2.appendChild(txtLabel2);"
                    + "div.appendChild(label2);"
                    + "var br2=document.createElement('BR');"
                    + "div.appendChild(br2);"
                    + "var txta=document.createElement('TEXTAREA');"
                    + "txta.setAttribute('name','des');"
                    + "txta.setAttribute('id','des');"
                    + "div.appendChild(txta);"
                    + "var br3=document.createElement('BR');"
                    + "div.appendChild(br3);"
                    + "var btnEnviar=document.createElement('INPUT');"
                    + "btnEnviar.setAttribute('type','submit');"
                    + "btnEnviar.setAttribute('value','Enviar');"
                    + "btnEnviar.setAttribute('onclick','validarDescripcion(event)');"
                    + "div.appendChild(btnEnviar);"
                    + "var btnCancelar=document.createElement('INPUT');"
                    + "btnCancelar.setAttribute('type','button');"
                    + "btnCancelar.setAttribute('onclick','cancelar()');"
                    + "btnCancelar.setAttribute('value','Cancelar');"
                    + "div.appendChild(btnCancelar);"
                    + "}"
                    + "function cancelar(){"
                    + "document.getElementById('frm').innerHTML='';"
                    + "for(i=0;i<numeroReg;i++){"
                    + "document.getElementById(i).setAttribute('onclick','mostrarForm(id)');}"
                    + "}"
                    + "function validarDescripcion(e){"
                    + "if(document.getElementById('des').value==''){"
                    + "e.preventDefault();alert('Hace falta agregar una descripcion');}else{}}");
            out.println("</script>");
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
