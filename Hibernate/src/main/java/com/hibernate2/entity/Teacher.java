package com.hibernate2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@NamedQueries({
	@NamedQuery(name="findAllTeacher", query="from Teacher")//HQL
})
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher")
	private int idTeacher;
		
	private String name;
	private String lastname;
	private String docNum;
	
	@OneToMany(mappedBy = "idTeacher", cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Course> courses;
	
	
	public Teacher() {
		
	}


	public int getIdTeacher() {
		return idTeacher;
	}


	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDocNum() {
		return docNum;
	}


	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Teacher [idTeacher=" + idTeacher + ", name=" + name + ", lastName=" + lastname + ", docNum=" + docNum
				+ ", courses=" + courses + "]";
	}
	
	
}
