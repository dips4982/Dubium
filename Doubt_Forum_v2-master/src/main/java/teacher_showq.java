/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class teacher_showq extends HttpServlet {

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
    public List<Doubts> make(String id)
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
                                     while(result.next())
                                     {
                                         String qid=result.getString(1);
                                         String ques=result.getString(4);
                                         String ans=result.getString(5);
                                          Doubts s=new Doubts();
                                         s.setAnswer(ans);
                                         s.setId(qid);
                                         s.setQuestion(ques);
                                         doubt.add(s);
                                     }
                     }catch(SQLException err)
                     {
                         err.printStackTrace();
                     }
         return doubt;
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession() ;
            String id = (String)session.getAttribute("username");
            List<Doubts> doubt=make(id);
            session.setAttribute("doubts",doubt);
             ServletContext context=getServletContext();
             RequestDispatcher dispatch=context.getRequestDispatcher("/teacherquestion.jsp");
             dispatch.forward(request, response);
    }


}
