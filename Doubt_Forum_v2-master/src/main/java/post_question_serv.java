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
public class post_question_serv extends HttpServlet {

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
          int flag=1;
          
            /* TODO output your page here. You may use following sample code. */
            //String teacher_id=request.getParameter("id");
            String ques=request.getParameter("ques");
           
            HttpSession session = request.getSession() ;
            String student_id = (String)session.getAttribute("username");
            String abc="Adesh12345@";
           
                try
                     {
                         try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                    Connection con=DriverManager.getConnection(  
                                    "jdbc:mysql://localhost:3306/public_answers","root",abc);
                                    String random="";
                                    do
                                        {
                                            flag=1;
                                         Random rand = new Random(); 
                                         random = Integer.toString(rand.nextInt(1000));
                                           PreparedStatement stmt=con.prepareStatement("select * from public_ques where qid='"+random+"';" );
                                           ResultSet result2=stmt.executeQuery();
                                                while(result2.next())
                                                {
                                                         flag=0;
                                                         break;
                                               }
                                        }while(flag==0);
                                    PreparedStatement stmt=con.prepareStatement("insert into public_ques values(?,?,?)");  
                                    stmt.setString(1,random);
                                    stmt.setString(2,ques);
                                    stmt.setString(3,student_id);
                                    int i=stmt.executeUpdate();  
//                                    out.println(random);
//                                    out.println(ques);
//                                    out.println(student_id);
                                    ViewDoubtServlet yo=new ViewDoubtServlet();
                                    List<Doubts> doubt=yo.make();
                                    List<Doubts> doubt1=yo.make1();
//                                    request.setAttribute("answerList", doubt1);
//                                request.setAttribute("doubtList",doubt);
//                                ServletContext context=getServletContext();
//                                RequestDispatcher dispatch=context.getRequestDispatcher("/index.jsp");
//                                dispatch.forward(request, response);
                                session.setAttribute("answerList", doubt1);
                                session.setAttribute("doubtList",doubt);
                                response.sendRedirect("index.jsp");
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }
        
   
        
    }

 

}
