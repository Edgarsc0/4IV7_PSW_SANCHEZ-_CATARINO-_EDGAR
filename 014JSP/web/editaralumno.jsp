
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
        <form name="editar" action="actualizaralumno.jsp" method="post">
            
                

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
                    int id=Integer.parseInt(request.getParameter("id"));
                    String q="select * from alumnobatiz where boleta="+id;
                    set=con.createStatement();
                    rs=set.executeQuery(q);
                    while(rs.next()){
                    %>
                    <label>Boleta</label>
                    <br>
                    <input type="hidden" name="boleta2" value="<%=rs.getInt("boleta")%>">
                    <br>
                    <label>Nombre</label>
                    <br>
                    <input type="texto" name="nombre2" value="<%=rs.getString("nombre")%>">
                    <br>
                    <label>Apellido Paterno</label>
                    <br>
                    <input type="texto" name="appat2" value="<%=rs.getString("appat")%>">
                    <br>
                    <label>Apellido Materno</label>
                    <br>
                    <input type="texto" name="apmat2" value="<%=rs.getString("apmat")%>">
                    <br>
                    <label>Telefono</label>
                    <br>
                    <input type="texto" name="tel2" value="<%=rs.getString("telefono")%>">
                    <br>
                    <input type="submit" value="Actualizar Datos">
                    <br>
                    <input type="reset" value="Borrar Datos">
                    
                    <%
                        }
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
        </form>
        <br>
        <a href="index.html">Regresar a principal</a>
        <br>
        <a href="index.html">Registrar nuevo alumno</a>
    </body>
</html>