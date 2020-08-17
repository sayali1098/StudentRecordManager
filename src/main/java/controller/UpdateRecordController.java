package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.StudentRecord;

public class UpdateRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRecordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering Update Record");
		System.out.println("Entering do post");
		int recordId = Integer.parseInt(request.getParameter("recordId"));
		System.out.println(recordId);
		
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
			System.out.println("inside try block of update");
			recordao.updateRecord(record);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("allrecords");
	}
}
