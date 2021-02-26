/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Julian
 */
public class factura {
    
    private  int ID_factu;
    private int ID_vendedor;
    private int ID_cliente;
    private int ID_P;
    private boolean envio;
    private int precio_total;
    private Date fecha;

 public factura() {
  }

    public void facturas(int ID_vendedor, int ID_cliente, int ID_P, boolean envio, int precio_total, Date fecha) {
        this.ID_vendedor = ID_vendedor;
        this.ID_cliente = ID_cliente;
        this.ID_P = ID_P;
        this.envio = envio;
        this.precio_total = precio_total;
        this.fecha = fecha;
    }

    public int getID_P() {
        return ID_P;
    }

    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }

    public int getID_vendedor() {
        return ID_vendedor;
    }

    public void setID_vendedor(int ID_vendedor) {
        this.ID_vendedor = ID_vendedor;
    }

    public factura(int ID_vendedor,int id_cliente, boolean envio, int precio_total, Date fecha) {
        this.ID_vendedor= ID_vendedor;
        this.ID_cliente=id_cliente;
        this.envio = envio;
        this.precio_total = precio_total;
        this.fecha = fecha;
    }

    public factura(int ID_factu, int ID_vendedor, int ID_cliente, boolean envio, int precio_total, Date fecha) {
        this.ID_factu = ID_factu;
        this.ID_vendedor = ID_vendedor;
        this.ID_cliente = ID_cliente;
        this.envio = envio;
        this.precio_total = precio_total;
        this.fecha = fecha;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public int getID_factu() {
        return ID_factu;
    }

    public void setID_factu(int ID_factu) {
        this.ID_factu = ID_factu;
    }

    public boolean isEnvio() {
        return envio;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return  ""+ID_factu;
    }
 
 
    
    
    
}
