
import Modelo.DAO.ClienteDAO;
import Modelo.DAO.VendedorDAO;
import Modelo.Vendedor;
import Modelo.cliente;
import java.awt.List;
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
public class main {
    
    public static void main(String[] args) {
        
        ArrayList<cliente> lst = null;
        ClienteDAO dao = new ClienteDAO();
        lst = dao.READALL();
        for(int i=0; i< lst.size(); i++){
            System.out.println(lst.get(i));
        }
        
        
    }
}
