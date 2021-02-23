/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.ProductoDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeProducto {
    
    public boolean CrearProducto(Producto objP){
        boolean rta=false;
        if(objP !=null){
            ProductoDAO dao= new ProductoDAO();
            rta= dao.insert(objP);
        }
        return rta;
    }
    
    public List<Producto> ListarProductos(){
        List<Producto> lst= null;
        ProductoDAO dao= new ProductoDAO();
        lst=dao.getProducto();
        return lst;
    }
    
    public Producto verProducto(Producto item){
        Producto dto;
        ProductoDAO dao = new ProductoDAO();
        dto=dao.read(item);
        
        return dto;
    }
    public Producto verProductoNombre(String item){
        Producto dto;
        ProductoDAO dao = new ProductoDAO();
        dto=dao.readNombre(item);
        
        return dto;
    }
    
  
    public boolean EliminarProducto(Producto eliminar){
        boolean rta=false;
        ProductoDAO dao = new ProductoDAO();
        rta=dao.delete(eliminar);
        
        return rta;
    }
    
  
}
