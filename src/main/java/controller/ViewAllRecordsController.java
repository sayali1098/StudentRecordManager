package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.StudentRecord;

/**
 * Servlet implementation class ViewAllRecordsController
 */
public class ViewAllRecordsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ViewAllRecordsController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View All Records");
		
		RecordDAO recordao = new RecordDAO();
		List<StudentRecord> recordlist = recordao.selectAllRecords();
		System.out.println("Getting all student data");
		for(StudentRecord records: recordlist) {
			System.out.println(records.getStudentId());
			System.out.println(records.getStudentName());
			System.out.println(records.getStudentBranch());
			System.out.println(records.getStudentCgpa());
			System.out.println(records.getDateOfBirth());
		}
		request.setAttribute("recordlist",recordlist);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/recordView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
