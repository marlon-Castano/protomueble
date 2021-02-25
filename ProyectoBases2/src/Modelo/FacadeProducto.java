/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.ProductoDAO;
import Modelo.DAO.ProvedorDAO;
import java.util.List;

/**
 *
 * @author alche
 */
public class FacadeProducto {

    public boolean update(Producto objP) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.update(objP);
            if (rta) {
                rta = dao.updateColor(objP);
                if (rta) {
                    rta = dao.updateDistribulle(objP);
                    if (rta) {
                        rta = dao.updateMaterial(objP);
                        if (rta) {
                            rta = dao.updateTipo(objP);
                        }
                    }
                }
            }
        }
        return rta;
    }

    public boolean delate(Producto objP) {
        boolean rta = false;
        ProductoDAO dao = new ProductoDAO();
        if (objP != null) {
            
            rta = dao.deleteColor(objP);
            if (rta) {
                rta = dao.deleteMaterial(objP);
                if (rta) {
                    rta = dao.deleteTipo(objP);
                    if (rta) {
                        rta = dao.deleteCantidad(objP);

                    }
                }
            }
        }
        if (rta) {
           // rta = dao.delete(objP);
        }
        return rta;
    }

    public boolean CrearProducto(Producto objP) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.insert(objP);
        }
        return rta;
    }

    public boolean CrearColor(Producto objP) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.insertColor(objP);
        }
        return rta;
    }

    public boolean CrearMaterial(Producto objP) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.insertMaterial(objP);
        }
        return rta;
    }

    public boolean CrearTipo(Producto objP) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.insertTipo(objP);
        }
        return rta;
    }

    public boolean distribuye(Producto objP, Provedor p) {
        boolean rta = false;
        if (objP != null) {
            ProductoDAO dao = new ProductoDAO();
            rta = dao.distrubuye(objP, p);
        }
        return rta;
    }

    public List<Producto> ListarProductos() {
        List<Producto> lst = null;
        ProductoDAO dao = new ProductoDAO();
        lst = dao.getProducto();
        return lst;
    }

    public List<Producto> ListarProductosInfo() {
        List<Producto> lst = null;
        ProductoDAO dao = new ProductoDAO();
        lst = dao.getInfoProducto();
        return lst;
    }

    public Producto verProducto(Producto item) {
        Producto dto;
        ProductoDAO dao = new ProductoDAO();
        dto = dao.read(item);

        return dto;
    }

    public Producto verProductoNombre(String item) {
        Producto dto;
        ProductoDAO dao = new ProductoDAO();
        dto = dao.readNombre(item);

        return dto;
    }

    public boolean EliminarProducto(Producto eliminar) {
        boolean rta = false;
        ProductoDAO dao = new ProductoDAO();
        rta = dao.delete(eliminar);

        return rta;
    }

    public String caracteristicas(Producto pro) {
        String res = "";
        ProductoDAO dao = new ProductoDAO();
        res = dao.caracteriscas(pro);

        return res;
    }

}
