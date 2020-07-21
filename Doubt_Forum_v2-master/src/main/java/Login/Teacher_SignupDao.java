/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adesh
 */
public class Teacher_SignupDao {
    
    String abc="Adesh12345@";
    public boolean check(String id,String password)
    {
                      try {  
                             try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Teacher_SignupDao.class.getName()).log(Level.SEVERE, null, ex);
                 }
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root",abc);
                           
                     PreparedStatement ps=conn.prepareStatement("select * from tchdata where id=? and password=?");  
                     ps.setString(1,id);  
                     ps.setString(2,password);  
      
                    ResultSet rs=ps.executeQuery();  
                    if(rs.next())
                    {
                      return true;
                    }
                   
                    }catch(SQLException err)
                    {
                       err.printStackTrace();
                    }
                    return false ;
    }
    
    
    
}
