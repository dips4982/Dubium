/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.Doubts;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adesh
 */
@WebServlet("")
public class ViewDoubtServlet extends HttpServlet 
{
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
    public List<Doubts> make1()
    {
        
        List<Doubts> doubts=new ArrayList<>();
         try
            {
                 try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/public_answers","root",abc);  //connecting with table
                             
                             
                  PreparedStatement ps=con.prepareStatement("SELECT * FROM public_ques;");
                   ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                   String q_id=result.getString(1);
                                   String q = result.getString(2);
                                   String std = result.getString(3);
                                        
          
                                        
                                    PreparedStatement ps2=con.prepareStatement("SELECT * FROM public_ans where qid='"+q_id+"';");
                                    ResultSet result2=ps2.executeQuery();
                                   while(result2.next())
                                   {
                                        String q_id1=result2.getString(1);
                                        String ans = result2.getString(2);
                                        String stid = result2.getString(3);
                                        Doubts s=new Doubts();
                                        s.setId(q_id);
                                        s.setQuestion(q);
                                        s.setStId(std);
                                        s.setAnswer(ans);  
                                        doubts.add(s);
                                  }
                                   
                            } 
                     
                     }catch(SQLException e)
                     {
                         e.printStackTrace();
                     }

                     return doubts;

    }
    public  List<Doubts> make()
    {
         List<Doubts> doubt=new ArrayList<>();
         try
                     {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
                                List<Doubts> doubt;
                                List<Doubts> doubt1;
                                doubt=make();
                                doubt1=make1();
                                request.setAttribute("answerList", doubt1);
                                request.setAttribute("doubtList",doubt);
                                ServletContext context=getServletContext();
                                RequestDispatcher dispatch=context.getRequestDispatcher("/index.jsp");
                                dispatch.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewDoubtServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewDoubtServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
