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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adesh
 */
public class add_ans extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String abc="Adesh12345@";
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
             PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            String question_id=request.getParameter("question_id");
            String answer=request.getParameter("answer");
           
            //String abc="1234";
            int flag=0;
            
                try
                     {try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                    int status=0;
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/questions","root",abc);  
                                    PreparedStatement ps=con.prepareStatement("update qdata set ans=? where qid='"+question_id+"';");  
                                    ps.setString(1,answer);
                                    status=ps.executeUpdate();  
                                    con.close();
                                    response.sendRedirect("Teacher_Home.jsp");
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }
                }
                
            
        }
    
