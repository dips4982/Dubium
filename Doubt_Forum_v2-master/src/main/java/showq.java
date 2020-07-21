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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author adesh
 */
public class showq extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param id
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public List<Doubts> make(String id)
    {
        List<Doubts> doubt=new ArrayList<>();
        try
                     {
                         try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(showq.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                    Connection con=DriverManager.getConnection(  
                                    "jdbc:mysql://localhost:3306/questions","root",abc);  
                                     PreparedStatement ps=con.prepareStatement("SELECT * FROM qdata;");
                                     ResultSet result=ps.executeQuery();
                                     int i=1;
                            while (result.next()) 
                            {
                              String student_id=result.getString(2);
                                if(student_id.equals(id))
                                {  
                                   String qid=result.getString(1);
                                    String q = result.getString(4);
                                   String a = result.getString(5);
                                   Doubts s=new Doubts();
                                   s.setId(qid);
                                   s.setAnswer(a);
                                   s.setQuestion(q);
                                   s.setStId(student_id);
                                   doubt.add(s);
                                }
                            }
                     }
                            catch(SQLException e)
                                    {
                                    e.printStackTrace();
                                    }
        return doubt;
    }
    public List<Doubts> make1(String id)
    {
        List<Doubts> doubt=new ArrayList<>();
        
        try
                     {
                                                try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(showq.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                     Connection con2=DriverManager.getConnection(  
                            "jdbc:mysql://localhost:3306/public_answers","root",abc);  //connecting with table
                             PreparedStatement ps1=con2.prepareStatement("SELECT * FROM public_ques where student_id='"+id+"';");
                             ResultSet result=ps1.executeQuery();
                                     int i=1;
                                     
                            while (result.next()) 
                            {
                                String qid=result.getString(1);
                                String ques=result.getString(2);
                                
                                int flag=0;
                               try
                                    {
                         
                                             try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(showq.class.getName()).log(Level.SEVERE, null, ex);
                 }
                                     Connection con3=DriverManager.getConnection(  
                                    "jdbc:mysql://localhost:3306/public_answers","root",abc);  //connecting with table
                                     PreparedStatement ps2=con3.prepareStatement("SELECT * FROM public_ans where qid='"+qid+"';");
                                     ResultSet result1=ps2.executeQuery();
                                     while(result1.next())
                                     {
                                         flag=1;
                                         Doubts s=new Doubts();
                                         s.setQuestion(ques);
                                        s.setId(qid);
                                        s.setStId(id);
                                         s.setAnswer(result1.getString(2));
                                         doubt.add(s);
                                     }
                                    }
                               catch(SQLException err)
                               {
                                   err.printStackTrace();
                               }
                               if(flag==0)
                               {
                                   Doubts s=new Doubts();
                                         s.setQuestion(ques);
                                        s.setId(qid);
                                        s.setStId(id);
                                   s.setAnswer("");
                                   doubt.add(s);
                               }
                            }
                     }
                            catch(SQLException e)
                                    {
                                    e.printStackTrace();
                                    }
        return doubt;
    }
    String abc="Adesh12345@";
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            System.out.print("IN SHOW Q");
            HttpSession session = request.getSession() ;
            String id = (String)session.getAttribute("username");
            List<Doubts> doubt=make(id);
            List<Doubts> doubt1=make1(id);
            session.setAttribute("username",session.getAttribute("username"));
            session.setAttribute("publicdoubt",doubt1);
            session.setAttribute("teacherdoubt",doubt);
            
            ServletContext context=getServletContext();
                                RequestDispatcher dispatch=context.getRequestDispatcher("/showallques.jsp");
                                dispatch.forward(request, response);
    }


}
