package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Record")
public class StudentRecord 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT_ID", updatable = false, nullable = false)
	private int StudentId;
	
	@Column(name="STUDENT_NAME")
	private String StudentName;
	
	@Column(name="BRANCH")
	private String StudentBranch;
	
	@Column(name="CGPA")
	private double StudentCgpa;
	
	@Column(name="DOB")
	private LocalDate DateOfBirth;

	//getters and setters
	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentBranch() {
		return StudentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		StudentBranch = studentBranch;
	}

	public double getStudentCgpa() {
		return StudentCgpa;
	}

	public void setStudentCgpa(double studentCgpa) {
		StudentCgpa = studentCgpa;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}	
}
