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

    private static final String SQL_READ_ALL = "SELECT * FROM producto ";
    private static final String SQL_INSERT = "INSERT INTO producto (ID_P, dimension, precio,nombre,estado) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE ID_P = ?";
    private static final String SQL_DELETE_COLOR = "DELETE FROM color WHERE ID_p = ?";
    private static final String SQL_DELETE_MATERIAL = "DELETE FROM material WHERE ID_p = ?";
    private static final String SQL_DELETE_TIPO = "DELETE FROM tipo WHERE ID_p = ?";
    private static final String SQL_DELETE_DISTRIBULLE = "DELETE FROM distribuye WHERE ID_p = ?";
    private static final String SQL_UPDATE = "UPDATE producto set nombre=?, dimension=?, precio=? WHERE ID_P= ?";
    private static final String SQL_UPDATE_ESTADO = "UPDATE producto set estado=? WHERE ID_P= ?";
    private static final String SQL_UPDATE_COLOR = "UPDATE color set color=? WHERE ID_P= ?";
    private static final String SQL_UPDATE_TIPO = "UPDATE tipo set tipo=? WHERE ID_P= ?";
    private static final String SQL_UPDATE_MATERIAL = "UPDATE material set material=? WHERE ID_P= ?";
     private static final String SQL_UPDATE_DISTRUBULLE= "UPDATE distribuye set cantidad=? WHERE ID_P= ?";
    private static final String SQL_READ = "SELECT * FROM producto where ID_P = ?";
    private static final String SQL_READ_Nombre = "SELECT * FROM producto where nombre = ?";
    private static final String SQL_INSERT_Login = "INSERT INTO login (ID_VENDEDOR, calve,correo) VALUES (?,?,?)";
    private static final String SQL_INSERT_COLOR = "INSERT INTO color (ID_color,ID_p,color) VALUES (null,?,?)";
    private static final String SQL_INSERT_MATERIAL = "INSERT INTO material (ID_material,ID_p,material) VALUES (null,?,?)";
    private static final String SQL_INSERT_TIPO = "INSERT INTO tipo (ID_tipo,ID_p,tipo) VALUES (null,?,?)";
    private static final String SQL_INSERT_distribuye = "INSERT INTO distribuye VALUES (?,?,?)";
    private static final String SQL_INSERT_buscar = "select producto.*, color.color, material.material, tipo.tipo, distribuye.cantidad \n"
            + "from producto INNER JOIN color ON color.ID_P=producto.ID_P \n"
            + "INNER JOIN material ON material.ID_P=producto.ID_P \n"
            + "INNER JOIN tipo ON tipo.ID_P=producto.ID_P \n"
            + "INNER JOIN distribuye ON distribuye.ID_P=producto.ID_P where producto.ID_P=?";
    private static final String SQL_READ_ALL_INFO = "select producto.*, color.color, material.material, tipo.tipo, distribuye.cantidad \n"
            + "from producto INNER JOIN color ON color.ID_P=producto.ID_P \n"
            + "INNER JOIN material ON material.ID_P=producto.ID_P \n"
            + "INNER JOIN tipo ON tipo.ID_P=producto.ID_P \n"
            + "INNER JOIN distribuye ON distribuye.ID_P=producto.ID_P where producto.ID_P=producto.ID_P";

    private Connection con = conexion.obtenerConexion();

    public Producto read(Producto filtro) {
        Producto objres = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ);
                psmt.setInt(1, filtro.getID_P());
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres = new Producto(rs.getString("dimension"), rs.getInt("ID_P"), rs.getInt("precio"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }

    public String caracteriscas(Producto p) {
        String objres ="";
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_INSERT_buscar);
                psmt.setInt(1, p.getID_P());
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres="<html> ID: "+rs.getString("ID_P")+" <p> ";
                    objres=objres+"Dimensiones: "+rs.getString("dimension")+" <p> ";
                    objres=objres+"Precio: "+rs.getString("precio")+" <p> ";
                    objres=objres+"Nombre: "+rs.getString("nombre")+" <p> ";
                    objres=objres+"Color: "+rs.getString("color")+" <p> ";
                    objres=objres+"Material: "+rs.getString("material")+" <p> ";
                    objres=objres+"Tipo: "+rs.getString("tipo")+" <p> ";
                    objres=objres+"Cantidad: "+rs.getString("cantidad")+" <p> </html>";
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }

    public Producto readNombre(String nombre) {
        Producto objres = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ_Nombre);
                psmt.setString(1, nombre);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    objres = new Producto(rs.getString("dimension"), rs.getInt("ID_P"), rs.getInt("precio"), rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                System.out.println("Error consultar el vendedor: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }

        }
        return objres;
    }
    public boolean update(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDimension());
            ps.setInt(3, c.getPrecio());
            ps.setInt(4, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error altulizar producto " + ex.getMessage());
        } finally {
           //conexion.cerrarConexion();
        }
        return false;
    }
    
    public boolean updateColor(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_COLOR);
            ps.setString(1, c.getColor());
            ps.setInt(2, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update color " + ex.getMessage());
        } finally {
          // conexion.cerrarConexion();
        }
        return false;
    }
    public boolean updateMaterial(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_MATERIAL);
            ps.setString(1, c.getMaterial());
            ps.setInt(2, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update material " + ex.getMessage());
        } finally {
           // conexion.cerrarConexion();
        }
        return false;
    }
     public boolean updateTipo(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_TIPO);
            ps.setString(1, c.getTipo());
            ps.setInt(2, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update tipo " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
     public boolean updateDistribulle(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_DISTRUBULLE);
            ps.setInt(1, c.getCantidad());
            ps.setInt(2, c.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update distrubulle " + ex.getMessage());
        } finally {
            //conexion.cerrarConexion();
        }
        return false;
    }


    public boolean insert(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getDimension());
            ps.setInt(3, c.getPrecio());
            ps.setString(4, c.getNombre());
            ps.setBoolean(5, c.isEstado());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean insertColor(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT_COLOR);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getColor());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean insertMaterial(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT_MATERIAL);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getMaterial());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean insertTipo(Producto c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT_TIPO);
            ps.setInt(1, c.getID_P());
            ps.setString(2, c.getTipo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean distrubuye(Producto p, Provedor po) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_INSERT_distribuye);
            ps.setInt(1, po.getID_PR());
            ps.setInt(2, p.getID_P());
            ps.setInt(3, p.getCantidad());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error crear producto: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public List<Producto> getProducto() {
        List<Producto> listProductos = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ_ALL);
                ResultSet rs = psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                    Producto aux = new Producto(rs.getString("dimension"), rs.getInt("ID_P"), rs.getInt("precio"), rs.getString("nombre"));
                    listProductos.add(aux);
                }
            } catch (SQLException ex) {
                System.out.println("Error obtener productos: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return listProductos;
    }

    public boolean delete(Producto item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, item.getID_P());
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
    public boolean deleteColor(Producto item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE_COLOR);
            ps.setInt(1, item.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Color: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
    public boolean deleteMaterial(Producto item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE_MATERIAL);
            ps.setInt(1, item.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Material: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
     public boolean deleteTipo(Producto item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE_TIPO);
            ps.setInt(1, item.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Tipo: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
    public boolean deleteCantidad(Producto item) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_DELETE_DISTRIBULLE);
            ps.setInt(1, item.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar Distribuye: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }
    
    public List<Producto> getInfoProducto() {
        List<Producto> listProductos = null;
        if (con != null) {
            PreparedStatement psmt;
            try {
                psmt = con.prepareStatement(SQL_READ_ALL_INFO);
                ResultSet rs = psmt.executeQuery();
                listProductos = new ArrayList<>();
                while (rs.next()) {
                  
                    Producto aux = new Producto(rs.getString("dimension"), rs.getInt("ID_P"), rs.getString("color"), rs.getInt("cantidad"),
                            rs.getInt("precio"), rs.getString("material"), rs.getString("tipo"), rs.getString("nombre"),rs.getBoolean("estado"));
                    
                    System.out.println("estado"+rs.getBoolean("estado"));
                    listProductos.add(aux);
                }
            } catch (SQLException ex) {
                System.out.println("Error obtener productos: " + ex.getMessage());
            } finally {
                conexion.cerrarConexion();
            }
        }
        return listProductos;
    }

    public boolean updateEstado(Producto objS) {
       PreparedStatement ps;
        try {
            ps = con.prepareStatement(SQL_UPDATE_ESTADO);
            ps.setBoolean(1, objS.isEstado());
            ps.setInt(2, objS.getID_P());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update distrubulle " + ex.getMessage());
        } finally {
            //conexion.cerrarConexion();
        }
        return false;
    }

}
