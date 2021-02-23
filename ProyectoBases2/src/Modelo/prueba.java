/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates1
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alche
 */
public class prueba {
    
    public static void main(String[] args) {
    FacadeCliente obj = new FacadeCliente();
    cliente ob = new cliente();
    
   
    ob.setIdentificacion(1);
        System.out.println(obj.verCliente(ob).toString());
    }
  
    
    
    
    
    
}
