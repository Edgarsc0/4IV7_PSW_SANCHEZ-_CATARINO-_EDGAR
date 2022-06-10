<%-- 
    Document   : inicio
    Created on : 9/05/2022, 03:57:03 PM
    Author     : Alumno
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Controlador.AccionesEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="listageneral">  
            <br>
            <table border="2">
                <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>PASSWORD</th>
                            <th>EMAIL</th>
                            <th>PAIS</th>
                            <th>EDITAR</th>
                            <th>ELIMINAR</th>
                        </tr>
                </thead>
                <tbody>
                    <%
                        List<Empleado> lista=AccionesEmpleado.getAllEmpleados();
                        for(Empleado e:lista){
                            %>
                        <tr>    
                            <td><%=e.getId()%></td>
                            <td><%=e.getNombre()%></td>
                            <td><%=e.getPassword()%></td>
                            <td><%=e.getEmail()%></td>
                            <td><%=e.getPais()%></td>
                            <td><a href="editarempleado.jsp?<%=e.getId()%>">ICONO PARA EDITAR</a></td>
                            <td><a href="eliminarempleado?<%=e.getId()%>">ICONO PARA ELIMINAR</a></td>
                        </tr>
                        }
                    <%
                        %>
                </tbody>
            </table>
        </div>
    </body>
</html>
