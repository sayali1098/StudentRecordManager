package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		AdminDAO admindao = new AdminDAO();
		
		boolean validateadmin = admindao.loginAdmin(admin);
		if(validateadmin) {
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/recordView.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			rd.forward(request, response);
		}
	}

}
