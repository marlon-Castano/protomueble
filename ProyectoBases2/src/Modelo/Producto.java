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
public class Producto {
    private String dimension;
    private int ID_P;
    private int ID_PR;
    private String Color;
    private int cantidad;
    private int Precio;
    private String material;
    private String tipo;
    private String nombre;
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Producto(String dimension, int ID_P, String Color, int cantidad, int Precio, String material, String tipo, String nombre, boolean estado) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
        this.nombre = nombre;
        this.estado=estado;
    }

    public Producto() {
    }

    public Producto(String dimension, int ID_P, String Color, int cantidad, int Precio, String material, String tipo, String nombre) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Producto(String dimension, int ID_P, int Precio, String nombre) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.Precio = Precio;
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String dimension, int ID_P, int ID_PR, String Color, int cantidad, int Precio, String material, String tipo) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.ID_PR = ID_PR;
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
    }

    public Producto(int ID_PR,String dimension, int cantidad, int Precio) {
        this.dimension = dimension;
        this.ID_PR = ID_PR;
        this.cantidad = cantidad;
        this.Precio = Precio;
    }

    public Producto(int ID_P, int ID_PR,String dimension, int cantidad, int Precio) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.ID_PR = ID_PR;
        this.cantidad = cantidad;
        this.Precio = Precio;
    }

    
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    
    public Producto(int ID_P, int ID_PR, String Color, int cantidad, int Precio, String material, String tipo) {
        this.ID_P = ID_P;
        this.ID_PR = ID_PR;
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
    }

    public Producto(String Color, int cantidad, int Precio, String material, String tipo) {
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
    }

    public Producto(int ID_P, int ID_PR) {
        this.ID_P = ID_P;
        this.ID_PR = ID_PR;
    }

    public Producto(int ID_P) {
        this.ID_P = ID_P;
    }

    
    public int getID_P() {
        return ID_P;
    }

    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }

    public int getID_PR() {
        return ID_PR;
    }

    public void setID_PR(int ID_PR) {
        this.ID_PR = ID_PR;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
    
     
}
