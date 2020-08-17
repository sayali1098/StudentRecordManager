package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;

public class DeleteRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRecordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete Blog");
		try {
			deleteRecord(request, response);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void deleteRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		RecordDAO recordao = new RecordDAO();
		recordao.deleteRecord(id);
		response.sendRedirect("allrecords");
	}

}
