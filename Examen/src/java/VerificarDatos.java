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
@WebServlet(urlPatterns = {"/VerificarDatos"})
public class VerificarDatos extends HttpServlet {
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
            String nombre=request.getParameter("nombre");
            String appat=request.getParameter("appat");
            String apmat=request.getParameter("apmat");
            int boleta=Integer.parseInt(request.getParameter("bol"));
            String grupo=request.getParameter("grupo");
            ArrayList <String> noSerie=new ArrayList<>();
            ArrayList <String> lab=new ArrayList<>();
            ArrayList <Integer> asgopt=new ArrayList<>();
            switch(grupo.split("")[0]){
                case "3":
                    for(int i=0;i<3;i++){
                        if(request.getParameter("LBD-"+i)==""){ 
                        }else{noSerie.add(request.getParameter("LBD-"+i));lab.add("LBD");}
                        if(request.getParameter("LNV-"+i)==""){   
                        }else{noSerie.add(request.getParameter("LNV-"+i));lab.add("LNV");}
                        if(request.getParameter("LDS-"+i)==""){
                        }else{noSerie.add(request.getParameter("LDS-"+i));lab.add("LDS");}
                        if(request.getParameter("4.0-"+i)==""){
                        }else{noSerie.add(request.getParameter("4.0-"+i));lab.add("4.0");}
                    }
                    break;
                case "4":
                    for(int i=0;i<5;i++){
                        if(request.getParameter("LBD-"+i)==""&&
                           request.getParameter("LNV-"+i)==""&&
                           request.getParameter("LDS-"+i)==""&&
                           request.getParameter("4.0-"+i)==""){
                           asgopt.add(i);
                        }else{
                            if(request.getParameter("LBD-"+i)==""){ 
                            }else{noSerie.add(request.getParameter("LBD-"+i));lab.add("LBD");}
                            if(request.getParameter("LNV-"+i)==""){   
                            }else{noSerie.add(request.getParameter("LNV-"+i));lab.add("LNV");}
                            if(request.getParameter("LDS-"+i)==""){
                            }else{noSerie.add(request.getParameter("LDS-"+i));lab.add("LDS");}
                            if(request.getParameter("4.0-"+i)==""){
                            }else{noSerie.add(request.getParameter("4.0-"+i));lab.add("4.0");}
                        }
                    }
                    break;
                case "5":
                    for(int i=0;i<6;i++){
                        if(request.getParameter("LBD-"+i)==""&&
                           request.getParameter("LNV-"+i)==""&&
                           request.getParameter("LDS-"+i)==""&&
                           request.getParameter("4.0-"+i)==""){
                           asgopt.add(i);
                        }else{
                            if(request.getParameter("LBD-"+i)==""){ 
                            }else{noSerie.add(request.getParameter("LBD-"+i));lab.add("LBD");}
                            if(request.getParameter("LNV-"+i)==""){   
                            }else{noSerie.add(request.getParameter("LNV-"+i));lab.add("LNV");}
                            if(request.getParameter("LDS-"+i)==""){
                            }else{noSerie.add(request.getParameter("LDS-"+i));lab.add("LDS");}
                            if(request.getParameter("4.0-"+i)==""){
                            }else{noSerie.add(request.getParameter("4.0-"+i));lab.add("4.0");}
                        }
                    }
                    break;
                case "6":
                    for(int i=0;i<6;i++){
                        if(request.getParameter("LBD-"+i)==""&&
                           request.getParameter("LNV-"+i)==""&&
                           request.getParameter("LDS-"+i)==""&&
                           request.getParameter("4.0-"+i)==""){
                           asgopt.add(i);
                        }else{
                            if(request.getParameter("LBD-"+i)==""){ 
                            }else{noSerie.add(request.getParameter("LBD-"+i));lab.add("LBD");}
                            if(request.getParameter("LNV-"+i)==""){   
                            }else{noSerie.add(request.getParameter("LNV-"+i));lab.add("LNV");}
                            if(request.getParameter("LDS-"+i)==""){
                            }else{noSerie.add(request.getParameter("LDS-"+i));lab.add("LDS");}
                            if(request.getParameter("4.0-"+i)==""){
                            }else{noSerie.add(request.getParameter("4.0-"+i));lab.add("4.0");}
                        }
                    }
                    break;
            }
            String [] tercero={"Programacion Orientada a Objetos",
                "LAB. Proyectos de Tecnologias de la infor. I",
                "ADMON. Proyectos de Tecnologias de la infor. I"};
            String [] cuarto={"Programacion y Servicios Web",
                "Bases de Datos",
                "LAB. Proyectos de Tecnologias de la infor. II",
                "Tecnicas de Programacion con Calidad",
                "ADMON. Proyectos de Tecnologias de la infor. II"};
            String [] quinto={"Seguridad Web y Aplicaciones",
                "LAB. Proyectos de Tecnologias de la infor. III",
                "Introduccion a la Ingenieria de Pruebas",
                "Introduccion a los Sistemas Distribuidos",
                "Automatizacion de Pruebas",
                "Desarrollo Humano y Personal"};
            String [] sexto={"Metodos Agiles de Programacion",
                "LAB. Proyectos de Tecnologias de la infor. IV",
                "Soporte de Software",
                "Ingenieria de Software Basica",
                "Plan de negocios",
                "Proyecto Integrador"};
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerificarDatos</title>");
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
            out.println("<h1>A continuación: Verifica los datos. De ser necesario, editalos.</h1>");
            /*out.println("<h1>"+noSerie+"</h1>");
            out.println("<h1>"+lab+"</h1>");*/
            out.println("<div class='main'>");
                out.println("<form action='EnviarDatos' method='post'>");
                out.println("<input type='hidden' name='usu' value='"+boleta+"'>"
                                +"<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>");
                out.println("<div class='table'>");
                out.println("<table align='center'>"
                        + "<tr>"
                        + "<td><label>Nombre: </label></td>"
                        + "<td><input type='text' id='nom' name='nom' value='"+nombre+"' onkeypress='return validarString(event)'></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td><label>Apellido Paterno: </label></td>"
                        + "<td><input type='text' id='appat' name='appat' value='"+appat+"' onkeypress='return validarString(event)'></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td><label>Apellido Materno: </label></td>"
                        + "<td><input type='text' id='apmat' name='apmat' value='"+apmat+"' onkeypress='return validarString(event)'></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td><label>Boleta: </label></td>"
                        + "<td><input type='number' min='0' onmousedown='error()' readonly='readonly' id='bol' name='bol' max='9999999999' value='"+boleta+"' onkeypress='return validarInt(event)'></td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td><label>Grupo: </label></td>"
                        + "<td><input type='text' id='grp'  onmousedown='error()' readonly='readonly' name='grp' maxlength='5' value='"+grupo+"'></td>"
                        + "</tr>");
            switch(grupo.split("")[0]){
                case "3":
                    for(int i=0;i<noSerie.size();i++){
                        out.println("<tr><td><label>"+tercero[i]+"</label><input type='text' name='lab-"+i+"' value='"+lab.get(i)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-"+i+"' id='ns-"+i+"' value='"+noSerie.get(i)+"'></td></tr>");
                    }
                    break;
                case "4":
                    for(int i=0;i<noSerie.size()-1;i++){
                        out.println("<tr><td><label>"+cuarto[i]+"</label><input type='text' name='lab-"+i+"' value='"+lab.get(i)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-"+i+"' id='ns-"+i+"' value='"+noSerie.get(i)+"'></td></tr>");
                    }
                    //out.println("<h1>"+asgopt.get(0)+"</h1>");
                    //out.println("<h1>"+(sexto.length-1)+"</h1>");
                    if(asgopt.get(0)==cuarto.length-1){
                        out.println("<tr><td><label>"+cuarto[cuarto.length-2]+"</label><input type='text' name='lab-3' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-3' id='ns-3' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }else{
                        out.println("<tr><td><label>"+cuarto[cuarto.length-1]+"</label><input type='text' name='lab-3' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-3' id='ns-3' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }
                    break;
                case "5":
                    for(int i=0;i<noSerie.size()-1;i++){
                        out.println("<tr><td><label>"+quinto[i]+"</label><input type='text' name='lab-"+i+"' value='"+lab.get(i)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-"+i+"' id='ns-"+i+"' value='"+noSerie.get(i)+"'></td></tr>");
                    }
                    //out.println("<h1>"+asgopt.get(0)+"</h1>");
                    //out.println("<h1>"+(sexto.length-1)+"</h1>");
                    if(asgopt.get(0)==quinto.length-1){
                        out.println("<tr><td><label>"+quinto[quinto.length-2]+"</label><input type='text' name='lab-4' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-4' id='ns-4' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }else{
                        out.println("<tr><td><label>"+quinto[quinto.length-1]+"</label><input type='text' name='lab-4' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-4' id='ns-4' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }
                    break;
                case "6":
                    for(int i=0;i<noSerie.size()-1;i++){
                        out.println("<tr><td><label>"+sexto[i]+"</label><input type='text' name='lab-"+i+"' value='"+lab.get(i)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-"+i+"' id='ns-"+i+"' value='"+noSerie.get(i)+"'></td></tr>");
                    }
                    //out.println("<h1>"+asgopt.get(0)+"</h1>");
                    //out.println("<h1>"+(sexto.length-1)+"</h1>");
                    if(asgopt.get(0)==sexto.length-1){
                        out.println("<tr><td><label>"+sexto[sexto.length-2]+"</label><input type='text' name='lab-4' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-4' id='ns-4' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }else{
                        out.println("<tr><td><label>"+sexto[sexto.length-1]+"</label><input type='text' name='lab-4' value='"+lab.get(noSerie.size()-1)+"' readonly='readonly'></td><td><input onkeypress='return validarInt(event)' min='0' type='number' name='ns-4' is='ns-4' value='"+noSerie.get(noSerie.size()-1)+"'></td></tr>");
                    }
                    break;
                    //out.println("<h1>"+sexto[asgopt.get(0)]+"</h1>"); 
            }
            out.println("</table>"); 
            out.println("</div>");
            out.println("</div>");
            //out.println("<h1>Servlet VerificarDatos at " + request.getContextPath() + "</h1>");
            out.println("<script>");
            out.println("function cancelar(){"
                    + "location.reload();"
                    + "}");
            out.println("function validarString(e){");//inicio funcion validarStr
            out.println("var teclado=(document.all)?e.keyCode:e.which;");
            out.println("if(teclado==8){return true;}");
            out.println("var patron=/[ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz ]/;");
            out.println("var codigo=String.fromCharCode(teclado);");
            out.println("return patron.test(codigo);");
            out.println("}");//fin funcion validarStr
            out.println("function validarInt(e){");//inicio funcion validarInt
            out.println("var teclado=(document.all)?e.keyCode:e.which;");
            out.println("if(teclado==8){return true;}");
            out.println("var patron=/[0-9]/;");
            out.println("var codigo=String.fromCharCode(teclado);");
            out.println("return patron.test(codigo);");
            out.println("}");//fin funcion validarInt
            out.println("function error(){alert('No puedes editar este elemento. Si te equivocaste: Deberas reiniciar el proceso.');}");
            out.println("function validarCampos(){"
                    + "var abecedario=String.fromCharCode(...Array(123).keys()).slice(97).toUpperCase()+String.fromCharCode(...Array(123).keys()).slice(97)+'Ñ'+'ñ';"
                    + "var nom=document.getElementById('nom').value.split('');var valNom=[];"
                    + "var appat=document.getElementById('appat').value.split('');var valAp=[];"
                    + "var apmat=document.getElementById('apmat').value.split('');var valAm=[];"
                    + "for(i=0;i<nom.length;i++){"
                    + "if(abecedario.includes(nom[i])){"
                    + "valNom.push(true)}else{valNom.push(false)}}"
                    + "for(i=0;i<appat.length;i++){"
                    + "if(abecedario.includes(appat[i])){"
                    + "valAp.push(true)}else{valAp.push(false)}}"
                    + "for(i=0;i<apmat.length;i++){"
                    + "if(abecedario.includes(apmat[i])){"
                    + "valAm.push(true)}else{valAm.push(false)}}"
                    + "return valNom.includes(false)||valAp.includes(false)||valAm.includes(false)}");
            out.println("function validarSerie(){"
                    + "switch(document.getElementById('grp').value.split('')[0]){"
                    + "case '3':"
                    + "return document.getElementById('ns-0').value==''||document.getElementById('ns-1').value==''||document.getElementById('ns-2').value=='';"
                    + "break;"
                    + "case '4':"
                    + "return document.getElementById('ns-0').value==''||document.getElementById('ns-1').value==''||document.getElementById('ns-2').value==''||document.getElementById('ns-3').value=='';"
                    + "break;"
                    + "case '5':"
                    + "return document.getElementById('ns-0').value==''||document.getElementById('ns-1').value==''||document.getElementById('ns-2').value==''||document.getElementById('ns-3').value==''||document.getElementById('ns-4').value=='';"
                    + "break;"
                    + "case '6':"
                    + "return document.getElementById('ns-0').value==''||document.getElementById('ns-1').value==''||document.getElementById('ns-2').value==''||document.getElementById('ns-3').value==''||document.getElementById('ns-4').value=='';"
                    + "break;}}");
            out.println("function validarForm(e){"
                    + "if(validarCampos()==true||validarSerie()==true){"
                    + "e.preventDefault();alert('No se envio el formulario');}else{}}");
            out.println("</script>");
            out.println("<input type='submit' onclick='validarForm(event)' value='Enviar datos'><input type='button' onclick='cancelar()' value='Cancelar'>");
            out.println("</form>");
                                out.println("<form method='post' action='principal'>"
                                + "<input type='submit' value='Regresar a principal'>"
                                + "<input type='hidden' name='usu' value='"+boleta+"'>"
                                +"<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"
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
