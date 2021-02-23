/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class cliente {
    
    private int Identificacion;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    
    public cliente(String telefono) {
        this.telefono = telefono;
    }

    public cliente(int Identificacion, String nombre, String correo, String direccion) {
        this.Identificacion = Identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
    }

    public cliente() {
    }

    public cliente(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "cliente{" + "Identificacion=" + Identificacion + ", nombre=" + nombre + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }


    
}
