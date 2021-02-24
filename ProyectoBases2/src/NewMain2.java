
import Modelo.DAO.ProductoDAO;
import Modelo.DAO.VendedorDAO;
import Modelo.Producto;
import Modelo.Vendedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vendedor ven = new Vendedor("123", "mscorreo");
        ven.setID(1456782);
        VendedorDAO obj= new VendedorDAO();
        //obj.insertLogin(ven);
    }
    
}
