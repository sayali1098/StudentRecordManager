package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.StudentRecord;

public class EditRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditRecordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			showEditRecord(request,response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void showEditRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RecordDAO recordao = new RecordDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		StudentRecord oldrecord = recordao.selectRecord(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recordListView.jsp");
		request.setAttribute("records", oldrecord);
		dispatcher.forward(request, response);

	}

}
