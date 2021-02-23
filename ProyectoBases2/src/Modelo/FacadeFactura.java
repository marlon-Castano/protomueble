/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.FacturaDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeFactura {
    
     public boolean CrearFactura(factura objP){
        boolean rta=false;
        if(objP !=null){
            FacturaDAO dao= new FacturaDAO();
            rta= dao.insert(objP);
        }
        return rta;
    }
    
    public List<factura> TraerFactura(){
        List<factura> lst= null;
        FacturaDAO dao= new FacturaDAO();
        lst=dao.getfactura();
        return lst;
    }
    
    public factura verFactura(factura item){
        factura dto;
        FacturaDAO dao = new FacturaDAO();
        dto=dao.read(item);
        
        return dto;
    }
    
    public boolean ActualizarFactura (factura actual){
      boolean rta=false;
      if(actual!=null){
          FacturaDAO dao= new FacturaDAO();
          rta=dao.update(actual);
      }
      
        return rta;
    }
    
   
    
    
}
