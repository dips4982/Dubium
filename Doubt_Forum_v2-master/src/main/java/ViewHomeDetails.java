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
public class ViewHomeDetails extends HttpServlet {

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
    public List<Teacher> make()
    {
        List<Teacher> teacher=new ArrayList<>();
        try {  
                        try {  
                     Class.forName("com.mysql.jdbc.Driver");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }     
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root",abc);
                           
                     PreparedStatement ps=conn.prepareStatement("select * from tchdata");   
                    ResultSet result=ps.executeQuery();  
                    while (result.next()) 
                            {
                                   String id=result.getString(1);
                                   String password = result.getString(2);
                                   String name = result.getString(3);
                                   String email = result.getString(3);
                                   Teacher s=new Teacher();
                                   s.setId(id);
                                   s.setName(name);
                                   s.setemail(email);
                                   s.setPassword(password);
                                   teacher.add(s);
                            }
                   
                    }catch(SQLException err)
                    {
                       err.printStackTrace();
                    }
        return teacher;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        HttpSession session =request.getSession();
        out.println(session.getAttribute("username"));
//        if(session.getAttribute("username")==null  || session==null)
//            {
//                response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//                response.setHeader("Progrma","no-cache");
//                response.setHeader("Expiers","0");
//                response.sendRedirect("signup.jsp");
//            }
        //HttpSession session1=request.getSession();
        //List<Teacher> teacher1=new ArrayList<>();
        List<Teacher> teacher1=make();
//        for(Teacher l:teacher1)
//        {
//        out.println(l.getId());
//        out.println(l.getName());
//        }
        session.setAttribute("username",session.getAttribute("username"));
        request.setAttribute("teacherList", teacher1);
//         response.sendRedirect("Home.jsp");
         ServletContext context=getServletContext();
         RequestDispatcher dispatch=context.getRequestDispatcher("/Home.jsp");
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
