package dao;

import java.sql.SQLException;
import java.util.List;

import model.StudentRecord;

public interface RecordInterface 
{
	void insertRecord(StudentRecord record) throws SQLException;
	StudentRecord selectRecord(int studId);
	List<StudentRecord> selectAllRecords();
	void deleteRecord(int id) throws SQLException;
	void updateRecord(StudentRecord record) throws SQLException, Exception;

}
