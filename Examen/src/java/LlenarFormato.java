/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
@WebServlet(urlPatterns = {"/LlenarFormato"})
public class LlenarFormato extends HttpServlet {

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
            LocalDate fechaActual = LocalDate.now();	 
            String grupo=request.getParameter("grupo");
            String [] caracterGrupo=grupo.split("");
            int semestre=Integer.parseInt(caracterGrupo[0]);
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
                    out.println("<title>Servlet LlenarFormato</title>");            
                out.println("</head>");
                out.println("<body>");
                String usu=request.getParameter("usuario");
                    out.println("<div class='formato'>");
                        out.println("<image src='i4.png'>");
                        out.println("<div class='txt'>");
                        out.println("<form method='post' action='VerificarDatos'>");
                            out.println("<h1>Formulario Alumno "+ fechaActual+"</h1>");
                            out.println("<hr>");
                            out.println("<p>Por medio de la presente yo <input onkeypress='return validarString(event)' type='text' id='nom' name='nombre' placeholder='Nombre (s)'>"
                                    + " <input onkeypress='return validarString(event)' type='text' name='appat' id='appat' placeholder='Apellido Paterno'>"
                                    + " <input onkeypress='return validarString(event)' type='text' name='apmat' id='apmat' placeholder='Apellido Materno'> alumno (a)"
                                    + " del CECyT 9 'Juan de dios Batiz', inscrito en el grupo <input readonly='readonly' id='semestre' name='grupo' value='"+grupo+"'>"
                                    + " de la carrera Técnico en Programacion, con numero de boleta <input placeholder='Boleta' readonly='' id='bol' name='bol' value='"+usu+"'>, y con"
                                    + " fundamento en lo expresado en el articulo 107, fracciones IX y X , y en el articulo 108 fracción"
                                    + " IX del Reglamento inerno del Instituto Politécnico Nacional, manifiesto mi compromiso de cuidar y hacer"
                                    + " buen uso de los equipos de cómputo (CPU, monitor, teclado, mouse, y demás componentes del mismo), que me"
                                    + " han sido asignados en los laboratorios del área. Así mismo me comprometo a reportar con el profesor (a)"
                                    + " responsable, cualquier irregularidad o anomalía dentro de los 10 primeros minutos de cada clase, siendo"
                                    + " conciente de que, de no ser asi, puedo ser acreedor de alguna de las sansioes establecidas en el articulo 110 del"
                                    + " citado reglamento.</p>");
                            //out.println("<h1>Servlet LlenarFormato at " + request.getContextPath() + "</h1>");
                            out.println("<p>El o los equipos que tengo asignados y que utilizo en mis clases son:</p>");
                            out.println("</div>");
                            out.println("<div class='table'>");
                            out.println("<table align='center'>"
                                            +"<thead>"
                                            + "<tr>"
                                                + "<th>Unidad de Aprendizaje</th>"
                                                + "<th>LBD</th>"
                                                + "<th>LNV</th>"
                                                + "<th>LDS</th>"
                                                + "<th>4.0</th>"
                                            + "</tr>"
                                            + "</thead>");
                                            //+ "<tbody>");
                                            switch(semestre){
                                                case 3:
                                                    for(int i=0;i<tercero.length;i++){
                                                        out.println("<tr>"
                                                                        +"<td>"+tercero[i]+"</td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LBD-"+i+"' id='LBD-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LNV-"+i+"' id='LNV-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LDS-"+i+"' id='LDS-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='4.0-"+i+"' id='4.0-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                   +"</tr>");
                                                    }
                                                    break;
                                                case 4:
                                                    for(int i=0;i<cuarto.length;i++){
                                                        out.println("<tr>"
                                                                        +"<td>"+cuarto[i]+"</td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LBD-"+i+"' id='LBD-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LNV-"+i+"' id='LNV-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LDS-"+i+"' id='LDS-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='4.0-"+i+"' id='4.0-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                   +"</tr>");
                                                    }
                                                    break;
                                                case 5:
                                                    for(int i=0;i<quinto.length;i++){
                                                        out.println("<tr>"
                                                                        +"<td>"+quinto[i]+"</td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LBD-"+i+"' id='LBD-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LNV-"+i+"' id='LNV-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LDS-"+i+"' id='LDS-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='4.0-"+i+"' id='4.0-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                   +"</tr>");
                                                    }
                                                    break;
                                                case 6:
                                                    for(int i=0;i<sexto.length;i++){
                                                        out.println("<tr>"
                                                                        +"<td>"+sexto[i]+"</td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LBD-"+i+"' id='LBD-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LNV-"+i+"' id='LNV-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='LDS-"+i+"' id='LDS-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                        +"<td><input type='number' min='0' onkeypress='return validarInt(event)' name='4.0-"+i+"' id='4.0-"+i+"' onmousedown='removerRO(id),resaltar(id)' readonly='readonly'></td>"
                                                                   +"</tr>");
                                                    }
                                                    break;
                                            }
                            out.println("</table>");
                            out.println("</div>");
                            out.println("<input type='submit' value='Enviar datos' onclick='verificarDatos(event)'>");
                            out.println("<script>");
                                out.println("function resaltar(id){"
                                        + "document.getElementById(id).setAttribute('style','border:2px solid aqua;');}");
                                out.println("function validarCampos(){"
                                        + "if(document.getElementById('nom').value==''"
                                        + "||document.getElementById('appat').value==''"
                                        + "||document.getElementById('apmat').value==''"
                                        + "||document.getElementById('bol').value==''){"
                                        + "return true;}else{return false;}}");
                                out.println("function validarTabla(){"
                                        + "var validacion=[];"
                                        + "switch(semestre){"
                                        + "case '3':"
                                        + "for(i=0;i<3;i++){"
                                        + "if(document.getElementById('LBD-'+i).value==''"
                                        + "&&document.getElementById('LNV-'+i).value==''"
                                        + "&&document.getElementById('LDS-'+i).value==''"
                                        + "&&document.getElementById('4.0-'+i).value==''){"
                                        + "validacion.push(true);}else{validacion.push(false)}}"
                                        + "break;"
                                        + "case '4':"
                                        + "for(i=0;i<3;i++){"
                                        + "if(document.getElementById('LBD-'+i).value==''"
                                        + "&&document.getElementById('LNV-'+i).value==''"
                                        + "&&document.getElementById('LDS-'+i).value==''"
                                        + "&&document.getElementById('4.0-'+i).value==''){"
                                        + "validacion.push(true);}else{validacion.push(false)}}"
                                        + "break;"
                                        + "case '5':"
                                        + "for(i=0;i<4;i++){"
                                        + "if(document.getElementById('LBD-'+i).value==''"
                                        + "&&document.getElementById('LNV-'+i).value==''"
                                        + "&&document.getElementById('LDS-'+i).value==''"
                                        + "&&document.getElementById('4.0-'+i).value==''){"
                                        + "validacion.push(true);}else{validacion.push(false)}}"
                                        + "break;"
                                        + "case '6':"
                                        + "for(i=0;i<4;i++){"
                                        + "if(document.getElementById('LBD-'+i).value==''"
                                        + "&&document.getElementById('LNV-'+i).value==''"
                                        + "&&document.getElementById('LDS-'+i).value==''"
                                        + "&&document.getElementById('4.0-'+i).value==''){"
                                        + "validacion.push(true);}else{validacion.push(false)}}"
                                        + "break;"
                                        + "}return validacion.includes(true);}");
                                out.println("function validarInputString(){"
                                        + "var abecedario=String.fromCharCode(...Array(123).keys()).slice(97).toUpperCase()+String.fromCharCode(...Array(123).keys()).slice(97)+'Ñ'+'ñ';"
                                        + "var nombre=document.getElementById('nom').value.split('');"
                                        + "var appat=document.getElementById('appat').value.split('');"
                                        + "var apmat=document.getElementById('apmat').value.split('');"
                                        + "var arrN=[];var arrP=[];var arrM=[];"
                                        + "for(i=0;i<nombre.length;i++){"
                                        + "if(abecedario.includes(nombre[i])){"
                                        + "arrN.push(true);}else{arrN.push(false);}}"
                                        + "for(i=0;i<appat.length;i++){"
                                        + "if(abecedario.includes(appat[i])){"
                                        + "arrP.push(true);}else{arrP.push(false);}}"
                                        + "for(i=0;i<apmat.length;i++){"
                                        + "if(abecedario.includes(apmat[i])){"
                                        + "arrM.push(true);}else{arrM.push(false);}}"
                                        + "return arrN.includes(false)||arrP.includes(false)||arrM.includes(false);}");
                                out.println("function validarBoleta(){"
                                        + "if(document.getElementById('bol').value<0 || document.getElementById('bol').value.split('').length!=10){"
                                        + "return true;}else{return false;}}");
                                out.println("function validarSerie(){"
                                        + "var valid=[];"
                                        + "switch(semestre){"
                                        + "case '3':"
                                        + "for(i=0;i<3;i++){"
                                        + "if(document.getElementById('LBD-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LNV-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LDS-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('4.0-'+i).value<0){"
                                        + "valid.push(true);break;}}"
                                        + "break;"
                                        + "case '4':"
                                        + "for(i=0;i<5;i++){"
                                        + "if(document.getElementById('LBD-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LNV-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LDS-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('4.0-'+i).value<0){"
                                        + "valid.push(true);break;}}"
                                        + "break;"
                                        + "case '5':"
                                        + "for(i=0;i<6;i++){"
                                        + "if(document.getElementById('LBD-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LNV-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LDS-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('4.0-'+i).value<0){"
                                        + "valid.push(true);break;}}"
                                        + "break;"
                                        + "case '6':"
                                        + "for(i=0;i<6;i++){"
                                        + "if(document.getElementById('LBD-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LNV-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('LDS-'+i).value<0){"
                                        + "valid.push(true);break;}"
                                        + "if(document.getElementById('4.0-'+i).value<0){"
                                        + "valid.push(true);break;}}"
                                        + "break;}if(valid.includes(true)){return true;}else{return false;}}");
                                out.println("function validarInt(e){");//inicio funcion validarInt
                                out.println("var teclado=(document.all)?e.keyCode:e.which;");
                                out.println("if(teclado==8){return true;}");
                                out.println("var patron=/[0-9]/;");
                                out.println("var codigo=String.fromCharCode(teclado);");
                                out.println("return patron.test(codigo);");
                                out.println("}");//fin funcion validarInt
                                out.println("function validarString(e){");//inicio funcion validarStr
                                out.println("var teclado=(document.all)?e.keyCode:e.which;");
                                out.println("if(teclado==8){return true;}");
                                out.println("var patron=/[A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z, ,'\'s]/;");
                                out.println("var codigo=String.fromCharCode(teclado);");
                                out.println("return patron.test(codigo);");
                                out.println("}");//fin funcion validarStr
                                out.println("function verificarDatos(e){");
                                out.println("if(validarAsig()==true || validarBoleta()==true || validarInputString()==true || validarCampos()==true || validarTabla()==true || validarSerie()==true){e.preventDefault();alert('No se envio el formulario."
                                        + " Es posible que no hayas llenado correctamente la tabla, introduciste una boleta invalida o tu nombre. Revisa la informacion.');}else{}}");
                                out.println("function validarAsig(){");
                                out.println("globalThis.semestre=document.getElementById('semestre').value.split('')[0];");
                                out.println("switch(semestre){"
                                        + "case '3':"
                                        + "break;"
                                        + "case '4':"
                                            + "var opt1=[document.getElementById('LBD-3').value"
                                            + ",document.getElementById('LNV-3').value"
                                            + ",document.getElementById('LDS-3').value"
                                            + ",document.getElementById('4.0-3').value];"
                                            + "var opt2=[document.getElementById('LBD-4').value"
                                            + ",document.getElementById('LNV-4').value"
                                            + ",document.getElementById('LDS-4').value"
                                            + ",document.getElementById('4.0-4').value];"
                                            + "if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''&&"
                                            + "opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){"
                                            + "return true;}if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''){"
                                            + "return false;}if(opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){return false;}"
                                            + "if((opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]=='')==false && (opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]=='')==false){"
                                            + "return true;}"
                                            + "break;"
                                        + "case '5':"
                                            + "var opt1=[document.getElementById('LBD-4').value"
                                            + ",document.getElementById('LNV-4').value"
                                            + ",document.getElementById('LDS-4').value"
                                            + ",document.getElementById('4.0-4').value];"
                                            + "var opt2=[document.getElementById('LBD-5').value"
                                            + ",document.getElementById('LNV-5').value"
                                            + ",document.getElementById('LDS-5').value"
                                            + ",document.getElementById('4.0-5').value];"
                                            + "if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''&&"
                                            + "opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){"
                                            + "return true;}if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''){"
                                            + "return false;}if(opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){return false;}"
                                            + "if((opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]=='')==false && (opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]=='')==false){"
                                            + "return true;}"
                                            + "break;"
                                        + "case '6':"
                                            + "var opt1=[document.getElementById('LBD-4').value"
                                            + ",document.getElementById('LNV-4').value"
                                            + ",document.getElementById('LDS-4').value"
                                            + ",document.getElementById('4.0-4').value];"
                                            + "var opt2=[document.getElementById('LBD-5').value"
                                            + ",document.getElementById('LNV-5').value"
                                            + ",document.getElementById('LDS-5').value"
                                            + ",document.getElementById('4.0-5').value];"
                                            + "if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''&&"
                                            + "opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){"
                                            + "return true;}if(opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]==''){"
                                            + "return false;}if(opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]==''){return false;}"
                                            + "if((opt1[0]==''&&opt1[1]==''&&opt1[2]==''&&opt1[3]=='')==false && (opt2[0]==''&&opt2[1]==''&&opt2[2]==''&&opt2[3]=='')==false){"
                                            + "return true;}"
                                            + "break;"
                                        + "}}"
                                        );
                                out.println("function removerRO(id){");
                                out.println("document.getElementById(id).removeAttribute('readonly');");
                                out.println("var no_id=id.split('')[4];");
                                out.println("var lab=id.split('')[0]+id.split('')[1]+id.split('')[2]");
                                out.println("switch(lab){");
                                out.println("case 'LBD':"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LNV-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('LDS-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('4.0-'+no_id).removeAttribute('onmousedown');"
                                        + "break;");
                                out.println("case 'LNV':"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LBD-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('LDS-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('4.0-'+no_id).removeAttribute('onmousedown');"
                                        + "break;");
                                out.println("case 'LDS':"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('4.0-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LBD-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('LNV-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('4.0-'+no_id).removeAttribute('onmousedown');"
                                        + "break;");
                                out.println("case '4.0':"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('readonly','readonly');"
                                        + "document.getElementById('LBD-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LNV-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LDS-'+no_id).setAttribute('onclick','error()');"
                                        + "document.getElementById('LBD-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('LNV-'+no_id).removeAttribute('onmousedown');"
                                        + "document.getElementById('LDS-'+no_id).removeAttribute('onmousedown');"
                                        + "break;");
                                out.println("}");
                                out.println("}");
                                out.println("function error(){alert('Solo puede existir un registro en cada fila.');}");
                            out.println("</script>");
                            out.println("<input type='hidden' name='usu' value='"+usu+"'>"
                                +"<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>");
                        out.println("</form>");
                        out.println("<form method='post' action='principal'>"
                                + "<input type='submit' value='Regresar a principal'>"
                                + "<input type='hidden' name='usu' value='"+usu+"'>"
                                +"<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"
                                + "</form>");
                    out.println("</div>");
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
