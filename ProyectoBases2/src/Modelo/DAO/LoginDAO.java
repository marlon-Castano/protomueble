/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Vendedor;
import Modelo.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class LoginDAO {

    private static final String SQL_INSERT_Login = "INSERT INTO login (ID_VENDEDOR, clave,correo) VALUES (?,?,?)";
    private static final String SQL_UPDATE_Login = "UPDATE login set correo = ?, clave =? WHERE ID_VENDEDOR = ?";
    private static final String SQL_READ_ADMIN= "SELECT * FROM administrador   where clave=? AND correo=?";
    private Connection con = conexion.obtenerConexion();

    public boolean insertLogin(Vendedor c) {
        PreparedStatement ps;
        if (con != null) {
            try {
                ps = con.prepareStatement(SQL_INSERT_Login);
                ps.setInt(1, c.getID());
                ps.setString(2, c.getClave());
                ps.setString(3, c.getCorreo());

                if (ps.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Error al crear login: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return false;
        
        
    }
    
    public boolean update_Login(Vendedor item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_Login);
            ps.setString(1, item.getCorreo());
            ps.setString(2, item.getClave());
            ps.setInt(3, item.getID());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
    public boolean READAdministrador(String clave, String correo) {
        PreparedStatement ps;
        if (con != null) {
            try {
                ps = con.prepareStatement(SQL_READ_ADMIN);
                ps.setString(1, clave);
                ps.setString(2, correo);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Error al crear login: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return false;
        
        
    }
}
