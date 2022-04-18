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
public class ModificarAlumno extends HttpServlet {

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
        String password="Hal02012()";
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
                    out.println("<title>Lista alumnos batiz</title>");       
                    
                    //INICIO CSS
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
                            + ".table{"
                                +"border: 1px solid #00A8CC;"
                            + "}"
                            + "a{"
                                +"color:white;margin-top:10px;"
                            + "}");
                    out.println("</style>");
                    //FIN CSS
                    
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Lista de alumnos</h1>"
                                +"<div class='table'>"
                                +"<table align='center' id='maintable'>"//style='empty-cells: hide;'
                                    +"<tr>"
                                        +"<th>Boleta</th>"
                                        +"<th>Nombre del alumno</th>"
                                        +"<th>Apellido paterno</th>"
                                        +"<th>Apellido materno"
                                        +"<th>Telefono</h1>"
                                        +"<th></th>"
                                    +"</tr>");
                    try{
                        int boleta,i=0;
                        String nombre, appat, apmat, telefono;
                        String q="select * from alumnobatiz";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        out.println("<form name='eliminar' method='post' action='EnviarDatos'>");//inicio form
                        
                        while(rs.next()){
                            boleta=rs.getInt("boleta");
                            nombre=rs.getString("nombre");
                            appat=rs.getString("appat");
                            apmat=rs.getString("apmat");
                            telefono=rs.getString("telefono");
                            out.println("<tr>"
                                        +"<td><input id='bol-"+i+"' name='bol-"+i+"' style='border: 0;' type='number' readonly='readonly' value='"+boleta+"' onkeypress='return validarInt(event)'></td>"
                                        +"<td><input id='nom-"+i+"' name='nom-"+i+"' style='border: 0;' type='text' readonly='readonly' value='"+nombre+"' maxlength='20' onkeypress='return validarStr(event)'></td>"
                                        +"<td><input id='ap-"+i+"' name='ap-"+i+"' style='border: 0;' type='text' readonly='readonly' value='"+appat+"' maxlength='20' onkeypress='return validarStr(event)'></td>"
                                        +"<td><input id='am-"+i+"' name='am-"+i+"' style='border: 0;' type='text' readonly='readonly' value='"+apmat+"' maxlength='20' onkeypress='return validarStr(event)'></td>"
                                        +"<td><input id='tel-"+i+"' name='tel-"+i+"' style='border: 0;' type='number' readonly='readonly' value='"+telefono+"' onkeypress='return validarInt(event)'></td>"
                                        +"<td><input id='btn-"+i+"' name='sel' type='button' value='Seleccionar' onclick='editar(id)'>"
                                      + "</tr>");
                            i++;
                        }
                        out.println("</table>");//fin tabla
                        out.println("</div>");
                        
                        
                        
                        out.println("<style>");//inicio style
                        out.println("#btn{");
                        out.println("margin-top:10px;");
                        out.println("}");
                        out.println("</style>");//fin style
                        
                        out.println("<div id='par'>");
                        out.println("<input type='submit' value='Enviar datos' onclick='verificarDatos(event)'>");
                        out.println("</div>");
                        out.println("</form>");//fin form
                        
                        out.println("<script>");//inicio js
                        out.println("function validarEntrada(){");
                        out.println("var abecedario=String.fromCharCode(...Array(123).keys()).slice(97).toUpperCase()+String.fromCharCode(...Array(123).keys()).slice(97)+'Ñ'+'ñ';");
                        
                        out.println("var nom=document.getElementById('nom-'+id_boton).value;");
                        out.println("var ap=document.getElementById('ap-'+id_boton).value;");
                        out.println("var am=document.getElementById('am-'+id_boton).value;");
                       
                        out.println("var arrNom=nom.split('');");
                        out.println("var arrAp=ap.split('');");
                        out.println("var arrAm=am.split('');");
                        
                        out.println("var arrN=[];");
                        out.println("var arrP=[];");
                        out.println("var arrM=[];");
                        
                        out.println("for(i=0;i<arrNom.length;i++){");
                        out.println("if(abecedario.includes(arrNom[i])){");
                        out.println("arrN.push(true);");
                        out.println("}else{");
                        out.println("arrN.push(false);");
                        out.println("}");
                        out.println("}");
                        
                        out.println("for(i=0;i<arrAp.length;i++){");
                        out.println("if(abecedario.includes(arrAp[i])){");
                        out.println("arrP.push(true);");
                        out.println("}else{");
                        out.println("arrP.push(false);");
                        out.println("}");
                        out.println("}");
                        
                        out.println("for(i=0;i<arrAm.length;i++){");
                        out.println("if(abecedario.includes(arrAm[i])){");
                        out.println("arrM.push(true);");
                        out.println("}else{");
                        out.println("arrM.push(false);");
                        out.println("}");
                        out.println("}");
                        
                        out.println("if(arrN.includes(false)||arrP.includes(false)||arrM.includes(false)){");
                        out.println("return true;}else{return false;}}");
                        
                        //out.println("return arrN.includes(false);");
                        
                        out.println("function verificarDatos(e){");
                        out.println("if(validarEntrada()==true && validarBoleta()==true){");
                        out.println("e.preventDefault();");
                        out.println("alert('No se envio el formulario. Revisa la entrada.')");
                        out.println("}else{}");
                        out.println("}");
                        
                        out.println("function validarBoleta(){");
                        out.println("if(document.getElementById('bol-'+id_boton).value.split('').includes('-')){");
                        out.println("return true;}else{return false}}");
                        
                        out.println("function editar(id){");//inicio funcion editar
                        for(int j=0;j<i;j++){
                            out.println("document.getElementById('btn-"+j+"').setAttribute('onclick','error()');");
                        }
                        out.println("var id_obtenido=id.split('')");
                        out.println("globalThis.id_boton=id_obtenido[4];");
                        out.println("document.getElementById('bol-'+id_boton).removeAttribute('readonly');");
                        out.println("document.getElementById('nom-'+id_boton).removeAttribute('readonly');");
                        out.println("document.getElementById('ap-'+id_boton).removeAttribute('readonly');");
                        out.println("document.getElementById('am-'+id_boton).removeAttribute('readonly');");
                        out.println("document.getElementById('tel-'+id_boton).removeAttribute('readonly');");
                        out.println("globalThis.datos=[]");
                        out.println("datos.push(document.getElementById('bol-'+id_boton).value)");
                        out.println("datos.push(document.getElementById('nom-'+id_boton).value)");
                        out.println("datos.push(document.getElementById('ap-'+id_boton).value);");
                        out.println("datos.push(document.getElementById('am-'+id_boton).value);");
                        out.println("datos.push(document.getElementById('tel-'+id_boton).value)");
                        //out.println("alert(datos)");
                        out.println("alert('Ahora puede editar los campos');");
                        /*out.println("var btn=document.createElement('INPUT');");*/
                        out.println("globalThis.btnc=document.createElement('INPUT');");
                        /*out.println("btn.setAttribute('value','Enviar');");
                        out.println("btn.setAttribute('type','submit');");
                        out.println("btn.setAttribute('id','btn');");*/
                        out.println("btnc.setAttribute('value','Cancelar');");
                        out.println("btnc.setAttribute('type','button');");
                        out.println("btnc.setAttribute('id',id_boton);");
                        out.println("btnc.setAttribute('onclick','cancelar(id),removerBtn()');");
                        out.println("var div=document.getElementById('par');");
                        //out.println("div.appendChild(btn);");
                        out.println("div.appendChild(btnc);");
                        out.println("}");//fin funcion editar
                        
                        out.println("function removerBtn(){");//inicio funcion removerBtn
                        out.println("par.removeChild(btnc);");
                        out.println("}");//fin funcion removerBtn
                        
                        out.println("function validarInt(e){");//inicio funcion validarInt
                        out.println("var teclado=(document.all)?e.keyCode:e.which;");
                        out.println("if(teclado==8){return true;}");
                        out.println("var patron=/[0-9'\'d]/;");
                        out.println("var codigo=String.fromCharCode(teclado);");
                        out.println("return patron.test(codigo);");
                        out.println("}");//fin funcion validarInt
                        
                        out.println("function validarStr(e){");//inicio funcion validarStr
                        out.println("var teclado=(document.all)?e.keyCode:e.which;");
                        out.println("if(teclado==8){return true;}");
                        out.println("var patron=/[A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z, ,'\'s]/;");
                        out.println("var codigo=String.fromCharCode(teclado);");
                        out.println("return patron.test(codigo);");
                        out.println("}");//fin funcion validarStr
                        
                        out.println("function cancelar(id){");//inicio funcion cancelar
                        out.println("document.getElementById('bol-'+id).value=datos[0]");
                        out.println("document.getElementById('nom-'+id).value=datos[1]");
                        out.println("document.getElementById('ap-'+id).value=datos[2];");
                        out.println("document.getElementById('am-'+id).value=datos[3];");
                        out.println("document.getElementById('tel-'+id).value=datos[4]");
                        out.println("document.getElementById('bol-'+id).setAttribute('readonly','readonly');");
                        out.println("document.getElementById('nom-'+id).setAttribute('readonly','readonly');");
                        out.println("document.getElementById('ap-'+id).setAttribute('readonly','readonly');");
                        out.println("document.getElementById('am-'+id).setAttribute('readonly','readonly');");
                        out.println("document.getElementById('tel-'+id).setAttribute('readonly','readonly');");
                        for(int j=0;j<i;j++){
                            out.println("document.getElementById('btn-"+j+"').setAttribute('onclick','editar(id)');");
                        }
                        out.println("}");//fin funcion cancelar
                        
                        out.println("function error(){alert('Solo puedes editar un solo usuario a la vez');}");
                        
                        out.println("</script>");//fin js
                        out.println("<a href='index.html'>Regresar a principal</a>");
                        rs.close();
                        set.close();
                    }catch(Exception e){
                        System.out.println("Error al conectar a la tabla");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                    }
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
