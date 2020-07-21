/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Doubts;
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
import javax.servlet.http.HttpSession;
import java.lang.ClassNotFoundException;
import java.util.List;
/**
 *
 * @author adesh
 */
public class insert_public_answer extends HttpServlet {

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
            String question_id=request.getParameter("question_id");
            String answer=request.getParameter("answer");
            HttpSession session = request.getSession();
            String student_id = (String)session.getAttribute("username");
            
           
            String abc="Adesh12345@";
            int flag=0;
            
                try
                     {
                         try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                    int status=0;
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/public_answers","root",abc);
                                   // Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/public_questions_unique","root","1234"); 
                                    PreparedStatement ps=con.prepareStatement("insert into public_ans values(?,?,?)");    
                                    ps.setString(1,question_id);  
                                    ps.setString(2,answer);
                                    ps.setString(3,student_id);
                                    status=ps.executeUpdate();  
                                    con.close();
                                    ViewDoubtServlet yo=new ViewDoubtServlet();
                                    List<Doubts> doubt=yo.make();
                                    List<Doubts> doubt1=yo.make1();
                                    session.setAttribute("answerList", doubt1);
                                session.setAttribute("doubtList",doubt);
                                response.sendRedirect("index.jsp");
                     
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }
                }
                
            
        }
    
