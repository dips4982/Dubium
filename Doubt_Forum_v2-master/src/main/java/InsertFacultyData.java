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
 * @author Sanchita
 */
public class InsertFacultyData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        String password = request.getParameter("psw");
        String abc = "Adesh12345@";
        int flag = 0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InsertFacultyData.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/teacher", "root", abc);
            PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM tchdata;");
            ResultSet result = stmt1.executeQuery();
            while (result.next()) {
                String q_id = result.getString(1);
                if (id.equals(q_id)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                response.sendRedirect("teacher_failure.jsp");
            } else {
                PreparedStatement stmt = con.prepareStatement("insert into tchdata values(?,?,?,?)");
                //here studentdb is database name, root is username and password 
                stmt.setString(1, id);//1 specifies the first parameter in the query  
                stmt.setString(2, password);
                stmt.setString(3, name);
                stmt.setString(4, email);

                int i = stmt.executeUpdate();
                request.setAttribute("name", name);
                //request.getRequestDispatcher("regis_success.jsp").forward(request, response);
                response.sendRedirect("teacher_success.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // C:\Users\KETAN SARODE\.m2\repository\mysql\mysql-connector-java\8.0.19\mysql-connector-java-8.0.19.jar
    }

}