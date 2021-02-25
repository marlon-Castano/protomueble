/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alche
 */
public class Vendedor {
    int ID;
    int ID_factura=0;
    String Clave;
    String Correo;
    String Nombre;

    public Vendedor() {
    }

    public Vendedor(int ID,String Nombre,String Correo,String Clave ) {
        this.ID = ID;
        this.Clave = Clave;
        this.Correo = Correo;
        this.Nombre = Nombre;
    }

    
    public Vendedor(int ID, int ID_factura, String Clave, String Correo, String Nombre) {
        this.ID = ID;
        this.ID_factura = ID_factura;
        this.Clave = Clave;
        this.Correo = Correo;
        this.Nombre = Nombre;
    }

    public Vendedor(String Clave, String Correo) {
        this.Clave = Clave;
        this.Correo = Correo;
    }

    public Vendedor(int ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public Vendedor(String Correo) {
        this.Correo = Correo;
    }
    
    public Vendedor(String Clave, String Correo, String Nombre) {
        this.Clave = Clave;
        this.Correo = Correo;
        this.Nombre = Nombre;
    }

    public Vendedor(int ID, int ID_factura) {
        this.ID = ID;
        this.ID_factura = ID_factura;
    }

    public Vendedor(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_factura() {
        return ID_factura;
    }

    public void setID_factura(int ID_factura) {
        this.ID_factura = ID_factura;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    
    
    
    
}
