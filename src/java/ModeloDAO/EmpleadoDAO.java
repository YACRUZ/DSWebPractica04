/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author yacruz
 */
public class EmpleadoDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado p=new Empleado();
    
    @Override
    public List listar() {
        ArrayList<Empleado>list=new ArrayList<>();
        String sql="select * from empleado";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado per=new Empleado();
                per.setClave(rs.getInt("clave"));
                per.setNombre(rs.getString("nombre"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getInt("telefono"));
                list.add(per);
            }
        } catch (Exception e) {
            Logger.getLogger("Error al listar");
        }
        return list;
    }

    @Override
    public Empleado list(int clave) {
        String sql="select * from empleado where clave="+clave;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setClave(rs.getInt("clave"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getInt("telefono"));
                
            }
        } catch (Exception e) {
            Logger.getLogger("Error al listar empleado");
        }
        return p;
    }

    @Override
    public boolean add(Empleado per) {
       String sql="insert into empleado(calve, nombre, direccion, telefono)values"
               + "('"+per.getClave()+"','"+per.getNombre()+"','"+per.getDireccion()+"','"+per.getTelefono()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger("Error al agregar empleado");
        }
       return false;
    }

    @Override
    public boolean edit(Empleado per) {
        String sql="update persona set nombre='"+per.getNombre()+"',direccion='"+per.getDireccion()+"',telefono='"+per.getTelefono()+"'where clave="+per.getClave();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger("Error al editar empleado");
        }
        return false;
    }

    @Override
    public boolean eliminar(int clave) {
        String sql="delete from empleado where clave="+clave;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger("Error al eliminar empleado");
        }
        return false;
    }
}
