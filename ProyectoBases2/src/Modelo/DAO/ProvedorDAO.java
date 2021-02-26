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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian
 */
public class ProvedorDAO {

    private static final String SQL_READ_ALL = "SELECT * FROM proveedor ";
    private static final String SQL_READ_INFO = "select proveedor.*,  provedor_telefono.Telefono \n"
            + "from proveedor INNER JOIN provedor_telefono ON provedor_telefono.ID_PR=proveedor.ID_PR \n"
            + "where proveedor.ID_PR=proveedor.ID_PR";
    private static final String SQL_INSERT = "INSERT INTO proveedor (ID_PR, direccion, nombre, contacto) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedor set  direccion= ?, nombre =?, contacto =? WHERE ID_PR = ?";
    private static final String SQL_READ = "SELECT * FROM provedor where ID_PR = ?";
    private static final String SQL_INSERT_TELEFONO = "INSERT INTO provedor_telefono (ID_PR, Telefono )  VALUES (?,?) ";
    private static final String SQL_TELEFONO = "SELECT * FROM provedor_telefono WHERE ID_PR = ?";
    private static final String SQL_DELETE_TELEFONO = "DELETE FROM provedor_telefono WHERE ID_PR = ?";
    private static final String SQL_UPDATE_TELEFONO = "UPDATE provedor_telefono set Telefono= ? WHERE ID_PR = ?";
    private static final String SQL_DELETE = "DELETE FROM provedor WHERE ID_PR = ?";

    private Connection con = conexion.obtenerConexion();

    public boolean insert(Provedor c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getID_PR());
            ps.setString(2, c.getDirecion());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getContacto());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear proveedor: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean update(Provedor item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, item.getDirecion());
            ps.setString(2, item.getNombre());
            ps.setString(3, item.getContacto());
            ps.setInt(4, item.getID_PR());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR PROVEEDOR" + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;

    }

    public boolean delete(Provedor item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getID_PR());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Produto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public Provedor read(Provedor filtro) {
        Provedor objres = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getID_PR());
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres = new Provedor(rs.getInt("ID_PR"), rs.getString("direccion"), rs.getString("nombre"), rs.getString("contacto"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el proveedor: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }

    public Provedor readTelefono(Provedor filtro) {
        Provedor objres = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_TELEFONO);
                psmt.setInt(1, filtro.getID_PR());
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres = new Provedor(rs.getString("telefono"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el proveedor: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }

    public ArrayList<Provedor> READALL() {
        ArrayList<Provedor> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.prepareStatement(SQL_READ_ALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                Provedor obj = new Provedor(rs.getInt("ID_PR"),
                        rs.getString("direccion"),
                        rs.getString("nombre"),
                        rs.getString("contacto"));
                lst.add(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Provedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }

        return lst;

    }

    public ArrayList<Provedor> READINFO() {
        ArrayList<Provedor> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.prepareStatement(SQL_READ_INFO);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while (rs.next()) {
                Provedor obj = new Provedor(rs.getInt("ID_PR"),
                        rs.getString("direccion"),
                        rs.getString("nombre"),
                        rs.getString("contacto")
                        );
                obj.setTelefono(rs.getString("Telefono"));
                lst.add(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Provedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }

        return lst;

    }

    public boolean insertTelefono(Provedor c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT_TELEFONO);
            ps.setInt(1, c.getID_PR());
            ps.setString(2, c.getTelefono());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear  telefono proveedor: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean deleteTelefono(Provedor item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE_TELEFONO);
            ps.setInt(1, item.getID_PR());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Telefono del proveedor: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean updateTelefono(Provedor item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_TELEFONO);

            ps.setString(1, item.getTelefono());
            ps.setInt(2, item.getID_PR());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR" + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;

    }

}
