package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.StudentRecord;

public class AddNewRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting into Add New Record");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/recordListView.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do post");
		String studentName = request.getParameter("title");
		String studentBranch = request.getParameter("message");
		double studentCgpa = Double.parseDouble(request.getParameter("cgpa"));
		LocalDate dob = LocalDate.now();
		
		StudentRecord record = new StudentRecord();
		record.setStudentName(studentName);
		record.setStudentBranch(studentBranch);
		record.setStudentCgpa(studentCgpa);
		record.setDateOfBirth(dob);
		
		RecordDAO recordao = new RecordDAO();
		try {
			recordao.insertRecord(record);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("allrecords");
	}

}
