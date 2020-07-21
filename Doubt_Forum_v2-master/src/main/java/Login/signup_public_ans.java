/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import classes.Doubts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adesh
 */
public class signup_public_ans extends HttpServlet {

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
    public  List<Doubts> make()
    {
         List<Doubts> doubt=new ArrayList<>();
         try
                     {
                                 try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Teacher_SignupDao.class.getName()).log(Level.SEVERE, null, ex);
                 }
                            Connection con=DriverManager.getConnection(  
                            "jdbc:mysql://localhost:3306/public_answers","root",abc);  
                             PreparedStatement ps=con.prepareStatement("SELECT * FROM public_ques;");
                             ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                   String q_id=result.getString(1);
                                   String q = result.getString(2);
                                   String ans = result.getString(3);
                                   Doubts s=new Doubts();
                                   s.setStId(ans);
                                   s.setId(q_id);
                                   s.setQuestion(q);
                                   doubt.add(s);
                            } 
                                   
                                //    int i=stmt.executeUpdate();  
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }
         return doubt;
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("uname");
        String pass = request.getParameter("psw");
        SignupDao user  = new SignupDao(); 
        if(user.check(uname,pass))
        {
            HttpSession session = request.getSession();
            List<Doubts> doubt=make();
            session.setAttribute("doubtList", doubt);
            session.setAttribute("username", uname);
            response.sendRedirect("give_pub_ans.jsp");
        }
        else
        {
          response.sendRedirect("failed_authentication.jsp");  
        }    
        
        
        
        
        
           
    }

   

}
