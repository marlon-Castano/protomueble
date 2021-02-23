
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    private static Connection cnx=null;
    
    public static Connection obtenerConexion(){
        if(cnx==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx=   DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?"
                        + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
            } catch (ClassNotFoundException |SQLException  ex ) {
               System.out.println("Error conectar BD: "+ex);
            } 
        }
        return cnx;
    }
    public static void cerrarConexion(){
        if(cnx!=null){
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error cerrarBD: "+ex);
            }
        }
        cnx=null;
    }
}
