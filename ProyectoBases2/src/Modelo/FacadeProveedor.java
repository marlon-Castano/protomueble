/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.ProvedorDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeProveedor {
    
    public boolean CrearProveedor(Provedor objP){
        boolean rta=false;
        if(objP !=null){
            ProvedorDAO dao= new ProvedorDAO();
            rta= dao.insert(objP);
        }
        return rta;
    }
    
    public List<Provedor> ListarProvedores(){
        List<Provedor> lst= null;
        ProvedorDAO dao= new ProvedorDAO();
        lst=dao.READALL();
        return lst;
    }
    
    public Provedor verProvedor(Provedor item){
        Provedor dto;
        ProvedorDAO dao = new ProvedorDAO();
        dto=dao.read(item);
        
        return dto;
    }
    
    public boolean ActualizarProvedor (Provedor actual){
      boolean rta=false;
      if(actual!=null){
          ProvedorDAO dao= new ProvedorDAO();
          rta=dao.update(actual);
      }
      
        return rta;
    }
    
    public boolean EliminarProvedor(Provedor eliminar){
        boolean rta=false;
        ProvedorDAO dao = new ProvedorDAO();
        rta=dao.delete(eliminar);
        
        return rta;
    }
    
     public boolean CrearTelefono(Provedor objP){
        boolean rta=false;
        if(objP !=null){
            ProvedorDAO dao= new ProvedorDAO();
            rta= dao.insertTelefono(objP);
        }
        return rta;
    }
     
     public Provedor verTelefono(Provedor item){
        Provedor dto;
        ProvedorDAO dao = new ProvedorDAO();
        dto=dao.readTelefono(item);
        
        return dto;
    }
     
      public boolean EliminarTelefono(Provedor eliminar){
        boolean rta=false;
        ProvedorDAO dao = new ProvedorDAO();
        rta=dao.updateTelefono(eliminar);
        
        return rta;
    }
    
     public boolean ActualizarTelefono (Provedor actual){
      boolean rta=false;
      if(actual!=null){
          ProvedorDAO dao= new ProvedorDAO();
          rta=dao.updateTelefono(actual);
      }
      
        return rta;
    }
    
}
