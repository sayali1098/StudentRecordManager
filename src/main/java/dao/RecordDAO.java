package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.StudentRecord;
import utility.HibernateConnectionManager;

public class RecordDAO implements RecordInterface 
{
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void insertRecord(StudentRecord record) throws SQLException 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Executed save1");
		session.save(record);
		System.out.println("Executed save");
		transaction.commit();
		System.out.println("Executed save");

	}

	public StudentRecord selectRecord(int studId) {
		Session session = this.sessionFactory.openSession();
		StudentRecord record = session.get(StudentRecord.class, studId);
        session.close();
        return record;
	}

	public List<StudentRecord> selectAllRecords() 
	{
		 Session session = this.sessionFactory.openSession();
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaQuery<StudentRecord> query = builder.createQuery(StudentRecord.class);
		 Root<StudentRecord> root = query.from(StudentRecord.class);
		 query.select(root);
		 System.out.println("executed all record query 1");
		 Query<StudentRecord> q=session.createQuery(query);
		 System.out.println("executed all record query 2");
		 List<StudentRecord> listRecord = q.getResultList();
		 return listRecord;	
	}

	public void deleteRecord(int id) throws SQLException 
	{
		Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentRecord record = session.get(StudentRecord.class, id);
        session.delete(record);
        transaction.commit();
        session.close();	
	}

	public void updateRecord(StudentRecord record) throws SQLException, Exception 
	{
		Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("executing update query");
        session.update(record) ;
        System.out.println("executed update query");
        transaction.commit();
 	    session.close();	
	}

}
