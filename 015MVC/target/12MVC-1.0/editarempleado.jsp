<%-- 
    Document   : editarempleado
    Created on : 9/05/2022, 04:09:48 PM
    Author     : Alumno
--%>

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
        <div class="editarempleado">
            <form method="post" name="editar" action="actualizarempleado">
                <table border="2">
                    <%
                        int id=Integer.parseInt(request.getParameter("id"));
                        System.out.println(id);
                        Empleado e=AccionesEmpleado.buscarEmpleadoporID(id);
                    %>
                    <tr>
                        <td>ID</td>
                        <td><input type="hidden" name="id2" value="<%=e.getId()%>"></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="hidden" name="nombre2" value="<%=e.getNombre()%>"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password2" value="<%=e.getPassword()%>"></td>
                    </tr>
                    
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email2" value="<%=e.getEmail()%>"></td>
                    </tr>
                    <tr>
                        <td>Pais</td>
                        <td>
                            <select name="pais2">
                                <option>Mexico</option>
                                <option>India</option>
                                <option>Al que nadie quiere</option>
                                <option>Por ahi</option>
                            </select>  
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Actualizar Empleado"></td>                 </td>
                    </tr>
                </table>
            </form>
                
        </div>
    </body>
</html>
