package com.spring.webservices.restfulwebservices.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about person.")
public class Person {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	
	private String address;
	
	@Past
	@ApiModelProperty(notes="Date should be in the past")
	private Date birth;
	
	@OneToMany(mappedBy = "person")
	private List<Post> post;
	
	public Person() {
		
	}
	
	public Person(Integer id, String name, String address, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birth = birth;
	}
	
	public Person(Integer id, String name, String address, Date birth, List<Post> post) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birth = birth;
		this.post = post;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", birth=" + birth + ", post=" + post
				+ "]";
	}
}
