/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author KETAN SARODE
 *///ANNOTATION
//@("/add")
public class addservlet  extends HttpServlet{
   

    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
    {
       
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));
        int k = i + j;
        
        HttpSession session = request.getSession() ;
        session.setAttribute("k", k);
        response.sendRedirect("sq");
        
        
        PrintWriter out = response.getWriter();
       // out.println("we are awesome");
//        req.setAttribute("k", k);
//        RequestDispatcher rd =req.getRequestDispatcher("sq");
//        rd.forward(req, res);
       // out.println("<h1> Result is - </h1>");
       // out.println(k);
        //System.out.println("Result is - " + k);
    }
    
}
