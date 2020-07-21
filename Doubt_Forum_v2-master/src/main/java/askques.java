/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Doubts;
import classes.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
/**
 *
 * @author adesh
 */
public class askques extends HttpServlet {
    String abc="Adesh12345@";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
//           Random rand = new Random(); 
//           String random = Integer.toString(rand.nextInt(1000)); 
            /* TODO output your page here. You may use following sample code. */
            String teacher_id=request.getParameter("teacher_id");
            String ques=request.getParameter("ques");
            HttpSession session = request.getSession();
            String student_id = (String)session.getAttribute("username");
            //String abc="1234";
            int flag=0;
           try
                     {
                         try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                    Connection con=DriverManager.getConnection(  
                                    "jdbc:mysql://localhost:3306/questions","root",abc);
                                    String random="";
//                                    do
//                                        {
//                                            flag=1;
                                         Random rand = new Random(); 
                                         random = Integer.toString(rand.nextInt(1000));
//                                           PreparedStatement stmt=con.prepareStatement("select * qdata" );
//                                           ResultSet result2=stmt.executeQuery();
//                                                while(result2.next())
//                                                {
//                                                     String q_id1=result2.getString(1);
//                                                     if(q_id1.equals(random))
//                                                     {
//                                                         flag=0;
//                                                         break;
//                                                     }
//                                               }
//                                        }while(flag==0);
                                    PreparedStatement stmt=con.prepareStatement("insert into qdata values(?,?,?,?,?)");  
         
                                    stmt.setString(1,random);
                                    stmt.setString(2,student_id);
                                    stmt.setString(3,teacher_id);
                                    stmt.setString(4, ques);
                                    stmt.setString(5, "");
                                   
                                    int i=stmt.executeUpdate();
                                    //out.println("question inserted");
                                    con.close();
                                    ViewHomeDetails d=new ViewHomeDetails();
                                    List<Teacher> teacher=d.make();
                                    session.setAttribute("teacherList", teacher);
                                session.setAttribute("username", student_id);
                                response.sendRedirect("Home.jsp");
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }
                      
   
        
    }

 

}
