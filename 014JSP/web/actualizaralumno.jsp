<%-- 
    Document   : registroalumno
    Created on : 4/04/2022, 03:25:05 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" language="java" import="java.sql.*,java.util.*,java.text.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con=null;
            Statement set=null;
            ResultSet rs=null;
            
            String user, URL, password,driver;
            URL="jdbc:mysql://localhost/alumnos";
            user="root";
            password="n0m3l0";
            driver="com.mysql.jdbc.Driver";
            try{
                Class.forName(driver);
                con=DriverManager.getConnection(URL, user, password);
                try{
                    String nom,appat,apmat,tel;
                    int bol;
                    nom=request.getParameter("nombre2");
                    appat=request.getParameter("appat2");
                    apmat=request.getParameter("apmat2");
                    tel=request.getParameter("tel2");
                    bol=Integer.parseInt(request.getParameter("boleta2"));
                    set=con.createStatement();
                    String q="update alumnobatiz set nombre='"+nom+"',appat='"+appat+"',apmat='"+apmat+"',telefono='"+tel+"' where boleta="+bol+"";
                    int registro=set.executeUpdate(q);
                    %>
                        <h1>Registro Exitoso</h1>
                    <%
                }catch(SQLException es){
                    System.out.println("Error al registrar la tabla");
                    System.out.println(es.getMessage());
                    %>
                        <h1>Error en el requisito de la tabla</h1>
                    <%
                }
            }catch(Exception e){
                System.out.println("Error al conectar con la BD");
                System.out.println(e.getMessage());
                %>
                <h1>No se conecto con la bd</h1>
                <%
                    
            }



        %>
        <br>
        <a href="index.html">Regresar a principal</a>
    </body>
</html>
