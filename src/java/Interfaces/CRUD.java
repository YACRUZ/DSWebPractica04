/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Empleado;
import java.util.List;

/**
 *
 * @author yacruz
 */
public interface CRUD {
    public List listar();
    public Empleado list(int clave);
    public boolean add(Empleado emp);
    public boolean edit(Empleado emp);
    public boolean eliminar(int clave);
}
