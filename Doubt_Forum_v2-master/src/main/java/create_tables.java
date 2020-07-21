/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


/**
 *
 * @author adesh
 */
public class create_tables  {

    String abc="Adesh12345@";
    public void teacher(){
        
                try
                 {
                               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root",abc);
                     
                                try (PreparedStatement prepStm = con.prepareStatement("DROP TABLE IF EXISTS tchdata;")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                   Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                 }
			
				try (PreparedStatement prepStm = con.prepareStatement("CREATE TABLE tchdata (name varchar(300), email varchar(300), id varchar(300),password varchar(130) );")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                  Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                }
                 }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }               
        
    }
    
    
     public void questions(){
        //response.setContentType("text/html;charset=UTF-8");
                try
                 {
                               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/questions","root",abc);
                     
                                try (PreparedStatement prepStm = con.prepareStatement("DROP TABLE IF EXISTS qdata;")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                   Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                 }
			
				try (PreparedStatement prepStm = con.prepareStatement("CREATE TABLE qdata (qid varchar(300), student_id varchar(300), teacher_id varchar(300),ques varchar(330),ans varchar(300) );")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                  Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                }
                 }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }               
        
    }
     
      public void studentdata(){
        //response.setContentType("text/html;charset=UTF-8");
                try
                 {
                     
                               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root",abc);
                     
                                try (PreparedStatement prepStm = con.prepareStatement("DROP TABLE IF EXISTS stdata;")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                   Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                 }
			
				try (PreparedStatement prepStm = con.prepareStatement("CREATE TABLE stdata (name varchar(300), email varchar(300), id varchar(300),password varchar(130) );")) {
					prepStm.execute();
				} catch (SQLException ex) {
                                  Logger.getLogger(create_tables.class.getName()).log(Level.SEVERE, null, ex);
                                }
                 }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }               
        
    }
    public void insert_teacher()
    {
          try
                 {
                               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root",abc);
                     
                               
					try (PreparedStatement prepStm = con.prepareStatement("INSERT INTO tchdata (name,email,id,password) values (?,?,?,?);");) {
						prepStm.setString(1,"keskar");
						prepStm.setString(2, "keskar12@gmail.com");
						prepStm.setString(3, "22134");
						prepStm.setString(4, "kes12");
						prepStm.execute();
					}
				
                 }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }      
    }
    public static void main(String[] args) {
        create_tables new_data = new create_tables() ;
        new_data.questions() ;
        new_data.teacher();
        new_data.studentdata();
        new_data.insert_teacher();
     
    }

 
}

