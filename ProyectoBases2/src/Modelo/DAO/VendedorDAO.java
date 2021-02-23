package Modelo.DAO;

import Modelo.Vendedor;
import Modelo.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class VendedorDAO {
 private static final String SQL_READ_ALL="SELECT * FROM vendedor";
    private static final String SQL_INSERT="INSERT INTO vendedor (ID,ID_factura, nombre) VALUES (?,?,?)";
    private static final String SQL_DELETE="DELETE FROM vendedor WHERE ID = ?";
    private static final String SQL_UPDATE="UPDATE vendedor set  ID_factura= ?, nombre =? WHERE ID = ?";
    private static final String SQL_READ="SELECT * FROM vendedor where ID = ?";
    private static final String SQL_INSERT_Login="INSERT INTO login (ID_VENDEDOR, calve,correo) VALUES (?,?,?)";
    private static final String SQL_VERIFICAR_LOGIN="SELECT * FROM login WHERE correo = ?";
    
    
    private Connection con= conexion.obtenerConexion();
    
    
    public Vendedor read(Vendedor filtro){
        Vendedor objres= null;
        if(con!=null){
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getID());
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    objres = new Vendedor(rs.getInt("ID"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
            
        }
        return objres;
    }
    
     public boolean insert(Vendedor c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getID());
            ps.setInt(2, c.getID_factura());
            ps.setString(3, c.getNombre());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }
    
        public List<Vendedor> getVendedores(){
        List<Vendedor> listProductos=null;
        if (con!=null) {
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ_ALL);
                ResultSet rs= psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                    Vendedor aux= new  Vendedor(rs.getInt("ID"), rs.getString("nombre"));
                    listProductos.add(aux);
                }   
            } catch (SQLException ex) {
                System.out.println("Error obtener productos: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
        }
        return listProductos;
    }
    
    public boolean delete(Vendedor item){
        PreparedStatement ps;
        try {
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getID());
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
    public boolean update(Vendedor item){
        PreparedStatement ps;
        try {
            ps=con.prepareStatement(SQL_UPDATE);
            ps.setInt(1, item.getID_factura());
            ps.setString(2, item.getNombre());
            ps.setInt(3, item.getID());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               conexion.cerrarConexion();
        }
        return false;
    }
    
    public boolean insertLogin(Vendedor c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT_Login);
            ps.setInt(1, c.getID());
            ps.setString(2, c.getClave());
            ps.setString(3, c.getCorreo());
            
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al crear login: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return false;
    }
    
    public Vendedor VerificarLogin(Vendedor c){
        PreparedStatement ps;
        ResultSet rs = null;
         try {
           ps= con.prepareStatement(SQL_VERIFICAR_LOGIN);
           ps.setString(1, c.getCorreo());
           
           rs=ps.executeQuery();
           
           if(rs.next()){
               
               if(c.getClave().equals(rs.getString(3))){
                   c.setID(rs.getInt(1));
                   conexion.cerrarConexion();
                   return c;
               }else{
                   conexion.cerrarConexion();
                   return null;
               }
           }
           
           
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return null;
    }
}

