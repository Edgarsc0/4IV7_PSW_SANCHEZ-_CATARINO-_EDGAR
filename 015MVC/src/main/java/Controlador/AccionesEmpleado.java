/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Alumno
 */
import Modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccionesEmpleado {
    
    public static int registrarEmpleado(Empleado e){
        int status = 0;
        try{
            //conexion
            Connection con = Conexion.getConnection();
            String q = "insert into empleado(nombre,password,email,pais) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPais());
            //se ejecuta
            status = ps.executeUpdate(q);
            con.close();
            System.out.println("Registro exitoso");
        }
        catch(Exception ex){
            System.out.println("Error al registrar");
            System.out.println(ex.getMessage());
        }
        return status;
    }
    
    public static List<Empleado> getAllEmpleados(){
        List<Empleado> lista=new ArrayList<Empleado>();
        try{
            Connection con=Conexion.getConnection();
            String q="select * from empleado";
            PreparedStatement ps=con.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Empleado e=new Empleado();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPais(rs.getString(5));
                lista.add(e);
            }
            System.out.println("Se encontro al empleado");
            con.close();
        }catch(Exception ex){
            System.out.println("Error al consultar el empleado");
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    //BUSCAR POR ID
    public static Empleado buscarEmpleadoporID(int id){
        Empleado e=new Empleado();
        try{
            Connection con=Conexion.getConnection();
            String q="select * from empleado where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPais(rs.getString(5));
            }
            System.out.println("Se encontro al empleado");
            con.close();
        }catch(Exception ex){
            System.out.println("Error al consultar el empleado");
            System.out.println(ex.getMessage());
        }
        return e;
    }
    
//ELIMINAR POR ID AL EMPLEADO    
    public static int eliminarEmpleado(int id){
        int estado=0;
        try{
            Connection con=Conexion.getConnection();
            String q="delete * from empleado where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1, id);
            estado=ps.executeUpdate();
            System.out.println("Se elimino al empleado");
            con.close();
        }catch(Exception ex){
            System.out.println("Error al eliminar el empleado");
            System.out.println(ex.getMessage());
        }
        return estado;
    }
    
    public static int actualizarEmpleado(Empleado e){
        int estado=0;
        try{
            Connection con=Conexion.getConnection();
            String q="update empleado set nombre=?,password=?,email=?,pais=? where id=? ";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,e.getNombre());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getPais());
            ps.setInt(5,e.getId());
            estado=ps.executeUpdate();
            System.out.println("Se elimino al empleado");
            con.close();
        }catch(Exception ex){
            System.out.println("Error al eliminar el empleado");
            System.out.println(ex.getMessage());
        }
        return estado;
    }
}
