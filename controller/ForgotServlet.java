package example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



import example.model.UserAccount;
import example.dao.ForgotDao;



@WebServlet("/forgot")
public class ForgotServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ForgotDao forgotDao;

    public void init() {
        forgotDao = new ForgotDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
          // Forward to /WEB-INF/views/forgot.jsp
          RequestDispatcher dispatcher=
        		  request.getRequestDispatcher("/WEB-INF/views/forgot.jsp");
          dispatcher.forward(request, response);
    }

    
 // When the user enters Email & secret code and click Submit.
    // This method will be executed
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        String email = request.getParameter("email");
        String secretcode = request.getParameter("secretcode");
        UserAccount useraccount = new UserAccount();
        useraccount.setEmail(email);
        useraccount.setSecretcode(secretcode);
          try {
        	String pswd= forgotDao.validate(useraccount);
        	if(pswd!=null) {
        	PrintWriter out = response.getWriter();  
            response.setContentType("text/html"); 
            out.println("<html><body>");
            out.println("<tr><th>Your Password is</th></tr>");
            out.println("<tr><td>" + pswd + "</td></tr>");   
            out.println("<html><body>");
            } 
          else
          {
          	RequestDispatcher dispatcher=
                    request.getRequestDispatcher("/WEB-INF/views/passworderror.jsp");
                dispatcher.forward(request, response);
	        }
          }
          catch (Exception e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        
             }
}
