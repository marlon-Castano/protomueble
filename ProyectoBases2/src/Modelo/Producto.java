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
    private int ID_cliente;
    private String Color;
    private int cantidad;
    private int Precio;
    private String material;
    private String tipo;
    private String nombre;

    public Producto() {
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

    public Producto(String dimension, int ID_P, int ID_cliente, String Color, int cantidad, int Precio, String material, String tipo) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.ID_cliente = ID_cliente;
        this.Color = Color;
        this.cantidad = cantidad;
        this.Precio = Precio;
        this.material = material;
        this.tipo = tipo;
    }

    public Producto(int ID_cliente,String dimension, int cantidad, int Precio) {
        this.dimension = dimension;
        this.ID_cliente = ID_cliente;
        this.cantidad = cantidad;
        this.Precio = Precio;
    }

    public Producto(int ID_P, int ID_cliente,String dimension, int cantidad, int Precio) {
        this.dimension = dimension;
        this.ID_P = ID_P;
        this.ID_cliente = ID_cliente;
        this.cantidad = cantidad;
        this.Precio = Precio;
    }

    
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    
    public Producto(int ID_P, int ID_cliente, String Color, int cantidad, int Precio, String material, String tipo) {
        this.ID_P = ID_P;
        this.ID_cliente = ID_cliente;
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

    public Producto(int ID_P, int ID_cliente) {
        this.ID_P = ID_P;
        this.ID_cliente = ID_cliente;
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

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
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
        return "producto{" + "dimension=" + dimension + ", ID_P=" + ID_P + ", ID_cliente=" + ID_cliente + ", Color=" + Color + ", cantidad=" + cantidad + ", Precio=" + Precio + ", material=" + material + ", tipo=" + tipo + '}';
    }
    
    
    
    
     
}
