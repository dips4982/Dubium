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

/**
 *
 * @author adesh
 */
public class TeacherQuestion extends HttpServlet {

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
    public  List<Doubts> make(String id)
    {
         List<Doubts> doubt=new ArrayList<>();
         try
                     {
                         try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                            Connection con=DriverManager.getConnection(  
                            "jdbc:mysql://localhost:3306/questions","root",abc);  
                             PreparedStatement ps=con.prepareStatement("SELECT * FROM qdata where teacher_id='"+id+"';");
                             ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                   String q_id=result.getString(1);
                                   String q = result.getString(4);
                                   String ans=result.getString(5);
                                   Doubts s=new Doubts();
                                   s.setAnswer(ans);
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession() ;
            String id = (String)session.getAttribute("username");
            List<Doubts> doubt=make(id);
            session.setAttribute("doubtList", doubt);
            session.setAttribute("username", session.getAttribute("username"));
            ServletContext context=getServletContext();
            RequestDispatcher dispatch=context.getRequestDispatcher("/give_ans.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
