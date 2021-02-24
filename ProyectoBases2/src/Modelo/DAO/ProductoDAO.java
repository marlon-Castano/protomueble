/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Producto;
import Modelo.Provedor;
import Modelo.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProductoDAO {
    private static final String SQL_READ_ALL="SELECT * FROM producto ";
    private static final String SQL_INSERT="INSERT INTO producto (ID_P, dimension, precio,nombre) VALUES (?,?,?,?)";
    private static final String SQL_DELETE="DELETE FROM producto WHERE ID_P = ?";
    private static final String SQL_UPDATE="UPDATE producto set ID_cliente=?, dimension=?, cantidad=?, precio=?  ID_ WHERE ID_P= ?";
    private static final String SQL_READ="SELECT * FROM producto where ID_P = ?";
    private static final String SQL_READ_Nombre="SELECT * FROM producto where nombre = ?";
    private static final String SQL_INSERT_Login="INSERT INTO login (ID_VENDEDOR, calve,correo) VALUES (?,?,?)";
    private static  final String SQL_INSERT_COLOR="INSERT INTO color (ID_color,ID_p,color) VALUES (null,?,?)";
    private static  final String SQL_INSERT_MATERIAL="INSERT INTO material (ID_material,ID_p,material) VALUES (null,?,?)";
    private static  final String SQL_INSERT_TIPO="INSERT INTO tipo (ID_tipo,ID_p,tipo) VALUES (null,?,?)";
    private static  final String SQL_INSERT_distribuye="INSERT INTO distribuye VALUES (?,?,?)";
    
    
    private Connection con= conexion.obtenerConexion();
    
        public Producto read(Producto filtro){
        Producto objres= null;
        if(con!=null){
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getID_P());
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    objres = new Producto(rs.getString("dimension"), rs.getInt("ID_P"),  rs.getInt("precio"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
            
        }
        return objres;
    }
        
        public Producto readNombre(String nombre){
        Producto objres= null;
        if(con!=null){
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ_Nombre);
                psmt.setString(1,nombre);
                ResultSet rs= psmt.executeQuery();
                if(rs.next()){
                    objres = new Producto(rs.getString("dimension"), rs.getInt("ID_P"),  rs.getInt("precio"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: "+ex.getMessage());
            }finally{
                conexion.cerrarConexion();
            }
            
        }
        return objres;
    }
        
    
   public boolean insert(Producto c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getDimension());
            ps.setInt(3, c.getPrecio());
            ps.setString(4, c.getNombre());
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
   public boolean insertColor(Producto c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT_COLOR);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getColor());
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
   public boolean insertMaterial(Producto c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT_MATERIAL);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getMaterial());
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
   public boolean insertTipo(Producto c){
        PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT_TIPO);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getTipo());
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
   public boolean distrubuye(Producto p, Provedor po){
               PreparedStatement ps;
         try {
            ps= con.prepareStatement(SQL_INSERT_distribuye);
            ps.setInt(1, po.getID_PR());
            ps.setInt(2, p.getID_P());
            ps.setInt(3, p.getCantidad());
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
   
    public List<Producto> getProducto(){
        List<Producto> listProductos=null;
        if (con!=null) {
            PreparedStatement psmt;
            try {
                psmt= con.prepareStatement(SQL_READ_ALL);
                ResultSet rs= psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                    Producto aux= new  Producto(rs.getString("dimension"), rs.getInt("ID_P"),  rs.getInt("precio"), rs.getString("nombre"));
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
    
    public boolean delete(Producto item){
        PreparedStatement ps;
        try {
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getID_P());
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
            
    
}
