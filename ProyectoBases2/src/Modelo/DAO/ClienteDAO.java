package Modelo.DAO;


import Modelo.cliente;
import Modelo.conexion;
import java.awt.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *identificacion nombre correo direccion 
 * @author alche
 */
public class ClienteDAO {
    private static final String SQL_READ_ALL="SELECT * FROM cliente";
    private static final String SQL_INSERT="INSERT INTO cliente (Identificacion, nombre, correo, direccion) VALUES (?,?,?,?)";
    private static final String SQL_DELETE="DELETE FROM cliente WHERE Identificacion = ?";
    private static final String SQL_UPDATE="UPDATE cliente set  nombre= ?, correo =?, direccion =? WHERE Identificacion = ?";
    private static final String SQL_READ="SELECT * FROM cliente where Identificacion = ?";
    private static final String SQL_TELEFONO="SELECT * FROM cliente_telefono WHERE Identificacion = ?";
    private static final String SQL_DELETE_TELEFONO="DELETE FROM cliente_telefono WHERE Identificacion = ?";
    private static final String SQL_UPDATE_TELEFONO="UPDATE cliente_telefono set Telefono= ? WHERE Identificacion = ?";
    
    private Connection con= conexion.obtenerConexion();
    
    
    public cliente read(cliente filtro){
        cliente objres= null;
        if(con!=null){
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getIdentificacion());
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    objres = new cliente(rs.getInt("Identificacion"),rs.getString("nombre"),rs.getString("correo"),rs.getString("direccion"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el cliente: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
            
        }
        return objres;
    }
    
    public boolean insert(cliente c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getIdentificacion());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getDireccion());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear cliente: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }
    
    public boolean delete(cliente item){
        PreparedStatement ps;
        try {
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getIdentificacion());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Produto: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }
    
     public boolean update(cliente item){
     PreparedStatement ps;
     try {
           ps=con.prepareStatement(SQL_UPDATE);
           
           ps.setString(1, item.getNombre());
           ps.setString(2, item.getCorreo());
           ps.setString(3, item.getDireccion());
           ps.setInt(4, item.getIdentificacion());
           if(ps.executeUpdate()>0){
               return true;
           }
       } catch (SQLException ex) {
           System.out.println("ERROR AL ACTUALIZAR"+ ex.getMessage());
       }finally{
         conexion.cerrarConexion();
     }
     return false;
     
 }
     
    public ArrayList<cliente> READALL (){
         ArrayList<cliente> lst= null;
     PreparedStatement psnt;
     try {
           psnt=con.prepareStatement(SQL_READ_ALL);
           ResultSet rs= psnt.executeQuery();
           lst= new ArrayList<>();
           while( rs.next()){
               cliente obj =new cliente(rs.getInt("Identificacion"), 
               rs.getString("nombre"),
               rs.getString("correo"),
               rs.getString("direccion"));
            lst.add(obj);
                
           }
       } catch (SQLException ex) {
           Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
       } finally{
           conexion.cerrarConexion();
       }
           
     return lst;
        
    }
 
    public cliente readTelefono(cliente filtro){
        cliente objres= null;
        if(con!=null){
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_TELEFONO);
                psmt.setInt(1, filtro.getIdentificacion());
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    objres = new cliente(rs.getString("telefono"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el cliente: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
            
        }
        return objres;
    }
    
     public boolean deleteTelefono(cliente item){
        PreparedStatement ps;
        try {
            ps= con.prepareStatement(SQL_DELETE_TELEFONO);
            ps.setInt(1, item.getIdentificacion());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Produto: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }
     
     
     public boolean updateTelefono(cliente item){
     PreparedStatement ps;
     try {
           ps=con.prepareStatement(SQL_UPDATE_TELEFONO);
           
           ps.setString(1, item.getTelefono());
           ps.setInt(2, item.getIdentificacion());
           if(ps.executeUpdate()>0){
               return true;
           }
       } catch (SQLException ex) {
           System.out.println("ERROR AL ACTUALIZAR"+ ex.getMessage());
       }finally{
         conexion.cerrarConexion();
     }
     return false;
     
 }
}


