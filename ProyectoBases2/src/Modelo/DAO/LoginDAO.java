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
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class LoginDAO {

    private static final String SQL_INSERT_Login = "INSERT INTO login (ID_VENDEDOR, clave,correo) VALUES (?,?,?)";
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
}
