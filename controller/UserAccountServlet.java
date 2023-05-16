package example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.dao.UserAccountDao;
import example.model.UserAccount;



@WebServlet("/register")
public class UserAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserAccountDao useraccountDao= new UserAccountDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
          // Forward to /WEB-INF/views/useraccountregister.jsp
          RequestDispatcher dispatcher=
        		  request.getRequestDispatcher("/WEB-INF/views/useraccountregister.jsp");
          dispatcher.forward(request, response);
    }


    // When the user enters Email,Password & secretcode and click Submit.
    // This method will be executed
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String secretcode = request.getParameter("secretcode");
        
        
	boolean hasError = false;
	

        if (email == null || password == null || secretcode==null ||email.length() == 0 || password.length() == 0 ||secretcode.length() == 0) 
		{
			hasError = true;
			
		}
       
       
        // If error, forward to /WEB-INF/views/useraccountregister.jsp
	if (hasError) 
         {	
	    
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/useraccountnotregistered.jsp");

	    dispatcher.forward(request, response);
         }


        // If no error
        else {
        	UserAccount useraccount = new UserAccount();
            useraccount.setEmail(email);
            useraccount.setPassword(password);
            useraccount.setSecretcode(secretcode);
            

            try {
                useraccountDao.registerUserAccount(useraccount);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        RequestDispatcher dispatcher=
      		  request.getRequestDispatcher("/WEB-INF/views/registerdetails.jsp");
        dispatcher.forward(request, response);
             }
}
}
