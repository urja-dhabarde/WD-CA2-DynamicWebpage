package example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import example.model.UserAccount;
import example.dao.LoginDao;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserAccount useraccount = new UserAccount();
        useraccount.setEmail(email);
        useraccount.setPassword(password);

        try {
            if (loginDao.validate(useraccount)) {
                
            	RequestDispatcher dispatcher=
              		  request.getRequestDispatcher("/WEB-INF/views/loginsuccess.jsp");
                dispatcher.forward(request, response);
            } else {
            	RequestDispatcher dispatcher=
                		  request.getRequestDispatcher("/WEB-INF/views/loginfailure.jsp");
                  dispatcher.forward(request, response);
	}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	
}