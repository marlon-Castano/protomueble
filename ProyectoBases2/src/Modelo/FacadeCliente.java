/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.ClienteDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeCliente {
    
    public boolean CrearCliente(cliente objP){
        boolean rta=false;
        if(objP !=null){
            ClienteDAO dao= new ClienteDAO();
            rta= dao.insert(objP);
        }
        return rta;
    }
    
    public List<cliente> ListarClientes(){
        List<cliente> lst= null;
        ClienteDAO dao= new ClienteDAO();
        lst=dao.READALL();
        return lst;
    }
    
    public cliente verCliente(cliente item){
        cliente dto;
        ClienteDAO dao = new ClienteDAO();
        dto=dao.read(item);
        
        return dto;
    }
    
    public boolean ActualizarCliente (cliente actual){
      boolean rta=false;
      if(actual!=null){
          ClienteDAO dao= new ClienteDAO();
          rta=dao.update(actual);
      }
      
        return rta;
    }
    
    public boolean EliminarCliente(cliente eliminar){
        boolean rta=false;
        ClienteDAO dao = new ClienteDAO();
        rta=dao.delete(eliminar);
        
        return rta;
    }
    
    public cliente verTelefono(cliente item){
        cliente dto;
        ClienteDAO dao = new ClienteDAO();
        dto=dao.readTelefono(item);
        
        return dto;
    }
    
    public boolean EliminarTelefono(cliente eliminar){
        boolean rta=false;
        ClienteDAO dao = new ClienteDAO();
        rta=dao.updateTelefono(eliminar);
        
        return rta;
    }
    
     public boolean ActualizarTelefono (cliente actual){
      boolean rta=false;
      if(actual!=null){
          ClienteDAO dao= new ClienteDAO();
          rta=dao.updateTelefono(actual);
      }
      
        return rta;
    }
    
}
