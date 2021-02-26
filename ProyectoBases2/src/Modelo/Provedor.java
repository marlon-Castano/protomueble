/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class Provedor {
    private int ID_PR;
    private String nombre;
    private String direcion;
    private String contacto;
    private String telefono;
    private String cantidad;

    public Provedor() {
    }

   
    public Provedor(int ID_PR) {
        this.ID_PR = ID_PR;
    }

    public Provedor(String telefono) {
        this.telefono = telefono;
    }

    
    public Provedor(int ID_PR, String nombre, String direcion, String contacto, String telefono) {
        this.ID_PR = ID_PR;
        this.nombre = nombre;
        this.direcion = direcion;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    public Provedor(int ID_PR, String nombre, String direcion, String contacto) {
        this.ID_PR = ID_PR;
        this.nombre = nombre;
        this.direcion = direcion;
        this.contacto = contacto;
    }

    
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    

    public int getID_PR() {
        return ID_PR;
    }

    public void setID_PR(int ID_PR) {
        this.ID_PR = ID_PR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
