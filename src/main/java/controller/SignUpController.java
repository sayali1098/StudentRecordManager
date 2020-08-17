package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;


public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String confirmPassword = request.getParameter("confirmPassword");
		LocalDate date = LocalDate.now(); 
		
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		AdminDAO admindao = new AdminDAO();
		
		int checkAdmin = admindao.signUp(admin);
		
		if(checkAdmin!=0)
		{
			System.out.println(admin.getEmail());
			System.out.println(admin.getPassword());
			
			request.setAttribute("message", "Registration Successful");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Check your email and password");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
	}

}
