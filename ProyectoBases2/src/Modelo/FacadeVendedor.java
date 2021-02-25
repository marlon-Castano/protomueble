/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.VendedorDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeVendedor {
    
   
    
    public List<Vendedor> ListarVendedor(){
        List<Vendedor> lst= null;
        VendedorDAO dao= new VendedorDAO();
        lst=dao.getVendedores();
        return lst;
    }
    
    public boolean Crearvendedor(Vendedor objP){
        boolean rta=false;
        if(objP !=null){
            VendedorDAO dao= new VendedorDAO();
            rta=dao.insert(objP);
            
        }
        return rta;
    }
    
  
    
    public Vendedor verCliente(Vendedor item){
        Vendedor dto;
        VendedorDAO dao = new VendedorDAO();
        dto=dao.read(item);
        
        return dto;
    }
    
    public boolean ActualizarVendedor (Vendedor actual){
      boolean rta=false;
      if(actual!=null){
          VendedorDAO dao= new VendedorDAO();
          rta=dao.update(actual);
          if(rta){
              rta=dao.updateLogin(actual);
          }
      }
      
        return rta;
    }
    
    public boolean EliminarCliente(Vendedor eliminar){
        boolean rta=false;
        VendedorDAO dao = new VendedorDAO();
        rta=dao.delete(eliminar);
        
        return rta;
    }
    
  
}
