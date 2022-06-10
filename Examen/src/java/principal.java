/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
@WebServlet(urlPatterns = {"/principal"})
public class principal extends HttpServlet {

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
     * @throws  IOException if an I/O error occurs
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
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license\n" +
"Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <style>\n" +
"            .main{\n" +
"                border: 5px solid #2F2F2F;\n" +
"                background-color: #2F2F2F;\n" +
"                width: 50%;\n" +
"            }\n" +
"            .inpClass{\n" +
"                margin-left: 10px;\n" +
"            }\n" +
"            .btn{\n" +
"                margin-left: 10px\n" +
"            }\n" +
"            *{\n" +
"                background-color:#111111;\n" +
"                color:white;\n" +
"                font-family: monospace;\n" +
"                text-align: center;\n" +
"            }\n" +
"            .btn,a{\n" +
"                background-color: #FFCB74;\n" +
"                color: #111111;\n" +
"                border: 0;\n" +
"                height: 35px;\n" +
"                font-family: arial black;\n" +
"                border-radius: 10px;\n" +
"                margin-bottom: 15px;\n" +
"                margin-top: 15px;\n" +
"            }\n" +
"            label{\n" +
"                font-size: 20px;\n" +
"            }\n" +
"            .second,.sol{\n" +
"                border: 5px solid #2F2F2F;\n" +
"                background-color: #2F2F2F;\n" +
"                margin-top: 15px;\n" +
"                width: 50%;\n" +
"            }\n" +
"            .tr{\n" +
"                border: 5px solid #2F2F2F;\n" +
"                background-color: #2F2F2F;\n" +
"                margin-top: 15px;\n" +
"                width: 50%;\n" +
"            }\n" +
"            h1{\n" +
"                background-color: #2F2F2F;\n" +
"            }\n" +
"            .s{\n" +
"                display: grid;\n" +
"                place-items:center;\n" +
"            }\n" +
"            input,select{\n" +
"                border: 1px solid aqua;\n" +
"                border-radius: 10px;\n" +
"            }\n" +
"            p{\n" +
"                font-size: 35px;\n" +
"                animation: espaciado 10s alternate infinite;\n" +
"                color:#FFCB74;\n" +
"            }\n" +
"            hr{\n" +
"                margin-bottom: 50px;\n" +
"            }\n" +
"            @keyframes espaciado{\n" +
"                from{\n" +
"                    letter-spacing:0px;\n" +
"                }to{\n" +
"                    letter-spacing: 10px;\n" +
"                }\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <image src='i2.png'>\n" +
"        <p>SISTEMA DE LEVANTAMIENTO DE REPORTES</p>\n" +
"        <hr>\n" +
"        <div class=\"s\">\n" +
"        <div class=\"main\">\n");
        switch(request.getParameter("rol")){
            case "1":
                out.println("<h1>Alumno</h1>");
                break;
            case "2":
                out.println("<h1>Docente</h1>");
                break;
            case "3":
                out.println("<h1>Administrador</h1>");
                break;
        }
        if(Integer.parseInt(request.getParameter("rol"))==1){
            out.println(
                    "<h1>"+request.getParameter("usu")+"</h1>"+
"        <form method=\"post\" name=\"intro\" action=\"LlenarFormato\">\n" +
"                    <label>Turno</label>\n" +
"                    <select name=\"turno\" id=\"select\" onchange=\"mostrarGrupos()\">\n" +
"                        <option value=\"Select\">Selecciona el turno</option>\n" +
"                        <option value=\"m\">Matutino</option>\n" +
"                        <option value=\"v\">Vespertino</option>\n" +
"                    </select>\n" +
"                <div id=\"grupo\"></div>\n" +
                "<input type='hidden' name='usuario' value='"+request.getParameter("usu")+"'>"+
                "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"+                 
"                <input class=\"btn\" type=\"submit\" value=\"Entrar\" onclick=\"validarDatos(event)\">\n" +
"        </form>\n" );
        }
        out.println(
    "        </div><div class=\"second\">\n" +
    "            <h1>¿Deseas levantar un reporte sobre una anomalia o irregularidad en tu computadora?</h1>\n" );
        if(Integer.parseInt(request.getParameter("rol"))==1){
            out.println("<form method=\"post\" action=\"LevantarReporte\">\n");
        }else{
            out.println("<form method=\"post\" action=\"LevantarReporte_docente\">\n");
        }
        out.println(
    //"                <label>Ingresa tu numero de boleta </label><input id=\"bol\" name=\"bol\" onkeypress=\"return validarInt(event)\" type=\"number\">\n" +
                    "<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"+
                    "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"+
    "                <br>\n" +
    "                <input class='btn'  type=\"submit\" onclick=\"valiarFormReporte(event)\" value=\"Acceder\">\n" +
    "        </form>\n" +
    "            </div>\n" +
    "        <div class='tr'>\n" +
    "        <h1>Consulta la bitacora aqui</h1>\n" +
    "        <form method='post' action='ConsultarBitacora'>\n" +
                "<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"+
                "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"+         
    "            <input class='btn' type='submit' value='Mostrar bitacora'><br>\n");
            if(Integer.parseInt(request.getParameter("rol"))==2){
                out.println("<label>Filtrar bitacora por: </label><br>"
                        + "<select onchange='darFiltro(value)'>"
                        + "<option>Escoja un filtro</option>"
                        + "<option value='noSerie'>Numero de serie</option>"
                        + "<optgroup label='Fallas'>"
                        + "<option value='1'>Monitor</option>"
                        + "<option value='2'>Mouse</option>"
                        + "<option value='3'>CPU</option>"
                        + "<option value='4'>Teclado</option>"
                        + "<option value='5'>Camara</option>"
                        + "<option value='6'>Software</option>"
                        + "</optgroup>"
                        + "</select>");
                out.println("<div id='input'></div>");
                
            }
            out.println("</form>\n" +
    "        </div>\n" +
    "            <div class=\"sol\">\n" +
    "                <h1>Solicitud de modificacion de datos o baja de datos del laboratorio</h1>\n" +
    "                <form method='post' action='EnviarDatos3'>\n" +
    "                    <label>Asunto</label>\n" +
    "                    <select name=\"sol\" id=\"select\" onchange=\"mostrarGrupos()\">\n" +
    "                        <option value=\"Modificacion de datos\">Modificacion de datos</option>\n" +
    "                        <option value=\"Baja de datos\">Baja de datos</option>\n" +
    "                    </select>\n" +
    "                    <br>\n" +
                        "<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"+
                        "<input type='hidden' name='rol' value='"+request.getParameter("rol")+"'>"+
    //"                    <label>Ingresa tu numero de boleta </label><input id=\"bol0\" name=\"bolsol\" onkeypress=\"return validarInt(event)\" type=\"number\">\n" +
    "                    <br>\n" +
    "                    <input class=\"btn\" type=\"submit\" onclick=\"verificarForm(event)\" value=\"Enviar solicitud\">\n" +
    "                </form>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "        <script>\n" +
                "function darFiltro(v){"
                                + "var div=document.getElementById('input');"
                                + "switch(v){"
                                + "case 'noSerie':"
                                + "var input=document.createElement('INPUT');"
                                + "input.setAttribute('placeholder','filtrar con numero de serie...');"
                                + "input.setAttribute('name','filtro_nos');"
                                + "div.appendChild(input);"
                                + ""
                                + "}"
                                + "}"+
    "            function verificarForm(e){\n" +
    "                if(document.getElementById(\"bol0\").value<0||document.getElementById(\"bol0\").value.split('').length!==10){\n" +
    "                    e.preventDefault();\n" +
    "                    alert(\"No has ingresado una boleta valida\");\n" +
    "                }\n" +
    "            }\n" +
    "            function validarBoleta(){\n" +
    "                if(document.getElementById(\"bol\").value<0||document.getElementById(\"bol\").value.split('').length!==10){\n" +
    "                    return true;\n" +
    "                }else{\n" +
    "                    return false;\n" +
    "                }\n" +
    "            }\n" +
    "            function valiarFormReporte(e){\n" +
    "                if(validarBoleta()===true){\n" +
    "                    e.preventDefault();\n" +
    "                    alert(\"No has ingresado una boleta valida\");\n" +
    "                }\n" +
    "            }\n" +
    "            function validarInt(e){\n" +
    "                var teclado=(document.all)?e.keyCode:e.which;\n" +
    "                if(teclado===8){return true;}\n" +
    "                var patron=/[0-9]/;\n" +
    "                var codigo=String.fromCharCode(teclado);\n" +
    "                return patron.test(codigo);\n" +
    "            }\n" +
    "            function mostrarGrupos(){\n" +
    "                document.getElementById(\"grupo\").innerHTML=\"\";\n" +
    "                var label=document.createElement(\"LABEL\");\n" +
    "                var cls=document.createAttribute(\"class\");\n" +
    "                cls.value=\"inpClass\";\n" +
    "                label.setAttributeNode(cls);\n" +
    "                var txt=document.createTextNode(\"Seleccione grupo: \");\n" +
    "                label.appendChild(txt);\n" +
    "                document.getElementById(\"grupo\").appendChild(label);\n" +
    "                var fecha_actual =new Date();\n" +
    "                var opt=\"\";\n" +
    "                if(document.getElementById(\"select\").value===\"m\"){\n" +
    "                    if(fecha_actual.getMonth()<=6){//EXISTEN SEMESTRES PARES\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='4IM`+i+`'>`+\"4IM\"+i+`</option>`;\n" +
    "                        }\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='6IM`+i+`'>`+\"6IM\"+i+`</option>`;\n" +
    "                        }\n" +
    "                    }else{//EXISTEN SEMESTRES IMPARES\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='3IM`+i+`'>`+\"3IM\"+i+`</option>`;\n" +
    "                        }\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='5IM`+i+`'>`+\"5IM\"+i+`</option>`;\n" +
    "                        }\n" +
    "                    }\n" +
    "                    var s=document.createElement(\"SELECT\");\n" +
    "                    s.innerHTML=opt;\n" +
    "                    s.setAttribute(\"name\",\"grupo\");\n" +
    "                    //s.setAttribute(\"id\",\"grupo\");\n" +
    "                    document.getElementById(\"grupo\").appendChild(s);\n" +
    "                    //alert(s.value);\n" +
    "                }else if(document.getElementById(\"select\").value===\"v\"){\n" +
    "                    if(fecha_actual.getMonth()<=6){//EXISTEN SEMESTRES PARES\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='4IV`+i+`'>`+\"4IV\"+i+`</option>`;\n" +
    "                        }\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='6IV`+i+`'>`+\"6IV\"+i+`</option>`;\n" +
    "                        }\n" +
    "                    }else{//EXISTEN SEMESTRES IMPARES\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='3IV`+i+`'>`+\"3IV\"+i+`</option>`;\n" +
    "                        }\n" +
    "                        for(i=7;i<=10;i++){\n" +
    "                            opt+=`<option value='5IV`+i+`'>`+\"5IV\"+i+`</option>`;\n" +
    "                        }\n" +
    "                    }\n" +
    "                    var s=document.createElement(\"SELECT\");\n" +
    "                    s.innerHTML=opt;\n" +
    "                    s.setAttribute(\"name\",\"grupo\");\n" +
    "                    //s.setAttribute(\"id\",\"grupo\");\n" +
    "                    document.getElementById(\"grupo\").appendChild(s);                    \n" +
    "                    //alert(s.value);\n" +
    "                }\n" +
    "            }\n" +
    "            function validarDatos(e){\n" +
    "                if(document.getElementById(\"select\").value===\"Select\"){\n" +
    "                    e.preventDefault();\n" +
    "                    alert(\"No se envio el formulario. No has seleccionado turno.\");\n" +
    "                }\n" +
    "            }\n" +
    "        </script>\n" +
            "<button class='btn'><a href='index.html'>Cerrar sesion</a></button>"+
    "    </body>\n" +
    "</html>");
            
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
