/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
 
public class UserDAO {      
     public static boolean login(String Usuario, String Contrasena) {
       
        PreparedStatement ps = null;
        try {
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/activosfijos?zeroDateTimeBehavior=convertToNull","root", "J@plv2107");  
            ps = con.prepareStatement( "select Usuario, Contrasena from login where Usuario= ? and Contrasena= ? ");
            ps.setString(1, Usuario);
            ps.setString(2, Contrasena);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("Usuario"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
        }
    }
}