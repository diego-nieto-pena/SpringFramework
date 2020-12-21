package com.hibernate;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//simple log 4(for) Java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.hibernate2.entity.Course;
import com.hibernate2.entity.FullTimeEmployee;
import com.hibernate2.entity.PartTimeEmployee;
import com.hibernate2.entity.Student;
import com.hibernate2.entity.Teacher;

@SpringBootApplication
@ComponentScan({"com.hibernate"})
@EntityScan("com.hibernate2.entity")
public class HibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(HibernateApplication.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired 
	private CourseDao courseDao;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 	 
		employeeActions();
		//entityManager.close();
	}
	
	public void employeeActions() {
		employeeRepository.insert(new PartTimeEmployee("Laura", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Pecas", 300L));
		
		logger.info("All employees -> {}", employeeRepository.findAll());
	}

	public void getCourses() {
		TypedQuery<Course> courses = entityManager.createNamedQuery("findAllCourse", Course.class);
		 
		List<Course> list = courses.getResultList();
		 
		list.forEach(item -> {
			System.out.println(item);
		});
		
	}
	
	public void getTeachers() {
		TypedQuery<Teacher> typedQuery = entityManager.createNamedQuery("findAllTeacher", Teacher.class);
		
		List<Teacher> teachers = typedQuery.getResultList();
		
		teachers.forEach(teacher ->{
			System.out.println(teacher);
		});
	}
	
	public void getStudents() {
		TypedQuery<Student> typedQuery = entityManager.createNamedQuery("findAllStudent", Student.class);
		
		List<Student> students = typedQuery.getResultList();
		
		students.forEach(student ->{
			System.out.println(student);
		});
		
	}
	
	private void createCourse() {
		
		Teacher t = new Teacher();
		t.setIdTeacher(3);
		
		Course c = new Course();
		c.setCourseName("Restful");
		c.setIdCourse(1);
		c.setStudentsNum(12);
		
		c.setIdTeacher(t);
			
		courseDao.delete(c);
	}
}
