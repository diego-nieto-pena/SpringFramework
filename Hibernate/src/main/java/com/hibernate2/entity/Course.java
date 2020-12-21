package com.hibernate2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="course")
@NamedQueries({
	@NamedQuery(name="findAllCourse", query="from Course")
})
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	private String courseName;
	private int studentsNum;
	
	@ManyToOne
	private Teacher idTeacher;
	
	@ManyToMany
	@JoinTable(name="student_course",
	joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")
	)
	private List<Student> students = new ArrayList<>();
	
	public Course() {
		
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getStudentsNum() {
		return studentsNum;
	}

	public void setStudentsNum(int studentsNum) {
		this.studentsNum = studentsNum;
	}

	public Teacher getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Teacher idTeacher) {
		this.idTeacher = idTeacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", courseName=" + courseName + ", studentsNum=" + studentsNum
				+ ", teacher=" + idTeacher + ", students=" + students + "]";
	}
}
