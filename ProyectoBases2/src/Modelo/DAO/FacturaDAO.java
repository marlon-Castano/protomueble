package Modelo.DAO;

import Modelo.conexion;
import Modelo.factura;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class FacturaDAO {

    private static final String SQL_READ_ALL = "SELECT * FROM factura";
    private static final String SQL_READ_INFO = "select factura.*,  vendedor.nombre as vendedor, producto.nombre as producto\n"
            + "from factura INNER JOIN vendedor ON vendedor.ID=factura.ID_vendedor \n"
            + "INNER JOIN producto ON producto.ID_P=factura.ID_P \n"
            + "where vendedor.ID=vendedor.ID";
    private static final String SQL_INSERT = "INSERT INTO factura (ID_factu,ID_vendedor,ID_cliente, envio, precio_total, fecha,ID_P) VALUES (null,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM factura WHERE ID_factu = ?";
    private static final String SQL_UPDATE = "UPDATE factura set  envio =?, precio_total =?, fecha =? WHERE ID_factu = ?";
    private static final String SQL_READ = "SELECT * FROM factura where ID_factu = ?";

    private Connection con = conexion.obtenerConexion();

    public factura read(factura filtro) {
        factura objres = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getID_factu());
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres = new factura(rs.getInt("ID_factu"), rs.getInt("ID_vendedor"), rs.getInt("ID_cliente"), rs.getBoolean("envio"), rs.getInt("precio_total"), rs.getDate("fecha"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar la factura: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }

    public boolean insert(factura c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getID_vendedor());
            ps.setInt(2, c.getID_cliente());
            ps.setBoolean(3, c.isEnvio());
            ps.setInt(4, c.getPrecio_total());
            ps.setDate(5, c.getFecha());
            ps.setInt(6, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear factura: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean update(factura c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setBoolean(1, c.isEnvio());
            ps.setInt(2, c.getPrecio_total());
            ps.setDate(3, c.getFecha());
            ps.setInt(4, c.getID_factu());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error no se pudo actualizar factura: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public List<factura> getfactura() {
        List<factura> listProductos = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ_ALL);
                ResultSet rs = psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                    factura aux = new factura(rs.getInt("ID_factu"), rs.getInt("ID_vendedor"), rs.getInt("ID_cliente"), rs.getBoolean("envio"), rs.getInt("precio_total"), rs.getDate("fecha"));
                    listProductos.add(aux);
                }
            } catch (SQLException ex) {
                System.out.println("Error obtener facturas: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return listProductos;
    }

    public List<String> getInfo() {
        List<String> listProductos = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ_INFO);
                ResultSet rs = psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                    String aux =""+rs.getInt("ID_factu")+","+rs.getBoolean("envio")+","+rs.getInt("precio_total")+
                            ","+rs.getString("fecha")+","+rs.getString("vendedor")+","+rs.getString("producto");
                    listProductos.add(aux);
                }
            } catch (SQLException ex) {
                System.out.println("Error obtener facturas: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return listProductos;
    }

}


