/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adesh
 */
public class Teacher_Signup extends HttpServlet {

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
        String uname = request.getParameter("uname");
        String pass = request.getParameter("psw");
        Teacher_SignupDao user  = new Teacher_SignupDao(); 
        if(user.check(uname,pass))
        {
            HttpSession session = request.getSession() ;
            session.setAttribute("username", uname);
            response.sendRedirect("Teacher_Home.jsp");
        }
        else
        {
          response.sendRedirect("failed_Teacher_Signup.jsp");  
        }    
        
        
    }
}
